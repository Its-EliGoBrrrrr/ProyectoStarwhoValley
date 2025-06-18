package servidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class AttClient extends Thread {
    private boolean continuar;
    private final Server server;
    private final Socket conexion;
    private final int nClient;

    public AttClient(Server server, Socket conexion, int nClient) {
        this.server = server;
        this.conexion = conexion;
        this.nClient = nClient;
        this.continuar = true;
    }
    
    @Override
    public void run() {
        ObjectOutputStream salidaClient;
        ObjectInputStream entradaClient;
        String pregunta;
        
        try{
            // Entrada y Salida para cliente
            salidaClient = new ObjectOutputStream(conexion.getOutputStream()); // Manda informacion al cliente
            entradaClient = new ObjectInputStream(conexion.getInputStream()); // Recibe informacion del cliente
            
            // System.out.println(entradaClient.readUTF());
            
            while(continuar){
                if(server.nuevoJuego == true){
                    ArrayList tablero = server.crearTablero();
                    salidaClient.writeObject(tablero);
                    while(entradaClient.readUTF() == null){
                        
                    }
                    System.out.println("Tablero Enviado");
                    System.out.println(entradaClient.readUTF());
                    server.nuevoJuego = false;
                }
            }
            /*
            pregunta = entradaClient.readLine();
            System.out.println("Mensaje Client: " + pregunta);

            // Enviar mensaje
            salidaClient.writeUTF("Conexion aceptada. Esperando instruccion\n");

            // Se ejecuta mientras haya mensajes

            while (continuar){
                if((pregunta = entradaClient.readLine()) != null){
                    System.out.println("Mensaje Client: " + pregunta);
                }
            }

            System.out.println("Final de conexion con Client: " + this.nClient);
            
            salidaClient.close();
            entradaClient.close();
            conexion.close();
*/
        }catch(IOException e){
            System.out.println("*** Error al conectar cliente: "+e.getMessage()+" ***");
            e.printStackTrace();
        }
    }
    
}
