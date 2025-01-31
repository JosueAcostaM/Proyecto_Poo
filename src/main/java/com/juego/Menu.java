package com.juego;

import javax.swing.*;


public class Menu  extends JPanel{

    private JButton btnIniciar;
    private JButton btnDetener;
    private JButton btnReiniciar;

    public Menu() {


        btnIniciar= new JButton("Iniciar Juego");
        btnDetener= new JButton("Parar Juego");
        btnReiniciar = new JButton("Reinciar el Juego");

        add(btnIniciar);
        add(btnDetener);
        add(btnReiniciar);
    }

}
