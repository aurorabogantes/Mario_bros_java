/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;
import vista.Juego;
import vista.MenuPrincipal;

/**
 *
 * @author auror
 */
public class Ventana {
    Juego juego = new Juego();
    public Ventana(){
        JFrame ventana = new JFrame("New Super Mario Bros U");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);  // Centrar la ventana
        ventana.setResizable(false);  // Deshabilitar redimensionamiento
        
        MenuPrincipal menu = new MenuPrincipal(ventana, juego);
        ventana.add(menu);
        
        ventana.setVisible(true);
    }
}
