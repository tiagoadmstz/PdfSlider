/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Classe de filtro para selecionar apenas arquivos pdf
 */
public class PdfFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith("pdf")
                || name.toLowerCase().endsWith("PDF");
    }

}
