/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.frames;

import br.com.pdfslider.listeners.Listener_Configuration;
import br.com.pdfslider.models.Configuration;
import br.com.pdfslider.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;


public final class Form_Configuration extends javax.swing.JFrame {

    private static final long serialVersionUID = -832090216053766349L;
    private final Listener_Configuration listener;

    /**
     * Creates new form Form_Configuration
     */
    public Form_Configuration() {
        setImageIcon();
        initComponents();
        listener = new Listener_Configuration(this);
    }

    public void setImageIcon() {
        Utilidades.setImageIcon(this);
    }

    public List<AbstractButton> getButtonsList() {
        return Arrays.asList(btRestore, btCancelar, btConfirmar, btDefault, btSelecionarIcone, btSelecionarPasta, itemFechar);
    }

    public JMenuItem getItemFechar() {
        return itemFechar;
    }

    public Configuration getConfiguration() {
        return Configuration.builder()
                .altura("".equals(txtAltura.getText()) ? 800 : Integer.parseInt(txtAltura.getText()))
                .comprimento("".equals(txtComprimento.getText()) ? 600 : Integer.parseInt(txtComprimento.getText()))
                .icone(txtIconeSistema.getText())
                .arquivos(txtPastaArquivo.getText())
                .tempoArquivo(txtTempoArquivo.getText())
                .tempoPagina(txtTempoPagina.getText())
                .loopArquivos(ckLoopArquivo.isSelected())
                .build();
    }

    public void setConfiguration(Configuration configuration) {
        txtAltura.setText(configuration.getAltura().toString());
        txtComprimento.setText(configuration.getComprimento().toString());
        txtIconeSistema.setText(configuration.getIcone());
        txtPastaArquivo.setText(configuration.getArquivos());
        txtTempoArquivo.setText(configuration.getTempoArquivo());
        txtTempoPagina.setText(configuration.getTempoPagina());
        ckLoopArquivo.setSelected(configuration.getLoopArquivos());
    }

    public void setAlturaComprimento(Dimension dimension) {
        txtAltura.setText(String.valueOf(dimension.height));
        txtComprimento.setText(String.valueOf(dimension.width));
    }

    public void setIconeSistema(String iconeSistema) {
        txtIconeSistema.setText(iconeSistema);
    }

    public void setPastaArquivos(String pastaArquivos) {
        txtPastaArquivo.setText(pastaArquivos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMain = new javax.swing.JPanel();
        painelArquivos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIconeSistema = new javax.swing.JTextField();
        btSelecionarIcone = new javax.swing.JButton();
        txtPastaArquivo = new javax.swing.JTextField();
        btSelecionarPasta = new javax.swing.JButton();
        separador1 = new javax.swing.JSeparator();
        painelTempo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTempoArquivo = new javax.swing.JTextField();
        txtTempoPagina = new javax.swing.JTextField();
        painelExibicao = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ckLoopArquivo = new javax.swing.JCheckBox();
        txtComprimento = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        btDefault = new javax.swing.JButton();
        separador2 = new javax.swing.JSeparator();
        btRestore = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuração de Sistema");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Ícone do Sistema");

        jLabel2.setText("Pasta de Arquivos");

        btSelecionarIcone.setText("Selecionar");
        btSelecionarIcone.setActionCommand("selecionarIcone");

        btSelecionarPasta.setText("Selecionar");
        btSelecionarPasta.setActionCommand("selecionarPasta");

        javax.swing.GroupLayout painelArquivosLayout = new javax.swing.GroupLayout(painelArquivos);
        painelArquivos.setLayout(painelArquivosLayout);
        painelArquivosLayout.setHorizontalGroup(
                painelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelArquivosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelArquivosLayout.createSequentialGroup()
                                                .addComponent(txtPastaArquivo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btSelecionarPasta))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelArquivosLayout.createSequentialGroup()
                                                .addComponent(txtIconeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btSelecionarIcone)))
                                .addContainerGap())
        );
        painelArquivosLayout.setVerticalGroup(
                painelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelArquivosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtIconeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btSelecionarIcone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtPastaArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btSelecionarPasta))
                                .addContainerGap())
        );

        painelTempo.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração de Transição"));

        jLabel4.setText("Tempo de Página");

        jLabel3.setText("Tempo de Arquivo");

        javax.swing.GroupLayout painelTempoLayout = new javax.swing.GroupLayout(painelTempo);
        painelTempo.setLayout(painelTempoLayout);
        painelTempoLayout.setHorizontalGroup(
                painelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelTempoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTempoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTempoPagina)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        painelTempoLayout.setVerticalGroup(
                painelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelTempoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(painelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(painelTempoLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTempoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(painelTempoLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTempoPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11))
        );

        painelExibicao.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração de Exibição"));

        jLabel6.setText("Altura");

        jLabel5.setText("Comprimento");

        ckLoopArquivo.setText("Loop de Arquivo");

        btDefault.setText("Default");
        btDefault.setActionCommand("defaultExibicao");

        javax.swing.GroupLayout painelExibicaoLayout = new javax.swing.GroupLayout(painelExibicao);
        painelExibicao.setLayout(painelExibicaoLayout);
        painelExibicaoLayout.setHorizontalGroup(
                painelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelExibicaoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ckLoopArquivo)
                                        .addGroup(painelExibicaoLayout.createSequentialGroup()
                                                .addGroup(painelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtComprimento)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(painelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtAltura)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btDefault)))
                                .addContainerGap())
        );
        painelExibicaoLayout.setVerticalGroup(
                painelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelExibicaoLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(ckLoopArquivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelExibicaoLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtComprimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(painelExibicaoLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btDefault, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );

        btRestore.setText("Restaurar");
        btRestore.setActionCommand("restore");
        btRestore.setMaximumSize(new java.awt.Dimension(95, 23));
        btRestore.setMinimumSize(new java.awt.Dimension(95, 23));
        btRestore.setPreferredSize(new java.awt.Dimension(95, 23));

        btConfirmar.setText("Confirmar");
        btConfirmar.setActionCommand("confirmar");
        btConfirmar.setMaximumSize(new java.awt.Dimension(95, 23));
        btConfirmar.setMinimumSize(new java.awt.Dimension(95, 23));
        btConfirmar.setPreferredSize(new java.awt.Dimension(95, 23));

        btCancelar.setText("Cancelar");
        btCancelar.setActionCommand("cancelar");
        btCancelar.setMaximumSize(new java.awt.Dimension(95, 23));
        btCancelar.setMinimumSize(new java.awt.Dimension(95, 23));
        btCancelar.setPreferredSize(new java.awt.Dimension(95, 23));

        javax.swing.GroupLayout painelMainLayout = new javax.swing.GroupLayout(painelMain);
        painelMain.setLayout(painelMainLayout);
        painelMainLayout.setHorizontalGroup(
                painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(separador1)
                                        .addComponent(separador2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMainLayout.createSequentialGroup()
                                                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(painelTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btRestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMainLayout.createSequentialGroup()
                                                                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(painelExibicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(painelArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        painelMainLayout.setVerticalGroup(
                painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(painelArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(painelExibicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(painelTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btRestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        menuBar.setMinimumSize(new java.awt.Dimension(0, 0));
        menuBar.setPreferredSize(new java.awt.Dimension(0, 0));

        menuArquivo.setText("Arquivo");

        itemFechar.setText("Fechar");
        itemFechar.setActionCommand("fechar");
        menuArquivo.add(itemFechar);

        menuBar.add(menuArquivo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(painelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btDefault;
    private javax.swing.JButton btRestore;
    private javax.swing.JButton btSelecionarIcone;
    private javax.swing.JButton btSelecionarPasta;
    private javax.swing.JCheckBox ckLoopArquivo;
    private javax.swing.JMenuItem itemFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel painelArquivos;
    private javax.swing.JPanel painelExibicao;
    private javax.swing.JPanel painelMain;
    private javax.swing.JPanel painelTempo;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtComprimento;
    private javax.swing.JTextField txtIconeSistema;
    private javax.swing.JTextField txtPastaArquivo;
    private javax.swing.JTextField txtTempoArquivo;
    private javax.swing.JTextField txtTempoPagina;
    // End of variables declaration//GEN-END:variables
}
