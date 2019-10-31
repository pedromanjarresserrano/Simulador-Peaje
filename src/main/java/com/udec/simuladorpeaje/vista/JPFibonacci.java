/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.vista;

import com.udec.simuladorpeaje.toFile.ToExcel;
import com.udec.simuladorpeaje.validaciones.Ayuda;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author PedroD
 */
public class JPFibonacci extends javax.swing.JPanel {

    /**
     *
     */
    public static ArrayList<Float> resultados = new ArrayList<>();
    private ToExcel a = new ToExcel();

    /**
     * Creates new form JPFibonacci
     */
    public JPFibonacci() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JPencabezado = new javax.swing.JPanel();
        JBguardar = new javax.swing.JButton();
        JLnombre = new javax.swing.JLabel();
        JPvariables = new javax.swing.JPanel();
        JBgenerar = new javax.swing.JButton();
        JBlimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTx1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTx0 = new javax.swing.JTextField();
        JTmodulo = new javax.swing.JTextField();
        JPnumerosgenerados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        JLperiodo = new javax.swing.JLabel();
        JPpruebas = new javax.swing.JPanel();
        JBpromedios = new javax.swing.JButton();
        JBfrecuencias = new javax.swing.JButton();
        JBdistancias = new javax.swing.JButton();
        JBkolgomorov = new javax.swing.JButton();
        JBpoker = new javax.swing.JButton();
        JBcorridas1 = new javax.swing.JButton();
        JBcorridas2 = new javax.swing.JButton();
        JBseries = new javax.swing.JButton();
        JLpromedio = new javax.swing.JLabel();
        JLfrecuencias = new javax.swing.JLabel();
        JLdistancias = new javax.swing.JLabel();
        JLkolgomorov = new javax.swing.JLabel();
        JLpoker = new javax.swing.JLabel();
        JLcorridas1 = new javax.swing.JLabel();
        JLcorridas2 = new javax.swing.JLabel();
        JLseries = new javax.swing.JLabel();

        JBguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1408783509_shine_13.png"))); // NOI18N
        JBguardar.setText("Guardar");
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        JLnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLnombre.setText("Fibonacci");

        javax.swing.GroupLayout JPencabezadoLayout = new javax.swing.GroupLayout(JPencabezado);
        JPencabezado.setLayout(JPencabezadoLayout);
        JPencabezadoLayout.setHorizontalGroup(
            JPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPencabezadoLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(JLnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBguardar)
                .addGap(64, 64, 64))
        );
        JPencabezadoLayout.setVerticalGroup(
            JPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPencabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre)
                    .addComponent(JBguardar))
                .addContainerGap())
        );

        JPvariables.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Variables"));

        JBgenerar.setText("Generar");
        JBgenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBgenerarActionPerformed(evt);
            }
        });

        JBlimpiar.setText("Limpiar");
        JBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlimpiarActionPerformed(evt);
            }
        });

        jLabel3.setText("Modulo (m)");

        jLabel2.setText("Semilla (Xo)");

        JTx1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTx1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTx1KeyTyped(evt);
            }
        });

        jLabel4.setText("Semilla (X1)");

        JTx0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTx0KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTx0KeyTyped(evt);
            }
        });

        JTmodulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTmoduloKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTmoduloKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JPvariablesLayout = new javax.swing.GroupLayout(JPvariables);
        JPvariables.setLayout(JPvariablesLayout);
        JPvariablesLayout.setHorizontalGroup(
            JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvariablesLayout.createSequentialGroup()
                .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPvariablesLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(JBlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(JBgenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPvariablesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTx0)
                            .addComponent(JTmodulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTx1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        JPvariablesLayout.setVerticalGroup(
            JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvariablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTx0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTmodulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(JPvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBlimpiar)
                    .addComponent(JBgenerar))
                .addContainerGap())
        );

        JPnumerosgenerados.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Numeros Generados"));

        jScrollPane2.setViewportView(jList1);

        JLperiodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLperiodo.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout JPnumerosgeneradosLayout = new javax.swing.GroupLayout(JPnumerosgenerados);
        JPnumerosgenerados.setLayout(JPnumerosgeneradosLayout);
        JPnumerosgeneradosLayout.setHorizontalGroup(
            JPnumerosgeneradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnumerosgeneradosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPnumerosgeneradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        JPnumerosgeneradosLayout.setVerticalGroup(
            JPnumerosgeneradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnumerosgeneradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        JPpruebas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Pruebas"));

        JBpromedios.setText("Promedio");
        JBpromedios.setEnabled(false);
        JBpromedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBpromediosActionPerformed(evt);
            }
        });

        JBfrecuencias.setText("Frecuencias");
        JBfrecuencias.setEnabled(false);
        JBfrecuencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBfrecuenciasActionPerformed(evt);
            }
        });

        JBdistancias.setText("Distancias");
        JBdistancias.setEnabled(false);
        JBdistancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBdistanciasActionPerformed(evt);
            }
        });

        JBkolgomorov.setText("Kolgomorov");
        JBkolgomorov.setEnabled(false);
        JBkolgomorov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBkolgomorovActionPerformed(evt);
            }
        });

        JBpoker.setText("Poker");
        JBpoker.setEnabled(false);
        JBpoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBpokerActionPerformed(evt);
            }
        });

        JBcorridas1.setText("Corridas 1");
        JBcorridas1.setEnabled(false);
        JBcorridas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcorridas1ActionPerformed(evt);
            }
        });

        JBcorridas2.setText("Corridas 2");
        JBcorridas2.setEnabled(false);
        JBcorridas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcorridas2ActionPerformed(evt);
            }
        });

        JBseries.setText("Series");
        JBseries.setEnabled(false);
        JBseries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBseriesActionPerformed(evt);
            }
        });

        JLpromedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLpromedio.setText("-");

        JLfrecuencias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLfrecuencias.setText("-");

        JLdistancias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLdistancias.setText("-");

        JLkolgomorov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLkolgomorov.setText("-");

        JLpoker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLpoker.setText("-");

        JLcorridas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLcorridas1.setText("-");

        JLcorridas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLcorridas2.setText("-");

        JLseries.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLseries.setText("-");

        javax.swing.GroupLayout JPpruebasLayout = new javax.swing.GroupLayout(JPpruebas);
        JPpruebas.setLayout(JPpruebasLayout);
        JPpruebasLayout.setHorizontalGroup(
            JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPpruebasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBkolgomorov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBdistancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBfrecuencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBpromedios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLpromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(JLfrecuencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLdistancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLkolgomorov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBseries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBcorridas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBcorridas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBpoker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLpoker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLcorridas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLcorridas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLseries, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPpruebasLayout.setVerticalGroup(
            JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPpruebasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBpromedios)
                    .addComponent(JBpoker)
                    .addComponent(JLpoker)
                    .addComponent(JLpromedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBfrecuencias)
                    .addComponent(JBcorridas1)
                    .addComponent(JLfrecuencias)
                    .addComponent(JLcorridas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBdistancias)
                    .addComponent(JBcorridas2)
                    .addComponent(JLdistancias)
                    .addComponent(JLcorridas2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPpruebasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBkolgomorov)
                    .addComponent(JBseries)
                    .addComponent(JLkolgomorov)
                    .addComponent(JLseries))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JPvariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPpruebas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(JPnumerosgenerados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addComponent(JPencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPencabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JPvariables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JPpruebas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(JPnumerosgenerados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTx0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTx0KeyTyped
        soloNumero(evt);
    }//GEN-LAST:event_JTx0KeyTyped

    private void JTmoduloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTmoduloKeyTyped
        soloNumero(evt);
    }//GEN-LAST:event_JTmoduloKeyTyped

    private void JTx1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTx1KeyTyped
        soloNumero(evt);
    }//GEN-LAST:event_JTx1KeyTyped

    private void JBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlimpiarActionPerformed
        JTx0.setText("");
        JTmodulo.setText("");
        JTx1.setText("");
        DefaultListModel lm = new DefaultListModel();
        jList1.setModel(lm);
        resultados = new ArrayList<>();
        JLperiodo.setText("");
        Ayuda.habilitarb(resultados, JBpromedios, JBfrecuencias, JBdistancias, JBkolgomorov, JBpoker, JBcorridas1, JBcorridas2, JBseries);
    }//GEN-LAST:event_JBlimpiarActionPerformed

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        a.guardar(resultados);
    }//GEN-LAST:event_JBguardarActionPerformed

    private void JBgenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBgenerarActionPerformed
        if (JTmodulo.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "El Modulo debe ser diferente de cero.");
        } else {
            if (!(JTx0.getText().equals("") || JTmodulo.getText().equals("") || JTx1.getText().equals(""))) {
                int xo = Integer.parseInt(JTx1.getText());
                int m = Integer.parseInt(JTmodulo.getText());
                int x1 = Integer.parseInt(JTx0.getText());
                resultados = new ArrayList<>();
                resultados.addAll(com.udec.simuladorpeaje.vista.Run.cg.fibonacci(x1, xo, m));
                Ayuda.listar(resultados, jList1, JLperiodo);
            } else {
                JOptionPane.showMessageDialog(this, "Llene todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            Ayuda.habilitarb(resultados, JBpromedios, JBfrecuencias, JBdistancias, JBkolgomorov, JBpoker, JBcorridas1, JBcorridas2, JBseries);
        }
    }//GEN-LAST:event_JBgenerarActionPerformed

    private void JTx0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTx0KeyPressed
        soloNumero(evt);
    }//GEN-LAST:event_JTx0KeyPressed

    private void JTmoduloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTmoduloKeyPressed
        soloNumero(evt);
    }//GEN-LAST:event_JTmoduloKeyPressed

    private void JTx1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTx1KeyPressed
        soloNumero(evt);
    }//GEN-LAST:event_JTx1KeyPressed

    private void JBpromediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBpromediosActionPerformed
        JLpromedio.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaPromedios(resultados));
    }//GEN-LAST:event_JBpromediosActionPerformed

    private void JBfrecuenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBfrecuenciasActionPerformed
        JLfrecuencias.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaFrecuencia(resultados));
    }//GEN-LAST:event_JBfrecuenciasActionPerformed

    private void JBdistanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBdistanciasActionPerformed
        JLdistancias.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaDistancia(resultados));
    }//GEN-LAST:event_JBdistanciasActionPerformed

    private void JBkolgomorovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBkolgomorovActionPerformed
        JLkolgomorov.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaKolgomorov(resultados));
    }//GEN-LAST:event_JBkolgomorovActionPerformed

    private void JBpokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBpokerActionPerformed
        JLpoker.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaPoker(resultados));
    }//GEN-LAST:event_JBpokerActionPerformed

    private void JBcorridas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcorridas1ActionPerformed
        JLcorridas1.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaCorridas1(resultados));
    }//GEN-LAST:event_JBcorridas1ActionPerformed

    private void JBcorridas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcorridas2ActionPerformed
        JLcorridas2.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaCorridas2(resultados));
    }//GEN-LAST:event_JBcorridas2ActionPerformed

    private void JBseriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBseriesActionPerformed
        JLseries.setText(com.udec.simuladorpeaje.vista.Run.cp.pruebaSerie(resultados));
    }//GEN-LAST:event_JBseriesActionPerformed

    private void soloNumero(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (!(Character.isDigit(caracter)) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    /**
     *
     * @return
     */
    public String nombre() {
        return JLnombre.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBcorridas1;
    private javax.swing.JButton JBcorridas2;
    private javax.swing.JButton JBdistancias;
    private javax.swing.JButton JBfrecuencias;
    private javax.swing.JButton JBgenerar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JButton JBkolgomorov;
    private javax.swing.JButton JBlimpiar;
    private javax.swing.JButton JBpoker;
    private javax.swing.JButton JBpromedios;
    private javax.swing.JButton JBseries;
    private javax.swing.JLabel JLcorridas1;
    private javax.swing.JLabel JLcorridas2;
    private javax.swing.JLabel JLdistancias;
    private javax.swing.JLabel JLfrecuencias;
    private javax.swing.JLabel JLkolgomorov;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLperiodo;
    private javax.swing.JLabel JLpoker;
    private javax.swing.JLabel JLpromedio;
    private javax.swing.JLabel JLseries;
    private javax.swing.JPanel JPencabezado;
    private javax.swing.JPanel JPnumerosgenerados;
    private javax.swing.JPanel JPpruebas;
    private javax.swing.JPanel JPvariables;
    private javax.swing.JTextField JTmodulo;
    private javax.swing.JTextField JTx0;
    private javax.swing.JTextField JTx1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
