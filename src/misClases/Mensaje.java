/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.io.*;

/**
 *
 * @author LENOVO
 */

public class Mensaje implements Serializable {
    private String texto;
    private int tipo; // 0 = pregunta | 1 = respuesta | 2 = Adivinar 
    
    public Mensaje(String texto, int tipo){
        this.texto=texto;
        this.tipo=tipo;
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
            default:
                return "Cadena vacia";
        }
    }
}
