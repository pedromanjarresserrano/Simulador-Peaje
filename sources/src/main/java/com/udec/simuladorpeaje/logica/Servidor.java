/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author PedroD
 */
public class Servidor {

    private boolean ocupado;
    private Vehiculo usuarioactual;
    private int tipo; //Tipo 0- Telepeaje ; 1- No telepeaje 
    private final int numeroCaseta;
    private int tiempoocio;
    private int tiempoatencion;
    private int vatendidos;
    private BigDecimal cobros;
    private ArrayList<Hora> horario;

    /**
     *
     */
    public Servidor() {
        this.ocupado = false;
        this.usuarioactual = new Vehiculo();
        this.tipo = 1;
        this.numeroCaseta = 0;
        this.tiempoocio = 0;
        this.tiempoatencion = 0;
        this.vatendidos = 0;
        this.cobros = (BigDecimal.valueOf(0));
        this.horario = new ArrayList<>();

    }

    /**
     *
     * @param caseta
     */
    public Servidor(int caseta) {
        this.usuarioactual = null;
        this.ocupado = false;
        this.numeroCaseta = caseta;
        this.tiempoocio = 0;
        this.vatendidos = 0;
        this.tiempoatencion = 0;
        this.cobros = (BigDecimal.valueOf(0));
    }

    /**
     *
     * @param s
     */
    public Servidor(Servidor s) {
        this.cobros = s.getCobros();
        this.horario = s.getHorario();
        this.numeroCaseta = s.getNumeroCaseta();
        this.ocupado = s.isOcupado();
        this.tiempoatencion = s.getTiempoatencion();
        this.tiempoocio = s.getTiempoocio();
        this.tipo = s.getTipo();
        this.usuarioactual = s.getUsuarioactual();
        this.vatendidos = s.getVatendidos();
    }

    /**
     *
     * @param ocupado
     * @param usuarioactual
     * @param tipo
     * @param numeroCaseta
     * @param tiempoocio
     * @param tiempoatencion
     * @param vatendidos
     * @param cobros
     */
    public Servidor(boolean ocupado, Vehiculo usuarioactual, int tipo, int numeroCaseta, int tiempoocio, int tiempoatencion, int vatendidos, double cobros) {
        this.ocupado = ocupado;
        this.usuarioactual = usuarioactual;
        this.tipo = tipo;
        this.numeroCaseta = numeroCaseta;
        this.tiempoocio = tiempoocio;
        this.tiempoatencion = tiempoatencion;
        this.vatendidos = vatendidos;
        this.cobros = (BigDecimal.valueOf(0));
    }

    /**
     *
     * @param estado
     * @param usuarioactual
     * @param cola
     * @param tipo
     * @param caseta
     */
    public Servidor(boolean estado, Vehiculo usuarioactual, Cola cola, int tipo, int caseta) {
        this.ocupado = estado;
        this.usuarioactual = usuarioactual;
        this.tipo = tipo;
        this.numeroCaseta = caseta;
        this.tiempoocio = 0;
        this.vatendidos = 0;
        this.tiempoatencion = 0;
        this.cobros = (BigDecimal.valueOf(0));
    }

    /**
     *
     * @param ocupado
     * @param usuarioactual
     * @param cola
     * @param tipo
     * @param numeroCaseta
     * @param tiempoocio
     */
    public Servidor(boolean ocupado, Vehiculo usuarioactual, Cola cola, int tipo, int numeroCaseta, int tiempoocio) {
        this.ocupado = ocupado;
        this.usuarioactual = usuarioactual;

        this.tipo = tipo;
        this.numeroCaseta = numeroCaseta;
        this.tiempoocio = tiempoocio;
        this.vatendidos = 0;
        this.tiempoatencion = 0;
        this.cobros = (BigDecimal.valueOf(0));
    }

    /**
     *
     * @param ocupado
     * @param usuarioactual
     * @param cola
     * @param tipo
     * @param numeroCaseta
     * @param tiempoocio
     * @param vatendidos
     */
    public Servidor(boolean ocupado, Vehiculo usuarioactual, Cola cola, int tipo, int numeroCaseta, int tiempoocio, int vatendidos) {
        this.ocupado = ocupado;
        this.usuarioactual = usuarioactual;
        this.tipo = tipo;
        this.numeroCaseta = numeroCaseta;
        this.tiempoocio = tiempoocio;
        this.vatendidos = vatendidos;
        this.vatendidos = 0;
        this.tiempoatencion = 0;
        this.cobros = (BigDecimal.valueOf(0));
    }

    /**
     *
     * @return
     */
    public int getTiempoatencion() {
        return tiempoatencion;
    }

    /**
     *
     * @param tiempoatencion
     */
    public void setTiempoatencion(int tiempoatencion) {
        this.tiempoatencion = tiempoatencion;
    }

    /**
     *
     * @return
     */
    public int getVatendidos() {
        return vatendidos;
    }

    /**
     *
     * @param vatendidos
     */
    public void setVatendidos(int vatendidos) {
        this.vatendidos = vatendidos;
    }

    /**
     *
     * @return
     */
    public int getTiempoocio() {
        return tiempoocio;
    }

    /**
     *
     * @param tiempoocio
     */
    public void setTiempoocio(int tiempoocio) {
        this.tiempoocio = tiempoocio;
    }

    /**
     *
     * @return
     */
    public int getNumeroCaseta() {
        return numeroCaseta;
    }

    /**
     *
     * @return
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     *
     * @param ocupado
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    /**
     *
     * @return
     */
    public Vehiculo getUsuarioactual() {
        return usuarioactual;
    }

    /**
     *
     * @param usuarioactual
     */
    public void setUsuarioactual(Vehiculo usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    /**
     *
     * @return
     */
    public BigDecimal getCobros() {
        return cobros;
    }

    /**
     *
     * @param cobros
     */
    public void setCobros(BigDecimal cobros) {
        this.cobros = cobros;
    }

    /**
     *
     * @return
     */
    public int getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Hora> getHorario() {
        return horario;
    }

    /**
     *
     * @param horario
     */
    public void setHorario(ArrayList<Hora> horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        if (tipo == 0) {
            float ocio = this.tiempoocio / 60;
            return "Servidor: " + " Tipo: " + "Telepeaje" + ", Numero Caseta: " + (numeroCaseta + 1) + ", tiempoocio: " + ocio + " minutos, Tiempo de atención: " + tiempoatencion + " seg, V. atendidos: " + vatendidos + ", Total Cobrado: " + this.moneyFormat(this.cobros.doubleValue());//cobros.toPlainString();
        } else {
            float ocio = this.tiempoocio / 60;
            return "Servidor: " + " Tipo: " + "Manual" + ", Numero Caseta: " + (numeroCaseta + 1) + ", tiempoocio: " + ocio + " minutos, Tiempo de atención: " + tiempoatencion + " seg, V. atendidos: " + vatendidos + ", Total Cobrado: " + this.moneyFormat(this.cobros.doubleValue());//cobros.toPlainString();
        }
    }

    /**
     *
     * @param money
     * @return
     */
    public String moneyFormat(double money) {
        NumberFormat dutchFormat = NumberFormat.getInstance(Locale.ENGLISH);
        String twoDecimals = dutchFormat.format(money);
        if (twoDecimals.matches(".*[.]...[,]00$")) {
            String zeroDecimals = twoDecimals.substring(0, twoDecimals.length() - 3);
            return zeroDecimals;
        }
        if (twoDecimals.endsWith(",00")) {
            String zeroDecimals = String.format("$ %.0f,-", money);
            return zeroDecimals;
        } else {
            return twoDecimals;
        }
    }

    /**
     *
     * @return
     */
    public int sizeHorario() {
        return horario.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyHorario() {
        return horario.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfHorario(Object o) {
        return horario.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Hora getHorario(int index) {
        return horario.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Hora setHorario(int index, Hora element) {
        return horario.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addHorario(Hora e) {
        return horario.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addHorario(int index, Hora element) {
        horario.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Hora removeHorario(int index) {
        return horario.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeHorario(Object o) {
        return horario.remove(o);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllHorario(Collection<? extends Hora> c) {
        return horario.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllHorario(int index, Collection<? extends Hora> c) {
        return horario.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllHorario(Collection<?> c) {
        return horario.removeAll(c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean retainAllHorario(Collection<?> c) {
        return horario.retainAll(c);
    }

    /**
     *
     * @param filter
     * @return
     */
    public boolean removeIfHorario(Predicate<? super Hora> filter) {
        return horario.removeIf(filter);
    }

    /**
     *
     * @param operator
     */
    public void replaceAllHorario(UnaryOperator<Hora> operator) {
        horario.replaceAll(operator);
    }

    /**
     *
     * @return
     */
    public String toStringHorario() {
        return horario.toString();
    }

    /**
     *
     */
    public void clearHorario() {
        horario.removeAll(horario);
    }

}
