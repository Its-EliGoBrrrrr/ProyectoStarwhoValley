package servidor;

import java.io.*;
import java.net.*;

public class AttClient extends Thread {
    private boolean continuar;
    private final Server server;
    private final Socket conexion;
    private final int nClient;

    public AttClient(Server server, Socket conexion, int nClient) {
        this.server = server;
        this.conexion = conexion;
        this.nClient = nClient;
        this.continuar=true;
    }
    
    @Override
    public void run() {
        DataOutputStream salidaClient;
        DataInputStream entradaClient;
        String pregunta;
        
        try{
            // Entrada y Salida para cliente
            salidaClient = new DataOutputStream(conexion.getOutputStream()); // Manda informacion
            entradaClient = new DataInputStream(conexion.getInputStream()); // Recibe informacion
            
            if(server.nuevoJuego == true){
                
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
            */
            salidaClient.close();
            entradaClient.close();
            conexion.close();
        }catch(IOException e){
            System.out.println("*** Error al conectar cliente: "+e.getMessage()+" ***");
        }
    }
    
}
