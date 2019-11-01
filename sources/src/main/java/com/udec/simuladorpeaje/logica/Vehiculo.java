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
public class Vehiculo {

    private int id;
    private float tiempollegada;
    private boolean telepeaje;
    private long tipo;// type 1 = "car", 2 ="taxi"; 3="private truck"; 4="public truck"; 5="bus"; 65= "big truck"
    private float tiempoatencion;
    private int tiempoencola;
    private float valoracancelar;

    /**
     *
     */
    public Vehiculo() {
    }

    /**
     *
     * @return
     */
    public int getTiemponecola() {
        return tiempoencola;
    }

    /**
     *
     * @param tiemponecola
     */
    public void setTiemponecola(int tiemponecola) {
        this.tiempoencola = tiemponecola;
    }

    /**
     *
     * @param v
     */
    public Vehiculo(Vehiculo v) {

        this.id = v.getId();
        this.telepeaje = v.isTelepeaje();
        this.tiempoatencion = v.getTiempoatencion();
        this.tiempollegada = v.getTiempollegada();
        this.tipo = v.getTipo();
        this.tiempoencola = v.getTiemponecola();
        this.valoracancelar = v.getValoracancelar();
    }

    /**
     *
     * @param id
     * @param tiempollegada
     * @param telepeaje
     * @param tipo
     * @param tiempoatencion
     * @param tiempoencola
     * @param valoracancelar
     */
    public Vehiculo(int id, float tiempollegada, boolean telepeaje, long tipo, float tiempoatencion, int tiempoencola, float valoracancelar) {
        this.id = id;
        this.tiempollegada = tiempollegada;
        this.telepeaje = telepeaje;
        this.tipo = tipo;
        this.tiempoatencion = tiempoatencion;
        this.tiempoencola = tiempoencola;
        this.valoracancelar = valoracancelar;
    }

    /**
     *
     * @return
     */
    public int getTiempoencola() {
        return tiempoencola;
    }

    /**
     *
     * @param tiempoencola
     */
    public void setTiempoencola(int tiempoencola) {
        this.tiempoencola = tiempoencola;
    }

    /**
     *
     * @return
     */
    public float getValoracancelar() {
        return valoracancelar;
    }

    /**
     *
     * @param valoracancelar
     */
    public void setValoracancelar(float valoracancelar) {
        this.valoracancelar = valoracancelar;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param tiempollegada
     * @param tipo
     * @param telepejae
     * @param tiempoatencion
     */
    public Vehiculo(float tiempollegada, long tipo, long telepejae, float tiempoatencion) {
        this.tiempollegada = tiempollegada;
        this.tipo = tipo;
        if (telepejae == 0) {
            this.telepeaje = true;
        } else {
            this.telepeaje = false;
        }

        this.tiempoatencion = tiempoatencion;
        this.tiempoencola = 0;
        switch ((int) this.tipo) {
            case 0: {
                if (this.isTelepeaje()) {
                    this.valoracancelar = 2100;
                } else {
                    this.valoracancelar = 2200;
                }

                //Respecto a los vehículos livianos y automóviles, es de $2.200 la manual y $2.100 por telepeaje
            }
            case 1: {
                if (this.isTelepeaje()) {
                    this.valoracancelar = 1700;
                } else {
                    this.valoracancelar = 1800;
                }
                //Para taxis, la tarifa manual quedó en $1.800, mientras que por telepeaje, el costo es de $1.700. 
            }
            case 2: {
                this.valoracancelar = 6500;
            }
            case 3: {
                this.valoracancelar = 6500;
            }
            case 4: {
                this.valoracancelar = 3600;
            }
            case 5: {
                this.valoracancelar = 13300;
            }
        }

    }

    /**
     *
     * @return
     */
    public float getTiempollegada() {
        return tiempollegada;
    }

    /**
     *
     * @param tiempollegada
     */
    public void setTiempollegada(float tiempollegada) {
        this.tiempollegada = tiempollegada;
    }

    /**
     *
     * @return
     */
    public long getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public boolean isTelepeaje() {
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
    public float getTiempoatencion() {
        return tiempoatencion;
    }

    /**
     *
     * @param tiempoatencion
     */
    public void setTiempoatencion(float tiempoatencion) {
        this.tiempoatencion = tiempoatencion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", tiempollegada=" + tiempollegada + ", telepeaje=" + telepeaje + ", tipo=" + tipo + ", tiempoatencion=" + tiempoatencion + ", tiempoencola=" + tiempoencola + '}';
    }

}
