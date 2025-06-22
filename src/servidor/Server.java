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
import misClases.Partida;
import misClases.Personaje;
import java.time.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import misClases.Juego;

public class Server {
    protected List<AttClient> clientes;
    protected ArrayList<Personaje> tablero;
    private boolean continuar;
    private int nClient;
    
    // Banderas de inicio de juego para permitir reinicar
    protected boolean nuevoJuego;
    protected boolean tableroListo;
    protected boolean enJuego;
    protected boolean[] jugadoresListos;
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
        this.enJuego = false;
        this.jugadoresListos = new boolean[]{false,false};
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
                    this.enJuego = true;
                    clientes.get(0).setTurno(true);
                    clientes.get(1).enviarMensaje(new Mensaje("Bloqueo Botones",5));
                    turno[0] = true;
                    while(this.enJuego){
                        System.out.println("JuegoActivo = "+this.enJuego);
                        if(turno[0]){
                            System.out.println("Entrada Turno Client 1");
                            while(turno[0]){
                                turno[0] = clientes.get(0).getTurno();
                            }
                            if(this.enJuego){
                                clientes.get(1).setTurno(true);
                                turno[1] = true;
                                clientes.get(0).enviarMensaje(new Mensaje("Bloqueo Botones",5));
                            }
                            System.out.println("Salida Turno Client 1");
                        }else if (turno[1]){
                            System.out.println("Entrada Turno Client 2");
                            while(turno[1]){
                                turno[1] = clientes.get(1).getTurno();
                            }
                            if(this.enJuego){
                                clientes.get(0).setTurno(true);
                                turno[0] = true;
                                clientes.get(1).enviarMensaje(new Mensaje("Bloqueo Botones",5));
                            }
                            System.out.println("Salida Turno Client 2");
                        }
                        if(!this.enJuego)
                            break;
                    }
                
                    System.out.println("Poniendo en Espera");
                    System.out.println("*** Fin del juego ***");
                //}
                
                while(this.juegos[0] == null || this.juegos[1] == null){
                    this.juegos[0] = clientes.get(0).getResultados();
                    this.juegos[1] = clientes.get(1).getResultados();
                }
                
                /*try {
                    clientes.get(0).wait();
                    clientes.get(1).wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                }*/
                
                System.out.println("*** Datos de juego obtenidos ***");
                
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
        
        try {
                    clientes.get(0).notify();
                    clientes.get(1).notify();
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        this.tablero=tablero;
    }
    
    private void reiniciarJuego(){
        this.nuevoJuego = true;
        this.tableroListo = false;
        this.jugadoresListos = new boolean[]{false,false};
        this.enJuego = false;
        this.turno = new boolean[]{false,false};
        this.juegos = new Juego[2];
        for(AttClient cliente : clientes){
            cliente.setPreparado(false);
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
        
        if(this.juegos[0].getGanador()){
            ganador1 = this.juegos[0].getJugador();
            personaje = this.juegos[0].getPersonaje();
        }else if(this.juegos[0].getGanador()){
            ganador1 = this.juegos[1].getJugador();
            personaje = this.juegos[1].getPersonaje();
        }
        
        fecha = new java.util.Date();
        tiempo = this.juegos[0].getTiempo();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaF = formatoFecha.format(fecha);

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String tiempoF = tiempo.format(formatoHora);
        
        resultado = new Partida(jugador1,jugador2,ganador1,personaje,fechaF,tiempoF);
        System.out.println(resultado);
        
        ConexionBD.guardarPartida(resultado);
    }
}
