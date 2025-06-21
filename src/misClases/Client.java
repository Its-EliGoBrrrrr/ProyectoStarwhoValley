/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import misPruebas.JFAplicacion;
import servidor.Mensaje;
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
                        System.out.println("*** Recibe un mensaje ***");
                        switch(mesg.getTipo()){
                            case 0: // Es pregunta
                                this.padre.getJuego().mostrarPregunta(mesg.getTexto());
                                break;
                            case 1: // Es respuesta
                                this.padre.getJuego().mostrarRespuesta(mesg.getTexto());
                                break;
                            case 2: // Es intento de adivinar
                                // Decidir que hacer la verdad
                                break;
                            case 3: // Cambia el display
                                padre.getSetUp().moverAJuego();
                                break;
                            /*case 4: // Comienzo de turno y desbloqueo de botones
                                System.out.println("Desbloqueando Botones");
                                padre.getJuego().desbloquearBotones();
                                break;*/
                            case 5: // Fin de turno, tiene que bloquear los botones del panel
                                System.out.println("Bloqueando Botones");
                                padre.getJuego().bloquearBotones();
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
                        // salidaServer.writeUTF("Tablero recibido");
                        // System.out.println("Mensaje de recibido enviado");
                    }
                    
                }catch(Exception e){
                    System.out.println("Cliente || Error en: " + e.getMessage());
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
            System.out.println("Problema al enviar pregunta");
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
    
    public void finDeTurno(){
        try {
            Mensaje fin = new Mensaje ("Fin de turno",5);
            salidaServer.writeObject(fin);
        } catch (IOException ex) {
            System.out.println("*** Problema Terminando Turno ***");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean cambiarAJuego(){
        return true;
    }
}
