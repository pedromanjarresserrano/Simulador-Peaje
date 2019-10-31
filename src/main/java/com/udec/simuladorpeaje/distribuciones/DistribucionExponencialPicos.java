/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones;

import com.udec.simuladorpeaje.distribuciones.sistemapicos.Dia;
import com.udec.simuladorpeaje.distribuciones.sistemapicos.Hora;
import com.udec.simuladorpeaje.distribuciones.sistemapicos.Mes;
import com.udec.simuladorpeaje.distribuciones.sistemapicos.Semana;

import java.util.ArrayList;

import static java.lang.Math.log1p;

/**
 *
 * @author PedroD
 */
public class DistribucionExponencialPicos {

    private ArrayList<Float> numeros;
    private float landa;
    private Mes mes;
    private final long segundos = 3600;
    private int indexanterior;

    /**
     *
     * @param numeros
     * @param landa
     */
    public DistribucionExponencialPicos(ArrayList<Float> numeros, float landa) {
        this.numeros = numeros;
        this.landa = landa;
        this.indexanterior = 0;
    }

    /**
     *
     * @param numeros
     * @param landa
     * @param mes
     */
    public DistribucionExponencialPicos(ArrayList<Float> numeros, float landa, Mes mes) {
        this.numeros = numeros;
        this.landa = landa;
        this.mes = mes;
        this.indexanterior = 0;
    }

    /**
     *
     * @return
     */
    public Mes getMes() {
        return mes;
    }

    /**
     *
     * @param mes
     */
    public void setMes(Mes mes) {
        this.mes = mes;
    }

    /**
     *
     */
    public DistribucionExponencialPicos() {

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
    public int getIndexanterior() {
        return indexanterior;
    }

    /**
     *
     * @param indexanterior
     */
    public void setIndexanterior(int indexanterior) {
        this.indexanterior = indexanterior;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> tiempos() {
        ArrayList<Float> tiempos = new ArrayList<>();
        for (Semana s : mes.getSemanas()) {
            for (Dia d : s.getDias()) {
                for (Hora h : d.getHoras()) {
                    if (h.isPico()) {
                        double landapico = 0;
                        if ("Sabado".equals(d.getDianombre()) || "Domingo".equals(d.getDianombre())) {
                            landapico = this.landa - (this.landa * .6);
                        } else {
                            landapico = this.landa - (this.landa * .4);
                        }
                        generaTiempo(tiempos, landapico);
                    }
                    if (h.isValle()) {
                        double landavalle = 0;
                        landavalle = this.landa * 5;
                        generaTiempo(tiempos, landavalle);
                    }
                    if (!h.isPico() && !h.isValle()) {
                        double landafin = 0;
                        if ("Sabado".equals(d.getDianombre()) || "Domingo".equals(d.getDianombre())) {
                            landafin = this.landa - (this.landa * .2);
                        } else {
                            landafin = this.landa;
                        }
                        generaTiempo(tiempos, landafin);
                    }
                    if (esHora(tiempos)) {
                        break;
                    }
                }
            }
        }
        this.indexanterior = 0;
        return tiempos;
    }

    @Override
    public String toString() {
        return "DistribucionExponencialPicos{" + ", landa=" + landa + ", indexanterior=" + indexanterior + '}';
    }

    private Boolean esHora(ArrayList<Float> tiempos) {
        double tiempo = 0;
        Integer ii = Integer.parseInt(String.valueOf(indexanterior));
        for (int i = ii; i < tiempos.size(); i++) {
            tiempo = tiempo + tiempos.get(i);
            if (i == numeros.size() - 1) {
                this.indexanterior = numeros.size();
                return true;
            }
        }
        //  System.out.println("hora "+tiempo);
        tiempo = this.segundos - tiempo;
        if (tiempo > -300 && tiempo < 300) {
            this.indexanterior = Integer.parseInt(String.valueOf(tiempos.size()));
            return true;
        }
        return false;
    }

    private void generaTiempo(ArrayList<Float> tiempos, Double landa) {
        float resultado;
        for (int in = indexanterior; in < this.numeros.size(); in++) {
            Float float1 = this.getNumeros().get(in);
            //       System.out.println("numero aleatorio: " + float1 + " Index " + numeros.indexOf(float1));
            if (0 < float1) {
                if (!esHora(tiempos)) {
                    resultado = (float) (log1p(float1.doubleValue() - 1));
                    resultado = (float) (-resultado * landa);
                    //         System.out.println("Resultado " + resultado);
                    tiempos.add(resultado);
                } else {

                    break;

                }
            }

        }

    }
}
