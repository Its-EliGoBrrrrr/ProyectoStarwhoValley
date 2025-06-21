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
import misClases.Personaje;

public class Server {
    protected List<AttClient> clientes;
    protected ArrayList<Personaje> tablero;
    private boolean continuar;
    private int nClient;
    
    // Banderas de inicio de juego para permitir reinicar
    protected boolean nuevoJuego;
    protected boolean tableroListo;
    protected boolean[] jugadoresListos;
    protected boolean[] turno;
    
    // Datos del servidor
    private final int puerto = 1234;
    private ServerSocket serverSocket;
    
    public Server() throws IOException {
        this.serverSocket = new ServerSocket(puerto);
        this.continuar=true;
        this.nuevoJuego=true;
        this.tableroListo=false;
        this.jugadoresListos = new boolean[]{false,false};
        this.turno = new boolean[]{false,false};
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
                if(!this.nuevoJuego){
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
                }
                
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
        this.turno = new boolean[]{false,false};
        for(AttClient cliente : clientes){
            cliente.setPreparado(false);
        }
    }
}
