/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.*;
import java.net.*;

public class Server {
    private final int puerto = 1234;
    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(puerto);
    }
    
    public void startServer() throws IOException {
        Socket clientSocket = new Socket();
        DataOutputStream salidaClient;
        BufferedReader entradaClient;
        String pregunta;
        
        // Espera conexion de cliente
        clientSocket = serverSocket.accept();
        
        // Entrada y Salida para cliente
        salidaClient = new DataOutputStream(clientSocket.getOutputStream());
        entradaClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        pregunta = entradaClient.readLine();
        System.out.println("Mensaje Client: "+pregunta);
        
        // Enviar mensaje
        salidaClient.writeUTF("Conexion aceptada. Esperando instruccion\n");
        
        // Se ejecuta mientras haya mensajes
        
        while ((pregunta = entradaClient.readLine()) != null ){
            System.out.println("Mensaje Client: "+pregunta);
        }
        
        System.out.println("Final de conexion");
        salidaClient.close();
        entradaClient.close();
        this.serverSocket.close();
    }
}