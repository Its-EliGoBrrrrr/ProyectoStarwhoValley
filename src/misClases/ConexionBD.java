/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.sql.*;
import java.util.*;

/**
 *
 * @author ferna
 */
public class ConexionBD {
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/starwho_valley";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("*** Conexion exitosa ***");
            return conn;
        } catch (Exception e) {
            System.out.println("*** Fallo de conexion ***");
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Personaje> obtenerPersonajes(){
        String sql = "SELECT * FROM personajes";
        List lista = new ArrayList<Personaje>();
        
        try (Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    Personaje pers = new Personaje(
                        rs.getString("Nombre"),
                        rs.getString("Imagen"),
                        rs.getInt("Id")
                    );
                    lista.add(pers);
                }
        } catch (Exception e) {
            System.out.println("*** Error al cargar los personajes ***");
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public static boolean guardarPartida(Partida partida){
        
        String sql = "INSERT INTO partidas (ID, jugador_1, Jugador_2, Ganador, Personaje, Fecha, Duracion_partida) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            
            stmt.setString(1, partida.getJugador1());
            stmt.setString(2, partida.getJugador2());
            stmt.setString(3, partida.getGanador());
            stmt.setString(4, partida.getPersonaje());
            stmt.setString(5, partida.getFecha());
            stmt.setString(6, partida.getTiempo());
            
            int filas = stmt.executeUpdate();
            return filas > 0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    //Se usa opciones para elegir que preguntas a importar
    public static Vector<String> ObtenerPreguntas(int tabla,int tipo){
        String sql;
        String pregunta,variable="";
        int id;
        
        switch (tabla) {
            case 1: // Tabla de sujetos
                sql = "SELECT * FROM pregunta_sujeto";
                pregunta = "Pregunta";
                break;
            case 2: // Tabla de objetos
                sql = "SELECT * FROM pregunta_objeto";
                pregunta = "objeto";
                break;
            case 3: // Tabla de adjetivos
                sql = "SELECT * FROM pregunta_adjetivo";
                pregunta = "adjetivo";
                break;
            default:
                throw new AssertionError();
        }

        Vector lista = new Vector<String>();
        
        try (Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()) {
                id = rs.getInt("id");
                switch(tipo){
                case 0: // Solo las interogantes
                    variable = rs.getString(pregunta);
                    lista.add(variable);
                    break;
                case 1: // Es
                    if(id<=6){
                        variable = rs.getString(pregunta);
                        lista.add(variable);
                    }
                    break;
                case 2: // Tiene
                    if(id>6){
                        variable = rs.getString(pregunta);
                        lista.add(variable);
                    }
                    break;
                case 3: // Cejas
                    if(id<=2){
                        variable = rs.getString(pregunta);
                        lista.add(variable);
                    }
                    break;
                case 4: // Pelo
                    if(id == 3 || id == 4){
                        variable = rs.getString(pregunta);
                        lista.add(variable);
                    }
                    break;
                case 5: // Color
                    if(id>=5 && id<=13){
                        variable = rs.getString(pregunta);
                        lista.add(variable);
                    }
                    break;
                case 6: // Piel
                    if(id>=14 && id<=16){
                        variable = rs.getString(pregunta);
                        lista.add(variable);
                    }
                    break;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return lista;
    }
}
