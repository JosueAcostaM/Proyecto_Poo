package com.juego;

import java.awt.Color;

public abstract class Personaje {

    protected String nombre;
    protected Color color; 
    protected String simbolo;
    protected int puntos;
    protected int x,y;

    public Personaje(int x, int y, String nombre, Color color, String simbolo, int puntos){

        this.x = x;
        this.y = y;
        this.nombre=nombre;
        this.color=color;
        this.simbolo=simbolo;
        this.puntos=puntos;
    }


    public abstract void mover();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
