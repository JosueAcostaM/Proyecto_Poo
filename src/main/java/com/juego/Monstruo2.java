package com.juego;

import java.awt.Color;

public class Monstruo2 extends Monstruo{

    protected String tipo;

    public Monstruo2(int x, int y, String nombre, Color color, String simbolo, int puntos, String tipo){
        super(x, y, nombre, color, simbolo, puntos,tipo);
        puntos=20;
    }

    @Override
    public void mover() {
        y += 1;
    }

}
