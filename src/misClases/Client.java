/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

/**
 *
 * @author LENOVO
 */

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client{
    private final int puerto = 1234;
    public static boolean flag = true;
    // private static String pregunta;
    private Socket conexion;
    private DataOutputStream salidaServer;
    private BufferedReader entradaServer;
    
    public Client() throws IOException{
        this.conexion=new Socket("localhost",puerto);
    }
    
    public void startClient() throws IOException{
        String mensaje;
        
        salidaServer = new DataOutputStream(conexion.getOutputStream());
        entradaServer = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        
        salidaServer.writeUTF("Iniciando transmision\n");
        
        mensaje = entradaServer.readLine();
        System.out.println("Mensaje Server: "+mensaje);
    }
    /*
    public static void setPregunta(String preg){
        pregunta = preg;
    }
    */
    public void enviarPregunta (String pregunta) {
        try {
            salidaServer.writeUTF(pregunta);
            System.out.println("Pregunta enviada: "+pregunta);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recibirPregunta(){
        String pregunta = "Indeterminado";
        
        try {
            pregunta = entradaServer.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pregunta;
    }
    /*
    public void enviarRespuesta(){
        
    }
    
    public String recibirRespuesta(){
        return "";
    }
    */
}
