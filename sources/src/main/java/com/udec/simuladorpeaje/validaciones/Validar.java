package com.udec.simuladorpeaje.validaciones;

/**
 *
 * @author Estudiante
 */
public class Validar {

    /**
     *
     * @param numero
     * @return
     */
    public static boolean esImpar(int numero) {
        boolean resultado;
        resultado = numero % 2 != 0;
        return resultado;
    }
}
