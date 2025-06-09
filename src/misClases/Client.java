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

public class Client implements Runnable{
    private final int puerto = 1234;
    public static boolean flag = true;
    private Socket conexion;
    private DataOutputStream salidaServer;
    private BufferedReader entradaServer;
    private String mensaje;
    
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
            respuesta = "no";
        
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

    @Override
    public void run() {
        while(flag){
            try {
                if(entradaServer.readLine() != null){
                    mensaje = entradaServer.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
