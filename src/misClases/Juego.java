/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.util.Timer;



/**
 *
 * @author LENOVO
 */

public class Juego {
    private String jugador, personaje;
    Timer tiempo;

    public Juego(String jugador, String personaje, Timer tiempo) {
        this.jugador = jugador;
        this.personaje = personaje;
        this.tiempo = tiempo;
    }

    public String getJugador() {
        return jugador;
    }

    public String getPersonaje() {
        return personaje;
    }

    public Timer getTiempo() {
        return tiempo;
    }
    
    
}
