/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.listeners;

import br.com.pdfslider.frames.Form_Configuration;
import br.com.pdfslider.interfaces.ListenerAdapter;
import br.com.pdfslider.services.Service_Configuration;
import java.awt.event.ActionEvent;


public final class Listener_Configuration extends ListenerAdapter<Form_Configuration> {

    private final Service_Configuration service;

    public Listener_Configuration(Form_Configuration form) {
        super(form);
        service = new Service_Configuration();
        initComponents();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        service.criarArquivoConfiguracao();
        service.setDados(form);
    }

    @Override
    protected void attachListeners() {
        form.getButtonsList().forEach(bt -> bt.addActionListener(this));
        fecharEsc(form.getItemFechar());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        switch (event.getActionCommand()) {
            case "defaultExibicao":
                service.getDefaultScreenSize(form);
                break;
            case "restore":
                service.setDados(form);
                break;
            case "confirmar":
                service.confirmar(form);
                break;
            case "cancelar":
                fechar();
                break;
            case "selecionarIcone":
                service.selecionarIcone(form);
                break;
            case "selecionarPasta":
                service.selecionarPastaArquivos(form);
                break;
        }
    }

}
