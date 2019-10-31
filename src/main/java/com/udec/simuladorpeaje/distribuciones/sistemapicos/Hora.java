/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones.sistemapicos;

/**
 *
 * @author PedroD
 */
public class Hora {

    private Boolean pico;
    private Boolean valle;

    /**
     *
     * @param pico
     * @param valle
     */
    public Hora(Boolean pico, Boolean valle) {
        this.pico = pico;
        this.valle = valle;
    }

    /**
     *
     */
    public Hora() {
        this.pico = false;
        this.valle = false;

    }

    /**
     *
     * @return
     */
    public Boolean isValle() {
        return valle;
    }

    /**
     *
     * @return
     */
    public Boolean isPico() {
        return pico;
    }

    /**
     *
     * @param pico
     */
    public void setPico(Boolean pico) {
        this.pico = pico;
    }

    /**
     *
     * @param valle
     */
    public void setValle(Boolean valle) {
        this.valle = valle;
    }

    @Override
    public String toString() {
        if (valle) {
            return "Hora Valle\n";
        }
        if (pico) {
            return "Hora Pico\n";
        }
        return "Hora Normal\n";
    }

}
