package com.juego;

import javax.swing.*;
import java.awt.event.*;


public class Menu  extends JPanel{

    private JButton btnIniciar;
    private JButton btnDetener;
    
    

    public Menu() {


        btnIniciar= new JButton("Iniciar Juego");
        btnDetener= new JButton("Parar Juego");

        add(btnIniciar);
        add(btnDetener);

    }

    

    public void setActionListenerBtnIniciar(ActionListener actionListener) {
        btnIniciar.addActionListener(actionListener);
    }

    public void setActionListenerBtnDetener(ActionListener actionListener) {
        btnDetener.addActionListener(actionListener);
    }

    


}
