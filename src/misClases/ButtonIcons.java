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
    private static ImageIcon optionNormal, optionHover;

    public ButtonIcons() {
        try{
            backButtonNormal = new ImageIcon("src/Resources/Assets/backButton.png");
            backButtonHover = new ImageIcon("src/Resources/Assets/backButtonHover.png");
            musicButtonNormal = new ImageIcon("src/Resources/Assets/SoundButton.png");
            musicButtonMute = new ImageIcon("src/Resources/Assets/SoundButtonMute.png");
            optionNormal = new ImageIcon("src/Resources/Assets/OptionsButton.png");
            optionHover = new ImageIcon("src/Resources/Assets/OptionsButtonHover.png");
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

    public static ImageIcon getOptionNormal() {
        return new ImageIcon(optionNormal.getImage().getScaledInstance((int)(optionNormal.getIconWidth()*1.48148), (int)(optionNormal.getIconHeight()*1.48148), Image.SCALE_SMOOTH));
    }

    public static ImageIcon getOptionHover() {
        return new ImageIcon(optionHover.getImage().getScaledInstance((int)(optionHover.getIconWidth()*1.48148), (int)(optionHover.getIconHeight()*1.48148), Image.SCALE_SMOOTH));
    }
    
    
}
