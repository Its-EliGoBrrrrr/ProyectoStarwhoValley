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
                        if(mesg.getTipo() == 4){
                            this.preparado = true;
                            // System.out.println("Client "+this.nClient+" preparado ="+this.preparado);
                        } else if(nClient == 1){
                            server.clientes.get(1).salidaClient.writeObject(mesg);
                        }else{
                            server.clientes.get(0).salidaClient.writeObject(mesg);
                        }
                        System.out.println("Recibido: " + mesg);
                        // System.out.println("Entrada Mensaje");
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
    
    public boolean getPreparado(){
        System.out.println("Retornando "+preparado+" de Client "+this.nClient); // Esta linea es importante por alguna razon? Creo porque obliga el programa a correr la instruccion
        return preparado;
    }
}
