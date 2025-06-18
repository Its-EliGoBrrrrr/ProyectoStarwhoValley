package servidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
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
                // System.out.println("Corriendo server client "+this.nClient);
                try{
                    Object entrada = entradaClient.readObject();
                    
                    if(entrada instanceof Mensaje mesg){ // Problema viene de aqui, no puede leer mensajes por alguna razon
                        /*System.out.println("Recibe un mensaje tipo "+mesg.getTipo());
                        if(mesg.getTipo() == 4){
                            this.preparado = true;
                            break;
                        }
                        if(nClient == 1){
                            server.clientes.get(1).salidaClient.writeObject(mesg);
                        }else{
                            server.clientes.get(0).salidaClient.writeObject(mesg);
                        }
                        System.out.println("Recibido: " + mesg);*/
                        System.out.println("Entrada Mensaje");
                    }
                }catch(Exception e){
                    System.out.println("Error en: " + e.getMessage());
                    e.printStackTrace();
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
        String mensaje = "";
        try {
            System.out.println("Recibiendo tablero");
            salidaClient.writeObject(tablero);
        } catch (IOException ex) {
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
        return preparado;
    }
}
