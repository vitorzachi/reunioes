package br.com.camtwo.reunioes.model;

import br.com.camtwo.reunioes.model.basic.Hora;
import br.com.camtwo.reunioes.model.basic.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vitor on 27/01/16.
 */
@Data
@Entity
@Table(name = "DECISAO")
public class Decisao  implements Serializable {

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    private Hora duracao;

    @ManyToOne
    @JoinColumn(name = "idassunto", foreignKey = @ForeignKey(name = "fk_decisao_assunto"), nullable = false)
    private Assunto assunto;

    @ManyToOne
    @JoinColumn(name = "idreuniao", foreignKey = @ForeignKey(name = "fk_decisao_reuniao"), nullable = false)
    private Reuniao reuniao;

    @Column(length = 1000, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idcriador", foreignKey = @ForeignKey(name = "fk_decisao_criador"), nullable = false, updatable = false)
    private Pessoa criador;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;
}
