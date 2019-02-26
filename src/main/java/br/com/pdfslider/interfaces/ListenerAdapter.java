/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.interfaces;

import br.com.pdfslider.frames.Form_Configuration;
import br.com.pdfslider.util.MessageFactory;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @param <T> Formulário que ficará sobre tutela do listener
 */
public abstract class ListenerAdapter<T> implements ActionListener {

    /**
     * Variável que representa o formulário gerenciado pelo listener
     */
    protected final T form;

    public ListenerAdapter(T form) {
        this.form = form;
    }

    /**
     * Método que encapsula a execução de outros métodos que iniciam o
     * formulário
     */
    protected void initComponents() {
        attachListeners();
    }

    /**
     * Método para adicionar listeners em geral
     */
    protected abstract void attachListeners();

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "fechar":
                fechar();
                break;
        }
    }

    /**
     * Seta a tecla esc como atalho para um JMenuItem que usa o método fechar
     *
     * @param item JMenuItem que usará o atalho
     */
    protected void fecharEsc(JMenuItem item) {
        if (item != null) {
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
            item.setActionCommand("fechar");
        }
    }

    /**
     * Fecha o sistema
     */
    protected void fechar() {
        if (MessageFactory.getQuestionMessage((Component) form, "Deseja realmente fechar o aplicativo?", "Fechar Aplicativo")) {
            System.exit(0);
        }
    }

    /**
     * Fecha a tela principal do slider e abre a tela de configuração novamente
     */
    protected void logout() {
        if (MessageFactory.getQuestionMessage((Component) form, "Deseja realmente fechar o aplicativo?", "Fechar Aplicativo")) {
            Form_Configuration config = new Form_Configuration();
            ((JFrame) form).dispose();
            config.setVisible(true);
        }
    }

}
