  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica;

  import com.udec.simuladorpeaje.distribuciones.DistribucionEmpirica;
  import com.udec.simuladorpeaje.distribuciones.DistribucionExponencial;
  import com.udec.simuladorpeaje.distribuciones.DistribucionExponencialPicos;

  import java.util.ArrayList;

/**
 *
 * @author PedroD
 */
public class Identificador {

    private ArrayList<Double> numeros1;
    private ArrayList<Double> numeros2;
    private ArrayList<Double> numeros3;
    private ArrayList<Double> numeros4;
    private ArrayList<Double> proba_tipocarro;
    private ArrayList<Double> proba_telepeaje;
    private float mediallegada;
    private float mediaatencionnormal;
    private float mediaatenciontele;

    /**
     *
     * @param mediallegada
     * @param mediaatencion
     */
    public Identificador(float mediallegada, float mediaatencion) {
        this.mediallegada = mediallegada;
        this.mediaatencionnormal = mediaatencion;

    }

    /**
     *
     * @param numeros1
     * @param numeros2
     * @param numeros3
     * @param numeros4
     * @param config
     */
    public Identificador(ArrayList<Double> numeros1, ArrayList<Double> numeros2, ArrayList<Double> numeros3, ArrayList<Double> numeros4, Configuracion config) {
        this.numeros1 = numeros1;
        this.numeros2 = numeros2;
        this.numeros3 = numeros3;
        this.numeros4 = numeros4;
        this.mediaatencionnormal = config.getMediaatencion();
        this.mediaatenciontele = config.getMediaatenciontelepeaje();
        this.mediallegada = config.getMediallegada();
        this.proba_telepeaje = config.getProba_telepeaje();
        this.proba_tipocarro = config.getProba_tipocarro();

    }

    /**
     *
     * @param proba_tipocarro
     * @param proba_telepeaje
     * @param mediallegada
     * @param mediaatencion
     */
    public Identificador(ArrayList<Double> proba_tipocarro, ArrayList<Double> proba_telepeaje, float mediallegada, float mediaatencion) {
        this.proba_tipocarro = proba_tipocarro;
        this.proba_telepeaje = proba_telepeaje;
        this.mediallegada = mediallegada;
        this.mediaatencionnormal = mediaatencion;
    }

    /**
     *
     * @param numeros1
     * @param numeros2
     * @param numeros3
     * @param numeros4
     * @param proba_tipocarro
     * @param proba_telepeaje
     * @param mediallegada
     * @param mediaatencion
     */
    public Identificador(ArrayList<Double> numeros1, ArrayList<Double> numeros2, ArrayList<Double> numeros3, ArrayList<Double> numeros4, ArrayList<Double> proba_tipocarro, ArrayList<Double> proba_telepeaje, float mediallegada, float mediaatencion) {
        this.numeros1 = numeros1;
        this.numeros2 = numeros2;
        this.numeros3 = numeros3;
        this.numeros4 = numeros4;
        this.proba_tipocarro = proba_tipocarro;
        this.proba_telepeaje = proba_telepeaje;
        this.mediallegada = mediallegada;
        this.mediaatencionnormal = mediaatencion;
    }

    /**
     *
     * @param numeros1
     * @param numeros2
     * @param numeros3
     * @param numeros4
     * @param proba_tipocarro
     * @param proba_telepeaje
     * @param mediallegada
     * @param mediaatencionnormal
     * @param mediaatenciontele
     */
    public Identificador(ArrayList<Double> numeros1, ArrayList<Double> numeros2, ArrayList<Double> numeros3, ArrayList<Double> numeros4, ArrayList<Double> proba_tipocarro, ArrayList<Double> proba_telepeaje, float mediallegada, float mediaatencionnormal, float mediaatenciontele) {
        this.numeros1 = numeros1;
        this.numeros2 = numeros2;
        this.numeros3 = numeros3;
        this.numeros4 = numeros4;
        this.proba_tipocarro = proba_tipocarro;
        this.proba_telepeaje = proba_telepeaje;
        this.mediallegada = mediallegada;
        this.mediaatencionnormal = mediaatencionnormal;
        this.mediaatenciontele = mediaatenciontele;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getNumeros1() {
        return numeros1;
    }

    /**
     *
     * @param numeros1
     */
    public void setNumeros1(ArrayList<Double> numeros1) {
        this.numeros1 = numeros1;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getNumeros2() {
        return numeros2;
    }

    /**
     *
     * @param numeros2
     */
    public void setNumeros2(ArrayList<Double> numeros2) {
        this.numeros2 = numeros2;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getNumeros3() {
        return numeros3;
    }

    /**
     *
     * @param numeros3
     */
    public void setNumeros3(ArrayList<Double> numeros3) {
        this.numeros3 = numeros3;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getNumeros4() {
        return numeros4;
    }

    /**
     *
     * @param numeros4
     */
    public void setNumeros4(ArrayList<Double> numeros4) {
        this.numeros4 = numeros4;
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
    public float getMediaatenciontele() {
        return mediaatenciontele;
    }

    /**
     *
     * @param mediaatenciontele
     */
    public void setMediaatenciontele(float mediaatenciontele) {
        this.mediaatenciontele = mediaatenciontele;
    }

    /**
     *
     */
    public Identificador() {
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

    @Override
    public String toString() {
        return "Identificador{" + "proba_tipocarro=" + proba_tipocarro + ", proba_telepeaje=" + proba_telepeaje + ", mediallegada=" + mediallegada + ", mediaatencion=" + mediaatencionnormal + '}';
    }

    /**
     *
     * @return
     */
    public ArrayList<Vehiculo> lista() {
        DistribucionEmpirica tipocarro = new DistribucionEmpirica();
        DistribucionEmpirica telepeaje = new DistribucionEmpirica();
        ArrayList<Float> aux = new ArrayList<>();
        for (Double double1 : numeros2) {
            aux.add(Float.parseFloat(double1.toString()));
        }
        tipocarro.setNumeros(aux);
        aux = new ArrayList<>();
        for (Double double1 : proba_tipocarro) {
            aux.add(Float.parseFloat(double1.toString()));
        }
        tipocarro.setProbablidades(aux);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        ArrayList<Long> tipos = new ArrayList<>();
        tipos = tipocarro.tipos();

//*************************************************************************************************
        aux = new ArrayList<>();
        for (Double double1 : numeros3) {
            aux.add(Float.parseFloat(double1.toString()));
        }
        telepeaje.setNumeros(aux);
        aux = new ArrayList<>();
        for (Double double1 : proba_telepeaje) {
            aux.add(Float.parseFloat(double1.toString()));
        }
        telepeaje.setProbablidades(aux);
        ArrayList<Long> telepeajes = new ArrayList<>();
        telepeajes = telepeaje.tipos();

//*************************************************************************************************      
        aux = new ArrayList<>();
        for (Double double1 : numeros1) {
            aux.add(Float.parseFloat(double1.toString()));
        }
        DistribucionExponencialPicos tiempollegada = new DistribucionExponencialPicos(aux, mediallegada, Configuracion.getInstancia().getMes());
        aux = new ArrayList<>();
        for (Double double1 : numeros4) {
            aux.add(Float.parseFloat(double1.toString()));
        }

        DistribucionExponencial tiempoatencion = new DistribucionExponencial(aux, mediaatencionnormal);

        aux = new ArrayList<>();
        for (Double double1 : numeros4) {
            aux.add(Float.parseFloat(double1.toString()));
        }

        DistribucionExponencial tiempoatenciontele = new DistribucionExponencial(aux, mediaatenciontele);

//****************************************************************************************************
        ArrayList<Float> tiempollegadalista = new ArrayList<>();
        ArrayList<Float> tiempoatencionlista = new ArrayList<>();
        ArrayList<Float> tiempoatencionlistatele = new ArrayList<>();
        tiempollegadalista = tiempollegada.tiempos();
        tiempoatencionlista = tiempoatencion.tiempos();
        tiempoatencionlistatele = tiempoatenciontele.tiempos();
//****************************************************************************************************
//****************************************************************************************************        
        int i = 0;
        for (Float obj : tiempollegadalista) {
            if (telepeajes.get(i) == 0) {
                try {
                    Vehiculo vehi = new Vehiculo(tiempollegadalista.get(i), tipos.get(i), telepeajes.get(i), tiempoatencionlistatele.get(i));
                    vehi.setId(i);
                    vehiculos.add(vehi);
                } catch (Exception e) {
                }

            } else {

                try {
                    Vehiculo vehi = new Vehiculo(tiempollegadalista.get(i), tipos.get(i), telepeajes.get(i), tiempoatencionlista.get(i));
                    vehi.setId(i);
                    vehiculos.add(vehi);
                } catch (Exception e) {
                }
            }
            i++;
        }

        return vehiculos;
    }

    /**
     *
     * @param alv
     * @param informacionextra
     * @return
     */
    public String toStringCantidades(ArrayList<Vehiculo> alv, Boolean informacionextra, ArrayList<ArrayList<String>> tablafondo) {
        ArrayList<String> columnauno = new ArrayList<>();
        ArrayList<String> cantidades = new ArrayList<>();
        ArrayList<String> porcentajes = new ArrayList<>();
        ArrayList<String> mediallega = new ArrayList<>();
        ArrayList<String> mediaatiende = new ArrayList<>();
        ArrayList<Vehiculo> vehiculos = alv;
        int car0 = 0, car1 = 0, car2 = 0, car3 = 0, car4 = 0, car5 = 0;
        double aten0 = 0, aten1 = 0, aten2 = 0, aten3 = 0, aten4 = 0, aten5 = 0;
        double llega0 = 0, llega1 = 0, llega2 = 0, llega3 = 0, llega4 = 0, llega5 = 0;

        columnauno.add("Carros Particulares");
        columnauno.add("Carros Publicos");
        columnauno.add("Camiones Particulares");
        columnauno.add("Camiones Publicos");
        columnauno.add("Buses");
        columnauno.add("Borradores");
        for (Vehiculo vehiculo : vehiculos) {
            switch ((int) vehiculo.getTipo()) {
                case 0: {
                    car0++;
                    aten0 = aten0 + vehiculo.getTiempoatencion();
                    llega0 = llega0 + vehiculo.getTiempollegada();
                    break;
                }
                case 1: {
                    car1++;
                    aten1 = aten1 + vehiculo.getTiempoatencion();
                    llega1 = llega1 + vehiculo.getTiempollegada();
                    break;
                }
                case 2: {
                    car2++;
                    aten2 = aten2 + vehiculo.getTiempoatencion();
                    llega2 = llega2 + vehiculo.getTiempollegada();
                    break;
                }
                case 3: {
                    car3++;
                    aten3 = aten3 + vehiculo.getTiempoatencion();
                    llega3 = llega3 + vehiculo.getTiempollegada();
                    break;
                }
                case 4: {
                    car4++;
                    aten4 = aten4 + vehiculo.getTiempoatencion();
                    llega4 = llega4 + vehiculo.getTiempollegada();
                    break;
                }
                case 5: {
                    car5++;
                    aten5 = aten5 + vehiculo.getTiempoatencion();
                    llega5 = llega5 + vehiculo.getTiempollegada();
                    break;
                }
            }
        }

        cantidades.add(String.valueOf(car0));
        cantidades.add(String.valueOf(car1));
        cantidades.add(String.valueOf(car2));
        cantidades.add(String.valueOf(car3));
        cantidades.add(String.valueOf(car4));
        cantidades.add(String.valueOf(car5));

        long size = vehiculos.size();
        double p0 = 0;
        p0 = car0 / (double) size;
        p0 = p0 * 100;
        p0 = (float) p0;
        double p1 = 0;
        p1 = car1 / (double) size;
        p1 = p1 * 100;
        p1 = (float) p1;
        double p2 = 0;
        p2 = car2 / (double) size;
        p2 = p2 * 100;
        p2 = (float) p2;
        double p3 = 0;
        p3 = car3 / (double) size;
        p3 = p3 * 100;
        p3 = (float) p3;
        double p4 = 0;
        p4 = car4 / (double) size;
        p4 = p4 * 100;
        p4 = (float) p4;
        double p5 = 0;
        p5 = car5 / (double) size;
        p5 = p5 * 100;
        p5 = (float) p5;

        porcentajes.add(String.valueOf(p0));
        porcentajes.add(String.valueOf(p1));
        porcentajes.add(String.valueOf(p2));
        porcentajes.add(String.valueOf(p3));
        porcentajes.add(String.valueOf(p4));
        porcentajes.add(String.valueOf(p5));

        float maten0 = 0, maten1 = 0, maten2 = 0, maten3 = 0, maten4 = 0, maten5 = 0;
        float mllega0 = 0, mllega1 = 0, mllega2 = 0, mllega3 = 0, mllega4 = 0, mllega5 = 0;

        maten0 = (float) (aten0 / car0);
        maten1 = (float) (aten1 / car1);
        maten2 = (float) (aten2 / car2);
        maten3 = (float) (aten3 / car3);
        maten4 = (float) (aten4 / car4);
        maten5 = (float) (aten5 / car5);
        mllega0 = (float) (llega0 / car0);
        mllega1 = (float) (llega1 / car1);
        mllega2 = (float) (llega2 / car2);
        mllega3 = (float) (llega3 / car3);
        mllega4 = (float) (llega4 / car4);
        mllega5 = (float) (llega5 / car5);

        mediallega.add(String.valueOf(mllega0));
        mediallega.add(String.valueOf(mllega1));
        mediallega.add(String.valueOf(mllega2));
        mediallega.add(String.valueOf(mllega3));
        mediallega.add(String.valueOf(mllega4));
        mediallega.add(String.valueOf(mllega5));

        mediaatiende.add(String.valueOf(maten0));
        mediaatiende.add(String.valueOf(maten1));
        mediaatiende.add(String.valueOf(maten2));
        mediaatiende.add(String.valueOf(maten3));
        mediaatiende.add(String.valueOf(maten4));
        mediaatiende.add(String.valueOf(maten5));

        double promllegada = 0;
        double promcaseta = 0;
        double promtele = 0;
        long cantcaseta = 0;
        long canttele = 0;
        for (Vehiculo v : vehiculos) {
            if (v.isTelepeaje()) {
                promtele = promtele + v.getTiempoatencion();
                canttele++;
            } else {
                promcaseta = promcaseta + v.getTiempoatencion();
                cantcaseta++;
            }
            promllegada = promllegada + v.getTiempollegada();

        }
        promllegada = promllegada / vehiculos.size();

        promtele = promtele / canttele;
        promcaseta = promcaseta / cantcaseta;

        if (informacionextra) {
            tablafondo.add(columnauno);
            tablafondo.add(cantidades);
            tablafondo.add(porcentajes);
            tablafondo.add(mediallega);
            tablafondo.add(mediaatiende);

            return "\n\nPasaron\n"
                    + "Vehiculos totales " + vehiculos.size() + "\n"
                    + + +car0 + " Carros Ptlares(" + p0 + "%), " + " Media Llegada " + mllega0 + " seg," + " Media Atención " + maten0 + " seg\n"
                    + car1 + " Carros Publicos(" + p1 + "%), " + " Media Llegada " + mllega1 + " seg," + " Media Atención " + maten1 + " seg\n"
                    + car2 + " Camiones Ptlares(" + p2 + "%), " + " Media Llegada " + mllega2 + " seg," + " Media Atención " + maten2 + " seg\n"
                    + car3 + " Camiones publicos(" + p3 + "%), " + " Media Llegada " + mllega3 + " seg," + " Media Atención " + maten3 + " seg\n"
                    + car4 + " Buses(" + p4 + "%), " + " Media Llegada " + mllega4 + " seg," + " Media Atención " + maten4 + " seg\n"
                    + car5 + " Borradores(" + p5 + "%), " + " Media Llegada " + mllega5 + " seg," + " Media Atención " + maten5 + " seg\n"
                    + "\nArrajaron las siguientes medias:\n" + "Tiempo promedio de llegada: " + promllegada + " seg\nTiempo promedio de atención en caseta: " + promcaseta
                    + " seg\nTiempo promedio de atención tele peaje: " + promtele + " seg";
        } else {
            tablafondo.add(columnauno);
            tablafondo.add(cantidades);
            tablafondo.add(porcentajes);
            tablafondo.add(mediallega);
            return "\n\nVehiculos totales " + vehiculos.size() + "\n"
                    + + +car0 + " Carros Ptlares(" + p0 + "%), " + " Media Llegada " + mllega0 + " seg\n"
                    + car1 + " Carros Publicos(" + p1 + "%), " + " Media Llegada " + mllega1 + " seg\n"
                    + car2 + " Camiones Ptlares(" + p2 + "%), " + " Media Llegada " + mllega2 + " seg\n"
                    + car3 + " Camiones publicos(" + p3 + "%), " + " Media Llegada " + mllega3 + " seg\n"
                    + car4 + " Buses(" + p4 + "%), " + " Media Llegada " + mllega4 + " seg\n"
                    + car5 + " Borradores(" + p5 + "%), " + " Media Llegada " + mllega5 + " seg\n"
                    + "\nArrajaron las siguientes medias:\n" + "Tiempo promedio de llegada: " + promllegada + " seg";

        }
    }

}
