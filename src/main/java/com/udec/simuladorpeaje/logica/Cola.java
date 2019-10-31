/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author PedroD
 */
public class Cola {

    private ArrayList<Vehiculo> vehiculos;

    /**
     *
     * @param vehiculos
     */
    public Cola(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     *
     */
    public Cola() {
        this.vehiculos = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     *
     * @param vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Cola{" + "vehiculos=" + vehiculos + '}';
    }

    /**
     *
     * @return
     */
    public int size() {
        return vehiculos.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return vehiculos.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        return vehiculos.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Vehiculo get(int index) {
        return vehiculos.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Vehiculo set(int index, Vehiculo element) {
        return vehiculos.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean add(Vehiculo e) {
        return vehiculos.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void add(int index, Vehiculo element) {
        vehiculos.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Vehiculo remove(int index) {
        return vehiculos.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        return vehiculos.remove(o);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAll(Collection<? extends Vehiculo> c) {
        return vehiculos.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAll(int index, Collection<? extends Vehiculo> c) {
        return vehiculos.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAll(Collection<?> c) {
        return vehiculos.removeAll(c);
    }

}
