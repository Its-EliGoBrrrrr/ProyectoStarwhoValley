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
    
    public static List<String> ObtenerPreguntas(){
        
        String sql = "SELECT * FROM preguntas";
        List lista = new ArrayList<String>();
        
        try (Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()) {
                String pregunta = rs.getString("Pregunta");
                
                lista.add(pregunta);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return lista;
    }
}
