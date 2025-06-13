/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elijah
 */
public class mainServidor {
    public static void main(String[] args) {
        try{
            Server server = new Server();
            server.startServer();
        }catch (IOException e){
            System.out.println(e.getMessage());
            Logger.getLogger(mainServidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
