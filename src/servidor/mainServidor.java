/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.IOException;

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
            
        }
    }
}
