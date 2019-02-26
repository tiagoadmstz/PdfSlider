/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;


public class FileUtil {

    /**
     * Pega o caminho para a pasta do sistema
     * @return String com o caminho
     */
    public static String getDefaultPath() {
        return System.getProperty("user.dir");
    }

    /**
     * Grava dados no arquivo de configuração
     * @param configurations Map com os parâmetros que serão gravados no arquivo
     */
    public static void gravarArquivoConfiguracao(Map<String, String> configurations) {
        try {
            String path = FileUtil.getDefaultPath().concat("/configuration.conf");
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            configurations.forEach((k, v) -> {
                try {
                    writer.append(k + "::" + v + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
