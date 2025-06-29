/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package misClases;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Elijah
 */
public class JPDerrota extends javax.swing.JPanel {
    // Variables
    private Image imgFondo; //Fondo
    
    // Creates new form JPDerrota
    public JPDerrota() {
        this.setFont(StardewFonts.getSVThin());
        
        try{
            imgFondo = ImageIO.read(new File("src/Resources/Fondos/CieloNoche.png"));
        }catch(Exception e){
            System.out.println("*** Error cargando fondo de panel ***");
            e.printStackTrace();
        }
        
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imgFondo != null){
            g.drawImage(imgFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDerrota = new javax.swing.JLabel();
        jButtonAgain = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setFont(getFont());
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabelDerrota.setBackground(new java.awt.Color(255, 238, 175));
        jLabelDerrota.setFont(StardewFonts.getSVTitleCaps());
        jLabelDerrota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDerrota.setText("DERROTA");
        jLabelDerrota.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(158, 79, 19)));
        jLabelDerrota.setOpaque(true);

        jButtonAgain.setBackground(new java.awt.Color(255, 241, 189));
        jButtonAgain.setFont(StardewFonts.getSVBold());
        jButtonAgain.setText("Jugar de Nuevo");
        jButtonAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgainActionPerformed(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(255, 241, 189));
        jButtonSalir.setFont(StardewFonts.getSVBold());
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabelDerrota, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jButtonAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelDerrota, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "MainScreen");
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgainActionPerformed
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "SetUpScreen");
    }//GEN-LAST:event_jButtonAgainActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgain;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelDerrota;
    // End of variables declaration//GEN-END:variables
}
