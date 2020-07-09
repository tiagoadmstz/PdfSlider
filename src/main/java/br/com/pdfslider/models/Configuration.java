package br.com.pdfslider.models;

import br.com.pdfslider.util.TimeUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Configuration implements Serializable {

    private static final long serialVersionUID = -3917919574955370986L;
    private String icone = null;
    private String arquivos = null;
    @SerializedName("tempo-pagina")
    private String tempoPagina = "00h00m10s";
    @SerializedName("tempo-arquivo")
    private String tempoArquivo = "00h01m00s";
    private Integer comprimento = 800;
    private Integer altura = 600;
    @SerializedName("loop-arquivos")
    private Boolean loopArquivos = true;
    @Builder.Default
    @SerializedName("image-dpi")
    private Integer dpi = 300;
    @Expose(serialize = false, deserialize = false)
    private static final String configurationFile = "/conf/configuration.json";
    @Expose(serialize = false, deserialize = false)
    private static final String configurationDirectory = "/conf";

    public Image getIconeSistema() {
        return new ImageIcon(icone).getImage();
    }

    public Long tempoArquivoToMillis() {
        return TimeUtil.stringToMillis(tempoArquivo);
    }

    public Long tempoPaginaToMillis() {
        return TimeUtil.stringToMillis(tempoPagina);
    }

    public File getDiretorioArquivos() {
        return new File(arquivos);
    }

    public static String getConfigurationFile() {
        return System.getProperty("user.dir").concat(configurationFile);
    }

    public static String getConfigurationDirectory() {
        return System.getProperty("user.dir").concat(configurationDirectory);
    }

}
