/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import br.com.pdfslider.enumerated.MESSAGE;
import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageFactory {

    /**
     * Mostra uma tela de pergunta para o usuário com opções sim e não.
     *
     * @param parent component que está mostrando a mensagem
     * @param msg pergunta que será realizada
     * @param title título da tela de pergunta
     * @return boolean com resposta do usuário
     */
    public static boolean getQuestionMessage(Component parent, String msg, String title) {
        return JOptionPane.showConfirmDialog(parent, msg, title, JOptionPane.YES_NO_OPTION) == 0;
    }

    public static void getInformationMessage(MESSAGE msg, Component parent) {
        switch (msg) {
            case ULTIMO_ARQUIVO:
                JOptionPane.showMessageDialog(parent, "Você chegou ao último arquivo", "Fim do cursor", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
