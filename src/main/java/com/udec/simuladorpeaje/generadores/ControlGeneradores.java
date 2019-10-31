/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author PedroD
 */
public class ControlGeneradores {

    private CongruencialCuadratico cc;
    private CongruencialMixto cm;
    private CongruencialMultiplicativo cmu;
    private Fibonacci f;
    private Green g;
    private Mezclas m;
    private MitchellMoore mm;
    private Mixto mix;

    /**
     *
     * @param a
     * @param c
     * @param xo
     * @param m
     * @return
     */
    public ArrayList<Float> congruencialMixto(int a, int c, int xo, int m) {
        this.cm = new CongruencialMixto(a, c, xo, m);
        return this.cm.generarCMixto();
    }

    /**
     *
     * @param a
     * @param xo
     * @param m
     * @return
     */
    public ArrayList<Float> congruencialMultiplicativo(int a, int xo, int m) {
        this.cmu = new CongruencialMultiplicativo(a, xo, m);
        return this.cmu.generarCMultiplicativo();
    }

    /**
     *
     * @param a
     * @param d
     * @param c
     * @param xo
     * @param m
     * @return
     */
    public ArrayList<Float> congruencialCuadratico(int a, int d, int c, int xo, int m) {
        this.cc = new CongruencialCuadratico(a, d, c, xo, m);
        return this.cc.generarCuadratico();
    }

    /**
     *
     * @param x1
     * @param xo
     * @param m
     * @return
     */
    public ArrayList<Float> fibonacci(int x1, int xo, int m) {
        this.f = new Fibonacci(x1, xo, m);
        return this.f.generarFibbonaci();
    }

    /**
     *
     * @param m
     * @param k
     * @return
     */
    public ArrayList<Float> green(int m, int k) {
        this.g = new Green(m, k);
        return this.g.generarGreen();
    }

    /**
     *
     * @param m
     * @param k
     * @return
     */
    public ArrayList<Float> mezclasI(int m, int k) {
        this.m = new Mezclas(m, k);
        return this.m.generarMezcla1();
    }

    /**
     *
     * @param m
     * @param k
     * @return
     */
    public ArrayList<Float> mezclasII(int m, int k) {
        this.m = new Mezclas(m, k);
        return this.m.generarMezcla2();
    }

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public ArrayList<Float> mitchellMoore(int m, int n) {
        this.mm = new MitchellMoore(m, n);
        return this.mm.generarMichellMoore();
    }

    /**
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public ArrayList<Float> mixto(int m, int n, int k) {
        this.mix = new Mixto(m, n, k);
        return this.mix.generarMixto();
    }

    /**
     *
     * @return
     */
    public CongruencialCuadratico getCc() {
        return cc;
    }

    /**
     *
     * @param cc
     */
    public void setCc(CongruencialCuadratico cc) {
        this.cc = cc;
    }

    /**
     *
     * @return
     */
    public CongruencialMixto getCm() {
        return cm;
    }

    /**
     *
     * @param cm
     */
    public void setCm(CongruencialMixto cm) {
        this.cm = cm;
    }

    /**
     *
     * @return
     */
    public CongruencialMultiplicativo getCmu() {
        return cmu;
    }

    /**
     *
     * @param cmu
     */
    public void setCmu(CongruencialMultiplicativo cmu) {
        this.cmu = cmu;
    }

    /**
     *
     * @return
     */
    public Fibonacci getF() {
        return f;
    }

    /**
     *
     * @param f
     */
    public void setF(Fibonacci f) {
        this.f = f;
    }

    /**
     *
     * @return
     */
    public Green getG() {
        return g;
    }

    /**
     *
     * @param g
     */
    public void setG(Green g) {
        this.g = g;
    }

    /**
     *
     * @return
     */
    public Mezclas getM() {
        return m;
    }

    /**
     *
     * @param m
     */
    public void setM(Mezclas m) {
        this.m = m;
    }

    /**
     *
     * @return
     */
    public MitchellMoore getMm() {
        return mm;
    }

    /**
     *
     * @param mm
     */
    public void setMm(MitchellMoore mm) {
        this.mm = mm;
    }

    /**
     *
     * @return
     */
    public Mixto getMix() {
        return mix;
    }

    /**
     *
     * @param mix
     */
    public void setMix(Mixto mix) {
        this.mix = mix;
    }

    /**
     *
     */
    public ControlGeneradores() {
    }

    /**
     *
     * @param cc
     * @param cm
     * @param cmu
     * @param f
     * @param g
     * @param m
     * @param mm
     * @param mix
     */
    public ControlGeneradores(CongruencialCuadratico cc, CongruencialMixto cm, CongruencialMultiplicativo cmu, Fibonacci f, Green g, Mezclas m, MitchellMoore mm, Mixto mix) {
        this.cc = cc;
        this.cm = cm;
        this.cmu = cmu;
        this.f = f;
        this.g = g;
        this.m = m;
        this.mm = mm;
        this.mix = mix;
    }

}
