package com.juego;

import java.awt.Color;
import java.awt.*;

public  abstract class Monstruo  extends Personaje{

    protected String tipo;

    public Monstruo(int x, int y, String nombre, Color color, String simbolo, int puntos, String tipo, Image diseño) {
        super(x, y, nombre, color, simbolo, puntos, diseño);
        this.tipo = tipo;
    }

    

}
