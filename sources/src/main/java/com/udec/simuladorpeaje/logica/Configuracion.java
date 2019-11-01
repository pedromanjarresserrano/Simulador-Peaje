/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;


import com.udec.simuladorpeaje.distribuciones.sistemapicos.Dia;
import com.udec.simuladorpeaje.distribuciones.sistemapicos.Mes;
import com.udec.simuladorpeaje.distribuciones.sistemapicos.Semana;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 *
 * @author PedroD
 */
public class Configuracion {

    private static Configuracion instancia;
    private ArrayList<Double> proba_tipocarro;
    private ArrayList<Double> proba_telepeaje;
    private float mediallegada;
    private float mediaatencionnormal;
    private float mediaatenciontelepeaje;
    private int casetas;
    private int telepeajes;
    private ArrayList<Caseta> alc;
    private Mes mes;

    private int HoraInicio;

    private Configuracion() {
        this.HoraInicio = 0;
        this.mes = this.creaMes();
        this.proba_tipocarro = new ArrayList<>();
        this.proba_telepeaje = new ArrayList<>();
        this.proba_tipocarro.add(0.411);
        this.proba_tipocarro.add(0.144);
        this.proba_tipocarro.add(0.104);
        this.proba_tipocarro.add(0.1 - .009);
        this.proba_tipocarro.add(0.14);
        this.proba_tipocarro.add(0.11);

        //*********************
        this.proba_telepeaje.add(0.432709279);
        this.proba_telepeaje.add(0.567290721);
        //**********************************
        this.mediallegada = (float) 17.39916929;
        this.mediaatencionnormal = (float) 15.05502802;
        this.mediaatenciontelepeaje = 1;
        this.casetas = 5;
        this.telepeajes = 2;
        ArrayList<Hora> horas = new ArrayList<Hora>();
        ArrayList<Caseta> alcs = new ArrayList<>();
        for (int i = 0; i < casetas; i++) {
            Caseta c = new Caseta(i);
            Servidor server1 = new Servidor(i);
            Servidor server2 = new Servidor(i);

            horas = new ArrayList<>();
            server1.setHorario(new ArrayList<>());
            server2.setHorario(new ArrayList<>());
            for (int w = 0; w < 24; w++) {
                Hora h = new Hora();
                h.setAtiende(Boolean.TRUE);
                horas.add(h);
            }
            server1.setTipo(1);

            for (;;) {
                if (server1.sizeHorario() < 1440) {
                    server1.addAllHorario(horas);
                } else {
                    break;
                }

            }
            server2.setTipo(1);

            for (;;) {
                if (server2.sizeHorario() < 1440) {
                    server2.addAllHorario(horas);
                } else {
                    break;
                }

            }
            c.setTipo(1);
            c.setAceptaBorradores(false);
            c.setAceptaBuses(false);
            c.setColaLarga(0);
            if (i == 3) {
                c.setAceptaBuses(true);
                horas = new ArrayList<>();
                server1.setHorario(new ArrayList<>());

                for (int w = 0; w < 24; w++) {
                    Hora h = new Hora();
                    h.setAtiende(Boolean.FALSE);
                    horas.add(h);
                }
                for (;;) {
                    if (server1.sizeHorario() < 1440) {

                        server1.addAllHorario(horas);
                    } else {
                        break;
                    }

                }
            }
            if (i == 1) {
                c.setAceptaBorradores(true);
            }
            c.addServidores(server1);
            c.addServidores(server2);
            alcs.add(c);
        }
        for (int i = casetas; i < casetas + telepeajes; i++) {
            Caseta c = new Caseta(i);
            Servidor server1 = new Servidor(i);

            horas = new ArrayList<>();
            server1.setHorario(new ArrayList<>());
            for (int w = 0; w < 24; w++) {
                Hora h = new Hora();
                h.setAtiende(Boolean.TRUE);
                horas.add(h);
            }
            server1.setTipo(0);

            for (;;) {
                if (server1.sizeHorario() < 1440) {
                    server1.addAllHorario(horas);
                } else {
                    break;
                }

            }

            c.setTipo(0);
            c.setAceptaBorradores(false);
            c.setAceptaBuses(false);
            c.setColaLarga(0);

            c.addServidores(server1);
            alcs.add(c);
        }
        this.alc = alcs;
    }

    private Mes creaMes() {
        Mes meslocal = new Mes();
        for (int y = 0; y < 4; y++) {
            Semana semana = new Semana();
            for (int x = 0; x < 7; x++) {
                Dia dia = new Dia();
                for (int i = 0; i < 24; i++) {
                    com.udec.simuladorpeaje.distribuciones.sistemapicos.Hora hora = new com.udec.simuladorpeaje.distribuciones.sistemapicos.Hora();
                    if (i == 11) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 12) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 13) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 5) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 6) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 7) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 17) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 18) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i == 19) {
                        hora.setPico(Boolean.TRUE);
                    }
                    if (i >= 0 && i < 5) {
                        hora.setValle(Boolean.TRUE);
                    }
                    if (i >= 21 && i <= 23) {
                        hora.setValle(Boolean.TRUE);
                    }

                    dia.addHora(hora);
                }
                switch (x) {
                    case 0: {
                        dia.setDianombre("Lunes");
                        break;
                    }
                    case 1: {
                        dia.setDianombre("Martes");
                        break;
                    }
                    case 2: {
                        dia.setDianombre("Miercoles");
                        break;
                    }
                    case 3: {
                        dia.setDianombre("Jueves");
                        break;
                    }
                    case 4: {
                        dia.setDianombre("Viernes");
                        break;
                    }
                    case 5: {
                        dia.setDianombre("Sabado");
                        break;
                    }
                    case 6: {
                        dia.setDianombre("Domingo");
                        break;
                    }
                }
                semana.addDias(dia);
            }
            meslocal.addSemanas(semana);
        }
        return meslocal;
    }

    /**
     *
     * @return
     */
    public float getMediaatencionnormal() {
        return mediaatencionnormal;
    }

    /**
     *
     * @param mediaatencionnormal
     */
    public void setMediaatencionnormal(float mediaatencionnormal) {
        this.mediaatencionnormal = mediaatencionnormal;
    }

    /**
     *
     * @return
     */
    public float getMediaatenciontelepeaje() {
        return mediaatenciontelepeaje;
    }

    /**
     *
     * @param mediaatenciontelepeaje
     */
    public void setMediaatenciontelepeaje(float mediaatenciontelepeaje) {
        this.mediaatenciontelepeaje = mediaatenciontelepeaje;
    }

    /**
     *
     */
    public static void porDefecto() {
        instancia = new Configuracion();
    }

    /**
     *
     * @return
     */
    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        } else {
        }
        return instancia;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getProba_tipocarro() {
        return proba_tipocarro;
    }

    /**
     *
     * @return
     */
    public int getCasetas() {
        return casetas;
    }

    /**
     *
     * @param casetas
     */
    public void setCasetas(int casetas) {
        this.casetas = casetas;
    }

    /**
     *
     * @return
     */
    public int getTelepeajes() {
        return telepeajes;
    }

    /**
     *
     * @param telepeajes
     */
    public void setTelepeajes(int telepeajes) {
        this.telepeajes = telepeajes;
    }

    /**
     *
     * @param proba_tipocarro
     */
    public void setProba_tipocarro(ArrayList<Double> proba_tipocarro) {
        this.proba_tipocarro = proba_tipocarro;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getProba_telepeaje() {
        return proba_telepeaje;
    }

    /**
     *
     * @param proba_telepeaje
     */
    public void setProba_telepeaje(ArrayList<Double> proba_telepeaje) {
        this.proba_telepeaje = proba_telepeaje;
    }

    /**
     *
     * @return
     */
    public float getMediallegada() {
        return mediallegada;
    }

    /**
     *
     * @param mediallegada
     */
    public void setMediallegada(float mediallegada) {
        this.mediallegada = mediallegada;
    }

    /**
     *
     * @return
     */
    public float getMediaatencion() {
        return mediaatencionnormal;
    }

    /**
     *
     * @param mediaatencion
     */
    public void setMediaatencion(float mediaatencion) {
        this.mediaatencionnormal = mediaatencion;
    }

    /**
     *
     * @return
     */
    public int sizeTelepeaje() {
        return proba_telepeaje.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyTelepeaje() {
        return proba_telepeaje.isEmpty();
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Double setTelepeaje(int index, Double element) {
        return proba_telepeaje.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addTelepeaje(Double e) {
        return proba_telepeaje.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addTelepeaje(int index, Double element) {
        proba_telepeaje.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Double removeTelepeaje(int index) {
        return proba_telepeaje.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeTelepeaje(Object o) {
        return proba_telepeaje.remove(o);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllTelepeaje(Collection<? extends Double> c) {
        return proba_telepeaje.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllTelepeaje(int index, Collection<? extends Double> c) {
        return proba_telepeaje.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllTelepeaje(Collection<?> c) {
        return proba_telepeaje.removeAll(c);
    }

    /**
     *
     * @param filter
     * @return
     */
    public boolean removeIfTelepeaje(Predicate<? super Double> filter) {
        return proba_telepeaje.removeIf(filter);
    }

    /**
     *
     * @param index
     * @return
     */
    public Double getTelepeaje(int index) {
        return proba_telepeaje.get(index);
    }

    /**
     *
     */
    public void clearTelepeaje() {
        proba_telepeaje.clear();
    }

    /**
     *
     * @return
     */
    public int sizeTipoCarro() {
        return proba_tipocarro.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyTipoCarro() {
        return proba_tipocarro.isEmpty();
    }

    /**
     *
     * @return
     */
    public Object cloneTipoCarro() {
        return proba_tipocarro.clone();
    }

    /**
     *
     * @param index
     * @return
     */
    public Double getTipoCarro(int index) {
        return proba_tipocarro.get(index);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addTipoCarro(Double e) {
        return proba_tipocarro.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addTipoCarro(int index, Double element) {
        proba_tipocarro.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Double removeTipoCarro(int index) {
        return proba_tipocarro.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeTipoCarro(Object o) {
        return proba_tipocarro.remove(o);
    }

    /**
     *
     */
    public void clearTipoCarro() {
        proba_tipocarro.clear();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllTipoCarro(Collection<? extends Double> c) {
        return proba_tipocarro.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllTipoCarro(int index, Collection<? extends Double> c) {
        return proba_tipocarro.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllTipoCarro(Collection<?> c) {
        return proba_tipocarro.removeAll(c);
    }

    /**
     *
     * @param filter
     * @return
     */
    public boolean removeIfTipoCarro(Predicate<? super Double> filter) {
        return proba_tipocarro.removeIf(filter);
    }

    /**
     *
     * @return
     */
    public ArrayList<Caseta> getAlc() {
        return alc;
    }

    /**
     *
     * @param alc
     */
    public void setAlcCasetas(ArrayList<Caseta> alc) {
        this.alc = alc;
    }

    /**
     *
     * @return
     */
    public int sizeCasetas() {
        return alc.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmptyCasetas() {
        return alc.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfCasetas(Object o) {
        return alc.indexOf(o);
    }

    /**
     *
     * @param index
     * @return
     */
    public Caseta getCasetas(int index) {
        return alc.get(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Caseta setCasetas(int index, Caseta element) {
        return alc.set(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addCasetas(Caseta e) {
        return alc.add(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addCasetas(int index, Caseta element) {
        alc.add(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Caseta removeCasetas(int index) {
        return alc.remove(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeCasetas(Object o) {
        return alc.remove(o);
    }

    /**
     *
     */
    public void clearCasetas() {
        alc.clear();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAllCasetas(Collection<? extends Caseta> c) {
        return alc.addAll(c);
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAllCasetas(int index, Collection<? extends Caseta> c) {
        return alc.addAll(index, c);
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean removeAllCasetas(Collection<?> c) {
        return alc.removeAll(c);
    }

    /**
     *
     * @return
     */
    public Mes getMes() {
        return mes;
    }

    /**
     *
     * @param mes
     */
    public void setMes(Mes mes) {
        this.mes = mes;
    }

    /**
     *
     * @return
     */
    public ArrayList<Semana> getSemanas() {
        return mes.getSemanas();
    }

    /**
     *
     * @param semanas
     */
    public void setSemanas(ArrayList<Semana> semanas) {
        mes.setSemanas(semanas);
    }

    public String toString() {
        return mes.toString();
    }

    /**
     *
     * @return
     */
    public int sizeSemanas() {
        return mes.sizeSemanas();
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOfSemanas(Object o) {
        return mes.indexOfSemanas(o);
    }

    /**
     *
     * @return
     */
    public Object cloneSemanas() {
        return mes.cloneSemanas();
    }

    /**
     *
     * @param index
     * @return
     */
    public Semana getSemanas(int index) {
        return mes.getSemanas(index);
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public Semana setSemanas(int index, Semana element) {
        return mes.setSemanas(index, element);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addSemanas(Semana e) {
        return mes.addSemanas(e);
    }

    /**
     *
     * @param index
     * @param element
     */
    public void addSemanas(int index, Semana element) {
        mes.addSemanas(index, element);
    }

    /**
     *
     * @param index
     * @return
     */
    public Semana removeSemanas(int index) {
        return mes.removeSemanas(index);
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean removeSemanas(Object o) {
        return mes.removeSemanas(o);
    }

    /**
     *
     */
    public void clearSemanas() {
        mes.clearSemanas();
    }

    /**
     *
     * @param alm
     * @param alt
     */
    public void casetasConfig(ArrayList<Caseta> alm, ArrayList<Caseta> alt) {

        int manueales = 0;
        for (Caseta c : alc) {
            if (c.getTipo() == 1) {
                manueales++;
            }

        }
        int x = 0;
        for (Caseta c : alm) {
            try {
                if (alc.get(x).getTipo() == 1) {
                    c.setNumeroCaseta(alc.get(x).getNumeroCaseta());
                    c.setServidores(alc.get(x).getServidores());
                    x++;
                    continue;
                }
            } catch (Exception e) {

            }
            int w = 0;
            if (x == manueales) {
                if (w < x) {
                    w = x;
                }
                Servidor server1 = new Servidor();
                server1.setTipo(1);
                Servidor server2 = new Servidor();
                server2.setTipo(1);
                Hora hora = new Hora();
                hora.setAtiende(Boolean.TRUE);
                while (server1.getHorario().size() < 1440) {
                    server1.addHorario(hora);
                    server2.addHorario(hora);
                }
                c.removeAllServidores(c.getServidores());
                c.addServidores(server1);
                c.addServidores(server2);
                c.setNumeroCaseta(w);
                w++;
            }
        }

        alc.removeAll(alc);
        alc = new ArrayList<>(alm);
        for (Caseta t : alt) {
            Servidor server = new Servidor();
            server.setTipo(0);
            Hora hora = new Hora();
            hora.setAtiende(Boolean.TRUE);
            while (server.getHorario().size() < 1440) {
                server.addHorario(hora);
            }
            t.removeAllServidores(t.getServidores());
            t.addServidores(server);
        }
        alc.addAll(alt);

    }

    /**
     *
     * @return
     */
    public int getHoraInicio() {
        return HoraInicio;
    }

    /**
     *
     * @param HoraInicio
     */
    public void setHoraInicio(int HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

}
