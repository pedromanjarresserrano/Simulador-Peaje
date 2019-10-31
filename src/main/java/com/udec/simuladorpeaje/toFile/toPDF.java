/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.toFile;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author PedroD
 */
public class toPDF {

    JFileChooser sfile = new JFileChooser();
    FileOutputStream file;

    /**
     *
     */
    public toPDF() {
    }

    /**
     *
     * @param text
     * @param tabla
     * @param tablafondo
     * @param tablafondoextra
     * @param extra
     * @param textoExtra
     * @param colasSize
     * @throws com.itextpdf.text.DocumentException
     * @throws java.io.FileNotFoundException
     */
    public void guardar(String text, ArrayList<ArrayList<String>> tabla, ArrayList<ArrayList<String>> tablafondo, ArrayList<ArrayList<String>> tablafondoextra, Boolean extra, ArrayList<String> textoExtra, ArrayList<String> colasSize, ArrayList<ArrayList<String>> tablafondoextra2) throws DocumentException, FileNotFoundException, IOException {

        sfile.removeChoosableFileFilter(sfile.getFileFilter());
        sfile.addChoosableFileFilter(new FileNameExtensionFilter("Archivo PDF", "PDF", "pdf"));
        int opcion = sfile.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {

            try {
                file = new FileOutputStream(sfile.getSelectedFile() + ".pdf");
                OutputStream textout = file;
                Font catFont = new Font();
                catFont.setFamily(FontFactory.TIMES_ROMAN);
                catFont.setSize(18);
                catFont.setStyle(Font.BOLD);
                catFont.setColor(BaseColor.BLACK);

                Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
                subFont.setFamily(FontFactory.TIMES_ROMAN);
                subFont.setSize(14);
                subFont.setStyle(Font.BOLD);
                subFont.setColor(BaseColor.BLACK);

                Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
                smallBold.setFamily(FontFactory.TIMES_ROMAN);
                smallBold.setSize(12);
                smallBold.setStyle(Font.BOLD);
                smallBold.setColor(BaseColor.BLACK);

                Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
                smallFont.setFamily(FontFactory.TIMES_ROMAN);
                smallFont.setSize(9);
                smallFont.setStyle(Font.NORMAL);
                smallFont.setColor(BaseColor.BLACK);

                Font smallSubFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
                smallSubFont.setFamily(FontFactory.TIMES);
                smallSubFont.setSize(9);
                smallSubFont.setStyle(Font.NORMAL);
                smallSubFont.setColor(BaseColor.WHITE);
                BaseColor fondo = new BaseColor(10, 162, 218);
                Document doc = new Document();

                PdfWriter.getInstance(doc, textout);
                doc.open();
                doc.add(new Paragraph("Sistema de Simulación de Peaje", catFont));
                doc.add(new Paragraph("Resultados de la Corrida ", subFont));
                int num = 1;
                int cuenta = 0;
                PdfPTable table = new PdfPTable(tabla.get(0).size());
                table.setWidthPercentage(100);
                table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                PdfPCell cell = new PdfPCell();
                cell.addElement(new Phrase("", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.addElement(new Phrase("Tipo", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.addElement(new Phrase("Numero de Caseta", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.addElement(new Phrase("Tiempo de Ocio", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.addElement(new Phrase("Tiempo de Atención", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.addElement(new Phrase("V. Atendidos", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.addElement(new Phrase("Total Cobrado", smallSubFont));
                cell.setBackgroundColor(fondo);
                table.addCell(cell);

                for (ArrayList<String> ala : tabla) {
                    if (cuenta == 0) {
                        if (num == 7) {

                            doc.add(new Paragraph(" "));
                            doc.add(new Paragraph("Caseta #" + num, smallBold));

                            doc.add(new Paragraph("Cola de mayor longitud: " + colasSize.get(num - 1), smallBold));
                            doc.add(new Paragraph(" "));
                        } else {
                            if (num == 6) {
                                doc.newPage();
                                doc.add(new Paragraph(" "));
                                doc.add(new Paragraph("Caseta #" + num, smallBold));

                                doc.add(new Paragraph("Cola de mayor longitud: " + colasSize.get(num - 1), smallBold));
                                doc.add(new Paragraph(" "));
                            } else {
                                doc.add(new Paragraph(" "));
                                doc.add(new Paragraph("Caseta #" + num, smallBold));

                                doc.add(new Paragraph("Cola de mayor longitud: " + colasSize.get(num - 1), smallBold));
                                doc.add(new Paragraph(" "));
                            }
                        }
                    }
                    for (String s : ala) {
                        cell = new PdfPCell();
                        table.addCell(new Phrase(s, smallFont));
                    }
                    cuenta++;
                    if (cuenta == 2 || ala.get(1).equals("Tele-peaje")) {
                        doc.add(table);
                        num++;
                        table = new PdfPTable(tabla.get(0).size());
                        table.setWidthPercentage(100);
                        table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("Tipo", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("Numero de Caseta", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("Tiempo de Ocio", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("Tiempo de Atención", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("V. Atendidos", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cell = new PdfPCell();
                        cell.addElement(new Phrase("Total Cobrado", smallSubFont));
                        cell.setBackgroundColor(fondo);
                        table.addCell(cell);
                        cuenta = 0;

                    }

                }

                long totalw = 0;
                for (int i = 0; i < tabla.size(); i++) {
                    String[] partes = tabla.get(i).get(6).split(",");
                    String completo = "";
                    for (int j = 0; j < partes.length; j++) {
                        completo = completo + partes[j];
                    }
                    totalw = totalw + Long.parseLong(completo);
                }
                doc.add(new Paragraph("Total Cobrado: $ " + moneyFormat(totalw), new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK)));

                PdfPTable tablaDatosExtras = new PdfPTable(2);
                tablaDatosExtras.setWidthPercentage(100);
                tablaDatosExtras.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                PdfPCell cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase("Tiempo promedio de ocio de servidores: ", smallSubFont));
                cellDatosExtras.setBackgroundColor(fondo);
                tablaDatosExtras.addCell(cellDatosExtras);
                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase(textoExtra.get(0) + " minutos", smallFont));
                tablaDatosExtras.addCell(cellDatosExtras);

                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase("Tiempo promedio de ocio de servidores manuales: ", smallSubFont));
                cellDatosExtras.setBackgroundColor(fondo);
                tablaDatosExtras.addCell(cellDatosExtras);
                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase(textoExtra.get(1) + " minutos", smallFont));
                tablaDatosExtras.addCell(cellDatosExtras);

                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase("Tiempo promedio de ocio de servidores telepeajes: ", smallSubFont));
                cellDatosExtras.setBackgroundColor(fondo);
                tablaDatosExtras.addCell(cellDatosExtras);
                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase(textoExtra.get(2) + " minutos", smallFont));
                tablaDatosExtras.addCell(cellDatosExtras);

                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase("Tiempo promedio en cola: ", smallSubFont));
                cellDatosExtras.setBackgroundColor(fondo);
                tablaDatosExtras.addCell(cellDatosExtras);
                cellDatosExtras = new PdfPCell();
                cellDatosExtras.addElement(new Phrase(textoExtra.get(3) + " segundos", smallFont));
                tablaDatosExtras.addCell(cellDatosExtras);

                doc.add(new Paragraph(" "));
                doc.add(tablaDatosExtras);

                int total = 0;
                for (int i = 0; i < tablafondo.get(1).size(); i++) {
                    total = total + Integer.parseInt(tablafondo.get(1).get(i));
                }
                doc.newPage();
                doc.add(new Phrase(" "));
                doc.add(new Paragraph("Llegaron al sistema", catFont));
                if (extra) {
                    doc.add(new Paragraph("Vehiculos aceptados por el sistema: " + total + " vehiculos", subFont));

                } else {
                    doc.add(new Paragraph("Vehiculos Totales: " + total + " vehiculos", subFont));
                }
                PdfPTable tablefondo = new PdfPTable(tablafondo.get(0).size() - 1);
                tablefondo.setWidthPercentage(100);
                tablefondo.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                PdfPCell cellfondo = new PdfPCell();
                cellfondo.addElement(new Phrase("Tipo de Vehiculo", smallSubFont));
                cellfondo.setBackgroundColor(fondo);
                tablefondo.addCell(cellfondo);
                cellfondo = new PdfPCell();
                cellfondo.addElement(new Phrase("Cantidad", smallSubFont));
                cellfondo.setBackgroundColor(fondo);
                tablefondo.addCell(cellfondo);
                cellfondo = new PdfPCell();
                cellfondo.addElement(new Phrase("Porcentaje (%)", smallSubFont));
                cellfondo.setBackgroundColor(fondo);
                tablefondo.addCell(cellfondo);
                cellfondo = new PdfPCell();
                cellfondo.addElement(new Phrase("Media de llegada", smallSubFont));
                cellfondo.setBackgroundColor(fondo);
                tablefondo.addCell(cellfondo);
                cellfondo = new PdfPCell();
                cellfondo.addElement(new Phrase("Media de Atención", smallSubFont));
                cellfondo.setBackgroundColor(fondo);
                tablefondo.addCell(cellfondo);
                int w = 0;
                for (int i = 0; i < tablafondo.get(0).size(); i++) {
                    w = 0;
                    cellfondo = new PdfPCell();
                    cellfondo.addElement(new Phrase(tablafondo.get(w).get(i), smallFont));
                    tablefondo.addCell(cellfondo);
                    w++;
                    cellfondo = new PdfPCell();
                    cellfondo.addElement(new Phrase(tablafondo.get(w).get(i), smallFont));
                    tablefondo.addCell(cellfondo);
                    w++;
                    cellfondo = new PdfPCell();
                    cellfondo.addElement(new Phrase(tablafondo.get(w).get(i), smallFont));
                    tablefondo.addCell(cellfondo);
                    w++;
                    cellfondo = new PdfPCell();
                    cellfondo.addElement(new Phrase(tablafondo.get(w).get(i), smallFont));
                    tablefondo.addCell(cellfondo);
                    w++;
                    cellfondo = new PdfPCell();
                    cellfondo.addElement(new Phrase(tablafondo.get(w).get(i), smallFont));
                    tablefondo.addCell(cellfondo);
                }
                doc.add(new Phrase(" "));
                doc.add(tablefondo);

                if (!tablafondoextra.isEmpty()) {
                    total = 0;
                    for (int i = 0; i < tablafondoextra.get(1).size(); i++) {
                        total = total + Integer.parseInt(tablafondoextra.get(1).get(i));
                    }
                    doc.add(new Paragraph(" "));
                    doc.add(new Paragraph("Vehiculos rechazados por el sistema: " + total + " vehiculos", subFont));
                    PdfPTable tablefondoextra = new PdfPTable(tablafondoextra.get(0).size() - 2);
                    tablefondoextra.setWidthPercentage(100);
                    tablefondoextra.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                    PdfPCell cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Tipo de Vehiculo", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);
                    cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Cantidad", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);
                    cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Porcentaje (%)", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);
                    cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Media de llegada", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);

                    w = 0;
                    for (int i = 0; i < tablafondoextra.get(0).size(); i++) {
                        w = 0;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;

                    }
                    doc.add(new Phrase(" "));
                    doc.add(tablefondoextra);
                }

                if (!tablafondoextra2.isEmpty()) {
                    total = 0;
                    for (int i = 0; i < tablafondoextra2.get(1).size(); i++) {
                        total = total + Integer.parseInt(tablafondoextra2.get(1).get(i));
                    }
                    doc.add(new Paragraph(" "));
                    doc.add(new Paragraph("Vehiculos rechazados por falta de atención: " + total + " vehiculos", subFont));
                    PdfPTable tablefondoextra = new PdfPTable(tablafondoextra2.get(0).size() - 2);
                    tablefondoextra.setWidthPercentage(100);
                    tablefondoextra.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                    PdfPCell cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Tipo de Vehiculo", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);
                    cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Cantidad", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);
                    cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Porcentaje (%)", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);
                    cellfondoextra = new PdfPCell();
                    cellfondoextra.addElement(new Phrase("Media de llegada", smallSubFont));
                    cellfondoextra.setBackgroundColor(fondo);
                    tablefondoextra.addCell(cellfondoextra);

                    w = 0;
                    for (int i = 0; i < tablafondoextra2.get(0).size(); i++) {
                        w = 0;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra2.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra2.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra2.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;
                        cellfondoextra = new PdfPCell();
                        cellfondoextra.addElement(new Phrase(tablafondoextra2.get(w).get(i), smallFont));
                        tablefondoextra.addCell(cellfondoextra);
                        w++;

                    }
                    doc.add(new Phrase(" "));
                    doc.add(tablefondoextra);
                }
                // doc.add(new Paragraph(text, smallFont));
                doc.close();
                textout.close();
                JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                file.close();
                sfile = new JFileChooser();
//                    sfile.getSelectedFile().deleteOnExit();
                sfile.cancelSelection();

                JOptionPane.showMessageDialog(null, "Error al guardar archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private String moneyFormat(double money) {
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
}
