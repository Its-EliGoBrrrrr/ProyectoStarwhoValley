/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.io.Serializable;
import java.time.LocalTime;


/**
 *
 * @author LENOVO
 */

public class Juego implements Serializable{
    private String jugador, personaje;
    // Timer tiempo;
    LocalTime tiempo;

    public Juego(String jugador, String personaje, /*Timer tiempo,*/ int s, int m, int h) {
        this.jugador = jugador;
        this.personaje = personaje;
        // this.tiempo = tiempo;
        this.tiempo = LocalTime.of(h, m, s);
    }

    public String getJugador() {
        return jugador;
    }

    public String getPersonaje() {
        return personaje;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }
}
