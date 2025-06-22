package servidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AttClient extends Thread {
    private boolean continuar;
    
    // Servidor
    private final Server server;
    private final Socket conexion;
    
    // Datos
    private boolean preparado;
    private boolean enTurno;
    private final int nClient;
    
    // Conexion
    private ObjectOutputStream salidaClient;
    private ObjectInputStream entradaClient;

    public AttClient(Server server, Socket conexion, int nClient) {
        this.server = server;
        this.conexion = conexion;
        this.nClient = nClient;
        this.continuar = true;
        this.preparado = false;
        this.enTurno = false;
    }
    
    @Override
    public void run() {
        try{
            // Entrada y Salida para cliente
            salidaClient = new ObjectOutputStream(conexion.getOutputStream()); // Manda informacion al cliente
            entradaClient = new ObjectInputStream(conexion.getInputStream()); // Recibe informacion del cliente
            
            while (continuar){
                try{
                    Mensaje entrada = (Mensaje)entradaClient.readObject();
                    
                    if(entrada instanceof Mensaje mesg){ // Problema viene de aqui, no puede leer mensajes por alguna razon
                        System.out.println("Recibe un mensaje tipo "+mesg.getTipo());
                        switch(mesg.getTipo()){
                            case 2:
                                break;
                            case 4:
                                this.preparado = true;
                                System.out.println("Client "+this.nClient+" preparado ="+this.preparado);
                                break;
                            case 5:
                                this.enTurno = false;
                                salidaClient.writeObject(new Mensaje("Bloqueo Botones",5));
                                System.out.println("Final de turno de Client "+this.nClient);
                                break;
                            case 6:
                                this.enTurno = false;
                                if(nClient == 1){
                                    //server.clientes.get(1).salidaClient.writeObject(mesg);
                                    server.clientes.get(1).enTurno = false;
                                } else{
                                    //server.clientes.get(0).salidaClient.writeObject(mesg);
                                    server.clientes.get(0).enTurno = false;
                                }
                                break;
                            default:
                                if(nClient == 1){
                                    server.clientes.get(1).salidaClient.writeObject(mesg);
                                } else{
                                    server.clientes.get(0).salidaClient.writeObject(mesg);
                                }
                                break;
                        }
                        
                        System.out.println("Recibido: " + mesg);
                    }
                }catch(ObjectStreamException e){
                    System.out.println("Servidor || Error en: " + e.getMessage());
                    // e.printStackTrace();
                    Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, e);
                }catch(Exception e){
                    System.out.println("Servidor || Error en: " + e.getMessage());
                    // e.printStackTrace();
                    Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            System.out.println("Final de conexion con Client: " + this.nClient);
            
            salidaClient.close();
            entradaClient.close();
            conexion.close();
        }catch(IOException e){
            System.out.println("*** Error al conectar cliente: "+e.getMessage()+" ***");
            e.printStackTrace();
        }
    }
    
    public void enviarTablero(ArrayList tablero){
        try {
            System.out.println("Recibiendo tablero");
            salidaClient.writeObject(tablero);
        } catch (IOException ex) {
            Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(Mensaje mesg){
        try{
            System.out.println("Enviando Mensaje: "+mesg.getTexto());
            salidaClient.writeObject(mesg);
        } catch (Exception ex) {
            System.out.println("*** Error al enviar objeto Mensaje ***");
            Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarFrame(){
        try {
            salidaClient.writeObject(new Mensaje("",3));
        } catch (IOException ex) {
            Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getnClient() {
        return nClient;
    }
    
    public void setPreparado(boolean flag){
        this.preparado = flag;
    }
    
    public boolean getPreparado(){
        System.out.println("Client "+this.nClient+" preparado = "+this.preparado);
        /*try {
            wait(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return preparado;
    }
    
    public void setTurno(boolean turno){
        this.enTurno = turno;
    }
    
    public boolean getTurno(){
        try {
            wait(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(AttClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.enTurno;
    }
}
