package com.udec.simuladorpeaje.pruebas;

/**
 *
 * @author Estudiante
 */
public class ConstanteD {

    /**
     *
     * @param n
     * @return
     */
    public double obtenerD(int n) {
        double d = 0;
        double t[] = {0.975, 0.842, 0.708, 0.624, 0.563, 0.521, 0.486, 0.457,
            0.432, 0.409, 0.391, 0.375, 0.361, 0.349, 0.338, 0.328,
            0.318, 0.309, 0.301, 0.294, 0.264, 0.242, 0.230, 0.210,
            0.188, 0.172, 0.160, 0.150, 0.141, 0.134};

        if (n > 0 && n <= 20) {
            d = t[n];
        } else if (n > 20 && n <= 25) {
            d = t[20];
        } else if (n > 25 && n <= 30) {
            d = t[21];
        } else if (n > 30 && n <= 35) {
            d = t[22];
        } else if (n > 35 && n <= 40) {
            d = t[23];
        } else if (n > 40 && n <= 50) {
            d = t[24];
        } else if (n > 50 && n <= 60) {
            d = t[25];
        } else if (n > 60 && n <= 70) {
            d = t[26];
        } else if (n > 70 && n <= 80) {
            d = t[27];
        } else if (n > 80 && n <= 90) {
            d = t[28];
        } else if (n > 90 && n <= 100) {
            d = t[29];
        } else if (n > 100) {
            d = 1.36 / Math.sqrt(n);
        }
        return d;
    }
}
