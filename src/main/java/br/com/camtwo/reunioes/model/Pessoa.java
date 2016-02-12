package br.com.camtwo.reunioes.model;

import br.com.camtwo.reunioes.model.basic.Email;
import br.com.camtwo.reunioes.model.basic.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Vitor Zachi Junior
 * @since 27/01/2016
 */
@Data
@Entity
@Table(name = "PESSOA")
public class Pessoa  implements Serializable {

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Email email;

    @Column(updatable = false)
    private String senha;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;
}
