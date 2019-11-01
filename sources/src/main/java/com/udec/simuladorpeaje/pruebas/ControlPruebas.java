/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.pruebas;

import java.util.ArrayList;

/**
 *
 * @author PedroD
 */
public class ControlPruebas {

    private Pruebas p = new Pruebas();
    private PruebaCorridas pc = new PruebaCorridas();

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaPoker(ArrayList<Float> numeros) {
        return p.getpoker(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaSerie(ArrayList<Float> numeros) {
        return p.getseries(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaDistancia(ArrayList<Float> numeros) {
        return p.pruebaDistancias(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaFrecuencia(ArrayList<Float> numeros) {
        return p.pruebaFrecuencias(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaKolgomorov(ArrayList<Float> numeros) {
        return p.pruebaKolgomorov(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaPromedios(ArrayList<Float> numeros) {
        return p.pruebaPromedios(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaCorridas1(ArrayList<Float> numeros) {
        return pc.getcorridas1(numeros);
    }

    /**
     *
     * @param numeros
     * @return
     */
    public String pruebaCorridas2(ArrayList<Float> numeros) {
        return pc.getcorridas2(numeros);
    }

    /**
     *
     */
    public ControlPruebas() {
    }

}
