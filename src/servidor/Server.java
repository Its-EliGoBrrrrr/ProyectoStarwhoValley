/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import misClases.ConexionBD;
import misClases.Juego;
import misClases.Partida;
import misClases.Personaje;
import java.time.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Server {
    protected List<AttClient> clientes;
    protected ArrayList<Personaje> tablero;
    private boolean continuar;
    private int nClient;
    
    // Banderas de inicio de juego para permitir reinicar
    protected boolean nuevoJuego;
    protected boolean tableroListo;
    protected boolean[] jugadoresListos;
    protected boolean[] ganador;
    protected boolean[] turno;
    
    protected Juego[] juegos;
    
    // Datos del servidor
    private final int puerto = 1234;
    private ServerSocket serverSocket;
    
    public Server() throws IOException {
        this.serverSocket = new ServerSocket(puerto);
        this.continuar=true;
        this.nuevoJuego=true;
        this.tableroListo=false;
        this.jugadoresListos = new boolean[]{false,false};
        this.ganador = new boolean[]{false,false};
        this.turno = new boolean[]{false,false};
        this.juegos = new Juego[2];
        this.nClient = 0;
        this.clientes = new ArrayList<>();
    }
    
    public void startServer(){
        // Hilo de conseguir clientes
        Socket clientSocket;
            
        while(continuar && (nClient < 2)){
            System.out.println("Esperando cliente");
            try {
                // Espera conexion de cliente
                clientSocket = serverSocket.accept();
                nClient++;
                
                System.out.println("Conexion con cliente "+this.nClient+" exitosa");
                
                AttClient client = new AttClient(this,clientSocket,nClient);
                client.start();
                clientes.add(client);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        new Thread(()->{
            while(continuar){
                Iterator<AttClient> it = clientes.iterator();
                if(this.nuevoJuego == true ){
                    if(!tableroListo){ // Crea el tablero para ambos
                        crearTablero();
                        while(it.hasNext()){
                            AttClient client = it.next();
                            client.enviarTablero(tablero);
                            client.enviarMensaje(new Mensaje("Tablero enviado",9));
                            System.out.println("Fin Tablero Client "+client.getnClient());
                        }
                        this.tableroListo = true;
                    }
                    
                    if(!jugadoresListos[0]||!jugadoresListos[1]){ // Espera a que ambos marquen que estan preparados
                        System.out.println("Esperando a ambos jugadores");
                        while(!jugadoresListos[0] || !jugadoresListos[1]){
                            this.jugadoresListos[0] = clientes.get(0).getPreparado();
                            this.jugadoresListos[1] = clientes.get(1).getPreparado();
                        }
                    }
                    
                    if(jugadoresListos[0] && jugadoresListos[1]){
                        it = clientes.iterator();
                        while(it.hasNext()){
                            AttClient client = it.next();
                            client.cambiarFrame();
                            
                            System.out.println("Client " + client.getnClient() + " preparado");
                        }
                    }
                    this.nuevoJuego = false;
                }
                //if(!this.nuevoJuego){
                    clientes.get(0).setTurno(true);
                    clientes.get(1).enviarMensaje(new Mensaje("Bloqueo Botones",5));
                    turno[0] = true;
                    while(turno[0] || turno[1]){
                        if(turno[0]){
                            while(turno[0]){
                                turno[0] = clientes.get(0).getTurno();
                            }
                            clientes.get(1).setTurno(true);
                            turno[1] = true;
                            
                            // Bloqueo Y desbloqueo de botones
                            // clientes.get(1).enviarMensaje(new Mensaje("Desbloqueo Botones",4));
                            clientes.get(0).enviarMensaje(new Mensaje("Bloqueo Botones",5));
                        }else if (turno[1]){
                            while(turno[1]){
                                turno[1] = clientes.get(1).getTurno();
                            }
                            clientes.get(0).setTurno(true);
                            turno[0] = true;
                            
                            // Bloqueo y desbloqueo de botones
                            // clientes.get(0).enviarMensaje(new Mensaje("Desbloqueo Botones",4));
                            clientes.get(1).enviarMensaje(new Mensaje("Bloqueo Botones",5));
                        }
                    }
                    System.out.println("*** Fin del juego ***");
                //}
                
                while(this.juegos[0] == null && this.juegos[1] == null){
                    this.juegos[0] = clientes.get(0).getResultados();
                    this.juegos[1] = clientes.get(1).getResultados();
                }
                
                while(!ganador[0] || !ganador[1]){
                    this.ganador[0] = clientes.get(0).isGanador();
                    this.ganador[1] = clientes.get(1).isGanador();
                }
                
                cargarPartida();
                
                reiniciarJuego();
            }
        }).start();

    }
    
    protected void crearTablero(){
        List personajes = ConexionBD.obtenerPersonajes();
        ArrayList tablero = new ArrayList<Personaje>();
        int cont = 0, random = (int) (Math.random() * personajes.size());
        
        for(int i=0;i<24;i++){
            while(tablero.contains(personajes.get(random))){
                random = (int) (Math.random() * personajes.size());
            }
            tablero.add(personajes.get(random));
        }
        
        System.out.println("Tablero generado");
        
        this.tablero=tablero;
    }
    
    private void reiniciarJuego(){
        this.nuevoJuego = true;
        this.tableroListo = false;
        this.jugadoresListos = new boolean[]{false,false};
        this.ganador = new boolean[]{false,false};
        this.turno = new boolean[]{false,false};
        for(AttClient cliente : clientes){
            cliente.setPreparado(false);
            cliente.setGanador(false);
            cliente.setResultados(null);
        }
    }
    
    private void cargarPartida(){
        System.out.println("Entre a cargar partida");
        Partida resultado;
        String jugador1, jugador2, ganador1="", personaje="";
        Date fecha;
        LocalTime tiempo;
        
        jugador1 = this.juegos[0].getJugador();
        jugador2 = this.juegos[1].getJugador();
        
        if(this.ganador[0]){
            ganador1 = this.juegos[0].getJugador();
            personaje = this.juegos[0].getPersonaje();
        }else if(this.ganador[1]){
            ganador1 = this.juegos[1].getJugador();
            personaje = this.juegos[1].getPersonaje();
        }
        
        fecha = new java.util.Date();
        tiempo = this.juegos[0].getTiempooo();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaF = formatoFecha.format(fecha);

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String tiempoF = tiempo.format(formatoHora);
        
        resultado = new Partida(jugador1,jugador2,ganador1,personaje,fechaF,tiempoF);
        
        ConexionBD.guardarPartida(resultado);
    }
}
