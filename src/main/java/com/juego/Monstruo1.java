package com.juego;

import java.awt.Color;

public class Monstruo1 extends Monstruo{

    protected String tipo;

    public Monstruo1(int x, int y, String nombre, Color color, String simbolo, int puntos, String tipo){
        super(x, y, nombre, color, simbolo, puntos,tipo);
        puntos=10;
    }

    @Override
    public void mover() {
        x += 1;
    }

}
