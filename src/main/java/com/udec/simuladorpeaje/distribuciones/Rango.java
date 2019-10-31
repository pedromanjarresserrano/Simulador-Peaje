/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones;

/**
 *
 * @author PedroD
 */
public class Rango {

    private float limiteinferior;
    private float limitesuperior;

    /**
     *
     */
    public Rango() {
        this.limiteinferior = 0;
        this.limitesuperior = 0;
    }

    /**
     *
     * @param limiteinferior
     * @param limitesuperior
     */
    public Rango(float limiteinferior, float limitesuperior) {
        this.limiteinferior = limiteinferior;
        this.limitesuperior = limitesuperior;
    }

    /**
     *
     * @return
     */
    public float getLimiteinferior() {
        return limiteinferior;
    }

    /**
     *
     * @param limiteinferior
     */
    public void setLimiteinferior(float limiteinferior) {
        this.limiteinferior = limiteinferior;
    }

    /**
     *
     * @return
     */
    public float getLimitesuperior() {
        return limitesuperior;
    }

    /**
     *
     * @param limitesuperior
     */
    public void setLimitesuperior(float limitesuperior) {
        this.limitesuperior = limitesuperior;
    }

    @Override
    public String toString() {
        return "Rango{" + "limiteinferior=" + limiteinferior + ", limitesuperior=" + limitesuperior + '}';
    }

}
