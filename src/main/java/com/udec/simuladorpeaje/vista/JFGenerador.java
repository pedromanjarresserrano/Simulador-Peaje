/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.vista;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Estudiante
 */
public class JFGenerador extends javax.swing.JFrame {

    JPConfiguracion configuracion = new JPConfiguracion();
    JPInicial inicial = new JPInicial();
    JPCMixto a = new JPCMixto();
    JPCMultiplicativo b = new JPCMultiplicativo();
    JPCuadratico c = new JPCuadratico();
    JPFibonacci d = new JPFibonacci();
    JPGreen e = new JPGreen();
    JPMezclaI f = new JPMezclaI();
    JPMezclaII g = new JPMezclaII();
    JPMitchelMoore h = new JPMitchelMoore();
    JPMixto j = new JPMixto();
    JPSimulacion simular = new JPSimulacion();

    /**
     * Creates new form JFgenerador
     */
    public JFGenerador() {
        initComponents();
        jScrollPane1.setViewportView(inicial);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador - Peaje");
        setIconImage(getIconImage());
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jScrollPane1.setWheelScrollingEnabled(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1408783508_shine_14.png"))); // NOI18N
        jButton3.setText("Simulacion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setMaximumRowCount(10);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Metodo", "Mixto(Congruencial)", "Mulplicativo", "Cuadratico", "Ficonacci", "Green", "MezclaI", "MezclaII", "MitchelMoore", "Mixto" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jComboBox1ComponentResized(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1408783511_shine_20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 535, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.configuracion.actualizar()) {

            jScrollPane1.setViewportView(simular);
        }

    }//GEN-LAST:event_jButton3ActionPerformed
    private void tamañonormal() {

    }
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        int index = jComboBox1.getSelectedIndex();

        switch (index) {
            case 0: {
                jScrollPane1.setViewportView(inicial);
                tamañonormal();
                break;
            }

            case 1: {
                jScrollPane1.setViewportView(a);
                tamañonormal();
                break;
            }
            case 2: {
                jScrollPane1.setViewportView(b);
                tamañonormal();
                break;
            }
            case 3: {
                jScrollPane1.setViewportView(c);
                tamañonormal();
                break;

            }
            case 4: {
                jScrollPane1.setViewportView(d);
                tamañonormal();
                break;
            }
            case 5: {
                jScrollPane1.setViewportView(e);
                tamañonormal();
                break;
            }
            case 6: {
                jScrollPane1.setViewportView(f);
                tamañonormal();
                break;
            }
            case 7: {
                jScrollPane1.setViewportView(g);
                tamañonormal();
                break;
            }
            case 8: {
                jScrollPane1.setViewportView(h);
                tamañonormal();
                break;
            }
            case 9: {
                jScrollPane1.setViewportView(j);
                tamañonormal();
                break;
            }

        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jScrollPane1.setViewportView(configuracion);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jComboBox1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ComponentResized

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/cars.png"));

        return retValue;
    }

    /**
     *
     * @param w
     */
    public void cargarP(JPanel w) {
        //      vista.Run.gen.jScrollPane1.setViewportView(w);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}