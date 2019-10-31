/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones.sistemapicos;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author PedroD
 */
public class Dia {

    private String dianombre;
    private ArrayList<Hora> horas;

    /**
     *
     * @param dianombre
     * @param horas
     */
    public Dia(String dianombre, ArrayList<Hora> horas) {
        this.dianombre = dianombre;
        this.horas = horas;
    }

    /**
     *
     * @param dianombre
     */
    public Dia(String dianombre) {
        this.dianombre = dianombre;
        this.horas = new ArrayList<>();
    }

    /**
     *
     */
    public Dia() {
        this.dianombre = "";
        this.horas = new ArrayList<>();
    }

    /**
     *
     * @param horas
     */
    public Dia(ArrayList<Hora> horas) {
        this.dianombre = "";
        this.horas = horas;
    }

    /**
     *
     * @return
     */
    public String getDianombre() {
        return dianombre;
    }

    /**
     *
     * @return
     */
    public ArrayList<Hora> getHoras() {
        return horas;
    }

    /**
     *
     * @param dianombre
     */
    public void setDianombre(String dianombre) {
        this.dianombre = dianombre;
    }

    /**
     *
     * @param horas
     */
    public void setHoras(ArrayList<Hora> horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Dia\n " + " Nombre " + dianombre + "\n" + horas.toString() + "\n";
    }

    /**
     *
     * @return
     */
    public int sizeHora() {
        return horas.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyHora() {
        return horas.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean containsHora(Object o) {
        return horas.contains(o);
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfHora(Object o) {
        return horas.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Hora getHora(int index) {
        return horas.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Hora setHora(int index, Hora element) {
        return horas.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addHora(Hora e) {
        return horas.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addHora(int index, Hora element) {
        horas.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Hora removeHora(int index) {
        return horas.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeHora(Object o) {
        return horas.remove(o);
    }

    /**
     *
     */
    public void clearHora() {
        horas.clear();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllHora(Collection<? extends Hora> c) {
        return horas.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllHora(int index, Collection<? extends Hora> c) {
        return horas.addAll(index, c);
    }

}
