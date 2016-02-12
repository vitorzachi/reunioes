package br.com.camtwo.reunioes.model.basic;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by vitor on 27/01/16.
 */
@lombok.Data
@AllArgsConstructor
public class DataHora  implements Serializable {
    private LocalDateTime valor;
}
