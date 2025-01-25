package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import controlador.ControladorJuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JPanel {

    private JFrame ventana;
    private Juego juego;

    public MenuPrincipal(JFrame ventana, Juego juego) {
        this.ventana = ventana;
        this.juego = juego;

        // Crear el panel principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //disposicion vertical
        setBackground(Color.DARK_GRAY);

        // Título del menú
        JLabel titulo = new JLabel("New Super Mario Bros U");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setForeground(Color.WHITE);

        // Botón para iniciar el juego
        JButton botonIniciarJuego = new JButton("Iniciar Juego");
        botonIniciarJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonIniciarJuego.setPreferredSize(new Dimension(200, 50));
        botonIniciarJuego.setMaximumSize(new Dimension(200, 50));
        botonIniciarJuego.setFont(new Font("Arial", Font.PLAIN, 24));
        botonIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                iniciarJuego();
            }
        });

        // Botón para salir del juego
        JButton botonSalir = new JButton("Salir");
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonSalir.setPreferredSize(new Dimension(200, 50));
        botonSalir.setMaximumSize(new Dimension(200, 50));
        botonSalir.setFont(new Font("Arial", Font.PLAIN, 24));
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);  // Salir de la aplicación
            }
        });

        // Añadir componentes al panel principal
        add(Box.createRigidArea(new Dimension(0, 100))); // Espacio superior
        add(titulo);
        add(Box.createRigidArea(new Dimension(0, 50))); // Espacio entre título y botones
        add(botonIniciarJuego);
        add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre botones
        add(botonSalir);
    }

    private void iniciarJuego() {
        ventana.getContentPane().removeAll();  // Remover contenido actual

        VistaJuego vistaJuego = new VistaJuego(juego, null);

        // Crear el controlador después de inicializar VistaJuego
        ControladorJuego controlador = new ControladorJuego(juego, vistaJuego);

        // Asignar el controlador a VistaJuego
        vistaJuego.setControlador(controlador);

        ventana.add(vistaJuego);  // Agregar el juego al JFrame
        ventana.revalidate();  // Refrescar la ventana para mostrar los cambios
        controlador.iniciarNuevaPartida();  // Iniciar la lógica del juego desde el menú
    }
}
