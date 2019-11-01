package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Mixto {

    private int m;
    private int n;
    private int k;
    private Green g;
    private MitchellMoore mm;

    /**
     *
     * @param m
     * @param n
     * @param k
     */
    public Mixto(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarMixto() {
        g = new Green(m, k);
        mm = new MitchellMoore(m, n);
        ArrayList<Float> lista = new ArrayList<>();
        ArrayList<Float> green = new ArrayList<>();
        ArrayList<Float> mitchell = new ArrayList<>();
        green.addAll(g.generarGreen());
        mitchell.addAll(mm.generarMichellMoore());
        if (!mitchell.isEmpty() && !green.isEmpty()) {
            for (int i = 0; i < m; i++) {
                int r = (int) (((green.get(i) * m) + (mitchell.get(i) * m)) % m);
                float resultado = (float) r / m;
                lista.add(new Float(resultado));
            }
        }
        return lista;
    }
}
