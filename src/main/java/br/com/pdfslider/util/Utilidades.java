/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import br.com.pdfslider.enumerated.LOOKANDFEEL;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

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
    public static Map<String, String> getConfiguration() {
        Map<String, String> map = new HashMap();
        try {
            String path = FileUtil.getDefaultPath().concat("/configuration.conf");
            File file = new File(path);
            if (!file.exists()) {
                FileUtil.gravarArquivoConfiguracao(getInitialConfiguration());
            }
            IOUtils.readLines(new FileInputStream(file)).forEach(ln -> {
                String[] itens = ((String) ln).split("::");
                map.put(itens[0], itens[1]);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }

    /**
     * Configuração inicial do sistema.
     *
     * @return Map com a configuração inicial do sistema.
     */
    public static Map<String, String> getInitialConfiguration() {
        Map<String, String> map = new HashMap();
        map.put("icone", "null");
        map.put("arquivos", "null");
        map.put("tempoPagina", "00h00m10s");
        map.put("tempoArquivo", "00h01m00s");
        map.put("comprimento", "800");
        map.put("altura", "600");
        map.put("loopArquivo", "true");
        return map;
    }

    /**
     * Seta o ícone padrão para um JFrame.
     *
     * @param form JFrame que usará o ícone
     */
    public static void setImageIcon(JFrame form) {
        try {
            String path = getConfiguration().get("icone");
            form.setIconImage(new ImageIcon(path).getImage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
