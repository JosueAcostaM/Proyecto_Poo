package com.juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

public class Monstruo1 extends Monstruo{

    protected String tipo;

    public Monstruo1(int x, int y, String nombre, Color color, int puntos, String tipo, Image diseño){
        super(x, y, nombre, color, puntos,tipo, diseño);
        puntos=10;
    }

    @Override
    public void mover() {
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        x += dx;
        y += dy;

        if (x < 0) x = 0;
        if (x >= PanelDibujo.getColumnas()) x = PanelDibujo.getColumnas()-1;
        if (y < 0) y = 0;
        if (y >= PanelDibujo.getFilas()) y = PanelDibujo.getFilas()-1;
    }

    public int getPosicionXmonstruo(){
        return x;
    }

    public int getPosicionymonstruo(){
        return y;
    }

}
