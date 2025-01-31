package com.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PantallaGeneral extends JFrame {

    JLabel diseñoJuador;
    private Menu menu;
    private PanelDibujo panelDibujo;
    private Jugador jugador;

    public PantallaGeneral() {
        setTitle("VideoJuego (JOSUE ACOSTA)");
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new Menu();
        add(menu, BorderLayout.NORTH);

        panelDibujo = new PanelDibujo();
        add(panelDibujo, BorderLayout.CENTER);

        inicializarPersonajes();
        agregarControles();
        iniciarMovimientoMonstruos();
        
    }

    private void inicializarPersonajes() {
         Image diseñojugador = new ImageIcon(getClass().getResource("/imagenes/cat-opens-moith-wide.gif")).getImage();

         Image diseñoMonstruo1= new ImageIcon(getClass().getResource("/imagenes/Jugador.png")).getImage();

         Image diseñoMonstruo2= new ImageIcon(getClass().getResource("/imagenes/Jugador.png")).getImage();

        jugador = new Jugador(2, 2, "Jugador", Color.BLUE, 0,diseñojugador);
        Monstruo1 monstruo1 = new Monstruo1(1, 2, "Monstruo1", Color.RED, 10, "tipo1", diseñoMonstruo1);
        Monstruo2 monstruo2 = new Monstruo2(5,5, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);
       /* Monstruo2 monstruo3 = new Monstruo2(2,2, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);
        Monstruo2 monstruo4 = new Monstruo2(9,5, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);
        Monstruo1 monstruo5 = new Monstruo1(8,5, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);
        Monstruo1 monstruo6 = new Monstruo1(14,6, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);
        Monstruo1 monstruo7 = new Monstruo1(8,5, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);
        Monstruo1 monstruo8 = new Monstruo1(14,9, "Monstruo2", Color.GREEN, 20, "tipo2",diseñoMonstruo2);*/



        panelDibujo.agregarPersonaje(jugador);
        panelDibujo.agregarPersonaje(monstruo1);
        panelDibujo.agregarPersonaje(monstruo2);
        /*panelDibujo.agregarPersonaje(monstruo3);
        panelDibujo.agregarPersonaje(monstruo4);
        panelDibujo.agregarPersonaje(monstruo5);
        panelDibujo.agregarPersonaje(monstruo6);
        panelDibujo.agregarPersonaje(monstruo7);
        panelDibujo.agregarPersonaje(monstruo8);*/
    }

    private void iniciarMovimientoMonstruos() {
        Timer timer = new Timer(700, e -> { 
            for (Personaje personaje : panelDibujo.getPersonajes()) {
                if (personaje instanceof Monstruo) {
                    personaje.mover();
                }
            }
            panelDibujo.repaint();
        });
        timer.start();
    }

    private void agregarControles() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> {
                        jugador.moverIzquierda();
                        panelDibujo.repaint();
                        jugador.atrapar(panelDibujo.getMonstruos());
                    }
                    case KeyEvent.VK_RIGHT -> {
                        jugador.moverDerecha(PanelDibujo.getColumnas()); 
                        panelDibujo.repaint();
                        jugador.atrapar(panelDibujo.getMonstruos());
                    }
                    case KeyEvent.VK_UP -> {
                        jugador.moverArriba();
                        panelDibujo.repaint();
                        jugador.atrapar(panelDibujo.getMonstruos());
                    }
                    case KeyEvent.VK_DOWN -> {
                        jugador.moverAbajo(PanelDibujo.getFilas());
                        panelDibujo.repaint();
                        jugador.atrapar(panelDibujo.getMonstruos());
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
