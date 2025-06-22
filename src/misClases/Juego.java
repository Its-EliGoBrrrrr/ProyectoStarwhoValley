/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.io.Serializable;
import java.util.Timer;
import java.time.LocalTime;


/**
 *
 * @author LENOVO
 */

public class Juego implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;
    private String jugador, personaje;
    LocalTime tiempo;
    Boolean ganador;

    public Juego(String jugador, String personaje, int s, int m, int h, boolean ganador) {
        this.jugador = jugador;
        this.personaje = personaje;
        this.tiempo = LocalTime.of(h, m, s);
        this.ganador = ganador;
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
    
    public Boolean getGanador(){
        return ganador;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugador=" + jugador + ", personaje=" + personaje + ", tiempo=" + tiempo + ", ganador=" + ganador + '}';
    }
    
    
}
