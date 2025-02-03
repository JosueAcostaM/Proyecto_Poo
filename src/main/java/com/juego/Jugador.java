package com.juego;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

public class Jugador extends Personaje {

    private PantallaGeneral pantallaGeneral;

    public Jugador(int x, int y, String nombre, Color color, int puntos, Image diseño,PantallaGeneral pantallaGeneral) {
        super(x, y, nombre, color, puntos, diseño);
        this.pantallaGeneral = pantallaGeneral; 
    }
        
    @Override
    public void mover() {
        
    }

    public void atrapar(List<Monstruo> monstruos) {
        for (Monstruo monstruo : monstruos) {
            if (this.x == monstruo.getX() && this.y == monstruo.getY()) {
                aumentarPuntos(monstruo.getPuntos()); 
                monstruo.desaparecer();  
                pantallaGeneral.actualizarPuntos();  
                System.out.println("Puntos actuales: " + this.puntos);
            }
        }
    }

    public void aumentarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void moverIzquierda() {
        if (x > 0) x--;
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

    public int getPosicionXJugador(){
        return x;
    }

    public int getPosicionYJugador(){
        return y;
    }

    
}
