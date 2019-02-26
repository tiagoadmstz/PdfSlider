/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.services;

import br.com.pdfslider.enumerated.MESSAGE;
import br.com.pdfslider.frames.Form_Slider;
import br.com.pdfslider.util.MessageFactory;
import br.com.pdfslider.util.PdfFilter;
import br.com.pdfslider.util.TimeUtil;
import br.com.pdfslider.util.Utilidades;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * Classe de serivço do formulário de exibição
 *
 */
public final class Service_Slider {

    //varíavel que controla o loop de arquivo
    private boolean stop = false;
    private boolean pause = false;
    private final List<ImageIcon> paginas;
    private final Map<String, Thread> sistemas;

    public Service_Slider() {
        paginas = new ArrayList();
        sistemas = new HashMap();
    }

    /**
     * Pega lista de arquivo dentro da pasta indicada no arquivo de configuração
     *
     * @return List com path dos arquivos
     */
    public List<String> getFiles() {
        List<String> lista = new ArrayList();
        try {
            File dir = new File(Utilidades.getConfiguration().get("arquivos"));
            Arrays.asList(dir.listFiles(new PdfFilter())).forEach(f -> lista.add(f.getPath()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void iniciarSistema(JLabel viewer, JLabel lbPaginas, List<String> paths, String loopArquivo) {
        sistemas.put("mostrarPaginas", mostrarPaginas(viewer, lbPaginas, paths, loopArquivo));
        sistemas.get("mostrarPaginas").start();
    }

    public void play(JButton button) {
        sistemas.forEach((k, v) -> v.resume());
        button.setIcon(new ImageIcon(getClass().getResource("/br/com/pdfslider/img/pause.png")));
        button.setActionCommand("pausar");
    }

    public void pause(JButton button) {
        sistemas.forEach((k, v) -> v.suspend());
        button.setIcon(new ImageIcon(getClass().getResource("/br/com/pdfslider/img/play-button.png")));
        button.setActionCommand("play");
    }

    public void anterior(JLabel viewer, JLabel lbPaginas) {
        ImageIcon atual = (ImageIcon) viewer.getIcon();
        for (int p = 0; p < paginas.size(); p++) {
            if (paginas.get(p).equals(atual)) {
                if (p > 0) {
                    ImageIcon img = paginas.get(p - 1);
                    viewer.setIcon(img);
                    setLbPaginas(lbPaginas, String.valueOf(p), String.valueOf(paginas.size()));
                } else {
                    //MessageFactory.getInformationMessage(MESSAGE.ULTIMO_ARQUIVO, viewer);
                }
            }
        }
    }

    public void proxima(JLabel viewer, JLabel lbPaginas) {
        ImageIcon atual = (ImageIcon) viewer.getIcon();
        for (int p = 0; p < paginas.size(); p++) {
            if (paginas.get(p).equals(atual)) {
                if (p < (paginas.size() - 1)) {
                    ImageIcon img = paginas.get(p + 1);
                    viewer.setIcon(img);
                    setLbPaginas(lbPaginas, String.valueOf(p + 2), String.valueOf(paginas.size()));
                } else {
                    //MessageFactory.getInformationMessage(MESSAGE.ULTIMO_ARQUIVO, viewer);
                }
            }
        }
    }

    public Thread mostrarPaginas(JLabel viewer, JLabel lbPaginas, List<String> paths, String loopArquivo) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                boolean continuar = Boolean.valueOf(loopArquivo);
                Thread t = passarArquivo(viewer, lbPaginas, paths, TimeUtil.stringToMillis(Utilidades.getConfiguration().get("tempoArquivo")), continuar);
                sistemas.put("passarArquivo", t);
                t.start();
            }
        });
    }

    public Thread passarArquivo(JLabel label, JLabel lbPaginas, List<String> paths, long tempoArquivo, boolean continuar) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (continuar) {
                        for (String path : paths) {
                            paginas.clear();
                            paginas.addAll(pdfPagesToImages(path));
                            setLbPaginas(lbPaginas, "0", String.valueOf(paginas.size()));
                            Thread t = passarPagina(label, lbPaginas, paginas, TimeUtil.stringToMillis(Utilidades.getConfiguration().get("tempoPagina")));
                            sistemas.put("passarPaginas", t);
                            t.start();
                            Thread.sleep(tempoArquivo);
                            label.setIcon(null);
                            setLbPaginas(lbPaginas, String.valueOf(0), String.valueOf(0));
                            t.interrupt();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void setLbPaginas(JLabel lbPaginas, String paginaAtual, String totalPaginas) {
        String text = "<html><b>Páginas</b><br/><p><atual>/<total></p></html>";
        lbPaginas.setText(text.replace("<atual>", paginaAtual).replace("<total>", totalPaginas));
    }

    public Thread passarPagina(JLabel label, JLabel lbPaginas, List<ImageIcon> paginas, long tempoPagina) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        for (ImageIcon pagina : paginas) {
                            setLbPaginas(lbPaginas, String.valueOf(paginas.indexOf(pagina) + 1), String.valueOf(paginas.size()));
                            label.setIcon(pagina);
                            Thread.sleep(tempoPagina);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * Faz a apresentação do arquivo no formulário página a página
     *
     * @param viewer JLabel onde a página será visualizada
     * @param paths List com paths dos arquivos
     * @param loopArquivo
     * @return
     */
    public void mostrarArquivo(JLabel viewer, List<String> paths, String loopArquivo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int cont = 1;
                //inicia um loop infinito
                while (cont == 1) {
                    //inicia um loop para cada arquivo na pasta
                    for (String path : paths) {
                        //pega as imagens das páginas do arquivo atual
                        List<ImageIcon> paginas = pdfPagesToImages(path);
                        try {
                            //pega o tempo que a página ficará em exibição
                            long tempoPagina = TimeUtil.stringToMillis(Utilidades.getConfiguration().get("tempoPagina"));
                            //inicia o cronômetro para encerrar a exibição do arquivo
                            TimeUtil.stopService(TimeUtil.stringToMillis(Utilidades.getConfiguration().get("tempoArquivo")), Service_Slider.this);
                            //inicia loop de exibição das páginas
                            while (!stop) {
                                for (ImageIcon pg : paginas) {
                                    while (pause) {
                                    }
                                    //exibe a página no label
                                    viewer.setIcon(pg);
                                    //pausa a pilha com o tempo da página
                                    Thread.sleep(tempoPagina);
                                }
                            }
                            //tira a última página de exibição
                            viewer.setIcon(null);
                            //reinia a variável de controle de arquivo
                            toogleStop();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    //encerra o loop infinito caso o usuário tenha selecionado como false
                    cont = Boolean.valueOf(loopArquivo) ? 1 : 0;
                }
            }
        }).start();
    }

    public void pausarSlider() {
        pause = !pause;
    }

    /**
     * Transforma as páginas de um arquivo pdf em uma lista de imagens em
     * memória.
     *
     * @param pdfPath string com o caminho para o arquivo
     * @return List com imagens das páginas do arquivo
     */
    public List<ImageIcon> pdfPagesToImages(String pdfPath) {
        List<ImageIcon> lista = new ArrayList();
        try {
            File f = new File(pdfPath);
            PDDocument document = PDDocument.load(f);
            List<PDPage> pages = document.getDocumentCatalog().getAllPages();
            for (PDPage pg : pages) {
                BufferedImage bff = pg.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
                Image img = Toolkit.getDefaultToolkit().createImage(bff.getSource());
                Map<String, String> map = Utilidades.getConfiguration();
                lista.add(new ImageIcon(img.getScaledInstance(Integer.valueOf(map.get("comprimento")),
                        Integer.valueOf(map.get("altura")), Image.SCALE_DEFAULT)));
            }
            document.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Método que alterna valor da variável de controle de arquivo
     */
    public void toogleStop() {
        stop = !stop;
    }

}
