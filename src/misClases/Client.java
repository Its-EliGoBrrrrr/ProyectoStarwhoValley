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
import java.net.Socket;

public class Client{
    public static Pregunta pregunta;
    
    public static void enviarPregunta () {
        try (Socket socket = new Socket("localhost", 8643)) {
            // Crear flujo de salida para enviar el objeto
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // Serializar el objeto y enviarlo
            out.writeObject(pregunta);
            System.out.println("Objeto enviado: " + pregunta);

            // Cerrar el flujo y el socket
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String recibirPregunta(){
        return "";
    }
    
    public static void enviarRespuesta(){
        
    }
    
    public static String recibirRespuesta(){
        return "";
    }
}
