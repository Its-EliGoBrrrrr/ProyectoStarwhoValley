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
    private final JFAplicacion padre;
    private final int puerto = 1234;
    public static boolean continuar = true;
    private Socket conexion;
    private ObjectOutputStream salidaServer;
    private ObjectInputStream entradaServer;

    private Mensaje respuesta;
    
    public Client(JFAplicacion padre) throws IOException{
        this.padre = padre;
        this.conexion = new Socket("127.0.0.2",puerto);
    }
    
    public void startClient() throws IOException{
        String mensaje;

        salidaServer = new ObjectOutputStream(conexion.getOutputStream()); // Manda informacion al Server
        entradaServer = new ObjectInputStream(conexion.getInputStream()); // Recibe informacion del Server
        
        new Thread(()->{ // Aqui voy a encargarme de que reciba los mensajes
            while(continuar){
                System.out.println("Corriendo cliente");
                try{
                    System.out.println("Entra Try-Catch");

                    Object entrada = entradaServer.readObject();
                    
                    if(entrada instanceof Mensaje mensaje1){
                        System.out.println("Recibe un mensaje");
                        respuesta = mensaje1;
                        System.out.println("Recibido: " + respuesta);
                    }
                    if(entrada instanceof ArrayList tablero){
                        System.out.println("Mandando tablero");
                        padre.getJuego().obtenerPersonajes(tablero);
                        padre.getSetUp().obtenerPersonajes(tablero);
                        salidaServer.writeUTF("Tablero recibido");
                    }
                    if(entrada instanceof String cadena){
                        System.out.println("Mensaje Server: " + cadena);
                    }
                }catch(Exception e){
                    System.out.println("Error en: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public void endClient() throws IOException{
        salidaServer.close();
        entradaServer.close();
        conexion.close();
    }

    public void enviarPregunta (String pregunta) {
        try {
            Mensaje mens = new Mensaje(pregunta,0);
            salidaServer.writeObject(mens);
            System.out.println("Pregunta enviada: "+pregunta);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarRespuesta(boolean resp){
        Mensaje respuesta;
        
        if(resp)
            respuesta = new Mensaje("Si",1);
        else
            respuesta = new Mensaje("No",1);
        
        try {
            salidaServer.writeObject(respuesta);
            System.out.println("Respuesta enviada: "+respuesta);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarAdivinar(String nombre){
        String pregunta = "¿Tu personaje es "+nombre+'?';
        
        try{
            Mensaje adivinar = new Mensaje(pregunta,2);
        }catch(Exception ex){
            
        }
    }
}
