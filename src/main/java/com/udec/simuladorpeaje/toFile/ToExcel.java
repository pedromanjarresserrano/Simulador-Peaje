/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.toFile;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vegal
 */
public class ToExcel {

    /**
     *
     * @param resultados
     */
    public void guardar(ArrayList<Float> resultados) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Numeros Aleatorios");
        int rownum = 0;
        int cellnum = 0;
        for (Float float1 : resultados) {
            Row row = sheet.createRow(rownum++);
            Cell cell = row.createCell(cellnum);
            cell.setCellValue(float1);

        }
        FileOutputStream fos = null;

        JFileChooser exp = new JFileChooser();
        exp.removeChoosableFileFilter(exp.getFileFilter());
        exp.addChoosableFileFilter(new FileNameExtensionFilter("Archivo excel", "xlsx"));
        int op = exp.showSaveDialog(exp);

        System.out.println(op);
        if (op == 0) {
            if (exp.getSelectedFile().exists()) {
                int op2 = JOptionPane.showConfirmDialog(null, "El archivo ya existe, Desea Sobrescribir?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (op2 == 0) {
                    try {
                        if (exp.getSelectedFile() != null) {
                            fos = new FileOutputStream(new File(exp.getSelectedFile() + ".xlsx"));
                            wb.write(fos);
                            JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al exportar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                try {
                    if (exp.getSelectedFile() != null) {
                        fos = new FileOutputStream(new File(exp.getSelectedFile() + ".xlsx"));
                        wb.write(fos);
                        JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al exportar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     *
     * @param numeros
     * @param jpb
     *
     * @param jlist
     * @param jlcarga
     * @return
     * @throws java.io.FileNotFoundException @throws IOException
     * @throws java.lang.InterruptedException
     */
    public ArrayList<Double> cargar(ArrayList<Double> numeros, JProgressBar jpb, JList jlist, JLabel jlcarga) throws IOException, InterruptedException {

        DefaultListModel lm = new DefaultListModel();

        String url = "";
        JFileChooser jfc = new JFileChooser();
        jfc.removeChoosableFileFilter(jfc.getFileFilter());
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Archivo excel", "xls", "xlsx"));
        jfc.showOpenDialog(null);
        if (jfc.getSelectedFile() != null) {
            try {
                url = jfc.getSelectedFile().toString();
                numeros.clear();

            } catch (Exception ex) {
            }
        }
        File url2 = new File(url);
        if (url.endsWith(".xls")) {
            new Thread() {
                @Override
                public void run() {
                    try (FileInputStream file = new FileInputStream(url2)) {
                        jlcarga.setText("Comenzando Carga");
                        jpb.setValue(0);
                        //Se obtiene el libro Excel
                        HSSFWorkbook wb = new HSSFWorkbook(file);
                        //Se obtiene la primera hoja
                        HSSFSheet sheet = wb.getSheetAt(0);
                        //Se obtiene la primera fila de la hoja
                        //    HSSFRow row = sheet.getRow(0);
                        //  HSSFCell cell = row.getCell((short) 0);
                        Iterator<Row> rowIterator = sheet.iterator();

                        int i = 0;
                        int w = 1;
                        jpb.setMaximum(sheet.getLastRowNum());
                        while (rowIterator.hasNext()) {
                            Row row;
                            row = rowIterator.next();
                            Cell cell = row.getCell(0);
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    double aux = cell.getNumericCellValue();
                                    numeros.add(aux);
                                    lm.addElement(w + "-> " + aux);
                                    jpb.setValue(i++);
                                    jlcarga.setText("Cargando");
                                    w++;
                                    break;
                            }
                        }

                        jlcarga.setText("Terminado");
                        file.close();
                        jlist.setModel(lm);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ToExcel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ToExcel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            ;
        }

        .start();
            }
        
        if (url.endsWith(".xlsx")) {

            new Thread() {
                @Override
                public void run() {
                    try (FileInputStream file = new FileInputStream(url2)) {
                        jlcarga.setText("Comenzando Carga");
                        jpb.setValue(0);
                        //Se obtiene el libro Excel
                        XSSFWorkbook wb = new XSSFWorkbook(file);
                        //Se obtiene la primera hoja
                        XSSFSheet sheet = wb.getSheetAt(0);
                        //Se obtiene la primera fila de la hoja
                        //    HSSFRow row = sheet.getRow(0);
                        //  HSSFCell cell = row.getCell((short) 0);
                        Iterator<Row> rowIterator = sheet.iterator();
                        int i = 0;
                        int w = 1;

                        jpb.setMaximum(sheet.getLastRowNum());
                        while (rowIterator.hasNext()) {
                            Row row;
                            row = rowIterator.next();
                            Cell cell = row.getCell(0);
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    double aux = cell.getNumericCellValue();
                                    numeros.add(aux);
                                    lm.addElement(w + "-> " + aux);
                                    jpb.setValue(i++);
                                    jlcarga.setText("Cargando");
                                    w++;
                                    break;
                            }
                            yield();

                        }
                        jlcarga.setText("Terminado");
                        file.close();
                        jlist.setModel(lm);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ToExcel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ToExcel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            ;
        }
        .start();
        }
    return numeros;
    }

}
