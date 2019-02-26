/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.listeners;

import br.com.pdfslider.frames.Form_Slider;
import br.com.pdfslider.interfaces.ListenerAdapter;
import br.com.pdfslider.services.Service_Slider;
import br.com.pdfslider.util.Utilidades;
import java.awt.event.ActionEvent;

public final class Listener_Slider extends ListenerAdapter<Form_Slider> {

    private final Service_Slider service;

    public Listener_Slider(Form_Slider form) {
        super(form);
        this.service = new Service_Slider();
        initComponents();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        //service.mostrarArquivo(form.getLbPage(), service.getFiles(), Utilidades.getConfiguration().get("loopArquivo"));
        //service.mostrarPaginas(form.getLbPage(), service.getFiles(), Utilidades.getConfiguration().get("loopArquivo"));
        service.iniciarSistema(form.getLbPage(), form.getLbPaginas(), service.getFiles(), Utilidades.getConfiguration().get("loopArquivo"));
        form.getBtPausar().addActionListener(this);
        form.getBtAnvacar().addActionListener(this);
        form.getBtVoltar().addActionListener(this);
    }

    @Override
    protected void attachListeners() {
        form.getItemFechar().addActionListener(this);
        super.fecharEsc(form.getItemFechar());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "fechar":
                logout();
                break;
            case "play":
                service.play(form.getBtPausar());
                break;
            case "pausar":
                service.pause(form.getBtPausar());
                break;
            case "voltar":
                service.anterior(form.getLbPage(), form.getLbPaginas());
                break;
            case "avancar":
                service.proxima(form.getLbPage(), form.getLbPaginas());
                break;
        }
    }

}
