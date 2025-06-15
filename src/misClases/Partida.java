/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

/**
 *
 * @author ferna
 */
public class Partida {
    String jugador1, jugador2, Ganador, Personaje;
    String fecha, tiempo;

    public Partida(String jugador1, String jugador2, String Ganador, String Personaje, String fecha, String tiempo) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.Ganador = Ganador;
        this.Personaje = Personaje;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getGanador() {
        return Ganador;
    }

    public void setGanador(String Ganador) {
        this.Ganador = Ganador;
    }

    public String getPersonaje() {
        return Personaje;
    }

    public void setPersonaje(String Personaje) {
        this.Personaje = Personaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
