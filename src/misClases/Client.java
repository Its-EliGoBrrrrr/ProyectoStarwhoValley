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

class Mensaje implements Serializable {
    private String texto;
    private int tipo; // 0 = pregunta | 1 = respuesta | 2 = Adivinar | 3 = Cambiar a juego | 4 = cambiar estado de preparado
    
    public Mensaje(String texto, int tipo){
        this.texto=texto;
        this.tipo=tipo;
    }

    public String getTexto() {
        return texto;
    }

    public int getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
        switch (this.tipo) {
        // Es pregunta
            case 0:
                return "Pregunta del jugador: " + this.texto;
        // Es respuesta
            case 1:
                return "Respuesta del jugador: " + this.texto;
        // Es adivinar
            case 2:
                return "Adivinanza del jugador: " + this.texto;
            case 3:
                return "Cambiando a juego";
            default:
                return "Cadena vacia";
        }
    }
}

public class Client{
    private final JFAplicacion padre;
    private final int puerto = 1234;
    public static boolean continuar = true;
    private Socket conexion;
    private ObjectOutputStream salidaServer;
    private ObjectInputStream entradaServer;
    
    public Client(JFAplicacion padre) throws IOException{
        this.padre = padre;
        this.conexion = new Socket("127.0.0.2",puerto);
    }
    
    public void startClient() throws IOException{
        salidaServer = new ObjectOutputStream(conexion.getOutputStream()); // Manda informacion al Server
        entradaServer = new ObjectInputStream(conexion.getInputStream()); // Recibe informacion del Server
        
        new Thread(()->{ // Aqui voy a encargarme de que reciba los mensajes
            while(continuar){
                try{
                    Object entrada = entradaServer.readObject();
                    
                    // Cualquier mensaje se capta aqui
                    if(entrada instanceof Mensaje mesg){
                        System.out.println("Recibe un mensaje");
                        switch(mesg.getTipo()){
                            case 0: // Es pregunta
                                // Mostrar en el panel como pregunta
                                break;
                            case 1: // Es respuesta
                                // Mostrar en el panel como respuesta
                                break;
                            case 2: // Es intento de adivinar
                                // Decidir que hacer la verdad
                                break;
                            case 3:
                                padre.getSetUp().moverAJuego();
                                break;
                            default:
                                break;
                        }
                        System.out.println("Recibido: " + mesg);
                    }
                    // Aqui se captura el tablero
                    if(entrada instanceof ArrayList tablero){
                        System.out.println("Mandando tablero");
                        padre.getJuego().obtenerPersonajes(tablero);
                        padre.getSetUp().obtenerPersonajes(tablero);
                        salidaServer.writeUTF("Tablero recibido");
                        System.out.println("Mensaje de recibido enviado");
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
    
    public void enviarPreparado(){ // En esta parte por alguna razon hay un error aca fuerte
        System.out.println("Enviar preparado");
        try{
            Mensaje listo = new Mensaje("Jugador Listo",4);
            salidaServer.writeObject(listo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean cambiarAJuego(){
        return true;
    }
}
