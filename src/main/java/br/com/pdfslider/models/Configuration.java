package br.com.pdfslider.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Configuration implements Serializable {

    private static final long serialVersionUID = -3917919574955370986L;
    private String icone = null;
    private String arquivos = null;
    private String tempoPagina = "00h00m10s";
    private String tempoArquivo = "00h01m00s";
    private String comprimento = "800";
    private String altura = "600";
    private Boolean loopArquivos = true;

}
