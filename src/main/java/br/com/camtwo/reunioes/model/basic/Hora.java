package br.com.camtwo.reunioes.model.basic;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by vitor on 27/01/16.
 */
@lombok.Data
@AllArgsConstructor
public class Hora  implements Serializable {
    private LocalTime valor;
}
