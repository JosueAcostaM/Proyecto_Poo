package com.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PantallaGeneral extends JFrame {

    private Menu menu;
    private PanelDibujo panelDibujo;
    private Jugador jugador;

    public PantallaGeneral() {
        setTitle("VideoJuego (JOSUE ACOSTA)");
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new Menu();
        add(menu, BorderLayout.NORTH);

        panelDibujo = new PanelDibujo();
        add(panelDibujo, BorderLayout.CENTER);

        inicializarPersonajes();
        agregarControles();

        
    }

    private void inicializarPersonajes() {
        jugador = new Jugador(2, 2, "Jugador", Color.BLUE, "J", 0);
        Monstruo1 monstruo1 = new Monstruo1(4, 4, "Monstruo1", Color.RED, "M1", 10, "tipo1");
        Monstruo2 monstruo2 = new Monstruo2(6, 6, "Monstruo2", Color.GREEN, "M2", 20, "tipo2");

        panelDibujo.agregarPersonaje(jugador);
        panelDibujo.agregarPersonaje(monstruo1);
        panelDibujo.agregarPersonaje(monstruo2);
    }

    private void agregarControles() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> {
                        jugador.moverIzquierda();
                        panelDibujo.repaint();
                    }
                    case KeyEvent.VK_RIGHT -> {
                        jugador.moverDerecha(panelDibujo.getColumnas()
                        ); 
                        panelDibujo.repaint();
                    }
                    case KeyEvent.VK_UP -> {
                        jugador.moverArriba();
                        panelDibujo.repaint();
                    }
                    case KeyEvent.VK_DOWN -> {
                        jugador.moverAbajo(panelDibujo.getFilas());
                        panelDibujo.repaint();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        setFocusable(true);
    }

    public int getAnchura(){
        return this.getHeight();
    }

    public int getAltura(){
        return this.getWidth();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PantallaGeneral pantalla = new PantallaGeneral();
            pantalla.setVisible(true);
        });
    }
}
