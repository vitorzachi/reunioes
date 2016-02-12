package br.com.camtwo.reunioes.model.basic;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by vitor on 27/01/16.
 */
@lombok.Data
@AllArgsConstructor
public class Data implements Serializable {
    private LocalDate valor;
}
