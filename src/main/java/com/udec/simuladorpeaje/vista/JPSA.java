/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.vista;

import com.udec.simuladorpeaje.logica.animacion.PanelConFondo;
import com.udec.simuladorpeaje.logica.Caseta;
import com.udec.simuladorpeaje.logica.Configuracion;
import com.udec.simuladorpeaje.logica.Vehiculo;
import com.udec.simuladorpeaje.logica.animacion.Servidor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author PedroD
 */
public class JPSA extends javax.swing.JPanel {

    private final PanelConFondo[] paneles;
    private final ArrayList<JLabel> label = new ArrayList();
    private final String[] nombres = {"Carro", "Carro Publico", "C. Particular", "C.Publico", "Bus", "Borrador"};
    private final JButton inicia;
    private final JButton parar;
    private final int ANCHO = 1000;
    private final ArrayList<com.udec.simuladorpeaje.logica.animacion.Vehiculo> carros;
    private final ArrayList<Servidor> peajes;
    private ArrayList<Vehiculo> alv;
    private ArrayList<Caseta> alc;
    private int reubicacion = 1;
    private int velocidad = 500;
    private int velocidad2 = 500;
    private Integer beforeValue = 0;
    private Integer beforeValue2 = 0;
    private JSlider jsl = new JSlider(1, 20, 1);
    private Thread hilo = new Thread();
    private JLabel siguiente = new JLabel("Siguiente Vehiculo en: ");
    private int acumula = 0;
    private int horaactual = 0;

    /**
     * Creates new form JPSA
     *
     * @param alcs
     */
    public JPSA(ArrayList<Caseta> alcs) {
        acumula = Configuracion.getInstancia().getHoraInicio();
        jsl.setEnabled(false);
        alc = alcs;
        int ncasillas = alc.size();
        this.carros = new ArrayList();
        this.peajes = new ArrayList();
        this.alv = new ArrayList<>();
        initComponents();
        setLayout(new GridLayout(0, 1));
        paneles = new PanelConFondo[ncasillas];
        Servidor s = new Servidor();

        for (int i = 0; i < ncasillas; i++) {

            Boolean borradores = alc.get(i).isAceptaBorradores();
            Boolean buses = alc.get(i).isAceptaBuses();
            Boolean telepeaje;
            Boolean cajeras = true;
            if (alc.get(i).getTipo() == 0) {
                telepeaje = true;
                paneles[i] = new PanelConFondo("/images/carreteratelepeaje2.gif");
                paneles[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                paneles[i].setOpaque(true);

                s = new Servidor(telepeaje, i, cajeras, buses, borradores);
            } else {
                telepeaje = false;
                s = new Servidor(telepeaje, i, cajeras, buses, borradores);
                paneles[i] = new PanelConFondo("/images/carreterapeaje.gif");
                paneles[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                paneles[i].setOpaque(true);

                System.out.println("");
                Boolean Primeracajera = (alc.get(i).getServidores().get(0).getHorario(acumula).isAtiende());
                Boolean Segundacajera = (alc.get(i).getServidores().get(1).getHorario(acumula).isAtiende());
                if (Primeracajera) {
                    if (Segundacajera) {
                        paneles[i].setImagen("/images/dosfunca.gif");
                        s.setPrimeracajera(true);
                        s.setSegundacajera(true);
                    } else {
                        paneles[i].setImagen("/images/onlyone.gif");
                        s.setPrimeracajera(true);
                        s.setSegundacajera(false);
                    }
                } else {
                    if (Segundacajera) {
                        paneles[i].setImagen("/images/onlytwo.gif");
                        s.setPrimeracajera(false);
                        s.setSegundacajera(true);
                    } else {
                        paneles[i].setImagen("/images/zero.gif");
                        s.setPrimeracajera(false);
                        s.setSegundacajera(false);
                    }
                }
            }

            paneles[i].setMaximumSize(new Dimension(ANCHO, paneles[i].getWidth()));
            this.add(paneles[i]);

            peajes.add(s);
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        jsl.setMajorTickSpacing(1);
        jsl.setMinorTickSpacing(1);
        jsl.setPaintTicks(true);
        jsl.setPaintTrack(true);
        jsl.setPaintLabels(true);
        jsl.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (jsl.getValue() == 1) {
                    velocidad = 500;
                    reubicacion = 1;

                } else {
                    if (jsl.getValue() > beforeValue) {
                        velocidad = velocidad2 / jsl.getValue();
                        reubicacion = reubicacion + (jsl.getValue());
                        beforeValue = jsl.getValue();
                    } else {
                        if (jsl.getValue() < beforeValue) {
                            velocidad = velocidad2 / jsl.getValue();
                            reubicacion = reubicacion - (jsl.getValue());
                            beforeValue = jsl.getValue();
                        }
                    }
                }
                for (com.udec.simuladorpeaje.logica.animacion.Vehiculo c : carros) {
                    c.setReubicacion(reubicacion);
                    c.setVelocidad(velocidad);
                }

            }
        });
        inicia = new JButton("Inicar Animación");
        inicia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo = new Thread() {
                    public int velo = velocidad;

                    @Override
                    public void run() {

                        for (int i = 0; i < alv.size(); i++) {
                            for (;;) {
                                for (int x = 0; x < carros.size(); x++) {
                                    if (carros.get(x).isTermino()) {
                                        carros.remove(x);
                                        System.out.println("afuera");
                                    }
                                }
                                if (horaactual > 3600) {
                                    acumula++;
                                    horaactual = 0;
                                    for (int j = 0; j < alc.size(); j++) {
                                        boolean telepeaje = peajes.get(j).getTelepeaje();
                                        if (telepeaje) {
                                            peajes.get(j).setPrimeracajera(alc.get(j).getServidores().get(0).getHorario(acumula).isAtiende());
                                            paneles[j].setImagen("/images/carreteratelepeaje2.gif");
                                            paneles[j].repaint();
                                        } else {
                                            peajes.get(j).setPrimeracajera(alc.get(j).getServidores().get(0).getHorario(acumula).isAtiende());
                                            peajes.get(j).setSegundacajera(alc.get(j).getServidores().get(1).getHorario(acumula).isAtiende());
                                            if (peajes.get(j).isPrimeracajera()) {
                                                if (peajes.get(j).isSegundacajera()) {
                                                    paneles[j].setImagen("/images/dosfunca.gif");
                                                    paneles[j].repaint();
                                                } else {
                                                    paneles[j].setImagen("/images/onlyone.gif");
                                                    paneles[j].repaint();
                                                }
                                            } else {
                                                if (peajes.get(j).isSegundacajera()) {
                                                    paneles[j].setImagen("/images/onlytwo.gif");
                                                    paneles[j].repaint();
                                                } else {
                                                    paneles[j].setImagen("/images/zero.gif");
                                                    paneles[j].repaint();
                                                }
                                            }
                                        }
                                        System.out.println("cambio de hora");

                                    }
                                }
                                boolean llego = false;
                                System.out.println(" entro ");
                                System.out.println("tiempo " + alv.get(0).getTiempollegada());
                                for (int w = 0; w < velocidad + 1; w++) {

                                    if (jsl.getValue() != beforeValue2) {
                                        beforeValue2 = jsl.getValue();
                                        break;
                                    } else {
                                        try {
                                            String s = String.valueOf(alv.get(0).getTiempollegada());
                                            Double l = Double.parseDouble(s.trim().toString());

                                            siguiente.setText("Siguiente Vehiculo en: " + l + " Seg");
                                            sleep((long) (alv.get(0).getTiempollegada()));

                                        } catch (InterruptedException ex) {
                                        }

                                    }
                                    if (!(w < velocidad)) {
                                        llego = true;
                                    }
                                }
                                System.out.println("paso");
                                if (llego) {
                                    break;
                                }
                            }
                            try {
                                horaactual = (int) (horaactual + alv.get(0).getTiempollegada());
                                cargarCarro(alv.remove(0));
                            } catch (Exception e) {
                            }
                        }
                    }
                };
                hilo.start();
                jsl.setEnabled(true);
                inicia.setEnabled(false);
                parar.setEnabled(true);
            }
        });
        parar = new JButton("Parar");
        parar.setEnabled(false);
        parar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo.stop();
                parar.setEnabled(false);
                inicia.setEnabled(true);
            }
        });
        ;

        panel.add(jsl);
        panel.add(siguiente);
        panel.add(inicia);
        panel.add(parar);

        this.add(panel);
        setLocation(200, 50);
        setSize(ANCHO, 550);
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(1000, 32767));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @return
     */
    public ArrayList<Vehiculo> getAlv() {
        return alv;
    }

    /**
     *
     * @param alv
     */
    public void setAlv(ArrayList<Vehiculo> alv) {
        for (Vehiculo vehiculo : alv) {
            this.alv.add(new Vehiculo(vehiculo));

        }

    }

    /**
     *
     * @return
     */
    public ArrayList<Caseta> getAlc() {
        return alc;
    }

    /**
     *
     * @param alc
     */
    public void setAlc(ArrayList<Caseta> alc) {
        this.alc = alc;
    }

    /**
     *
     * @param v
     */
    public void cargarCarro(Vehiculo v) {
        int tipodecarro = (int) v.getTipo();
        Boolean telepeaje = v.isTelepeaje();
        int segundos = (int) v.getTiempoatencion();
        JLabel j = new JLabel();
        j.setText(this.nombres[tipodecarro]);
        String path = ("/images/" + tipodecarro + ".gif").trim();
        URL url = getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        j.setIcon(icon);
        j.setForeground(Color.WHITE);
        label.add(j);
        label.get(label.size() - 1).setName("Nuevo");
        int m = menor(telepeaje, tipodecarro);
        paneles[m].add(label.get(label.size() - 1));
        com.udec.simuladorpeaje.logica.animacion.Vehiculo telep = new com.udec.simuladorpeaje.logica.animacion.Vehiculo("Vehiculo", ANCHO - 40, label.get(label.size() - 1), peajes.get(m), segundos);
        telep.setReubicacion(reubicacion);
        telep.setVelocidad(velocidad);
        carros.add(telep);
        peajes.get(m).setCarrosensistema(1);
        telep.start();
        paneles[m].getComponentAt(0, 0).validate();
    }

    /**
     *
     * @param t
     * @return
     */
    public int menor(Boolean t, int tipodecarro) {

        int imenor = 0;
        ArrayList<Servidor> temp = new ArrayList();

        for (Servidor peaje : peajes) {
            if (peaje.isSegundacajera() == false && peaje.isPrimeracajera() == false) {
                continue;
            }
            if (t) {
                if (peaje.getTelepeaje() == true) {
                    if (tipodecarro == 5) {
                        if (peaje.isCamiones()) {
                            temp.add(peaje);
                        }
                    } else {
                        if (tipodecarro == 4) {
                            if (peaje.isBuses()) {
                                temp.add(peaje);
                            }
                        } else {
                            temp.add(peaje);
                        }
                    }
                }
            } else {
                if (peaje.getTelepeaje() == false) {
                    if (tipodecarro == 5) {
                        if (peaje.isCamiones()) {
                            temp.add(peaje);
                        }
                    } else {
                        if (tipodecarro == 4) {
                            if (peaje.isBuses()) {
                                temp.add(peaje);
                            }
                        } else {
                            temp.add(peaje);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getCarrosensistema() < temp.get(imenor).getCarrosensistema()) {
                imenor = i;
            } else if (temp.get(i).getCarrosensistema() == temp.get(imenor).getCarrosensistema()) {
            }
        }
        return temp.get(imenor).getPanel();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
