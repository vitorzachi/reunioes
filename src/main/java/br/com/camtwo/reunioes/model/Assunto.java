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
@Table(name = "ASSUNTO")
public class Assunto implements Comparable<Assunto> , Serializable{

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    @Column
    private Hora duracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoassunto", nullable = false)
    private TipoAssunto tipoAssunto;

    @Column(length = 1000, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idlocutor", foreignKey = @ForeignKey(name = "fk_assunto_locutor"))
    private Pessoa locutor;

    @ManyToOne
    @JoinColumn(name = "idpauta", foreignKey = @ForeignKey(name = "fk_assunto_pauta"), nullable = false)
    private Pauta pauta;

    @Column
    private int ordem;

    @ManyToOne
    @JoinColumn(name = "idcriador", foreignKey = @ForeignKey(name = "fk_assunto_criador"), nullable = false, updatable = false)
    private Pessoa criador;

    @OneToOne
    @JoinColumn(name = "idassuntopai", foreignKey = @ForeignKey(name = "fk_assunto_assuntopai"))
    private Assunto assuntoPai;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;

    public boolean isMovido(){
        return assuntoPai!=null;
    }

    public int compareTo(Assunto o) {
        return Integer.valueOf(ordem).compareTo(Integer.valueOf(o.ordem));
    }
}
