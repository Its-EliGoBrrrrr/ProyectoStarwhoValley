/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package misClases;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import javax.swing.Timer;

public class JPJuego extends JPanel {
    // Variables
    private Image imgFondo; //Fondo
    
    // Datos preguntas
    private Vector<String> interrogativo;       // Tipo 0
    private Vector<String> verboEs;             // Tipo 1
    private Vector<String> verboTiene;          // Tipo 2
    private Vector<String> complementoCeja;     // Tipo 3
    private Vector<String> complementoPelo;     // Tipo 4
    private Vector<String> complementoColor;    // Tipo 5
    private Vector<String> complementoPiel;     // Tipo 6
    private boolean esTiene;
    
    // Datos Juego
    private ArrayList<Personaje> personajes = new ArrayList<>(); //Personajes en el tablero
    private ArrayList<ImageIcon> iconos = new ArrayList<>(); // Imagenes en uso (Personajes en el tablero)
    private ArrayList<JLabel> labelsImg; //Lista de los labels de las imagenes
    private ArrayList<JLabel> labelsNoms; //Lista de los labels de los nombres
    private JLabel seleccionado; //Personaje elegido para adivinar
    private static Juego resultados; // Guarda resultados finales de la partida
    
    // Datos jugador
    private static String nombre = ""; //Nombre del jugador
    private Personaje miPersonaje; //El personaje con el que se juega
    private boolean clicElegir; //Comprobar si se elegira el personaje por el tablero
    private Client jugador; 
    
    // Timer
    private int segundos; //Segundos del timer
    private int minutos; //Minutos del timer
    private int horas; //Horas del timer
    private Timer cronometro; //El timer
    private Date fecha; //Fecha del momento
    private SimpleDateFormat formato1, formato2; //Formatos de fecha
    
    // Creates new form JPJuego
    public JPJuego(Client jugador) {
        addComponentListener(new ComponentAdapter(){
            @Override
            public void componentShown(ComponentEvent evt){
                clicElegir=false;
                jLabelPersonajeJugable.setIcon(null);
                segundos = 0;
                minutos = 0;
                horas = 0;
                cronometro.start();
                jLabelJugador.setText(nombre);
                
                fecha = new Date();
                //Normalizer es para "normalizar" el string y poder usar replaceAll para quitar los acentos
                // \\p{M} es el unicode de los acentos
                //format es para obtener solo ciertas cosas de la fecha de cierta manera
                jLabelFecha1.setText(Normalizer.normalize(formato1.format(fecha),Normalizer.Form.NFD).replaceAll("\\p{M}",""));
                jLabelFecha2.setText(formato2.format(fecha));
                ZonaPreguntaRespuesta.setText("");
                
                elegirPersonaje();
                cargarOpcionesPregunta();
            }
        });
        
        // Fuente estandar utilizada por el Panel
        this.setFont(StardewFonts.getSVThin());
        this.jugador = jugador;
        
        // Insertar imagen de fondo en el Panel
        try{
            imgFondo = ImageIO.read(new File("src/Resources/Fondos/TablonEspecial2.png"));
        }catch(Exception e){
            System.out.println("*** Error cargando fondo de panel ***");
            e.printStackTrace();
        }
        
        // Inicializa componentes
        initComponents();
        // cargarOpcionesPregunta();
        
        // Acciones que se tienen que tomar despues de inicializar
        this.labelsImg = new ArrayList<>(Arrays.asList(jLabelPersonaje1, jLabelPersonaje2, jLabelPersonaje3, jLabelPersonaje4,
            jLabelPersonaje5, jLabelPersonaje6, jLabelPersonaje7, jLabelPersonaje8,
            jLabelPersonaje9, jLabelPersonaje10, jLabelPersonaje11, jLabelPersonaje12,
            jLabelPersonaje13, jLabelPersonaje14, jLabelPersonaje15, jLabelPersonaje16,
            jLabelPersonaje17, jLabelPersonaje18, jLabelPersonaje19, jLabelPersonaje20,
            jLabelPersonaje21, jLabelPersonaje22, jLabelPersonaje23, jLabelPersonaje24
        ));
        this.labelsNoms = new ArrayList<>(Arrays.asList(jLabelNombre1, jLabelNombre2, jLabelNombre3, jLabelNombre4,
                jLabelNombre5, jLabelNombre6, jLabelNombre7, jLabelNombre8,
                jLabelNombre9, jLabelNombre10, jLabelNombre11, jLabelNombre12,
                jLabelNombre13, jLabelNombre14, jLabelNombre15, jLabelNombre16,
                jLabelNombre17, jLabelNombre18, jLabelNombre19, jLabelNombre20,
                jLabelNombre21, jLabelNombre22, jLabelNombre23, jLabelNombre24
                
        ));
        
        this.jButtonMusica.setIcon(ButtonIcons.getMusicButtonNormal());
        this.jLabelFondoReloj.setIcon(new ImageIcon("src/Resources/Assets/RelojB.png"));
        formato1 = new SimpleDateFormat("EEE  d");
        formato2 = new SimpleDateFormat("MMMM  yyyy");
        
        cronometro = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                segundos++;
                if(segundos == 60){
                    segundos = 0;
                    minutos++;
                    if(minutos == 60){
                        minutos = 0;
                        horas++;
                    }
                }
                String duracion = String.format("%02d : %02d : %02d",horas,minutos,segundos);
                duracion = duracion.replaceAll("", " ");
                jLabelTiempo.setText(duracion);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPersonaje1 = new javax.swing.JLabel();
        jLabelPersonaje2 = new javax.swing.JLabel();
        jLabelPersonaje3 = new javax.swing.JLabel();
        jLabelPersonaje4 = new javax.swing.JLabel();
        jLabelPersonaje5 = new javax.swing.JLabel();
        jLabelPersonaje6 = new javax.swing.JLabel();
        jLabelPersonaje7 = new javax.swing.JLabel();
        jLabelPersonaje8 = new javax.swing.JLabel();
        jLabelPersonaje9 = new javax.swing.JLabel();
        jLabelPersonaje10 = new javax.swing.JLabel();
        jLabelPersonaje11 = new javax.swing.JLabel();
        jLabelPersonaje12 = new javax.swing.JLabel();
        jLabelPersonaje13 = new javax.swing.JLabel();
        jLabelPersonaje14 = new javax.swing.JLabel();
        jLabelPersonaje15 = new javax.swing.JLabel();
        jLabelPersonaje16 = new javax.swing.JLabel();
        jLabelPersonaje17 = new javax.swing.JLabel();
        jLabelPersonaje18 = new javax.swing.JLabel();
        jLabelPersonaje19 = new javax.swing.JLabel();
        jLabelPersonaje20 = new javax.swing.JLabel();
        jLabelPersonaje21 = new javax.swing.JLabel();
        jLabelPersonaje22 = new javax.swing.JLabel();
        jLabelPersonaje23 = new javax.swing.JLabel();
        jLabelPersonaje24 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelNombre2 = new javax.swing.JLabel();
        jLabelNombre3 = new javax.swing.JLabel();
        jLabelNombre4 = new javax.swing.JLabel();
        jLabelNombre5 = new javax.swing.JLabel();
        jLabelNombre6 = new javax.swing.JLabel();
        jLabelNombre7 = new javax.swing.JLabel();
        jLabelNombre8 = new javax.swing.JLabel();
        jLabelNombre9 = new javax.swing.JLabel();
        jLabelNombre10 = new javax.swing.JLabel();
        jLabelNombre11 = new javax.swing.JLabel();
        jLabelNombre12 = new javax.swing.JLabel();
        jLabelNombre13 = new javax.swing.JLabel();
        jLabelNombre14 = new javax.swing.JLabel();
        jLabelNombre15 = new javax.swing.JLabel();
        jLabelNombre16 = new javax.swing.JLabel();
        jLabelNombre17 = new javax.swing.JLabel();
        jLabelNombre18 = new javax.swing.JLabel();
        jLabelNombre19 = new javax.swing.JLabel();
        jLabelNombre20 = new javax.swing.JLabel();
        jLabelNombre21 = new javax.swing.JLabel();
        jLabelNombre22 = new javax.swing.JLabel();
        jLabelNombre23 = new javax.swing.JLabel();
        jLabelNombre24 = new javax.swing.JLabel();
        jLabelPersonajeJugable = new javax.swing.JLabel();
        jLabelNombreJugable = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelJugador = new javax.swing.JLabel();
        jButtonMusica = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelPregunta1 = new javax.swing.JLabel();
        jComboBoxPregunta1 = new javax.swing.JComboBox<>();
        jComboBoxPregunta2 = new javax.swing.JComboBox<>();
        jComboBoxPregunta3 = new javax.swing.JComboBox<>();
        jLabelPregunta2 = new javax.swing.JLabel();
        jButtonDefQue = new javax.swing.JButton();
        jTextFieldQuestion = new javax.swing.JTextField();
        jButtonPersQue = new javax.swing.JButton();
        jLabelAdivinar = new javax.swing.JLabel();
        jButtonAdivinar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ZonaPreguntaRespuesta = new javax.swing.JTextArea();
        jPanelReloj = new javax.swing.JPanel();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelFecha1 = new javax.swing.JLabel();
        jLabelFecha2 = new javax.swing.JLabel();
        jLabelFondoReloj = new javax.swing.JLabel();

        setFont(getFont());
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabelPersonaje1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelPersonaje24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonajeMouseClicked(evt);
            }
        });

        jLabelNombre1.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre1.setFont(StardewFonts.getSVBold());
        jLabelNombre1.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre1.setText("jLabel1");
        jLabelNombre1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre1.setOpaque(true);

        jLabelNombre2.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre2.setFont(StardewFonts.getSVBold());
        jLabelNombre2.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre2.setText("jLabel1");
        jLabelNombre2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre2.setOpaque(true);

        jLabelNombre3.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre3.setFont(StardewFonts.getSVBold());
        jLabelNombre3.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre3.setText("jLabel1");
        jLabelNombre3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre3.setOpaque(true);

        jLabelNombre4.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre4.setFont(StardewFonts.getSVBold());
        jLabelNombre4.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre4.setText("jLabel1");
        jLabelNombre4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre4.setOpaque(true);

        jLabelNombre5.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre5.setFont(StardewFonts.getSVBold());
        jLabelNombre5.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre5.setText("jLabel1");
        jLabelNombre5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre5.setOpaque(true);

        jLabelNombre6.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre6.setFont(StardewFonts.getSVBold());
        jLabelNombre6.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre6.setText("jLabel1");
        jLabelNombre6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre6.setOpaque(true);

        jLabelNombre7.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre7.setFont(StardewFonts.getSVBold());
        jLabelNombre7.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre7.setText("jLabel1");
        jLabelNombre7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre7.setOpaque(true);

        jLabelNombre8.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre8.setFont(StardewFonts.getSVBold());
        jLabelNombre8.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre8.setText("jLabel1");
        jLabelNombre8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre8.setOpaque(true);

        jLabelNombre9.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre9.setFont(StardewFonts.getSVBold());
        jLabelNombre9.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre9.setText("jLabel1");
        jLabelNombre9.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre9.setOpaque(true);

        jLabelNombre10.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre10.setFont(StardewFonts.getSVBold());
        jLabelNombre10.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre10.setText("jLabel1");
        jLabelNombre10.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre10.setOpaque(true);

        jLabelNombre11.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre11.setFont(StardewFonts.getSVBold());
        jLabelNombre11.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre11.setText("jLabel1");
        jLabelNombre11.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre11.setOpaque(true);

        jLabelNombre12.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre12.setFont(StardewFonts.getSVBold());
        jLabelNombre12.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre12.setText("jLabel1");
        jLabelNombre12.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre12.setOpaque(true);

        jLabelNombre13.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre13.setFont(StardewFonts.getSVBold());
        jLabelNombre13.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre13.setText("jLabel1");
        jLabelNombre13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre13.setOpaque(true);

        jLabelNombre14.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre14.setFont(StardewFonts.getSVBold());
        jLabelNombre14.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre14.setText("jLabel1");
        jLabelNombre14.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre14.setOpaque(true);

        jLabelNombre15.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre15.setFont(StardewFonts.getSVBold());
        jLabelNombre15.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre15.setText("jLabel1");
        jLabelNombre15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre15.setOpaque(true);

        jLabelNombre16.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre16.setFont(StardewFonts.getSVBold());
        jLabelNombre16.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre16.setText("jLabel1");
        jLabelNombre16.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre16.setOpaque(true);

        jLabelNombre17.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre17.setFont(StardewFonts.getSVBold());
        jLabelNombre17.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre17.setText("jLabel1");
        jLabelNombre17.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre17.setOpaque(true);

        jLabelNombre18.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre18.setFont(StardewFonts.getSVBold());
        jLabelNombre18.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre18.setText("jLabel1");
        jLabelNombre18.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre18.setOpaque(true);

        jLabelNombre19.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre19.setFont(StardewFonts.getSVBold());
        jLabelNombre19.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre19.setText("jLabel1");
        jLabelNombre19.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre19.setOpaque(true);

        jLabelNombre20.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre20.setFont(StardewFonts.getSVBold());
        jLabelNombre20.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre20.setText("jLabel1");
        jLabelNombre20.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre20.setOpaque(true);

        jLabelNombre21.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre21.setFont(StardewFonts.getSVBold());
        jLabelNombre21.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre21.setText("jLabel1");
        jLabelNombre21.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre21.setOpaque(true);

        jLabelNombre22.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre22.setFont(StardewFonts.getSVBold());
        jLabelNombre22.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre22.setText("jLabel1");
        jLabelNombre22.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre22.setOpaque(true);

        jLabelNombre23.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre23.setFont(StardewFonts.getSVBold());
        jLabelNombre23.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre23.setText("jLabel1");
        jLabelNombre23.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre23.setOpaque(true);

        jLabelNombre24.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombre24.setFont(StardewFonts.getSVBold());
        jLabelNombre24.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombre24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre24.setText("jLabel1");
        jLabelNombre24.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombre24.setOpaque(true);

        jLabelNombreJugable.setBackground(new java.awt.Color(218, 173, 114));
        jLabelNombreJugable.setFont(StardewFonts.getSVBold());
        jLabelNombreJugable.setForeground(new java.awt.Color(85, 23, 12));
        jLabelNombreJugable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreJugable.setText("jLabel1");
        jLabelNombreJugable.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(177, 78, 5)));
        jLabelNombreJugable.setOpaque(true);

        jLabelTitulo.setBackground(new java.awt.Color(218, 173, 114));
        jLabelTitulo.setFont(StardewFonts.getSVSmallTitle());
        jLabelTitulo.setForeground(new java.awt.Color(85, 23, 12));
        jLabelTitulo.setText("Starwho Valley");
        jLabelTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(177, 78, 5)));
        jLabelTitulo.setOpaque(true);

        jLabelJugador.setFont(StardewFonts.getSVBold());
        jLabelJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJugador.setText("Nombre");

        jButtonMusica.setBackground(new Color(0,0,0,0));
        jButtonMusica.setMaximumSize(new java.awt.Dimension(40, 40));
        jButtonMusica.setMinimumSize(new java.awt.Dimension(40, 40));
        jButtonMusica.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMusicaMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 210, 152));

        jLabelPregunta1.setFont(StardewFonts.getSVThin());
        jLabelPregunta1.setText("Tu Personaje");

        jComboBoxPregunta1.setFont(StardewFonts.getSVThin());
        jComboBoxPregunta1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPregunta1ItemStateChanged(evt);
            }
        });

        jComboBoxPregunta2.setFont(StardewFonts.getSVThin());
        jComboBoxPregunta2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPregunta2ItemStateChanged(evt);
            }
        });

        jComboBoxPregunta3.setFont(StardewFonts.getSVThin());

        jLabelPregunta2.setFont(StardewFonts.getSVThin());
        jLabelPregunta2.setText("?");

        jButtonDefQue.setFont(StardewFonts.getSVThin());
        jButtonDefQue.setText("Enviar");
        jButtonDefQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefQueActionPerformed(evt);
            }
        });

        jTextFieldQuestion.setFont(getFont());

        jButtonPersQue.setFont(StardewFonts.getSVThin());
        jButtonPersQue.setText("Enviar");
        jButtonPersQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersQueActionPerformed(evt);
            }
        });

        jLabelAdivinar.setFont(StardewFonts.getSVBold());
        jLabelAdivinar.setText("Crees que ya lo tienes?");

        jButtonAdivinar.setFont(StardewFonts.getSVBold());
        jButtonAdivinar.setText("ADIVINAR");
        jButtonAdivinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdivinarActionPerformed(evt);
            }
        });

        ZonaPreguntaRespuesta.setEditable(false);
        ZonaPreguntaRespuesta.setColumns(20);
        ZonaPreguntaRespuesta.setFont(getFont());
        ZonaPreguntaRespuesta.setRows(5);
        jScrollPane1.setViewportView(ZonaPreguntaRespuesta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabelAdivinar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdivinar)
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPregunta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPregunta3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPregunta2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPersQue)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButtonDefQue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPregunta1)
                    .addComponent(jComboBoxPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPregunta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPregunta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDefQue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPersQue))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdivinar)
                    .addComponent(jButtonAdivinar))
                .addGap(20, 20, 20))
        );

        jPanelReloj.setBackground(new java.awt.Color(255, 255, 255));
        jPanelReloj.setOpaque(false);
        jPanelReloj.setLayout(null);

        jLabelTiempo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTiempo.setFont(StardewFonts.getSVBold());
        jLabelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTiempo.setText("0 0 : 0 0 : 0 0");
        jLabelTiempo.setVerifyInputWhenFocusTarget(false);
        jPanelReloj.add(jLabelTiempo);
        jLabelTiempo.setBounds(10, 146, 180, 20);

        jLabelFecha1.setFont(StardewFonts.getSVBold());
        jLabelFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha1.setText("Fecha");
        jPanelReloj.add(jLabelFecha1);
        jLabelFecha1.setBounds(81, 20, 110, 20);

        jLabelFecha2.setFont(StardewFonts.getSVBold());
        jLabelFecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha2.setText("Fecha");
        jPanelReloj.add(jLabelFecha2);
        jLabelFecha2.setBounds(80, 80, 110, 20);
        jPanelReloj.add(jLabelFondoReloj);
        jLabelFondoReloj.setBounds(0, 0, 214, 175);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPersonaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPersonaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPersonaje5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPersonaje7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPersonaje11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPersonaje13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelPersonaje14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelPersonaje15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNombre16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPersonaje16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNombre19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPersonaje19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNombre13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombre15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPersonaje21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPersonaje23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNombre21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombre23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelNombre18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPersonaje18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelPersonaje24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(402, 402, 402)
                                .addComponent(jButtonMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPersonajeJugable, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombreJugable, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addComponent(jLabelPersonajeJugable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNombreJugable, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jPanelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPersonaje5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPersonaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPersonaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPersonaje6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPersonaje7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPersonaje11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNombre11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPersonaje12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNombre12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPersonaje13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPersonaje16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPersonaje18, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNombre18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPersonaje19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPersonaje21, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje22, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje23, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPersonaje24, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPersonajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPersonajeMouseClicked
        if(clicElegir == false){
            JLabel labelClick = (JLabel)evt.getSource();
            int n = labelsImg.indexOf(labelClick);
            if(evt.getButton() == MouseEvent.BUTTON1){
                if(labelClick.getIcon() == iconos.get(n)){
                    ImageIcon vacio = new ImageIcon("src/Resources/Assets/CardBackdrop.png");
                    labelClick.setIcon(new ImageIcon(vacio.getImage().getScaledInstance(100, 99, Image.SCALE_SMOOTH)));
                }
                else{
                    labelClick.setIcon(iconos.get(n));
                }
            }
            else if(evt.getButton() == MouseEvent.BUTTON3){
                if(seleccionado != null && seleccionado == labelClick && seleccionado.getBorder()!=null){
                    seleccionado.setBorder(null);
                }
                else{
                    if(seleccionado != null){
                        seleccionado.setBorder(null);
                    }
                    seleccionado = labelClick;
                    Border borde = BorderFactory.createLineBorder(new Color(255,64,96), 5);
                    seleccionado.setBorder(borde);
                }
            }
        }
        else{
            clicElegir=false;
            JLabel labelClick = (JLabel)evt.getSource();
            int n = labelsImg.indexOf(labelClick);
            miPersonaje = personajes.get(n);
            iniciarPersonajeJugable();
        }
    }//GEN-LAST:event_jLabelPersonajeMouseClicked

    private void jButtonAdivinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdivinarActionPerformed
        int indice = this.labelsImg.indexOf(seleccionado);
        Personaje guess = this.personajes.get(indice);
        String pregunta = guess.getNombre();
        
        System.out.println("Pregunta creada: ¿Tu personaje es " + pregunta + '?');
        String texto = this.ZonaPreguntaRespuesta.getText().trim();
        texto += ("\nTu personaje es " + pregunta + "?");
        
        this.ZonaPreguntaRespuesta.setText("");
        this.ZonaPreguntaRespuesta.setText(texto);
        
        try{
            jugador.enviarAdivinar(pregunta);
        }catch(Exception e){
            System.out.println("*** Error enviando pregunta ***");
        }
    }//GEN-LAST:event_jButtonAdivinarActionPerformed

    private void jButtonMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMusicaMouseClicked
        if(JPInicio.soundActive == true){
            this.jButtonMusica.setIcon(ButtonIcons.getMusicButtonMute());
            JPInicio.soundActive = false;
        } else if (JPInicio.soundActive == false){
            this.jButtonMusica.setIcon(ButtonIcons.getMusicButtonNormal());
            JPInicio.soundActive = true;
        }
    }//GEN-LAST:event_jButtonMusicaMouseClicked

    private void jButtonDefQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefQueActionPerformed
        String pregunta = "\nTu personaje "+this.jComboBoxPregunta1.getSelectedItem().toString()+' '+this.jComboBoxPregunta2.getSelectedItem().toString()+' '+this.jComboBoxPregunta3.getSelectedItem().toString() + "?";
        
        System.out.println("Pregunta creada: " + pregunta);
        
        String texto = this.ZonaPreguntaRespuesta.getText().trim();
        texto += pregunta;
        
        this.ZonaPreguntaRespuesta.setText("");
        this.ZonaPreguntaRespuesta.setText(texto);
        
        try{
            jugador.enviarPregunta(pregunta);
        }catch(Exception e){
            System.out.println("*** Error enviando pregunta ***");
        }
    }//GEN-LAST:event_jButtonDefQueActionPerformed

    private void jButtonPersQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersQueActionPerformed
        String pregunta = this.jTextFieldQuestion.getText().trim();
        
        System.out.println("Pregunta creada: " + pregunta);
        String texto = this.ZonaPreguntaRespuesta.getText().trim();
        texto += ("\n" + pregunta);
        
        this.ZonaPreguntaRespuesta.setText("");
        this.ZonaPreguntaRespuesta.setText(texto);
        
        try{
            jugador.enviarPregunta(pregunta);
        }catch(Exception e){
            System.out.println("*** Error enviando pregunta ***");
        }
    }//GEN-LAST:event_jButtonPersQueActionPerformed

    private void jComboBoxPregunta1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPregunta1ItemStateChanged
        ComboBoxModel modeloCaja2;
        
        if(this.jComboBoxPregunta1.getSelectedIndex() == 0){
            // Cambia a la lista de objetos para Es
            modeloCaja2 = new DefaultComboBoxModel(this.verboEs);
            this.jComboBoxPregunta2.setModel(modeloCaja2);
            
            this.esTiene = false;
            
            // Bloquea los complementos
            this.jComboBoxPregunta3.setSelectedIndex(0);
            this.jComboBoxPregunta3.setEnabled(false);
        }else{
            // Cambia a la lista de objetos para Tiene
            modeloCaja2 = new DefaultComboBoxModel(this.verboTiene);
            this.jComboBoxPregunta2.setModel(modeloCaja2);
            
            this.esTiene = true;
            
            // Desbloquea los complementos
            this.jComboBoxPregunta3.setSelectedIndex(0);
            this.jComboBoxPregunta3.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxPregunta1ItemStateChanged

    private void jComboBoxPregunta2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPregunta2ItemStateChanged
        DefaultComboBoxModel modeloCaja3 = new DefaultComboBoxModel();
        
        Vector <String> modelo;
        
        if(this.esTiene == true){
            System.out.println("Entra porque es Tiene");
            int id = this.jComboBoxPregunta2.getSelectedIndex();
            
            switch(id){
                case 2: case 7: // Pelo, vello facial
                    modelo = new Vector(this.complementoPelo);
                    modelo.addAll(this.complementoColor);
                    break;
                case 1: // Cejas
                    modelo = this.complementoCeja;
                    break;
                case 5: // Piel
                    modelo = this.complementoPiel;
                    break;
                default: // Lentes, Ojos, Ropa, Gorro
                    modelo = this.complementoColor;
                    break;
            }
            
            modeloCaja3.addElement(" ");
            modeloCaja3.addAll(modelo);
            modeloCaja3.setSelectedItem(" ");
            this.jComboBoxPregunta3.setModel(modeloCaja3);
        }
    }//GEN-LAST:event_jComboBoxPregunta2ItemStateChanged

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imgFondo != null){
            g.drawImage(imgFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // Inicio de partida
    
    private void cargarOpcionesPregunta(){
        DefaultComboBoxModel modelo;
        
        try{
            this.interrogativo = ConexionBD.ObtenerPreguntas(1,0);
            this.verboEs = ConexionBD.ObtenerPreguntas(2,1);
            this.verboTiene = ConexionBD.ObtenerPreguntas(2,2);
            this.complementoCeja = ConexionBD.ObtenerPreguntas(3,3);
            this.complementoPelo = ConexionBD.ObtenerPreguntas(3,4);
            this.complementoColor = ConexionBD.ObtenerPreguntas(3,5);
            this.complementoPiel = ConexionBD.ObtenerPreguntas(3,6);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        System.out.println("Interrogativo: "+this.interrogativo);
        System.out.println("Es: "+this.verboEs);
        System.out.println("Tiene: "+this.verboTiene);
        System.out.println("Cejas: "+this.complementoCeja);
        System.out.println("Pelo: "+this.complementoPelo);
        System.out.println("Color: "+this.complementoColor);
        System.out.println("Piel: "+this.complementoPiel);
        
        // Caja de preguntas 1
        modelo = new DefaultComboBoxModel(this.interrogativo);
        modelo.setSelectedItem(this.interrogativo.get(0));
        this.jComboBoxPregunta1.setModel(modelo);
        
        // Caja de preguntas 2
        modelo = new DefaultComboBoxModel(this.verboEs);
        modelo.setSelectedItem(this.verboEs.get(0));
        this.jComboBoxPregunta2.setModel(modelo);
        
        // Caja de Preguntas 3
        modelo = new DefaultComboBoxModel();
        modelo.addElement(" ");
        modelo.addAll(this.complementoColor);
        modelo.setSelectedItem(" ");
        
        this.jComboBoxPregunta3.setModel(modelo);
        this.jComboBoxPregunta3.setEnabled(false);
    }
    
    // Tablero
    protected void obtenerPersonajes(ArrayList tablero){
        System.out.println("Tablero enviado a Juego\n"+tablero);
        personajes = tablero;
        ImageIcon portrait;
        iconos.clear();
        
        for (int i = 0; i < labelsImg.size(); i++) {
            portrait = new ImageIcon(personajes.get(i).getImagen());
            portrait = new ImageIcon(portrait.getImage().getScaledInstance(100, 99, Image.SCALE_SMOOTH));
            
            labelsImg.get(i).setIcon(portrait);
            labelsNoms.get(i).setText(personajes.get(i).getNombre());
            iconos.add(portrait);
        }
    }
    
    private void iniciarPersonajeJugable(){
        ImageIcon chara = new ImageIcon(miPersonaje.getImagen());
        jLabelPersonajeJugable.setIcon(new ImageIcon(chara.getImage().getScaledInstance(102, 100, Image.SCALE_SMOOTH)));
        this.jLabelNombreJugable.setText(miPersonaje.nombre);
    }
    
    // Formas de elección de personaje
    private void elegirPersonaje(){
        int n = JPSetUp.getMetodo();
        switch(n){
            case 1:
                miPersonaje = personajeLista();
                iniciarPersonajeJugable();
                break;
            case 2:
                this.jLabelNombreJugable.setText("");
                this.clicElegir = true;
                break;
            default:
                miPersonaje = personajeAlAzar();
                iniciarPersonajeJugable();
        }
    };
    
    private Personaje personajeAlAzar(){
        Random rand = new Random();
        int num = rand.nextInt(24);
        return personajes.get(num);
    }
    
    private Personaje personajeLista(){
        Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JDListaP lista = new JDListaP(parentFrame, personajes);
        lista.setLocationRelativeTo(parentFrame);
        lista.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        lista.setVisible(true);
        
        return lista.getSeleccionado();
    }
    
    // Preguntas, respuestas y adivinar
    protected void mostrarPregunta(String pregunta){
        int opcion = JOptionPane.showConfirmDialog(null, pregunta,"Recibió una pregunta",JOptionPane.YES_NO_OPTION);
        
        if(opcion == JOptionPane.YES_OPTION){
            this.jugador.enviarRespuesta(true);
        }else if(opcion == JOptionPane.NO_OPTION){
            this.jugador.enviarRespuesta(false);
        }
        
        desbloquearBotones();
    }
    
    protected void mostrarRespuesta(String resp){
        String texto = this.ZonaPreguntaRespuesta.getText().trim();
        
        texto += "\nRespuesta: "+resp+"\n";
        
        this.ZonaPreguntaRespuesta.setText("");
        this.ZonaPreguntaRespuesta.setText(texto);
        
        this.jugador.finDeTurno();
    }
    
    protected void mostrarAdivinarPersonaje(String pregunta){
        JOptionPane.showMessageDialog(null, "El contrincante esta intentando adivinar personaje...");
        
        if(pregunta.equals(this.miPersonaje.getNombre())){
            this.jugador.enviarRespAdivinar(true);
            this.resultados = new Juego(nombre,this.miPersonaje.getNombre(), this.segundos, this.minutos, this.horas,false);
            this.jugador.enviarResultado(resultados);
            
            //cambiar al panel de derrota
            this.derrota();
        }else if(!pregunta.equals(this.miPersonaje.getNombre())){
            this.jugador.enviarRespAdivinar(false);
        }
        
        desbloquearBotones();
    }
    
    // Ganador
    protected void mostrarGanador(String pregunta){
        JOptionPane.showMessageDialog(null, "Adivinaste Correctamente");
        this.resultados = new Juego(nombre,this.miPersonaje.getNombre(), this.segundos, this.minutos, this.horas,true);
        this.jugador.enviarResultado(resultados);
        
        this.victoria();
    }
    
    // Mover pantalla
    protected void victoria(){
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "VictoryScreen");
    }
    
    protected void derrota(){
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "DefeatScreen");
    }
    
    // Turnos
    
    public void bloquearBotones(){
        this.jButtonAdivinar.setEnabled(false);
        this.jButtonDefQue.setEnabled(false);
        this.jButtonPersQue.setEnabled(false);
    }
    
    public void desbloquearBotones(){
        this.jButtonAdivinar.setEnabled(true);
        this.jButtonDefQue.setEnabled(true);
        this.jButtonPersQue.setEnabled(true);
    }
    
    // Getters y Setter
    
    public Personaje getPersonajeSeleccionado(){
        return this.miPersonaje;
    }
    
    public ArrayList<Personaje> getPersonajes(){
        return personajes;
    }
    
    public static void setNombre(String nombre) {
        JPJuego.nombre = nombre;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ZonaPreguntaRespuesta;
    private javax.swing.JButton jButtonAdivinar;
    private javax.swing.JButton jButtonDefQue;
    private javax.swing.JButton jButtonMusica;
    private javax.swing.JButton jButtonPersQue;
    private javax.swing.JComboBox<String> jComboBoxPregunta1;
    private javax.swing.JComboBox<String> jComboBoxPregunta2;
    private javax.swing.JComboBox<String> jComboBoxPregunta3;
    private javax.swing.JLabel jLabelAdivinar;
    private javax.swing.JLabel jLabelFecha1;
    private javax.swing.JLabel jLabelFecha2;
    private javax.swing.JLabel jLabelFondoReloj;
    private javax.swing.JLabel jLabelJugador;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre10;
    private javax.swing.JLabel jLabelNombre11;
    private javax.swing.JLabel jLabelNombre12;
    private javax.swing.JLabel jLabelNombre13;
    private javax.swing.JLabel jLabelNombre14;
    private javax.swing.JLabel jLabelNombre15;
    private javax.swing.JLabel jLabelNombre16;
    private javax.swing.JLabel jLabelNombre17;
    private javax.swing.JLabel jLabelNombre18;
    private javax.swing.JLabel jLabelNombre19;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre20;
    private javax.swing.JLabel jLabelNombre21;
    private javax.swing.JLabel jLabelNombre22;
    private javax.swing.JLabel jLabelNombre23;
    private javax.swing.JLabel jLabelNombre24;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JLabel jLabelNombre5;
    private javax.swing.JLabel jLabelNombre6;
    private javax.swing.JLabel jLabelNombre7;
    private javax.swing.JLabel jLabelNombre8;
    private javax.swing.JLabel jLabelNombre9;
    private javax.swing.JLabel jLabelNombreJugable;
    private javax.swing.JLabel jLabelPersonaje1;
    private javax.swing.JLabel jLabelPersonaje10;
    private javax.swing.JLabel jLabelPersonaje11;
    private javax.swing.JLabel jLabelPersonaje12;
    private javax.swing.JLabel jLabelPersonaje13;
    private javax.swing.JLabel jLabelPersonaje14;
    private javax.swing.JLabel jLabelPersonaje15;
    private javax.swing.JLabel jLabelPersonaje16;
    private javax.swing.JLabel jLabelPersonaje17;
    private javax.swing.JLabel jLabelPersonaje18;
    private javax.swing.JLabel jLabelPersonaje19;
    private javax.swing.JLabel jLabelPersonaje2;
    private javax.swing.JLabel jLabelPersonaje20;
    private javax.swing.JLabel jLabelPersonaje21;
    private javax.swing.JLabel jLabelPersonaje22;
    private javax.swing.JLabel jLabelPersonaje23;
    private javax.swing.JLabel jLabelPersonaje24;
    private javax.swing.JLabel jLabelPersonaje3;
    private javax.swing.JLabel jLabelPersonaje4;
    private javax.swing.JLabel jLabelPersonaje5;
    private javax.swing.JLabel jLabelPersonaje6;
    private javax.swing.JLabel jLabelPersonaje7;
    private javax.swing.JLabel jLabelPersonaje8;
    private javax.swing.JLabel jLabelPersonaje9;
    private javax.swing.JLabel jLabelPersonajeJugable;
    private javax.swing.JLabel jLabelPregunta1;
    private javax.swing.JLabel jLabelPregunta2;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelReloj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldQuestion;
    // End of variables declaration//GEN-END:variables
    
}
