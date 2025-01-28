package com.juego;

//import java.awt.event.*;
import javax.swing.*;


public class Menu  extends JPanel{

    private JButton btnIniciar;
    private JButton btnDetener;
    //private boolean isGameOver;

    public Menu() {

        //inicio los botones
        btnIniciar= new JButton("Iniciar Juego");
        btnDetener= new JButton("Parar Juego");

        //agregar botones
        add(btnIniciar);
        add(btnDetener);
    }

}
