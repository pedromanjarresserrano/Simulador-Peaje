package com.udec.simuladorpeaje.generadores;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Mezclas {

    private int m;
    private int k;
    private Green g;

    /**
     *
     * @param m
     * @param k
     */
    public Mezclas(int m, int k) {
        this.m = m;
        this.k = k;
        g = new Green(m, k);
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarMezcla1() {
        ArrayList<Float> nums = new ArrayList<>();
        if (m > k && k >= 16) {
            ArrayList<Float> numsGreen = new ArrayList<>();
            ArrayList<Float> numsGreen2 = new ArrayList<>();
            numsGreen.addAll(g.generarGreen());
            numsGreen2.addAll(g.generarGreen());
            ArrayList<Float> vector = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                vector.add(numsGreen2.get(i));
            }
            for (int i = 0; i < m; i++) {
                int j = (int) (k * numsGreen2.get(i));
                nums.add(numsGreen.get(j));
            }
        }
        return nums;
    }

    /**
     *
     * @return
     */
    public ArrayList<Float> generarMezcla2() {
        ArrayList<Float> nums = new ArrayList<>();
        if (m > k && k > 16) {
            ArrayList<Float> numsGreen = new ArrayList<>();
            numsGreen.addAll(g.generarGreen());
            ArrayList<Float> vector = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                vector.add(numsGreen.get(i));
            }
            for (int i = 0; i < m; i++) {
                int j = (int) (k * numsGreen.get(i));
                nums.add(numsGreen.get(j));
            }
        } else {
            JOptionPane.showMessageDialog(null, "M debe ser mayor que K y K>16");
        }
        return nums;
    }

}
