package com.juego;

import java.awt.Color;
import java.awt.*;

public abstract class Personaje {

    protected String nombre;
    protected Color color; 
    protected int puntos;
    protected int x,y;
    protected Image diseño;

    

    public Personaje(int x, int y, String nombre, Color color, int puntos, Image diseño){

        this.x = x;
        this.y = y;
        this.nombre=nombre;
        this.color=color;
        this.puntos=puntos;
        this.diseño= diseño;
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

    public Image getImagen(){
        return diseño;
    }
}
