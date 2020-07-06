/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import br.com.pdfslider.enumerated.LOOKANDFEEL;
import br.com.pdfslider.models.Configuration;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * Classe que contém métodos utilizados por todo sistema
 */
public class Utilidades {

    /**
     * Troca lookandfeel do sistema todo
     *
     * @param lookandfeel Enum qual look deve ser usado
     */
    public static void lookandfeelDefine(LOOKANDFEEL lookandfeel) {
        try {
            UIManager.setLookAndFeel(lookandfeel.getValor());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Pega as configurações gravados no arquivo.
     *
     * @return Map com as configurações
     */
    public static Configuration getConfiguration() {
        try {
            String path = Configuration.getConfigurationFile();
            File file = new File(path);
            if (!file.exists()) FileUtil.gravarArquivoConfiguracao(new Configuration());
            return new Gson().fromJson(IOUtils.toString(new FileInputStream(file)), Configuration.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Configuration();
    }

    /**
     * Seta o ícone padrão para um JFrame.
     *
     * @param form JFrame que usará o ícone
     */
    public static void setImageIcon(JFrame form) {
        form.setIconImage(getConfiguration().getIconeSistema());
    }

    /**
     * Abre um selecionador de arquivos padrão para o usuário.
     *
     * @param form    Component que está utilizando o selecionador
     * @param legenda Legenda do selecionador
     * @param mode    Modo de seleção de arquivo
     * @param filtro  Extensões dos arquivos que serão exibidos Ex("txt", "pdf")
     * @return
     */
    public static String selecionadorArquivos(Component form, String legenda, int mode, String... filtro) {
        JFileChooser fileChooser = new JFileChooser(FileUtil.getDefaultPath());
        if (!"".equals(filtro) && filtro != null) {
            fileChooser.setFileFilter(new FileNameExtensionFilter(null, filtro));
        }
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(mode);
        fileChooser.setDialogTitle(legenda);
        int acao = fileChooser.showDialog(form, "Selecionar");
        if (acao == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

}
