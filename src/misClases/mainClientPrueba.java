/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class mainClientPrueba {
    public static void main(String[] args) {
        Client client1, client2;
        
        try {
            client1 = new Client();
            client2 = new Client();
            
            client1.startClient();
            client2.startClient();
            
            client1.enviarPregunta("Texto texto texto");
            client1.enviarPregunta("aaaaaaaaaaaaaaaaaa");
            client2.enviarRespuesta(false);
            client1.enviarRespuesta(true);
            client2.enviarPregunta("Trikitraka");
            
            client1.endClient();
            client2.endClient();
        } catch (IOException ex) {
            Logger.getLogger(mainClientPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
