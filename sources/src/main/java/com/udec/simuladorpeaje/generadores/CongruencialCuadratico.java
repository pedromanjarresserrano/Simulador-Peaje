package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class CongruencialCuadratico {

    ArrayList<Float> lista = new ArrayList<>();
    private int a;
    private int d;
    private int c;
    private int xo;
    private int mo;

    /**
     *
     * @param a
     * @param d
     * @param c
     * @param xo
     * @param mo
     */
    public CongruencialCuadratico(int a, int d, int c, int xo, int mo) {
        this.a = a;
        this.d = d;
        this.c = c;
        this.xo = xo;
        this.mo = mo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarCuadratico() {
        lista = new ArrayList<>();

        int actual;
        int anterior = xo;
        for (int i = 0; i < mo; i++) {
            actual = ((d * (anterior * anterior)) + (a * anterior) + c) % mo;

            float x = (float) actual / mo;
            lista.add(new Float(x));
            anterior = actual;
        }
        return lista;
    }

}
