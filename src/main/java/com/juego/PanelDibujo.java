package com.juego;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class PanelDibujo extends JPanel {

    private final int filas = 14;
    private final int columnas = 25;
    private final int tamanoCelda = 54;
    private List<Personaje> personajes;
    private Image fondo;

    public PanelDibujo() {

        setBackground(Color.BLACK);
        personajes = new ArrayList<>();
        fondo = new ImageIcon(getClass().getResource("/imagenes/WhatsApp Image 2025-01-28 at 5.54.37 PM.jpg")).getImage();

    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
        repaint(); //redibuja
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }

        // Dibujar tablero
        g.setColor(Color.GRAY);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                g.drawRect(j * tamanoCelda, i * tamanoCelda, tamanoCelda, tamanoCelda);
            }
        }

        // Dibujar personajes
        for (Personaje personaje : personajes) {
            g.setColor(personaje.getColor());
            g.fillOval(personaje.getX() * tamanoCelda, personaje.getY() * tamanoCelda, tamanoCelda, tamanoCelda);
        }
    }

    public int getFilas(){
        return filas;
    }

    public int getColumnas(){
        return columnas;
    }
}
