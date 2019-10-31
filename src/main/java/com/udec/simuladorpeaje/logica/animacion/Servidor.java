/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica.animacion;

/**
 *
 * @author Estudiante
 */
public class Servidor {

    private boolean telepeaje, enUso, segundacajera, primeracajera = true, buses, camiones;
    private int carrosensistema;
    private int panel;

    /**
     *
     * @param telepeaje
     * @param panel
     * @param segundacajera
     * @param buses
     * @param camiones
     */
    public Servidor(boolean telepeaje, int panel, boolean segundacajera, boolean buses, boolean camiones) {
        this.telepeaje = telepeaje;
        this.enUso = false;
        this.carrosensistema = 0;
        this.panel = panel;
        this.segundacajera = segundacajera;
        this.buses = buses;
        this.camiones = camiones;
    }

    /**
     *
     * @return
     */
    public boolean getTelepeaje() {
        return telepeaje;
    }

    /**
     *
     * @param telepeaje
     */
    public void setTelepeaje(boolean telepeaje) {
        this.telepeaje = telepeaje;
    }

    /**
     *
     * @return
     */
    public boolean getEnUso() {
        return enUso;
    }

    /**
     *
     * @param enUso
     */
    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    /**
     *
     * @return
     */
    public int getCarrosensistema() {
        return carrosensistema;
    }

    /**
     *
     * @return
     */
    public boolean isSegundacajera() {
        return segundacajera;
    }

    /**
     *
     * @param segundacajera
     */
    public void setSegundacajera(boolean segundacajera) {
        this.segundacajera = segundacajera;
    }

    /**
     *
     * @return
     */
    public boolean isBuses() {
        return buses;
    }

    /**
     *
     * @param buses
     */
    public void setBuses(boolean buses) {
        this.buses = buses;
    }

    /**
     *
     * @return
     */
    public boolean isCamiones() {
        return camiones;
    }

    /**
     *
     * @param camiones
     */
    public void setCamiones(boolean camiones) {
        this.camiones = camiones;
    }

    /**
     *
     * @return
     */
    public boolean isPrimeracajera() {
        return primeracajera;
    }

    /**
     *
     * @param primeracajera
     */
    public void setPrimeracajera(boolean primeracajera) {
        this.primeracajera = primeracajera;
    }

    /**
     *
     * @param carros
     */
    public void setCarrosensistema(int carros) {
        if (carros == 1) {
            this.carrosensistema = carrosensistema + 1;
        } else {
            this.carrosensistema = carrosensistema - 1;
        }
    }

    /**
     *
     * @return
     */
    public int getPanel() {
        return panel;
    }

    /**
     *
     * @param panel
     */
    public void setPanel(int panel) {
        this.panel = panel;
    }

    @Override
    public String toString() {
        return "Peaje{" + "telepeaje=" + telepeaje + ", enUso=" + enUso + ", segundacajera=" + segundacajera + ", buses=" + buses + ", camiones=" + camiones + ", carrosensistema=" + carrosensistema + ", panel=" + panel + '}';
    }

    /**
     *
     */
    public Servidor() {
    }
    

}
