/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misClases;

import java.awt.Font;
import java.io.File;

/**
 *
 * @author Elijah
 */
public class StardewFonts {
    private static Font SVBold;
    private static Font SVThin;
    private static Font SVTitleCaps;
    private static Font SVTitleRegular;
    
    public StardewFonts(){
        loadFonts();
    }
    
    // Se encarga de cargar las fuentes de los recursos al JFrame tal cual
    private static void loadFonts(){
        try{
            File fileSVBold = new File("src/Resources/Fuentes/svbold.otf");
            File fileSVThin = new File("src/Resources/Fuentes/svthin.otf");
            File fileSVTitleCaps = new File("src/Resources/Fuentes/Stardew Valley ALL CAPS.ttf");
            File fileSVTitleReg = new File("src/Resources/Fuentes/Stardew Valley Regular.ttf");
            SVBold = Font.createFont(Font.TRUETYPE_FONT, fileSVBold).deriveFont(16f);
            SVThin = Font.createFont(Font.TRUETYPE_FONT, fileSVThin).deriveFont(16f);
            SVTitleCaps = Font.createFont(Font.TRUETYPE_FONT, fileSVTitleCaps).deriveFont(80f);
            SVTitleRegular = Font.createFont(Font.TRUETYPE_FONT, fileSVTitleReg).deriveFont(80f);
        }
        catch(Exception e){
            System.out.println("*** Error cargando fuentes ***");
            e.printStackTrace();
        }
    }

    // Solo incluye Getters porque no quiero que sea capaz de modificar los contenidos de las fuentes
    public static Font getSVBold() {
        return SVBold;
    }

    public static Font getSVThin() {
        return SVThin;
    }

    public static Font getSVTitleCaps() {
        return SVTitleCaps;
    }

    public static Font getSVTitleRegular() {
        return SVTitleRegular;
    }
}
