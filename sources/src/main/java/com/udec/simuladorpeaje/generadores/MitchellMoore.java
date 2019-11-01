package com.udec.simuladorpeaje.generadores;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class MitchellMoore {

    private int mo;
    private int n;

    /**
     *
     * @param mo
     * @param n
     */
    public MitchellMoore(int mo, int n) {
        this.mo = mo;
        this.n = n;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarMichellMoore() {
        Fibonacci f = new Fibonacci(0, 1, n);
        ArrayList<Float> nums = new ArrayList<>();
        ArrayList<Float> vectorMoore = new ArrayList<>();
        vectorMoore.addAll(f.generarFibbonaci());
        for (int i = 0; i < mo; i++) {
            int xn24 = (int) ((vectorMoore.get((vectorMoore.size() - 1) - 24)) * n);
            int xnn = (int) ((vectorMoore.get(vectorMoore.size() - n)) * n);
            int r = (xn24 + xnn) % mo;
            float resultado = (float) r / mo;
            vectorMoore.add(new Float(resultado));
            nums.add(new Float(resultado));
        }
        return nums;
    }
}
