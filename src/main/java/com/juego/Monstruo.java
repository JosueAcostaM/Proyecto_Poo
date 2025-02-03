package com.juego;

import java.awt.*;
import java.util.Random;

public  abstract class Monstruo  extends Personaje{

    protected String tipo;
    protected boolean isAtrapado;

    public Monstruo(int x, int y, String nombre, Color color, int puntos, String tipo, Image diseño) {
        super(x, y, nombre, color, puntos, diseño);
        this.tipo = tipo;
    }

    public void reiniciarPosicion(int maxX, int maxY) {
        Random rand = new Random();
        this.x = rand.nextInt(maxX);
        this.y = rand.nextInt(maxY);
    }

    public void desaparecer() {
        reiniciarPosicion(PanelDibujo.getColumnas(), PanelDibujo.getFilas());
        System.out.println("Monstruo reiniciado en nueva posición: x=" + this.x + ", y=" + this.y);
    }

    public void atrapado() {
        this.isAtrapado = true;
    }

    public int getPuntos() {
        return puntos;
    }
    

}
