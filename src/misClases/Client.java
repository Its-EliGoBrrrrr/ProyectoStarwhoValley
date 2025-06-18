/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import misPruebas.JFAplicacion;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client{
    // private final JFAplicacion padre;
    private final int puerto = 1234;
    public static boolean continuar = true;
    private Socket conexion;
    private DataOutputStream salidaServer;
    private DataInputStream entradaServer;
    private String mensaje;
    private String respuesta;
    
    public Client(/*JFAplicacion padre*/) throws IOException{
        // this.padre = padre;
        this.conexion=new Socket("localhost",puerto);
    }
    
    public void startClient() throws IOException{
        salidaServer = new DataOutputStream(conexion.getOutputStream()); // Manda informacion al Server
        entradaServer = new DataInputStream(conexion.getInputStream()); // Recibe informacion del Server
        
        salidaServer.writeUTF("Iniciando transmision\n");
        
        respuesta = entradaServer.readUTF();
        System.out.println("Mensaje Server: " + respuesta);
        
        
        new Thread(()->{ // Aqui voy a encargarme de que reciba las preguntas
            while(continuar){
                try{
                    if((respuesta = entradaServer.readUTF()) != null){
                        System.out.println("Recibido: " + respuesta);
                    }
                }catch(Exception e){
                    
                }
            }
        }).start();
    }
    
    private Map<String, String> recibirTablero(){
        try {
            ObjectInputStream entrada = new ObjectInputStream(conexion.getInputStream());
            Map<String, String> tablero = (Map<String, String>) entrada.readObject();
            
            return tablero;
        } catch (Exception ex) {
            System.out.println("*** Error al conseguir tablero ***");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void endClient() throws IOException{
        salidaServer.close();
        entradaServer.close();
        conexion.close();
    }

    public void enviarPregunta (String pregunta) {
        try {
            salidaServer.writeUTF(pregunta);
            System.out.println("Pregunta enviada: "+pregunta);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarRespuesta(boolean resp){
        String respuesta;
        
        if(resp)
            respuesta = "Si";
        else
            respuesta = "No";
        
        try {
            salidaServer.writeUTF(respuesta);
            System.out.println("Respuesta enviada: "+respuesta);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getMensaje(){
        return this.mensaje;
    }
}
