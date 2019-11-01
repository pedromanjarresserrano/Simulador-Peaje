package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Fibonacci {

    private int x1;
    private int xo;
    private int mo;

    /**
     *
     * @param x1
     * @param xo
     * @param mo
     */
    public Fibonacci(int x1, int xo, int mo) {
        this.x1 = x1;
        this.xo = xo;
        this.mo = mo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarFibbonaci() {
        ArrayList<Float> lista = new ArrayList<>();
        int anterior = xo;
        int anterior2 = x1;
        int actual;

        for (int i = 0; i < mo; i++) {
            actual = (anterior + anterior2) % mo;
            Float x = (float) actual / mo;
            lista.add(new Float(x));
            anterior2 = anterior;
            anterior = actual;
        }
        return lista;
    }
}
