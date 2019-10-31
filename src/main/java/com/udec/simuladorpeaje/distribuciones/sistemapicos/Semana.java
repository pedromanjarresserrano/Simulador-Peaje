/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones.sistemapicos;

import java.util.ArrayList;

/**
 *
 * @author PedroD
 */
public class Semana {

    private ArrayList<Dia> dias;

    /**
     *
     */
    public Semana() {
        this.dias = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Dia> getDias() {
        return dias;
    }

    /**
     *
     * @param dias
     */
    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Semana " + "\n Dias" + dias.toString() + "\n";
    }

    /**
     *
     * @return
     */
    public int sizeDias() {
        return dias.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyDias() {
        return dias.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfDias(Object o) {
        return dias.indexOf(o);
    }

    /**
     *
     * @return
     */
    public Object cloneDias() {
        return dias.clone();
    }

    /**
     *
     * @param index
     * @return
     */
    public Dia getDias(int index) {
        return dias.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Dia setDias(int index, Dia element) {
        return dias.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addDias(Dia e) {
        return dias.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addDias(int index, Dia element) {
        dias.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Dia removeDias(int index) {
        return dias.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeDias(Object o) {
        return dias.remove(o);
    }

    /**
     *
     */
    public void clearDias() {
        dias.clear();
    }

}
