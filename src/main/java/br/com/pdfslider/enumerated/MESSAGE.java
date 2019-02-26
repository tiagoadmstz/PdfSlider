/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.enumerated;

/**
 *
 * @author tiago.teixeira
 */
public enum MESSAGE {

    ULTIMO_ARQUIVO(0);

    private final int valor;

    private MESSAGE(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}
