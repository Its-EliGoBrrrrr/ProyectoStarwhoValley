/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.awt.*;
import javax.swing.*;

public class ButtonIcons {
    private static ImageIcon backButtonNormal, backButtonHover;
    private static ImageIcon musicButtonNormal, musicButtonMute;

    public ButtonIcons() {
        try{
            backButtonNormal = new ImageIcon("src/Resources/Assets/backButton.png");
            backButtonHover = new ImageIcon("src/Resources/Assets/backButtonHover.png");
            musicButtonNormal = new ImageIcon("src/Resources/Assets/SoundButton.png");
            musicButtonMute = new ImageIcon("src/Resources/Assets/SoundButtonMute.png");
        }catch(Exception e){
            System.out.println("*** Error al cargar iconos de botones ***");
        }
    }

    public static ImageIcon getBackButtonNormal() {
        return new ImageIcon(backButtonNormal.getImage().getScaledInstance(backButtonNormal.getIconWidth()*2, backButtonNormal.getIconHeight()*2, Image.SCALE_SMOOTH));
    }

    public static ImageIcon getBackButtonHover() {
        return new ImageIcon(backButtonHover.getImage().getScaledInstance(backButtonHover.getIconWidth()*2, backButtonHover.getIconHeight()*2, Image.SCALE_SMOOTH));
    }

    public static ImageIcon getMusicButtonNormal() {
        return new ImageIcon(musicButtonNormal.getImage().getScaledInstance((int)(musicButtonNormal.getIconWidth()*4.444), (int)(musicButtonNormal.getIconHeight()*4.444), Image.SCALE_SMOOTH));
    }

    public static ImageIcon getMusicButtonMute() {
        return new ImageIcon(musicButtonMute.getImage().getScaledInstance((int)(musicButtonMute.getIconWidth()*4.444), (int)(musicButtonMute.getIconHeight()*4.444), Image.SCALE_SMOOTH));
    }
}
