/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica.animacion;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Vehiculo extends Thread {

    String nombre;
    JLabel label, labelfila = null;
    boolean termino, pago = false;
    Servidor peaje;
    private int segundos;
    private int ubicacion = 0;
    private int puestolabelsiguiente = 0;
    private int limite;
    private int reubicacion;
    private int velocidad;

    /**
     *
     * @param nombre
     * @param limite
     * @param label
     * @param peaje
     * @param segundos
     */
    public Vehiculo(String nombre, int limite, JLabel label, Servidor peaje, int segundos) {
        this.nombre = nombre;
        this.limite = limite;
        this.label = label;
        this.termino = false;
        this.peaje = peaje;
        this.segundos = segundos;
    }

    @Override
    public void run() {
        label.setLocation(0, 0);
        Container jpanelpadre = label.getParent();
        Component[] component = jpanelpadre.getComponents();

        for (Component component1 : component) {
            if (component1 instanceof JLabel) {
                JLabel button = (JLabel) component1;
                switch (button.getName()) {
                    case "Nuevo":
                        break;
                    case "Soy primero antiguo":
                        break;
                    case "Ultimo":
                        label.setName("Ultimo");
                        labelfila = button;
                        labelfila.setName("No soy ultimo");
                        break;
                    case "Soy primero":
                        label.setName("Ultimo");
                        labelfila = button;
                        labelfila.setName("Soy primero antiguo");
                        break;
                }
                if (labelfila != null) {
                    break;
                }
            }
        }
        if (labelfila == null) {
            label.setName("Soy primero");
        }
        while (ubicacion < 1001) {
            if (label.getName().equals("Soy primero") || label.getName().equals("Soy primero antiguo")) {
                puestolabelsiguiente = 3000;
            } else if (puestolabelsiguiente > 851) {
                puestolabelsiguiente = 2100;
            } else {
                puestolabelsiguiente = labelfila.getX();
            }
            if (label.getX() == 850 && pago == false && peaje.isPrimeracajera()) {
                for (int i = 0; i < velocidad; i++) {
                    try {
                        if (label.getX() != 850) {
                            label.setLocation(ubicacion, 0);
                        }
                        Thread.sleep(segundos);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                label.setLocation(851, 0);
                peaje.setCarrosensistema(2);
            } else {
                if ((peaje.isSegundacajera() && label.getX() == 750 && labelfila != null && puestolabelsiguiente == 850 && pago == false) || (peaje.isSegundacajera() && label.getX() == 750 && puestolabelsiguiente!= 3000 && peaje.isPrimeracajera() == false && pago == false)) {
                    for (int i = 0; i < velocidad; i++) {
                        try {
                            if (label.getX() != 850) {
                                label.setLocation(ubicacion, 0);
                            }
                            Thread.sleep(segundos);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    label.setLocation(751, 0);
                    peaje.setCarrosensistema(2);
                    pago = true;
                } else {
                    if (label.getName().equals("Soy primero") || label.getName().equals("Soy primero antiguo")) {
                        if (peaje.isSegundacajera() && label.getX() == 750 && pago == false && peaje.isPrimeracajera() == false) {
                            for (int i = 0; i < velocidad; i++) {
                                try {
                                    if (label.getX() != 850) {
                                        label.setLocation(ubicacion, 0);
                                    }
                                    Thread.sleep(segundos);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            label.setLocation(751, 0);
                            peaje.setCarrosensistema(2);
                            pago = true;
                        } else if (label.getX() == 850 && pago == false) {
                            for (int i = 0; i < velocidad; i++) {
                                try {
                                    if (label.getX() != 850) {
                                        label.setLocation(ubicacion, 0);
                                    }
                                    Thread.sleep(segundos);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            label.setLocation(851, 0);
                            peaje.setCarrosensistema(2);
                        } else {
                            ubicacion = ubicacion + reubicacion;
                            try {
                                label.setLocation(ubicacion, 0);
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        if (puestolabelsiguiente - label.getX() > 100) {
                            ubicacion = ubicacion + reubicacion;
                            try {
                                label.setLocation(ubicacion, 0);
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try {
                                label.setLocation(ubicacion, 0);
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }

        termino = true;
        label.setText("Listo");
        label.setVisible(false);
        jpanelpadre.remove(label);
        jpanelpadre.validate();
        yield();
        this.interrupt();
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getLimite() {
        return limite;
    }

    /**
     *
     * @param limite
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }

    /**
     *
     * @return
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     *
     * @param label
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     *
     * @return
     */
    public boolean isTermino() {
        return termino;
    }

    /**
     *
     * @param termino
     */
    public void setTermino(boolean termino) {
        this.termino = termino;
    }

    /**
     *
     * @return
     */
    public Servidor getPeaje() {
        return peaje;
    }

    /**
     *
     * @param peaje
     */
    public void setPeaje(Servidor peaje) {
        this.peaje = peaje;
    }

    /**
     *
     * @return
     */
    public JLabel getLabelfila() {
        return labelfila;
    }

    /**
     *
     * @param labelfila
     */
    public void setLabelfila(JLabel labelfila) {
        this.labelfila = labelfila;
    }

    /**
     *
     * @return
     */
    public boolean isPago() {
        return pago;
    }

    /**
     *
     * @param pago
     */
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    /**
     *
     * @return
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     *
     * @param segundos
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    /**
     *
     * @return
     */
    public int getPuestolabelsiguiente() {
        return puestolabelsiguiente;
    }

    /**
     *
     * @param puestolabelsiguiente
     */
    public void setPuestolabelsiguiente(int puestolabelsiguiente) {
        this.puestolabelsiguiente = puestolabelsiguiente;
    }

    /**
     *
     * @return
     */
    public int getReubicacion() {
        return reubicacion;
    }

    /**
     *
     * @param reubicacion
     */
    public void setReubicacion(int reubicacion) {
        this.reubicacion = reubicacion;
    }

    /**
     *
     * @return
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     *
     * @param velocidad
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
