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
        return switch (this.tipo) {
            case 0 -> "Pregunta del jugador: " + this.texto;
            case 1 -> "Respuesta del jugador: " + this.texto;
            case 2 -> "Adivinanza del jugador: " + this.texto;
            case 3 -> "Cambiando a juego";
            default -> this.texto;
        }; // Es pregunta
        // Es respuesta
        // Es adivinar
    }
}
