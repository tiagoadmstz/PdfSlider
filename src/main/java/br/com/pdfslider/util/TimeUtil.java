/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdfslider.util;

import br.com.pdfslider.services.Service_Slider;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;


public class TimeUtil {

    /**
     * Transforma uma string com o formato 00h00m00s em um LocalTime
     *
     * @param time String com horário a transformar
     * @return LocalTime
     */
    public static LocalTime stringToLocalTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH'h'mm'm'ss's'"));
    }

    /**
     * Transforma um LocalTime em milisegundos
     *
     * @param localTime LocalTime a ser transformado
     * @return long com milisegundos
     */
    public static long localtimeToMillis(LocalTime localTime) {
        return Instant.ofEpochSecond(0, localTime.toNanoOfDay()).toEpochMilli();
    }

    /**
     * Transforma uma string com o formato 00h00m00s em milisegundos
     *
     * @param time String com horário a transformar
     * @return long com milisegundos
     */
    public static long stringToMillis(String time) {
        return localtimeToMillis(stringToLocalTime(time));
    }

    /**
     * Cronômetro que interrompe a execução da pilha que exibe as páginas.
     *
     * @param millis tempo de exibição do arquivo
     * @param service classe de serviço do slider
     */
    public static void stopService(long millis, Service_Slider service) {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                service.toogleStop();
            }
        };
        t.schedule(task, millis);
    }

}
