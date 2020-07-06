/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.services;

import br.com.pdfslider.frames.Form_Configuration;
import br.com.pdfslider.frames.Form_Slider;
import br.com.pdfslider.models.Configuration;
import br.com.pdfslider.util.FileUtil;
import br.com.pdfslider.util.MessageFactory;
import br.com.pdfslider.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Classe de serviço do formulário de configuração
 */
public class Service_Configuration {

    public Service_Configuration() {
    }

    /**
     * Pega o tamanho da tela do usuário e seta nos campos do formulário de
     * configuração
     *
     * @param form Form_Configuration
     */
    public void getDefaultScreenSize(Form_Configuration form) {
        form.setAlturaComprimento(Toolkit.getDefaultToolkit().getScreenSize());
    }

    /**
     * Pega os dados de configuração do arquivo e mostrar nos campos do
     * formulário
     *
     * @param form Form_Configuration
     */
    public void setDados(Form_Configuration form) {
        form.setConfiguration(Utilidades.getConfiguration());
    }

    /**
     * Grava os dados do formulário no arquivo de configuração do sistema
     *
     * @param form Form_Configuration
     */
    private void gravarDados(Form_Configuration form) {
        FileUtil.gravarArquivoConfiguracao(form.getConfiguration());
    }

    /**
     * Método utilizado pelo botão de confirmar do formulário. Grava os dados do
     * formulário no arquivo de configuração, fecha o formulário de configuração
     * e abre o formulário de apresentação.
     *
     * @param form Form_Configuration
     */
    public void confirmar(Form_Configuration form) {
        if (MessageFactory.getQuestionMessage(form, "Deseja realmente confirmar?", "Confirmar")) {
            gravarDados(form);
            Form_Slider slider = new Form_Slider();
            slider.setVisible(true);
            form.dispose();
        }
    }

    /**
     * Cria o arquivo de configuração caso o mesmo não exista
     */
    public void criarArquivoConfiguracao() {
        File f = new File(Configuration.getConfigurationFile());
        if (!f.exists()) {
            FileUtil.gravarArquivoConfiguracao(new Configuration());
        }
    }

    /**
     * Método utilizado pelo botão de selecionar icone no formulário de
     * configuração.
     *
     * @param form Form_Configuration
     */
    public void selecionarIcone(Form_Configuration form) {
        try {
            form.setIconeSistema(Utilidades.selecionadorArquivos(form, "Selecionar ícone", JFileChooser.FILES_ONLY, "jpg", "jpeg", "gif"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método utilizado pelo botão de selecionar pasta de arquivos no formulário
     * de configuração.
     *
     * @param form Form_Configuration
     */
    public void selecionarPastaArquivos(Form_Configuration form) {
        try {
            form.setPastaArquivos(Utilidades.selecionadorArquivos(form, "Selecionar", JFileChooser.FILES_AND_DIRECTORIES, "pdf"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
