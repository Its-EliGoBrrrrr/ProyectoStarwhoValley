/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package misClases;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

// @author LENOVO

public class JPInicio extends javax.swing.JPanel {
    // Variables
    private Image imgFondo;
    private ImageIcon imgTitle;
    public static boolean soundActive = true;
    
    // Creates new form JPInicio
    public JPInicio() {
        this.setFont(StardewFonts.getSVThin());
        
        try{
            imgFondo = ImageIO.read(new File("src/Resources/Fondos/Menu2.png"));
        }catch(Exception e){
            System.out.println("*** Error cargando fondo de panel ***");
            e.printStackTrace();
        }
        
        initComponents();
        
        imgTitle = new ImageIcon("src/Resources/Assets/Logo.png");
        this.jLTitle.setIcon(new ImageIcon(imgTitle.getImage().getScaledInstance((int)(imgTitle.getIconWidth()*1.5), (int)(imgTitle.getIconHeight()*1.5), Image.SCALE_SMOOTH)));
        
        this.ButtonOptions.setIcon(ButtonIcons.getOptionNormal());
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

        ButtonStart = new javax.swing.JButton();
        ButtonInstrucc = new javax.swing.JButton();
        ButtonCredits = new javax.swing.JButton();
        ButtonOptions = new javax.swing.JButton();
        jLTitle = new javax.swing.JLabel();
        jButtonInfoPartidas = new javax.swing.JButton();

        setFont(getFont());
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        ButtonStart.setBackground(new java.awt.Color(218, 173, 114));
        ButtonStart.setFont(StardewFonts.getSVBold());
        ButtonStart.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(226, 122, 62)));
        ButtonStart.setBorderPainted(true);
        ButtonStart.setLabel("Jugar");
        ButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonStartActionPerformed(evt);
            }
        });

        ButtonInstrucc.setBackground(new java.awt.Color(218, 173, 114));
        ButtonInstrucc.setFont(StardewFonts.getSVBold());
        ButtonInstrucc.setText("Instrucciones");
        ButtonInstrucc.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(226, 122, 62)));
        ButtonInstrucc.setBorderPainted(true);
        ButtonInstrucc.setIconTextGap(0);
        ButtonInstrucc.setInheritsPopupMenu(true);
        ButtonInstrucc.setMaximumSize(new java.awt.Dimension(200, 60));
        ButtonInstrucc.setMinimumSize(new java.awt.Dimension(200, 60));
        ButtonInstrucc.setPreferredSize(new java.awt.Dimension(200, 60));
        ButtonInstrucc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInstruccActionPerformed(evt);
            }
        });

        ButtonCredits.setBackground(new java.awt.Color(218, 173, 114));
        ButtonCredits.setFont(StardewFonts.getSVBold());
        ButtonCredits.setText("Creditos");
        ButtonCredits.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(226, 122, 62)));
        ButtonCredits.setBorderPainted(true);
        ButtonCredits.setMaximumSize(new java.awt.Dimension(200, 60));
        ButtonCredits.setMinimumSize(new java.awt.Dimension(200, 60));
        ButtonCredits.setPreferredSize(new java.awt.Dimension(200, 60));
        ButtonCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreditsActionPerformed(evt);
            }
        });

        ButtonOptions.setBackground(new Color(0,0,0,0));
        ButtonOptions.setFont(getFont());
        ButtonOptions.setBorder(null);
        ButtonOptions.setBorderPainted(false);
        ButtonOptions.setIconTextGap(0);
        ButtonOptions.setInheritsPopupMenu(true);
        ButtonOptions.setMaximumSize(new java.awt.Dimension(300, 60));
        ButtonOptions.setMinimumSize(new java.awt.Dimension(40, 37));
        ButtonOptions.setPreferredSize(new java.awt.Dimension(40, 37));
        ButtonOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonOptionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonOptionsMouseExited(evt);
            }
        });
        ButtonOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOptionsActionPerformed(evt);
            }
        });

        jLTitle.setBackground(new Color(0,0,0,0));
        jLTitle.setFont(getFont());
        jLTitle.setMaximumSize(new java.awt.Dimension(600, 280));
        jLTitle.setMinimumSize(new java.awt.Dimension(600, 280));
        jLTitle.setPreferredSize(new java.awt.Dimension(600, 280));

        jButtonInfoPartidas.setBackground(new java.awt.Color(218, 173, 114));
        jButtonInfoPartidas.setFont(StardewFonts.getSVBold());
        jButtonInfoPartidas.setText("InfoPartidas");
        jButtonInfoPartidas.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(226, 122, 62)));
        jButtonInfoPartidas.setMaximumSize(new java.awt.Dimension(200, 60));
        jButtonInfoPartidas.setMinimumSize(new java.awt.Dimension(200, 60));
        jButtonInfoPartidas.setPreferredSize(new java.awt.Dimension(200, 60));
        jButtonInfoPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfoPartidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(ButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonInstrucc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonInfoPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ButtonOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInfoPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonInstrucc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        ButtonInstrucc.getAccessibleContext().setAccessibleName("");
        ButtonOptions.getAccessibleContext().setAccessibleName("OpcionesButton");

        getAccessibleContext().setAccessibleName("MainScreen");
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonStartActionPerformed
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "SetUpScreen");
    }//GEN-LAST:event_ButtonStartActionPerformed

    private void ButtonInstruccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInstruccActionPerformed
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "InstructScreen");
    }//GEN-LAST:event_ButtonInstruccActionPerformed

    private void ButtonCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreditsActionPerformed
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "CreditsScreen");
    }//GEN-LAST:event_ButtonCreditsActionPerformed

    private void ButtonOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOptionsActionPerformed
        JPOpciones.cardAnterior="MainScreen";
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "OptionScreen");
    }//GEN-LAST:event_ButtonOptionsActionPerformed

    private void ButtonOptionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOptionsMouseEntered
        this.ButtonOptions.setIcon(ButtonIcons.getOptionHover());
    }//GEN-LAST:event_ButtonOptionsMouseEntered

    private void ButtonOptionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOptionsMouseExited
        this.ButtonOptions.setIcon(ButtonIcons.getOptionNormal());
    }//GEN-LAST:event_ButtonOptionsMouseExited

    private void jButtonInfoPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoPartidasActionPerformed
        JPanel parent = (JPanel)getParent();
        CardLayout cardLayout = (CardLayout)parent.getLayout();
        cardLayout.show(parent, "InfoPartidas");
    }//GEN-LAST:event_jButtonInfoPartidasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCredits;
    private javax.swing.JButton ButtonInstrucc;
    private javax.swing.JButton ButtonOptions;
    private javax.swing.JButton ButtonStart;
    private javax.swing.JButton jButtonInfoPartidas;
    private javax.swing.JLabel jLTitle;
    // End of variables declaration//GEN-END:variables
}
