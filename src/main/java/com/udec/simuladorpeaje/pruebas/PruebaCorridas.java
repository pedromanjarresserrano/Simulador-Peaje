package com.udec.simuladorpeaje.pruebas;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class PruebaCorridas {

    Chi2 c = new Chi2();

    /**
     *
     * @param resultados
     * @return
     */
    public String getcorridas1(ArrayList<Float> resultados) {
        double fei[], x02 = 0, xan1;
        int N = resultados.size(), bin[], flag, aux, ultimo = 0, Z, n = 5;
        double[] vec = new double[N];
        for (int i = 0; i < resultados.size(); i++) {
            vec[i] = resultados.get(i);
        }
        bin = new int[N];
        getbin(vec, bin, N);
        int[] R = new int[N];
        fei = new double[N];
        for (int j = 0; j < N; j++) {
            flag = bin[j];
            aux = j;
            ultimo = j;
            Z = -1;
            do {
                Z++;
                aux++;
                if (aux >= N - 1) {
                    break;
                }
            } while (bin[aux] != flag);
            if (Z >= n) {
                Z = n;
            }
            R[Z]++;
        }
        if (ultimo != N - 1) {
            R[N - 1 - ultimo]++;
        }
        double xx;
        if (N <= 20) {
            for (int i = 0; i < N; i++) {
                if (i != N - 1) {
                    xx = (2 * (N * (i * i) + 3 * i + 1) - (i * i * i + 3 * i * i - i - 4));
                    fei[i] = xx / fact(i + 3);
                } else {
                    fei[i] = 2 / fact(N);
                }
            }
            rodar(R, fei, N);
            for (int i = 0; fei[i] != 0; i++) {
                x02 += Math.pow(R[i] - fei[i], 2) / fei[i];
            }
        } else {
            x02 = Long.MAX_VALUE;
        }
        xan1 = c.ObtenerChi(0.05, n - 1);
        String msg = (x02 < xan1) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param resultados
     * @return
     */
    public String getcorridas2(ArrayList<Float> resultados) {
        double fei, x02 = 0, xan1;
        int R[], N = resultados.size(), bin[], flag, aux, ultimo = 0, Z;
        double[] vec = new double[N];
        for (int i = 0; i < resultados.size(); i++) {
            vec[i] = resultados.get(i);
        }
        bin = new int[N];
        getbin2(vec, bin, N);
        int n = (N + 1) / 2;
        R = new int[n];
        for (int j = 0; j < N; j++) {
            flag = bin[j];
            aux = j;
            ultimo = j;
            Z = -1;
            do {
                Z++;
                aux++;
                if (aux >= N - 1) {
                    break;
                }
            } while (bin[aux] != flag);
            if (Z >= n) {
                Z = n;
            }
            R[Z]++;
        }
        if (ultimo != N - 1) {
            R[N - 1 - ultimo]++;
        }
        for (int i = 0; i < n; i++) {
            fei = (N - i - 3) / (Math.pow(2, i + 1));
            x02 += Math.pow(R[i] - fei, 2) / fei;
        }
        xan1 = c.ObtenerChi(0.05, n - 1);
        String msg = (x02 < xan1) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param a
     * @param fe
     * @param N
     */
    public void rodar(int a[], double fe[], int N) {
        for (int i = 1; i < N; i++) {
            if (fe[i] < 5) {
                for (int j = i - 1; j >= 0; j--) {
                    if (fe[j] > 0) {
                        fe[j] += fe[i];
                        fe[i] = 0;
                        a[j] += a[i];
                        a[i] = 0;
                    }
                }
            }
        }
    }

    /**
     *
     * @param a
     * @return
     */
    public long fact(int a) {
        long f = 1;
        for (int i = 2; i <= a; i++) {
            f *= i;
        }
        return f;
    }

    /**
     *
     * @param a
     * @param b
     * @param N
     */
    public void getbin(double a[], int b[], int N) {
        for (int i = 0; i < N - 1; i++) {
            if (a[i] < a[i + 1]) {
                b[i] = 0;
            } else {
                b[i] = 1;
            }
        }
    }

    /**
     *
     * @param a
     * @param b
     * @param N
     */
    public void getbin2(double a[], int b[], int N) {
        for (int i = 0; i < N; i++) {
            if (a[i] < 0.5) {
                b[i] = 0;
            } else {
                b[i] = 1;
            }
        }
    }
}
