/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.simuladorpeaje.logica.animacion;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Estudiante
 */
public class PanelConFondo extends JPanel {

    private Image imagen;

    /**
     *
     * @param filename
     */
    public PanelConFondo(String filename) {
        this.imagen = new ImageIcon(getClass().getResource(filename)).getImage();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
                this);

        setOpaque(false);
        super.paint(g);
    }

    /**
     *
     * @return
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     *
     * @param filename
     */
    public void setImagen(String filename) {
        this.imagen = new ImageIcon(getClass().getResource(filename)).getImage();
    }

}
