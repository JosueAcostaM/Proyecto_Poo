package com.juego;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class PanelDibujo extends JPanel {

    private static int filas = 16; //13  -  16
    private static int columnas = 33;  //25 -  
    private int tamanoCelda;
    private List<Personaje> personajes;
    private List<Monstruo> monstruos;
    private Image fondo;

    

    public PanelDibujo() {
        setBackground(Color.BLACK);
        personajes = new ArrayList<>();
        fondo = new ImageIcon(getClass().getResource("/imagenes/bee6b29d-854f-4610-83d1-b35a1f385202.jpg")).getImage();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
        repaint(); 
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ajustarTamanoCelda();

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
            int x = personaje.getX() * tamanoCelda;
            int y = personaje.getY() * tamanoCelda;
            if (imagen != null) {
                g.drawImage(imagen, x, y, tamanoCelda, tamanoCelda, this);
            } else {
                g.setColor(personaje.getColor());
                g.fillOval(x, y, tamanoCelda, tamanoCelda);
            }
        }

        
    }

    private void ajustarTamanoCelda() {
        tamanoCelda = Math.min(getWidth() / columnas, getHeight() / filas);
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Monstruo> getMonstruos() {
        return monstruos;
    }

    public static int getFilas(){
        return filas;
    }

    public static int getColumnas(){
        return columnas;
    }
}
