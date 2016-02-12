package br.com.camtwo.reunioes.model.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Vitor Zachi Junior
 * @since 27/01/2016
 */
@Data
@ToString(of = "valor")
@AllArgsConstructor
public class Email  implements Serializable {
    @org.hibernate.validator.constraints.Email(message = "erro.email.invalido")
    private String valor;
}
