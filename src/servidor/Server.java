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
    private List<AttClient> clientes;
    private boolean continuar;
    protected boolean nuevoJuego;
    private int nClient;
    
    // Datos del servidor
    private final int puerto = 1234;
    private ServerSocket serverSocket;
    
    public Server() throws IOException {
        this.serverSocket = new ServerSocket(puerto);
        this.continuar=true;
        this.nuevoJuego=true;
        this.nClient=0;
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
    }
    
    protected ArrayList crearTablero(){
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
        
        return tablero;
    }
}
