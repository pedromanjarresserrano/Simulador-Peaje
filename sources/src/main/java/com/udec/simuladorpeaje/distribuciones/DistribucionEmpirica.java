/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.distribuciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author PedroD
 */
public class DistribucionEmpirica {

    private ArrayList<Float> numeros;
    private ArrayList<Float> probablidades;
    private List<Rango> rangos;

    /**
     *
     */
    public DistribucionEmpirica() {
        this.rangos = new ArrayList<>();
    }

    /**
     *
     * @param numeros
     * @param probablidades
     */
    public DistribucionEmpirica(ArrayList<Float> numeros, ArrayList<Float> probablidades) {
        this.numeros = numeros;
        this.probablidades = probablidades;
        this.rangos = new ArrayList<>();
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
    public ArrayList<Float> getProbablidades() {
        return probablidades;
    }

    /**
     *
     * @param probablidades
     */
    public void setProbablidades(ArrayList<Float> probablidades) {
        this.probablidades = probablidades;
    }

    /**
     *
     * @return
     */
    public ArrayList<Rango> getRangos() {
        return (ArrayList<Rango>) rangos;
    }

    /**
     *
     * @param rangos
     */
    public void setRangos(ArrayList<Rango> rangos) {
        this.rangos = rangos;
    }

    @Override
    public String toString() {
        return "DistribucionBernoulli{" + "numeros=" + numeros + ", probablidades=" + probablidades + ", rangos=" + rangos + '}';
    }

    /**
     *
     * @return
     */
    public ArrayList<Long> tipos() {
     //   System.out.println("Entro");
        ArrayList<Long> tipos = new ArrayList<>();
        float inferior = 0;
        float superior = 0;
        Rango rango = new Rango();
        for (Float float1 : probablidades) {
            superior = inferior + float1;
            rango.setLimiteinferior(inferior);
            rango.setLimitesuperior(superior);
            this.rangos.add(rango);
            inferior = superior;
            rango = new Rango();
        }
        long i = 0;
        for (Float float1 : numeros) {
            for (Rango float2 : this.rangos) {
                if (float1 >= float2.getLimiteinferior() && float1 < float2.getLimitesuperior()) {
                    tipos.add(i);
                }
                i++;
            }
            i = 0;
        }
        return tipos;
    }

    /**
     *
     * @return
     */
    public int sizeNumeros() {
        return numeros.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyNumeros() {
        return numeros.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfNumeros(Object o) {
        return numeros.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Float getNumeros(int index) {
        return numeros.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Float setNumeros(int index, Float element) {
        return numeros.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addNumeros(Float e) {
        return numeros.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addNumeros(int index, Float element) {
        numeros.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Float removeNumeros(int index) {
        return numeros.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeNumeros(Object o) {
        return numeros.remove(o);
    }

    /**
     *
     */
    public void clearNumeros() {
        numeros.clear();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllNumeros(Collection<? extends Float> c) {
        return numeros.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllNumeros(int index, Collection<? extends Float> c) {
        return numeros.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllNumeros(Collection<?> c) {
        return numeros.removeAll(c);
    }

    /**
     *
     * @return
     */
    public Iterator<Float> iteratorNumeros() {
        return numeros.iterator();
    }

    /**
     *
     * @param filter
     * @return
     */
    public boolean removeIfNumeros(Predicate<? super Float> filter) {
        return numeros.removeIf(filter);
    }

    /**
     *
     * @param operator
     */
    public void replaceAllNumeros(UnaryOperator<Float> operator) {
        numeros.replaceAll(operator);
    }

    /**
     *
     * @return
     */
    public int sizeProbablidades() {
        return probablidades.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyProbablidades() {
        return probablidades.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfProbablidades(Object o) {
        return probablidades.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Float getProbablidades(int index) {
        return probablidades.get(index);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addProbablidades(Float e) {
        return probablidades.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addProbablidades(int index, Float element) {
        probablidades.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Float removeProbablidades(int index) {
        return probablidades.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeProbablidades(Object o) {
        return probablidades.remove(o);
    }

    /**
     *
     */
    public void clearProbablidades() {
        probablidades.clear();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllProbablidades(Collection<? extends Float> c) {
        return probablidades.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllProbablidades(int index, Collection<? extends Float> c) {
        return probablidades.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllProbablidades(Collection<?> c) {
        return probablidades.removeAll(c);
    }

    /**
     *
     * @return
     */
    public Iterator<Float> iteratorProbablidades() {
        return probablidades.iterator();
    }

    /**
     *
     * @param filter
     * @return
     */
    public boolean removeIfProbablidades(Predicate<? super Float> filter) {
        return probablidades.removeIf(filter);
    }

    /**
     *
     * @param operator
     */
    public void replaceAllProbablidades(UnaryOperator<Float> operator) {
        probablidades.replaceAll(operator);
    }

}
