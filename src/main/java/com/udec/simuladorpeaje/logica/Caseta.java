/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 *
 * @author DDV
 */
public class Caseta {

    private ArrayList<Servidor> servidores;
    private Cola cola;
    private long numeroCaseta;
    private long tipo; //0 Telepeaje - 1 Caseta Normal
    private Boolean aceptaBuses;
    private Boolean aceptaBorradores;
    private long colaLarga;

    /**
     *
     * @param servidores
     * @param cola
     * @param numeroCaseta
     * @param tipo
     */
    public Caseta(ArrayList<Servidor> servidores, Cola cola, long numeroCaseta, long tipo) {
        this.servidores = servidores;
        this.cola = cola;
        this.numeroCaseta = numeroCaseta;
        this.tipo = tipo;
        if (this.tipo == 0) {
            for (int i = 1; i < this.servidores.size(); i++) {
                this.servidores.remove(i);
            }
        }
        this.colaLarga = 0;
    }

    /**
     *
     * @param caseta
     */
    public Caseta(Caseta caseta) {
        this.servidores = new ArrayList<>();
        for (Servidor s : caseta.getServidores()) {
            servidores.add(new Servidor(s));
        }
        this.cola = caseta.getCola();
        this.numeroCaseta = caseta.getNumeroCaseta();
        this.tipo = caseta.getTipo();
        this.aceptaBuses = caseta.isAceptaBuses();
        this.aceptaBorradores = caseta.isAceptaBorradores();
        this.colaLarga = caseta.getColaLarga();
    }

    /**
     *
     * @param numeroCaseta
     */
    public Caseta(long numeroCaseta) {
        this.cola = new Cola();
        this.servidores = new ArrayList<>();
        this.numeroCaseta = numeroCaseta;
        cambiaTipo();
        this.colaLarga = 0;
    }

    /**
     *
     * @param servidores
     * @param cola
     */
    public Caseta(ArrayList<Servidor> servidores, Cola cola) {
        this.servidores = servidores;
        this.cola = cola;
        this.colaLarga = 0;
    }

    /**
     *
     * @param servidores
     */
    public Caseta(ArrayList<Servidor> servidores) {
        this.servidores = servidores;
        this.colaLarga = 0;
    }

    /**
     *
     * @param servidores
     * @param cola
     * @param numeroCaseta
     */
    public Caseta(ArrayList<Servidor> servidores, Cola cola, long numeroCaseta) {
        this.servidores = servidores;
        this.cola = cola;
        this.numeroCaseta = numeroCaseta;
        this.colaLarga = 0;

    }

    private void cambiaTipo() {
        if (this.tipo == 0) {
            for (int i = 1; i < this.servidores.size(); i++) {
                this.servidores.remove(i);
            }
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Servidor> getServidores() {
        return servidores;
    }

    /**
     *
     * @return
     */
    public Cola getCola() {
        return cola;
    }

    /**
     *
     * @return
     */
    public long getColaLarga() {
        return colaLarga;
    }

    /**
     *
     * @return
     */
    public long getNumeroCaseta() {
        return numeroCaseta;
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
     * @return
     */
    public Boolean isAceptaBuses() {
        return aceptaBuses;
    }

    /**
     *
     * @return
     */
    public Boolean isAceptaBorradores() {
        return aceptaBorradores;
    }

    /**
     *
     * @param servidores
     */
    public void setServidores(ArrayList<Servidor> servidores) {
        this.servidores = servidores;
    }

    /**
     *
     * @param cola
     */
    public void setCola(Cola cola) {
        this.cola = cola;
    }

    /**
     *
     * @param numeroCaseta
     */
    public void setNumeroCaseta(long numeroCaseta) {
        this.numeroCaseta = numeroCaseta;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(long tipo) {
        this.tipo = tipo;
        this.cambiaTipo();
    }

    /**
     *
     * @param aceptaBuses
     */
    public void setAceptaBuses(Boolean aceptaBuses) {
        this.aceptaBuses = aceptaBuses;
    }

    /**
     *
     * @param aceptaBorradores
     */
    public void setAceptaBorradores(Boolean aceptaBorradores) {
        this.aceptaBorradores = aceptaBorradores;
    }

    /**
     *
     * @param colaLarga
     */
    public void setColaLarga(long colaLarga) {
        this.colaLarga = colaLarga;
    }

    @Override
    public String toString() {
        return "Caseta{" + "servidores=" + servidores + ", numeroCaseta=" + numeroCaseta + ", tipo=" + tipo + ", aceptaBuses=" + aceptaBuses + ", aceptaBorradores=" + aceptaBorradores + '}';
    }

    /**
     *
     * @return
     */
    public int sizeServidores() {
        return servidores.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyServidores() {
        return servidores.isEmpty();
    }

    /**
     *
     * @return
     */
    public Object cloneServidores() {
        return servidores.clone();
    }

    /**
     *
     * @param index
     * @return
     */
    public Servidor getServidores(int index) {
        return servidores.get(index);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addServidores(Servidor e) {
        return servidores.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addServidores(int index, Servidor element) {
        servidores.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Servidor removeServidores(int index) {
        return servidores.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeServidores(Object o) {
        return servidores.remove(o);
    }

    /**
     *
     */
    public void clearServidores() {
        servidores.clear();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllServidores(Collection<? extends Servidor> c) {
        return servidores.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllServidores(int index, Collection<? extends Servidor> c) {
        return servidores.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllServidores(Collection<?> c) {
        return servidores.removeAll(c);
    }

    /**
     *
     * @param filter
     * @return
     */
    public boolean removeIfServidores(Predicate<? super Servidor> filter) {
        return servidores.removeIf(filter);
    }

    /**
     *
     * @return
     */
    public ArrayList<Vehiculo> getVehiculosCola() {
        return cola.getVehiculos();
    }

    /**
     *
     * @param vehiculos
     */
    public void setVehiculosCola(ArrayList<Vehiculo> vehiculos) {
        cola.setVehiculos(vehiculos);
    }

    /**
     *
     * @return
     */
    public int sizeCola() {
        return cola.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyCola() {
        return cola.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfCola(Object o) {
        return cola.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Vehiculo getCola(int index) {
        return cola.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Vehiculo setCola(int index, Vehiculo element) {
        return cola.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addCola(Vehiculo e) {
        return cola.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addCola(int index, Vehiculo element) {
        cola.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Vehiculo removeCola(int index) {
        return cola.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeCola(Object o) {
        return cola.remove(o);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllCola(Collection<? extends Vehiculo> c) {
        return cola.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllCola(int index, Collection<? extends Vehiculo> c) {
        return cola.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllCola(Collection<?> c) {
        return cola.removeAll(c);
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfServidor(Object o) {
        return servidores.indexOf(o);
    }

}
