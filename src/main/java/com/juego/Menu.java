package com.juego;

import javax.swing.*;


public class Menu  extends JPanel{

    private JButton btnIniciar;
    private JButton btnDetener;

    public Menu() {


        btnIniciar= new JButton("Iniciar Juego");
        btnDetener= new JButton("Parar Juego");

        add(btnIniciar);
        add(btnDetener);
    }

}
