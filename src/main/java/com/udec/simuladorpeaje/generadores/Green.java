package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Green {

    private int mo;
    private int k;

    /**
     *
     * @param mo
     * @param k
     */
    public Green(int mo, int k) {
        this.mo = mo;
        this.k = k;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarGreen() {
        Fibonacci f = new Fibonacci(0, 1, mo);
        ArrayList<Float> lista = new ArrayList<>();
        ArrayList<Float> green = new ArrayList<>();
        green.addAll(f.generarFibbonaci());
        if (mo > k && k >= 16) {
            for (int i = 0; i < mo; i++) {
                int r = 0;
                int xn = (int) (green.get(green.size() - k) * mo);
                int xnk = (int) (green.get(i) * mo);

                r = (xn + xnk) % mo;
                float resultado = (float) r / mo;
                green.add(new Float(resultado));
                lista.add(new Float(resultado));
            }
        }
        return lista;
    }

}
