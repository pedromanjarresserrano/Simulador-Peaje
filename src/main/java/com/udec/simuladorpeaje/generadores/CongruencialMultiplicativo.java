package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class CongruencialMultiplicativo {

    private int a;
    private int xo;
    private int mo;

    /**
     *
     * @param a
     * @param xo
     * @param mo
     */
    public CongruencialMultiplicativo(int a, int xo, int mo) {
        this.a = a;
        this.xo = xo;
        this.mo = mo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarCMultiplicativo() {
        ArrayList<Float> lista = new ArrayList<>();
        int n = 0;
        int o = (int) mo / 4;
        if (mo == 1 || mo == 2 || mo == 3) {
            o = 1;
        }
        while (n < o) {
            xo = (a * xo) % mo;
            n++;
            float x = (float) xo / mo;
            lista.add(new Float(x));
        }
        return lista;
    }
}
