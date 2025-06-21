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

public class Pregunta implements Serializable {
    private String pregunta;
    
    public Pregunta(String personal){
        this.pregunta=personal;
    }
    
    public Pregunta(String verbo, String complemento){
        this.pregunta="¿Tu personaje "+verbo+complemento+"?";
    }
    
    /*public Pregunta(String verbo, String complemento, String color){
        this.pregunta="¿Tu personaje "+verbo+complemento+color+"?";
    }*/

    @Override
    public String toString() {
        return "Pregunta del jugador: " + pregunta ;
    }
}
