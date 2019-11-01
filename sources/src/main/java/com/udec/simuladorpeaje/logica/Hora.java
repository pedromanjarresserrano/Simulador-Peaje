/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;

/**
 *
 * @author PedroD
 */
public class Hora {

    private Boolean atiende;

    /**
     *
     * @param atiende
     */
    public Hora(Boolean atiende) {
        this.atiende = atiende;
    }

    /**
     *
     */
    public Hora() {
        this.atiende = Boolean.TRUE;
    }

    /**
     *
     * @return
     */
    public Boolean isAtiende() {
        return atiende;
    }

    /**
     *
     * @param atiende
     */
    public void setAtiende(Boolean atiende) {
        this.atiende = atiende;
    }

    @Override
    public String toString() {
        return "Hora{" + "atiende=" + atiende + '}';
    }

    /**
     *
     * @return
     */
    public boolean booleanValue() {
        return atiende.booleanValue();
    }
    

}
