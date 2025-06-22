/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.Serializable;

/**
 *
 * @author Elijah
 */
public class Mensaje implements Serializable {
    private String texto;
    private Integer tipo; // 0 = pregunta | 1 = respuesta | 2 = Adivinar | 3 = Cambiar a juego | 4 = Inicio de turno y Desbloquear Botones | 5 = Fin de turno y Bloquear Botones | 6 = Fin de juego | 7 = Ganador/Perdedor
    
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
                return this.texto;
        }
    }
}
