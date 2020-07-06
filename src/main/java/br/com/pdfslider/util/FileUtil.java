/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import br.com.pdfslider.models.Configuration;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;


public class FileUtil {

    /**
     * Pega o caminho para a pasta do sistema
     *
     * @return String com o caminho
     */
    public static String getDefaultPath() {
        return System.getProperty("user.dir");
    }

    /**
     * Grava dados no arquivo de configuração
     *
     * @param configuration Map com os parâmetros que serão gravados no arquivo
     */
    public static void gravarArquivoConfiguracao(Configuration configuration) {
        try {
            File file = new File(Configuration.getConfigurationFile());
            if (!file.exists()) {
                File directory = new File(Configuration.getConfigurationDirectory());
                if (!directory.exists()) directory.mkdir();
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(new Gson().toJson(configuration)
                    .replaceAll("\\{", "{\n")
                    .replaceAll("\\}", "\n}")
                    .replaceAll(",", ",\n")
            );
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
