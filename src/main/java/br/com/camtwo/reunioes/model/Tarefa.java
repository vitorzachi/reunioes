package br.com.camtwo.reunioes.model;

import br.com.camtwo.reunioes.model.basic.Data;
import br.com.camtwo.reunioes.model.basic.DataHora;
import br.com.camtwo.reunioes.model.basic.Id;
import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by vitor on 27/01/16.
 */
@lombok.Data
@Entity
@Table(name = "TAREFA")
public class Tarefa  implements Serializable {

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    @Column(name = "datahoracriacao")
    private DataHora dataHoraCriacao;

    @Column(name = "datadevida")
    private Data dataDevida;

    @Column(name = "datatermino")
    private Data dataTermino;

    @ManyToOne
    @JoinColumn(name = "idcriador", foreignKey = @ForeignKey(name = "fk_tarefa_criador"), nullable = false)
    @NotNull(message = "tarefa.criador.obrigatorio")
    private Pessoa criador;


    @ManyToOne
    @JoinColumn(name = "idatribuido", foreignKey = @ForeignKey(name = "fk_tarefa_atribuido"), nullable = false)
    @NotNull(message = "tarefa.atribuido.obrigatorio")
    private Pessoa atribuido;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;
}
