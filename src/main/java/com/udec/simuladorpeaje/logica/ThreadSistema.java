/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author Estudiante
 */
public class ThreadSistema extends Thread {

    private String Informe;
    private ArrayList<ArrayList<String>> tabla;
    private ArrayList<String> textoExtra;
    private ArrayList<String> colasSize;
    private ArrayList<Vehiculo> alvrechazados;

    /**
     *
     * @return
     */
    public String getInforme() {
        return Informe;
    }

    /**
     *
     * @return
     */
    public ArrayList<Vehiculo> getAlvrechazados() {
        return alvrechazados;
    }

    /**
     *
     * @param alvrechazados
     */
    public void setAlvrechazados(ArrayList<Vehiculo> alvrechazados) {
        this.alvrechazados = alvrechazados;
    }

    /**
     *
     * @param Informe
     */
    public void setInforme(String Informe) {
        this.Informe = Informe;
    }

    @Override
    public String toString() {
        return "Sistema" + "\nInforme:" + Informe;
    }

    private Boolean atiendeParaTipo(int tipo, ArrayList<Caseta> alc, int horaactual) {
        for (Caseta c : alc) {
            if (c.getTipo() == 0) {
                continue;
            }
            switch (tipo) {
                case 4: {
                    if (c.isAceptaBuses()) {
                        for (Servidor s : c.getServidores()) {
                            if (s.getHorario(horaactual).isAtiende()) {
                                return true;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    if (c.isAceptaBorradores()) {
                        for (Servidor s : c.getServidores()) {
                            if (s.getHorario(horaactual).isAtiende()) {
                                return true;
                            }
                        }
                    }
                    break;
                }
            }

        }
        return false;
    }

    /**
     *
     * @param vehiculos
     * @param casetas
     * @param horainicial
     */
    public synchronized void start(ArrayList<Vehiculo> vehiculos, ArrayList<Caseta> casetas, int horainicial) {
        this.alvrechazados = new ArrayList<>();
        ArrayList<Vehiculo> alvs = new ArrayList<>();
        long tiempo = 0;
        for (;;) {

            tiempo++;
            if (!vehiculos.isEmpty()) {
                vehiculos.get(0).setTiempollegada((float) (vehiculos.get(0).getTiempollegada() - 5.5));
            }
            for (Caseta caseta : casetas) {
                try {

                } catch (Exception e) {
                }
                if (tiempo == 3600) {
                    horainicial++;
                    tiempo = 0;
                }
                if (vehiculos.size() > 0) {
                    if (!vehiculos.get(0).isTelepeaje()) {
                        try {
                            if (vehiculos.get(0).getTipo() == 4) {

                                if (!atiendeParaTipo((int) vehiculos.get(0).getTipo(), casetas, horainicial)) {
                                    alvrechazados.add(vehiculos.remove(0));
                                }
                            }
                            if (vehiculos.get(0).getTipo() == 5) {
                                if (!atiendeParaTipo((int) vehiculos.get(0).getTipo(), casetas, horainicial)) {
                                    alvrechazados.add(vehiculos.remove(0));
                                }
                            }
                        } catch (Exception e) {

                        }
                    }
                }
                try {
                    if (!algunoAtiende(caseta.getServidores(), horainicial)) {
                        continue;
                    }
                } catch (Exception e) {
                }
                if (!vehiculos.isEmpty()) {
                    if (vehiculos.get(0).getTiempollegada() <= 0) {
                        switch ((Integer.parseInt(String.valueOf(vehiculos.get(0).getTipo())))) {
                            case 4: {
                                if (!caseta.isAceptaBuses()) {
                                    continue;
                                }
                                break;
                            }
                            case 5: {
                                if (!caseta.isAceptaBorradores()) {
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                }

                for (Servidor server : caseta.getServidores()) {
                    try {
                        if (!server.getHorario(horainicial).isAtiende()) {
                            if (!server.isOcupado()) {
                                continue;
                            }

                        }
                    } catch (Exception e) {
                        break;
                    }
                    if (caseta.getTipo() == 1) {
                        if (caseta.indexOfServidor(server) == 1) {
                            if (!server.isOcupado()) {
                                if (caseta.getServidores(0).isOcupado()) {
                                    server.setTiempoocio(server.getTiempoocio() + 1);
                                    continue;
                                }
                            }
                        }
                    }
                    if (!server.isOcupado()) {
                        if (caseta.isEmptyCola()) {
                            if (!vehiculos.isEmpty()) {
                                if (vehiculos.get(0).getTiempollegada() <= 0) {
                                    if (vehiculos.get(0).isTelepeaje()) {
                                        if (server.getTipo() == 0) {
                                            server.setUsuarioactual(vehiculos.remove(0));
                                            server.setOcupado(true);
                                        }
                                    } else {
                                        if (!(server.getTipo() == 0)) {
                                            server.setUsuarioactual(vehiculos.remove(0));
                                            server.setOcupado(true);
                                        }
                                    }
                                }
                            }
                        } else {
                            server.setUsuarioactual(caseta.removeCola(0));
                            server.setOcupado(true);
                        }
                        if (server.getUsuarioactual() == null) {
                            server.setTiempoocio(server.getTiempoocio() + 1);
                        }
                    } else {
                        server.getUsuarioactual().setTiempoatencion((float) (server.getUsuarioactual().getTiempoatencion() - 1));
                        server.setTiempoatencion(server.getTiempoatencion() + 1);
                    }
                    if (server.getUsuarioactual() != null) {
                        if (server.getUsuarioactual().getTiempoatencion() <= 0) {
                            if (caseta.indexOfServidor(server) == 1) {
                                if (!caseta.getServidores(0).isOcupado()) {
                                    alvs.add(new Vehiculo(server.getUsuarioactual()));
                                    server.setCobros(BigDecimal.valueOf(server.getCobros().doubleValue() + server.getUsuarioactual().getValoracancelar()));
                                    server.setVatendidos(server.getVatendidos() + 1);
                                    server.setUsuarioactual(null);
                                    server.setOcupado(false);
                                } else {
                                    server.getUsuarioactual().setTiempoatencion(server.getUsuarioactual().getTiempoatencion() - 1);
                                    server.setTiempoatencion(server.getTiempoatencion() + 1);
                                }
                            } else {
                                alvs.add(new Vehiculo(server.getUsuarioactual()));
                                server.setCobros(BigDecimal.valueOf(server.getCobros().doubleValue() + server.getUsuarioactual().getValoracancelar()));
                                server.setVatendidos(server.getVatendidos() + 1);
                                server.setUsuarioactual(null);
                                server.setOcupado(false);
                            }
                        }
                    }
                }
                for (Vehiculo v : caseta.getCola().getVehiculos()) {
                    v.setTiempoencola(v.getTiempoencola() + 1);
                }
                if (caseta.getColaLarga() < caseta.sizeCola()) {
                    caseta.setColaLarga(caseta.sizeCola());
                }
            }
            if (!vehiculos.isEmpty()) {
                if (vehiculos.get(0).getTiempollegada() <= 0) {
                    Caseta cst = colaCorta(casetas, vehiculos.get(0).isTelepeaje(), vehiculos.get(0).getTipo(), horainicial);
                    for (Caseta c : casetas) {
                        if (c.equals(cst)) {
                            c.addCola(vehiculos.remove(0));
                            break;

                        }
                    }
                }
            }
            if (full(casetas) && vehiculos.isEmpty()) {
                break;
            }
            try {
                if (casetas.get(0).getServidores(0).getHorario(horainicial).isAtiende()) {

                }
            } catch (Exception e) {
                break;
            }

        }
        float tiempomencola = 0;
        for (Vehiculo vehiculo : alvs) {
            tiempomencola = tiempomencola + vehiculo.getTiemponecola();
        }
        tiempomencola = tiempomencola / alvs.size();
        this.Informe = "" + "\n";
        double totalCobrado = 0;
        this.tabla = new ArrayList<>();
        this.colasSize = new ArrayList<>();
        for (Caseta c : casetas) {
            this.colasSize.add(String.valueOf(c.getColaLarga()));
            ArrayList<String> serverdatos = new ArrayList<>();
            this.Informe = this.Informe + "Caseta Nº" + c.getNumeroCaseta() + " de Tipo: " + c.getTipo() + ", Cola mas Larga: " + c.getColaLarga() + "\n";
            for (Servidor s : c.getServidores()) {
                serverdatos = new ArrayList<>();
                serverdatos.add("Servidor " + c.indexOfServidor(s));
                if (s.getTipo() == 0) {
                    serverdatos.add("Tele-peaje");
                } else {
                    serverdatos.add("Manual");
                }
                serverdatos.add(String.valueOf(casetas.indexOf(c) + 1));
                Long tiempoocioLong = Long.parseLong(String.valueOf(s.getTiempoocio())) / 60;
                serverdatos.add(String.valueOf(tiempoocioLong + " Min"));
                Long tiempoatencionLong = Long.parseLong(String.valueOf(s.getTiempoatencion())) / 60;
                serverdatos.add(String.valueOf(tiempoatencionLong + " Min"));
                serverdatos.add(String.valueOf(s.getVatendidos()));
                serverdatos.add(String.valueOf(moneyFormat(s.getCobros().doubleValue())));
                this.Informe = this.Informe + s.toString() + "\n";
                totalCobrado = totalCobrado + s.getCobros().doubleValue();
                this.tabla.add(serverdatos);
            }
        }
        this.Informe = this.Informe + "\nTotal Cobrado por Peaje : " + moneyFormat(totalCobrado);
        float ociom = 0;
        int sizeserver = 0;
        for (Caseta c : casetas) {
            for (Servidor s : c.getServidores()) {
                ociom = ociom + s.getTiempoocio();
                sizeserver++;
            }
        }
        ociom = ociom / sizeserver;
        ociom = ociom / 60;
        float ociomtele = 0;
        int teles = 0;
        float ociomcaseta = 0;
        int casas = 0;
        for (Caseta c : casetas) {
            for (Servidor servidor : c.getServidores()) {
                if (servidor.getTipo() == 0) {
                    ociomtele = ociomtele + servidor.getTiempoocio();

                    teles++;
                } else {
                    ociomcaseta = ociomcaseta + servidor.getTiempoocio();
                    casas++;
                }
                servidor = new Servidor();
                servidor.setTipo((int) c.getTipo());
            }
        }
        ociomtele = ociomtele / teles;
        ociomtele = ociomtele / 60;
        ociomcaseta = ociomcaseta / casas;
        ociomcaseta = ociomcaseta / 60;
        this.Informe = this.Informe + "\n\nTiempo promedio de ocio de servidores: " + ociom + " minutos";
        this.Informe = this.Informe + "\nTiempo promedio de ocio de servidores manuales: " + ociomcaseta + " minutos";
        this.Informe = this.Informe + "\nTiempo promedio de ocio de servidores telepeajes: " + ociomtele + " minutos";
        this.Informe = this.Informe + "\n\nTiempo promedio en cola: " + tiempomencola + " segundos";
        this.textoExtra = new ArrayList<>();
        this.textoExtra.add(String.valueOf(ociom));
        this.textoExtra.add(String.valueOf(ociomcaseta));
        this.textoExtra.add(String.valueOf(ociomtele));
        this.textoExtra.add(String.valueOf(tiempomencola));
        yield();

    }

    private Boolean algunoAtiende(ArrayList<Servidor> als, int horanow) {
        for (Servidor s : als) {
            if (s.getHorario(horanow).isAtiende()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param alc
     * @return
     */
    public Boolean full(ArrayList<Caseta> alc) {
        for (Caseta caseta : alc) {
            for (Servidor server : caseta.getServidores()) {
                if (server.isOcupado()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param alc
     * @param telepaje
     * @param tipocarro
     * @param hora
     * @return
     */
    public Caseta colaCorta(ArrayList<Caseta> alc, Boolean telepaje, long tipocarro, int hora) {
        int i = 1000000000;
        Caseta csta = null;
        for (Caseta cst : alc) {
            int no_atiende = 0;
            for (Servidor s : cst.getServidores()) {
                try {
                    if (!s.getHorario(hora).isAtiende()) {
                        no_atiende++;
                    }
                } catch (Exception e) {
                    return cst;
                }

            }
            if (no_atiende == cst.getServidores().size()) {
                continue;
            }
            switch ((Integer.parseInt(String.valueOf(tipocarro)))) {
                case 4: {
                    if (!cst.isAceptaBuses()) {
                        continue;
                    }
                    break;
                }
                case 5: {
                    if (!cst.isAceptaBorradores()) {
                        continue;
                    }
                    break;
                }
            }
            Boolean uso = false;
            if (cst.getTipo() == 0) {
                uso = true;
            }
            if (Objects.equals(uso, telepaje)) {
                if (cst.sizeCola() < i) {
                    i = cst.sizeCola();
                    csta = cst;
                }
            }
        }
        return csta;
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
    public ArrayList<ArrayList<String>> getTabla() {
        return tabla;
    }

    /**
     *
     * @param tabla
     */
    public void setTabla(ArrayList<ArrayList<String>> tabla) {
        this.tabla = tabla;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTextoExtra() {
        return textoExtra;
    }

    /**
     *
     * @param textoExtra
     */
    public void setTextoExtra(ArrayList<String> textoExtra) {
        this.textoExtra = textoExtra;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getColasSize() {
        return colasSize;
    }

    /**
     *
     * @param colasSize
     */
    public void setColasSize(ArrayList<String> colasSize) {
        this.colasSize = colasSize;
    }

}
