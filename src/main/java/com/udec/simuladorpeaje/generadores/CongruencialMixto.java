package com.udec.simuladorpeaje.generadores;

import com.udec.simuladorpeaje.validaciones.Ayuda;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class CongruencialMixto {

    private int a;
    private int c;
    private int xo;
    private int mo;

    /**
     *
     * @param a
     * @param c
     * @param xo
     * @param mo
     */
    public CongruencialMixto(int a, int c, int xo, int mo) {
        this.a = a;
        this.c = c;
        this.xo = xo;
        this.mo = mo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarCMixto() {
        ArrayList<Float> lista = new ArrayList<>();
        int n = 0;
        double p = 0;
        while (n < mo) {
            if (n == 0) {
                xo = ((a * xo) + c) % mo;
                n++;
                double x = (double) xo / mo;
                p = x;
                if (Ayuda.verificanumero(lista, x)) {
                    lista.add(new Float(x));
                }
            } else {
                xo = ((a * xo) + c) % mo;
                n++;
                double x = (double) xo / mo;
                if (p == x) {
                    break;
                }
                if (Ayuda.verificanumero(lista, x)) {
                    lista.add(new Float(x));
                }
            }
        }
        return lista;
    }

}
