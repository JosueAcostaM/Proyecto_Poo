package com.juego;

import java.awt.Color;

public  abstract class Monstruo  extends Personaje{

    protected String tipo;

    public Monstruo(int x, int y, String nombre, Color color, String simbolo, int puntos, String tipo) {
        super(x, y, nombre, color, simbolo, puntos);
        this.tipo = tipo;
    }

    

}
