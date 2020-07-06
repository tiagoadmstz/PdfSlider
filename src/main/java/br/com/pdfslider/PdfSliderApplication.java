/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider;

import br.com.pdfslider.enumerated.LOOKANDFEEL;
import br.com.pdfslider.frames.Form_Configuration;
import br.com.pdfslider.util.Utilidades;


public class PdfSliderApplication {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utilidades.lookandfeelDefine(LOOKANDFEEL.WINDOWS);
        Form_Configuration form = new Form_Configuration();
        form.setVisible(true);
    }

}
