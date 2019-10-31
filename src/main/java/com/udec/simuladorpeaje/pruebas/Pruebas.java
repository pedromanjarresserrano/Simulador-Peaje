package com.udec.simuladorpeaje.pruebas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Estudiante
 */
public class Pruebas {

    double vec_sub[];
    int m_fo[][];
    Chi2 chi2;

    /**
     *
     * @param resultados
     * @return
     */
    public String pruebaPromedios(ArrayList<Float> resultados) {
        double suma = 0;
        for (Float resultado : resultados) {
            suma += resultado;
        }
        double media = suma / resultados.size();
        double zo = ((media - 0.5) * Math.sqrt(resultados.size())) / Math.sqrt((double) 1 / 12);
        String msg = (Math.abs(zo) < 1.96) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param resultados
     * @return
     */
    public String pruebaFrecuencias(ArrayList<Float> resultados) {
        Chi2 c = new Chi2();
        int n = 5;
        int N = resultados.size();
        float fe = (float) N / n;
        double chi = c.ObtenerChi(0.05, n - 1);
        double chi1 = 0;
        int fo;
        double[] muestra = new double[resultados.size()];
        for (int i = 0; i < resultados.size(); i++) {
            muestra[i] = resultados.get(i);
        }

        for (int i = 0; i < n; i++) {
            float x = (float) i / n;
            float y = (float) (i + 1) / n;
            fo = 0;
            for (int i1 = 0; i1 < muestra.length; i1++) {
                if (muestra[i1] >= x && muestra[i1] < y) {
                    fo = fo + 1;
                }
            }
            chi1 = chi1 + (double) Math.pow((fo - fe), 2) / fe;
        }
        String msg = (chi1 < chi) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param resultados
     * @return
     */
    public String pruebaKolgomorov(ArrayList<Float> resultados) {
        double d;
        double mayor = 0;
        double[] lista = new double[resultados.size()];
        for (int i = 0; i < resultados.size(); i++) {
            lista[i] = resultados.get(i);
        }
        Arrays.sort(lista);
        double[] pos = new double[lista.length];
        for (int i = 0; i < lista.length; i++) {
            pos[i] = i + 1;
        }
        double[] lista2 = new double[lista.length];
        for (int i = 0; i < lista.length; i++) {
            double x = (double) (pos[i] / lista.length);
            lista2[i] = x;
        }
        double[] lista3 = new double[lista.length];
        for (int i = 0; i < lista.length; i++) {
            double x = (double) Math.abs(lista2[i] - lista[i]);
            lista3[i] = x;
        }
        for (int i = 0; i < lista3.length; i++) {
            mayor = lista3[i];
            for (int u = 0; u < lista3.length; u++) {
                if (mayor >= lista3[u]) {
                    mayor = mayor;
                } else {
                    mayor = lista3[u];
                }
            }
        }
        ConstanteD constante = new ConstanteD();
        d = constante.obtenerD(lista.length);
        String msg = (mayor <= d) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param resultados
     * @return
     */
    public String getseries(ArrayList<Float> resultados) {
        double fei, x02 = 0, xn2;
        int N = resultados.size();
        int n = 5;
        double vec[] = new double[N];
        for (int i = 0; i < resultados.size(); i++) {
            vec[i] = resultados.get(i);
        }
        vec_sub = new double[n];
        m_fo = new int[n][n];
        fei = (N - 1) / Math.pow(n, 2);
        for (int i = 0; i < n; i++) {
            vec_sub[i] = (double) i / n;
        }
        for (int i = 0; i < N - 1; i++) {
            ubicar(vec[i], vec[i + 1], n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x02 += Math.pow(m_fo[i][j] - fei, 2);
            }
        }
        x02 *= Math.pow(n, 2) / (N - 1);
        chi2 = Chi2.getchi2();
        xn2 = chi2.ObtenerChi(0.05, n * n - 2);
        String msg = (x02 < xn2) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param resultados
     * @return
     */
    public String pruebaDistancias(ArrayList<Float> resultados) {
        double FE, alfa = 0.3, beta = 0.7, chi1, chi2;
        int N = resultados.size(), fot, x = 0, n = 5;
        Chi2 c = new Chi2();
        chi2 = c.ObtenerChi(0.05, n);
        if (N <= 5) {
            N = 6;
        }
        int[] hueco = new int[N];
        double[] prob = new double[n + 1];
        double[] numeros = new double[N];
        for (int i = 0; i < resultados.size(); i++) {
            numeros[i] = resultados.get(i);
        }
        int aux, aux2;
        for (int j = 0; j < N; j++) {
            if (numeros[j] >= alfa && numeros[j] <= beta) {
                aux = j;
                x = j;
                aux2 = -1;
                do {
                    aux2++;
                    aux++;
                    if (aux >= N - 1) {
                        break;
                    }
                } while (numeros[aux] < alfa || numeros[aux] > beta);
                if (aux2 >= n) {
                    aux2 = n;
                }
                hueco[aux2]++;
            }
        }
        if (x != N - 1) {
            hueco[N - 1 - x]++;
        }
        fot = 0;
        for (int i = 0; i <= n; i++) {
            fot += hueco[i];
            prob[i] = (beta - alfa) * Math.pow((1 - (beta - alfa)), i);
        }
        prob[n] = Math.pow((1 - (beta - alfa)), n);
        chi1 = 0;
        for (int i = 0; i <= n; i++) {
            FE = fot * prob[i];
            chi1 += (hueco[i] - FE) / FE;
        }
        String msg = (chi1 < chi2) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param resultados
     * @return
     */
    public String getpoker(ArrayList<Float> resultados) {
        int vec[], vec_fo[], n = 5;
        double vec_fei[], x02 = 0, xan1, pmano[] = {0.324, 0.504, 0.108, 0.072, 0.009, 0.0045, 0.0001};
        int N = resultados.size();
        vec = new int[N];
        vec_fo = new int[7];
        vec_fei = new double[7];
        double nps[] = new double[N];
        for (int i = 0; i < resultados.size(); i++) {
            nps[i] = resultados.get(i);
        }
        for (int i = 0; i < N; i++) {
            vec[i] = (int) (nps[i] * 100000);
        }
        getfo(vec, vec_fo);
        for (int i = 0; i < vec_fo.length; i++) {
            vec_fei[i] = pmano[i] * N;
        }
        rodar(vec_fo, vec_fei);
//        for (int i = 0; vec_fei[i] < vec_fei.length; i++) {
        for (int i = 0; i < vec_fei.length; i++) {
            x02 += Math.pow(vec_fo[i] - vec_fei[i], 2) / vec_fei[i];
        }
        xan1 = Chi2.getchi2().ObtenerChi(0.05, n - 1);
        String msg = (x02 < xan1) ? "Paso" : "No paso";
        return msg;
    }

    /**
     *
     * @param a
     * @param fe
     */
    public void rodar(int a[], double fe[]) {
        for (int i = 1; i < fe.length; i++) {
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
     * @param digitos
     */
    public void limpiar(int digitos[]) {
        for (int i = 0; i < digitos.length; i++) {
            digitos[i] = 0;
        }
    }

    /**
     *
     * @param vec
     * @param vec_fo
     */
    public void getfo(int vec[], int vec_fo[]) {
        int max, max2, index, sapo = 0;
        String aux;
        int digitos[] = new int[10];
        limpiar(digitos);
        for (int i = 0; i < vec.length; i++) {
            aux = "";
            max = max2 = 0;
            aux += vec[i];
            limpiar(digitos);
            if (aux.length() < 5) {
                digitos[0] = 5 - aux.length();
            }
            for (int j = 0; j < aux.length(); j++) {
                index = aux.charAt(j) - '0';
                digitos[index]++;
                if (digitos[index] > max) {
                    max = digitos[index];
                    sapo = index;
                }
            }
            if (max == 4) {
                vec_fo[5]++;
            } else if (max == 5) {
                vec_fo[6]++;
            } else if (max <= 3) {
                for (int i1 = 0; i1 < digitos.length; i1++) {
                    if (digitos[i1] > max2 && i1 != sapo) {
                        max2 = digitos[i1];
                    }
                }
                if (max == 3 && max2 == 1) {
                    vec_fo[3]++;
                } else if (max == 3 && max2 == 2) {
                    vec_fo[4]++;
                } else if (max == 2 && max2 == 2) {
                    vec_fo[2]++;
                } else if (max == 2 && max2 == 1) {
                    vec_fo[1]++;
                } else if (max == 1) {
                    vec_fo[0]++;
                }
            }
        }
    }

    /**
     *
     * @param a
     * @param b
     * @param n
     */
    public void ubicar(double a, double b, int n) {
        int aux1 = -1, aux2 = -1;
        for (int i = 0; i < n - 1; i++) {
            if (a >= vec_sub[i] && a < vec_sub[i + 1]) {
                aux1 = i;
            } else if (i == n - 2 && a >= vec_sub[i + 1] && a <= 1) {
                aux1 = i + 1;
            }
            if (b >= vec_sub[i] && b < vec_sub[i + 1]) {
                aux2 = i;
            } else if (i == n - 2 && b >= vec_sub[i + 1] && b <= 1) {
                aux2 = i + 1;
            }
        }
        m_fo[aux1][aux2]++;

    }
}
