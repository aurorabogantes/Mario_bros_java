package vista;

import controlador.ControladorJuego;
import modelo.Nodo;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaJuego extends JPanel {
    private Juego juego;
    private ControladorJuego controlador;
    private int fondoX;
    private Image fondo;
    private boolean victoria;
    private boolean gameOver;
    private Image imagenVictoria;
    private Image imagenGameOver;
    private JButton botonMenu;

    public VistaJuego(Juego juego, ControladorJuego controlador) {
        this.juego = juego;
        this.controlador = controlador;

        this.fondoX = 0;
        this.fondo = new ImageIcon("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/background.png").getImage();
        this.imagenVictoria = new ImageIcon("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/ganaste.png").getImage();
        this.imagenGameOver = new ImageIcon("C:Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/gameover.png").getImage();
        this.victoria = false;
        this.gameOver = false;

        botonMenu = new JButton("Volver al Menú");
        botonMenu.setBounds(300, 400, 200, 50);
        botonMenu.setVisible(false);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(VistaJuego.this); //obtiene el componente desde el cual se llama el método 
                marco.getContentPane().removeAll(); //eliminar contenido

                MenuPrincipal menuPrincipal = new MenuPrincipal(marco, juego);
                marco.add(menuPrincipal);

                marco.revalidate(); //refrescar
                marco.repaint(); //reflejar los cambios
            }
        });
        this.setLayout(null); //introducir layout manualmente
        this.add(botonMenu);

        setFocusable(true);
        requestFocusInWindow();
        System.out.println("VistaJuego inicializada y esperando eventos de teclado.");

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evento) {
                if (!victoria && !gameOver) {
                    System.out.println("Tecla presionada: " + KeyEvent.getKeyText(evento.getKeyCode()));
                    switch (evento.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            juego.getJugador().moverIzquierda();
                            break;
                        case KeyEvent.VK_RIGHT:
                            juego.getJugador().moverDerecha();
                            break;
                        case KeyEvent.VK_SPACE:
                            juego.getJugador().saltar();
                            break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent evento) {
                if (!victoria && !gameOver) {
                    switch (evento.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                        case KeyEvent.VK_RIGHT:
                            juego.getJugador().detener();
                            break;
                    }
                }
            }
        });

        // Asegurar que VistaJuego tenga el foco cuando se muestra
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evento) {
                requestFocusInWindow(); // Asegura que VistaJuego tenga el foco cuando se muestre
            }
        });
    }

    public void setControlador(ControladorJuego controlador) {
        this.controlador = controlador;
    }

    public ControladorJuego getControlador() {
        return controlador;
    }

    public void mostrarVictoria() {
        this.victoria = true;
        repaint();
    }

    public void mostrarGameOver() {
        this.gameOver = true;
        botonMenu.setVisible(true);
        repaint();
    }

    public void mostrarMenu() {
        botonMenu.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics graficos) {
        super.paintComponent(graficos);

        graficos.drawImage(fondo, fondoX, 0, this.getWidth(), this.getHeight(), this);

        if (victoria) {
            graficos.drawImage(imagenVictoria, getWidth() / 2 - 150, getHeight() / 2 - 75, 300, 150, this);
            return;
        }

        if (gameOver) {
            graficos.drawImage(imagenGameOver, getWidth() / 2 - 150, getHeight() / 2 - 75, 300, 150, this);
            return;
        }

        Jugador jugador = juego.getJugador();
        int desplazamientoX = jugador.getPosicionX() - getWidth() / 2;
        int desplazamientoY = 0;

        Image imagenMario = jugador.getImagen();
        if (imagenMario != null)
            graficos.drawImage(imagenMario, jugador.getPosicionX() - desplazamientoX, jugador.getPosicionY() - desplazamientoY, jugador.getAncho(), jugador.getAlto(), this);

        Nodo nodoEnemigo = juego.getNivelActual().getEnemigos().getElemento();
        while (nodoEnemigo != null) {
            Enemigo enemigo = (Enemigo) nodoEnemigo.getDato();
            graficos.drawImage(enemigo.getImagen(), enemigo.getPosicionX() - desplazamientoX, enemigo.getPosicionY() - desplazamientoY, enemigo.getAncho(), enemigo.getAlto(), this);
            nodoEnemigo = nodoEnemigo.getSiguiente();
        }

        Nodo nodoMoneda = juego.getNivelActual().getMonedas().getElemento();
        while (nodoMoneda != null) {
            Moneda moneda = (Moneda) nodoMoneda.getDato();
            graficos.drawImage(moneda.getImagen(), moneda.getPosicionX() - desplazamientoX, moneda.getPosicionY() - desplazamientoY, moneda.getAncho(), moneda.getAlto(), this);
            nodoMoneda = nodoMoneda.getSiguiente();
        }

        graficos.drawImage(new ImageIcon("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/moneda.png").getImage(), 10, 10, 30, 30, this);
        graficos.setFont(new Font("Arial", Font.BOLD, 20));
        graficos.setColor(Color.WHITE);
        graficos.drawString("x " + jugador.getMonedas(), 50, 35);

        graficos.setFont(new Font("Arial", Font.PLAIN, 18));
        graficos.setColor(Color.WHITE);
        graficos.drawString("Partidas jugadas: " + juego.getPartidasJugadas(), getWidth() - 200, 20);
        graficos.drawString("Partidas ganadas: " + juego.getPartidasGanadas(), getWidth() - 200, 40);
    }

    private void volverAlMenuPrincipal() {
        JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this); //obtiene el componente desde el cual se llama el método 
        ventana.getContentPane().removeAll(); //elimina componentes dentro del contentPane

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana, juego);
        ventana.add(menuPrincipal);

        ventana.revalidate(); //refrescar
        ventana.repaint(); //visualizar cambios
    }

    public void actualizarPantalla() {
        repaint();
    }
}
