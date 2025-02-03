package com.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PantallaGeneral extends JFrame {

    private Menu menu;
    private PanelDibujo panelDibujo;
    private Jugador jugador;
    private Timer timerMonstruos;  // Mueve esta variable a nivel de clase
    private int contador;
    private JLabel labelContador;
    private Timer timerContador;
    private JPanel pantallaNegra;
    private JLabel puntosLabel;
    private JPanel contenedorJuego;
    private JPanel panelInfo;  

    public PantallaGeneral() {
        setTitle("VideoJuego (JOSUE ACOSTA)");
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new Menu();
        add(menu, BorderLayout.NORTH); 

        contenedorJuego = new JPanel();
        contenedorJuego.setLayout(new BorderLayout());
        add(contenedorJuego, BorderLayout.CENTER);  

        pantallaNegra = new JPanel();
        pantallaNegra.setBackground(Color.BLACK);
        contenedorJuego.add(pantallaNegra, BorderLayout.CENTER);

        contador = 0;

        panelInfo = new JPanel();
        panelInfo.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        panelInfo.setBackground(Color.BLACK);

        labelContador = new JLabel("Tiempo: " + contador);
        labelContador.setFont(new Font("Arial", Font.PLAIN, 24));
        labelContador.setForeground(Color.WHITE);
        panelInfo.add(labelContador);

        puntosLabel = new JLabel("Puntos: 0");
        puntosLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        puntosLabel.setForeground(Color.WHITE);
        panelInfo.add(puntosLabel);

        add(panelInfo, BorderLayout.SOUTH);

        menu.setActionListenerBtnIniciar(e -> {
            remove(pantallaNegra);  // Eliminar la pantalla negra
            panelDibujo = new PanelDibujo();
            contenedorJuego.add(panelDibujo, BorderLayout.CENTER);  

            // Pasar la referencia de PantallaGeneral al jugador
            jugador = new Jugador(2, 2, "Jugador", Color.BLUE, 0, new ImageIcon(getClass().getResource("/imagenes/cat-opens-moith-wide.gif")).getImage(), this);
            inicializarPersonajes();
            contador = 11;
            agregarControles();
            iniciarMovimientoMonstruos();
            inciarContador();

            revalidate();  
            repaint();     
        });

        menu.setActionListenerBtnDetener(e -> {
            detenerJuego();
        });
    }

    public void inicializarPersonajes() {
        Image diseñoMonstruo1 = new ImageIcon(getClass().getResource("/imagenes/Jugador.png")).getImage();
        Image diseñoMonstruo2 = new ImageIcon(getClass().getResource("/imagenes/Jugador.png")).getImage();

        Monstruo1 monstruo1 = new Monstruo1(1, 2, "Monstruo1", Color.RED, 10, "tipo1", diseñoMonstruo1);
        Monstruo2 monstruo2 = new Monstruo2(5, 5, "Monstruo2", Color.GREEN, 20, "tipo2", diseñoMonstruo2);

        panelDibujo.agregarPersonaje(jugador);
        panelDibujo.agregarPersonaje(monstruo1);
        panelDibujo.agregarPersonaje(monstruo2);
    }

   public void agregarControles() {
    panelDibujo.setFocusable(true);  
    panelDibujo.requestFocusInWindow();  

    panelDibujo.addKeyListener(new KeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
                    jugador.moverIzquierda();
                    panelDibujo.repaint();
                    jugador.atrapar(panelDibujo.getMonstruos());  
                }
                case KeyEvent.VK_RIGHT -> {
                    jugador.moverDerecha(PanelDibujo.getColumnas());
                    panelDibujo.repaint();
                    jugador.atrapar(panelDibujo.getMonstruos());
                }
                case KeyEvent.VK_UP -> {
                    jugador.moverArriba();
                    panelDibujo.repaint();
                    jugador.atrapar(panelDibujo.getMonstruos()); 
                }
                case KeyEvent.VK_DOWN -> {
                    jugador.moverAbajo(PanelDibujo.getFilas());
                    panelDibujo.repaint();
                    jugador.atrapar(panelDibujo.getMonstruos()); 
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}
    });
}


    public void iniciarMovimientoMonstruos() {
        if (timerMonstruos != null) {
            timerMonstruos.stop();
        }   

        timerMonstruos = new Timer(700, e -> {
            for (Personaje personaje : panelDibujo.getPersonajes()) {
                if (personaje instanceof Monstruo) {
                    personaje.mover();
                }
            }
            panelDibujo.repaint();
        });

        timerMonstruos.start();
    }


    public void inciarContador() {
        timerContador = new Timer(1000, e -> {
            if (contador > 0) {
                contador--;
                labelContador.setText("Tiempo: " + contador);
            } else {
                timerMonstruos.stop();
                mostrarMensajeGameOver();
                
            }
        });
        timerContador.start();
    }

    public void detenerJuego() {
        if (panelDibujo != null) {
            contenedorJuego.remove(panelDibujo);  // Remover solo el panel de juego
        }
    
        // Volver a mostrar la pantalla negra
        pantallaNegra = new JPanel();
        pantallaNegra.setBackground(Color.BLACK);
        contenedorJuego.add(pantallaNegra, BorderLayout.CENTER);
    
        // Asegurar que el panel de información siga visible
        add(panelInfo, BorderLayout.SOUTH);
        add(menu, BorderLayout.NORTH);
    
        // Reiniciar valores del contador y los puntos
        contador = 0;
        labelContador.setText("Tiempo: " + contador);
        puntosLabel.setText("Puntos: 0");
    
        if (timerContador != null) {
            timerContador.stop();  // Detener el contador
        }
    
        revalidate();
        repaint();
    }
    

    public void actualizarPuntos() {
        puntosLabel.setText("Puntos: " + jugador.getPuntos());
    }

    public void mostrarMensajeGameOver() {
        timerContador.stop();
        JOptionPane.showMessageDialog(this, "¡Game Over!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
        detenerJuego();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PantallaGeneral pantalla = new PantallaGeneral();
            pantalla.setVisible(true);
        });
    }
}
