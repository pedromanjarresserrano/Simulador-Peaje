package com.udec.simuladorpeaje.vista;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.udec.simuladorpeaje.generadores.ControlGeneradores;
import com.udec.simuladorpeaje.pruebas.ControlPruebas;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PedroD
 */
public class Run {

    /**
     *
     */
    public static JFmainTabble gen;

    /**
     *
     */
    public static ControlGeneradores cg;

    /**
     *
     */
    public static ControlPruebas cp;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                    cg = new ControlGeneradores();
                    gen = new JFmainTabble();
                    cp = new ControlPruebas();
                    gen.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

}
