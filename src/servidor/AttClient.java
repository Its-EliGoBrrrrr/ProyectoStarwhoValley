package servidor;

import java.io.*;
import java.net.*;

public class AttClient extends Thread {
    private boolean continuar;
    private final Socket conexion;
    private final int nClient;

    public AttClient(Socket conexion, int nClient) {
        this.conexion = conexion;
        this.nClient = nClient;
        this.continuar=true;
    }
    
    @Override
    public void run() {
        DataOutputStream salidaClient;
        BufferedReader entradaClient;
        String pregunta;
        
        try{
            // Entrada y Salida para cliente
            salidaClient = new DataOutputStream(conexion.getOutputStream());
            entradaClient = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            pregunta = entradaClient.readLine();
            System.out.println("Mensaje Client: "+pregunta);

            // Enviar mensaje
            salidaClient.writeUTF("Conexion aceptada. Esperando instruccion\n");

            // Se ejecuta mientras haya mensajes

            while (continuar){
                if((pregunta = entradaClient.readLine()) != null){
                    System.out.println("Mensaje Client: "+pregunta);
                }
            }

            System.out.println("Final de conexion con Client: "+this.nClient);
            
            salidaClient.close();
            entradaClient.close();
            conexion.close();
        }catch(IOException e){
            System.out.println("*** Error al conectar cliente: "+e.getMessage()+" ***");
        }
    }
    
}
