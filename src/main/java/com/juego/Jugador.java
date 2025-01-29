package com.juego;

import java.awt.Color;
import java.awt.Image;

public class Jugador extends Personaje {

    public Jugador(int x, int y, String nombre, Color color, String simbolo, int puntos, Image diseño) {
        super(x, y, nombre, color, simbolo, puntos, diseño);
    }

    @Override
    public void mover() {
        // Este método será controlado por los eventos de teclado
    }

    public void moverIzquierda() {
        if (x > 0) x--; // No permite salir del tablero
    }

    public void moverDerecha(int limite) {
        if (x < limite - 1) x++;
    }

    public void moverArriba() {
        if (y > 0) y--;
    }

    public void moverAbajo(int limite) {
        if (y < limite - 1) y++;
    }

    
}
