package com.udec.simuladorpeaje.validaciones;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Estudiante
 */
public class Ayuda {

    /**
     *
     * @param a
     * @param d
     * @param m
     * @return
     */
    public static boolean MultiplosFactoresPrimosM(int a, int d, int m) {
        ArrayList numeros = new ArrayList();
        for (int i = 3; i < (m / 2); i++) {
            if (Primo(i) && m % i == 0) {
                numeros.add(i);
            }
        }
        for (Iterator it = numeros.iterator(); it.hasNext();) {
            Object numero = it.next();
            int aux = (Integer) numero;
            boolean sison = (d % aux == 0 && (a - 1) % aux == 0);
            if (!sison) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param numero
     * @return
     */
    public static boolean Impar(int numero) {
        return numero % 2 != 0;
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean Primo(int n) {
        if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            boolean esprimo = true;
            for (int contador = 2; (esprimo) && (contador != n); contador++) {
                if (n % contador == 0) {
                    esprimo = false;
                }
            }
            return esprimo;
        }
    }

    /**
     *
     * @param numerador
     * @param denominador
     * @return
     */
    public static boolean Divisible(int numerador, int denominador) {
        boolean resultado;
        resultado = numerador % denominador == 0;
        return resultado;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean primoRelativo(int a, int b) {
        boolean resultado;
        int mcd;
        if (a < b) {
            mcd = mcd(b, a);
        } else {
            mcd = mcd(a, b);
        }
        resultado = mcd == 1 || mcd == -1;
        return resultado;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int mcd(int a, int b) {
        int resultado;
        if (b == 0) {
            resultado = a;
        } else {
            resultado = mcd(b, a % b);
        }
        return resultado;
    }

    /**
     *
     * @param m
     * @param a
     * @param d
     * @param c
     * @return
     */
    public static boolean verificar(int m, int a, int d, int c) {
        boolean flag = true;
        if (m % 4 == 0) {
            flag = (a - 1) % 4 == d && d % 2 == 0;
            if (!flag) {
                return false;
            }
        }
        if (m % 2 == 0) {
            flag = (a - 1) % 2 == d && d % 2 == 0;
            if (!flag) {
                return false;
            }
        }
        if (m % 9 == 0) {
            flag = ((0) % 9 == d) || (1 % 9 == a && (c * d == 6 % 9));
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param resultados
     * @param jList
     * @param jLabel
     */
    public static void listar(ArrayList resultados, JList jList, JLabel jLabel) {
        if (!resultados.isEmpty()) {
            DefaultListModel lm = new DefaultListModel();
            for (int i = 0; i < resultados.size(); i++) {
                lm.addElement("Número " + (i + 1) + " = " + resultados.get(i));
            }
            jList.setModel(lm);
            jLabel.setText("Periodo: " + resultados.size());
        }
    }

    /**
     *
     * @param resultados
     * @param jButton11
     * @param jButton12
     * @param jButton13
     * @param jButton14
     * @param jButton15
     * @param jButton16
     * @param jButton17
     * @param jButton18
     */
    public static void habilitarb(ArrayList<Float> resultados, JButton jButton11, JButton jButton12, JButton jButton13, JButton jButton14, JButton jButton15, JButton jButton16, JButton jButton17, JButton jButton18) {
        if (!resultados.isEmpty()) {
            jButton11.setEnabled(true);
            jButton12.setEnabled(true);
            jButton13.setEnabled(true);
            jButton14.setEnabled(true);
            jButton15.setEnabled(true);
            jButton16.setEnabled(true);
            jButton17.setEnabled(true);
            jButton18.setEnabled(true);
        } else {
            jButton11.setEnabled(!true);
            jButton12.setEnabled(!true);
            jButton13.setEnabled(!true);
            jButton14.setEnabled(!true);
            jButton15.setEnabled(!true);
            jButton16.setEnabled(!true);
            jButton17.setEnabled(!true);
            jButton18.setEnabled(!true);
        }
    }

    /**
     *
     * @param lista
     * @param x
     * @return
     */
    public static boolean verificanumero(ArrayList<Float> lista, Double x) {
        float dato = Float.parseFloat(String.valueOf(x));
        int inicio = 0;
        int fin = lista.size() - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (lista.get(pos) == dato) {
                return false;
            } else if (lista.get(pos) < dato) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return true;
    }

    /**
     *
     * @param a
     * @return
     */
    public static boolean verificaMultiplicativo(int a) {
        double r = 0;
        r = (a - 3);
        r = r / 8;
        if (esEntero(r)) {
            return true;
        } else {
            r = (a + 3);
            r = r / 8;
            if (esEntero(r)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param x
     * @return
     */
    public static boolean esEntero(double x) {
        return x % 1 == 0;
    }
}
