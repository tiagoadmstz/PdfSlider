/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.services;

import br.com.pdfslider.frames.Form_Configuration;
import br.com.pdfslider.frames.Form_Slider;
import br.com.pdfslider.util.FileUtil;
import br.com.pdfslider.util.MessageFactory;
import br.com.pdfslider.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        form.getTxtAltura().setText(String.valueOf(d.height));
        form.getTxtComprimento().setText(String.valueOf(d.width));
    }

    /**
     * Pega os dados de configuração do arquivo e mostrar nos campos do
     * formulário
     *
     * @param form Form_Configuration
     */
    public void setDados(Form_Configuration form) {
        Map<String, String> map = Utilidades.getConfiguration();
        form.getTxtAltura().setText(map.get("altura"));
        form.getTxtComprimento().setText(map.get("comprimento"));
        form.getTxtIconeSistema().setText(map.get("icone"));
        form.getTxtPastaArquivo().setText(map.get("arquivos"));
        form.getTxtTempoArquivo().setText(map.get("tempoArquivo"));
        form.getTxtTempoPagina().setText(map.get("tempoPagina"));
        form.getCkLoopArquivo().setSelected(Boolean.valueOf(map.get("loopArquivo")));
    }

    /**
     * Grava os dados do formulário no arquivo de configuração do sistema
     *
     * @param form Form_Configuration
     */
    private void gravarDados(Form_Configuration form) {
        Map<String, String> map = new HashMap();
        map.put("altura", form.getTxtAltura().getText());
        map.put("comprimento", form.getTxtComprimento().getText());
        map.put("icone", form.getTxtIconeSistema().getText());
        map.put("arquivos", form.getTxtPastaArquivo().getText());
        map.put("tempoArquivo", form.getTxtTempoArquivo().getText());
        map.put("tempoPagina", form.getTxtTempoPagina().getText());
        map.put("loopArquivo", String.valueOf(form.getCkLoopArquivo().isSelected()));
        try {
            FileUtil.gravarArquivoConfiguracao(map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        File f = new File(FileUtil.getDefaultPath().concat("/configuration.conf"));
        if (!f.exists()) {
            FileUtil.gravarArquivoConfiguracao(Utilidades.getInitialConfiguration());
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
            form.getTxtIconeSistema().setText(Utilidades.selecionadorArquivos(form, "Selecionar ícone", JFileChooser.FILES_ONLY, "jpg", "jpeg", "gif"));
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
            form.getTxtPastaArquivo().setText(Utilidades.selecionadorArquivos(form, "Selecionar", JFileChooser.FILES_AND_DIRECTORIES, "pdf"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
