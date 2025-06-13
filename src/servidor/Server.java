/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.*;
import java.net.*;

public class Server {
    private boolean continuar;
    private int nClient;
    private final int puerto = 1234;
    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(puerto);
        this.continuar=true;
        this.nClient=0;
    }
    
    public void startServer() throws IOException {
        Socket clientSocket;
        
        while(continuar){
            System.out.println("Esperando cliente");
            // Espera conexion de cliente
            clientSocket = serverSocket.accept();
            nClient++;
            
            System.out.println("Conexion con cliente "+this.nClient+" exitosa");
            AttClient client = new AttClient(clientSocket,nClient);
            client.start();
        }
        
        this.serverSocket.close();
    }
}