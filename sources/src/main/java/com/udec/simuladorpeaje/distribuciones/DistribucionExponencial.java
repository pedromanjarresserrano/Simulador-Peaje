/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones;

import java.util.ArrayList;

import static java.lang.Math.log1p;

/**
 *
 * @author PedroD
 */
public class DistribucionExponencial {

    private ArrayList<Float> numeros;
    private float landa;

    /**
     *
     * @param numeros
     * @param landa
     */
    public DistribucionExponencial(ArrayList<Float> numeros, float landa) {
        this.numeros = numeros;
        this.landa = landa;
    }

    /**
     *
     */
    public DistribucionExponencial() {

    }

    /**
     *
     * @return
     */
    public ArrayList<Float> getNumeros() {
        return numeros;
    }

    /**
     *
     * @param numeros
     */
    public void setNumeros(ArrayList<Float> numeros) {
        this.numeros = numeros;
    }

    /**
     *
     * @return
     */
    public float getLanda() {
        return landa;
    }

    /**
     *
     * @param landa
     */
    public void setLanda(float landa) {
        this.landa = landa;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> tiempos() {
       //   System.out.println("Entro");
        ArrayList<Float> tiempos = new ArrayList<>();

        float resultado;
        for (Float float1 : this.numeros) {
            if (0 < float1) {
                resultado = (float) (log1p(float1.doubleValue() - 1));
                resultado = -resultado * this.landa;
                tiempos.add(resultado);
            }

        }

        return tiempos;
    }

    @Override
    public String toString() {
        return "DistribucionNormal{" + "numeros=" + numeros + ", landa=" + landa + '}';
    }

}
