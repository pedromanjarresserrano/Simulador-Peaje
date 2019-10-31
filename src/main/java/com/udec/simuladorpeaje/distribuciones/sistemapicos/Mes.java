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
public class Mes {

    private ArrayList<Semana> semanas;

    /**
     *
     * @param semanas
     */
    public Mes(ArrayList<Semana> semanas) {
        this.semanas = semanas;
    }

    /**
     *
     */
    public Mes() {
        this.semanas = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Semana> getSemanas() {
        return semanas;
    }

    /**
     *
     * @param semanas
     */
    public void setSemanas(ArrayList<Semana> semanas) {
        this.semanas = semanas;
    }

    @Override
    public String toString() {
        return "Mes{" + "semanas=" + semanas + '}';
    }

    /**
     *
     * @return
     */
    public int sizeSemanas() {
        return semanas.size();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfSemanas(Object o) {
        return semanas.indexOf(o);
    }

    /**
     *
     * @return
     */
    public Object cloneSemanas() {
        return semanas.clone();
    }

    /**
     *
     * @param index
     * @return
     */
    public Semana getSemanas(int index) {
        return semanas.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Semana setSemanas(int index, Semana element) {
        return semanas.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addSemanas(Semana e) {
        return semanas.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addSemanas(int index, Semana element) {
        semanas.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Semana removeSemanas(int index) {
        return semanas.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeSemanas(Object o) {
        return semanas.remove(o);
    }

    /**
     *
     */
    public void clearSemanas() {
        semanas.clear();
    }

}
