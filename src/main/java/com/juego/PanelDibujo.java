package com.juego;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class PanelDibujo extends JPanel {

    private final static int filas = 13;
    private final static int columnas = 25;
    private final int tamanoCelda = 54;
    private List<Personaje> personajes;
    private Image fondo;

    public PanelDibujo() {

        setBackground(Color.BLACK);
        personajes = new ArrayList<>();
        fondo = new ImageIcon(getClass().getResource("/imagenes/Fondo suelo.jpg")).getImage();

    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
        repaint(); 
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
            Image imagen = personaje.getImagen(); 
            if (imagen != null) {
                g.drawImage(imagen, personaje.getX() * tamanoCelda, personaje.getY() * tamanoCelda, tamanoCelda, tamanoCelda, this);
            } else {
               
                g.setColor(personaje.getColor());
                g.fillOval(personaje.getX() * tamanoCelda, personaje.getY() * tamanoCelda, tamanoCelda, tamanoCelda);
            }
        }
    }

    public static int getFilas(){
        return filas;
    }

    public static int getColumnas(){
        return columnas;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
