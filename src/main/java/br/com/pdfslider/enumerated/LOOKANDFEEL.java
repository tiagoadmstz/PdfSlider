/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.enumerated;


public enum LOOKANDFEEL {

    METAL("javax.swing.plaf.metal.MetalLookAndFeel"),
    NIMBUS("javax.swing.plaf.nimbus.NimbusLookAndFeel"),
    MOTIF("com.sun.java.swing.plaf.motif.MotifLookAndFeel"),
    WINDOWS("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"),
    WINDOWS_CLASSIC("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

    private final String valor;

    private LOOKANDFEEL(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
