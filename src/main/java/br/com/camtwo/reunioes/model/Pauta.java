package br.com.camtwo.reunioes.model;

import br.com.camtwo.reunioes.model.basic.DataHora;
import br.com.camtwo.reunioes.model.basic.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by vitor on 27/01/16.
 */
@Data
@Entity
@Table(name = "PAUTA")
public class Pauta  implements Serializable {

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    @Column(name = "datahora", nullable = false)
    private DataHora dataHora;

    @ManyToOne
    @JoinColumn(name = "idcriador", foreignKey = @ForeignKey(name = "fk_pauta_criador"), nullable = false, updatable = false)
    private Pessoa criador;

    @Column(length = 150, nullable = false)
    private String titulo;

    @Column(length = 500)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idgrupo", foreignKey = @ForeignKey(name = "fk_pauta_grupo"), nullable = false)
    private Grupo grupo;

    @Column(nullable = false)
    private boolean bloqueada;

    @OneToMany
    @JoinTable(name = "PAUTA_PARTICIPANTES", joinColumns = @JoinColumn(name = "idpauta"), inverseJoinColumns = @JoinColumn(name = "idpessoa"),
            foreignKey = @ForeignKey(name = "fk_pautaparticipantes_pauta"), inverseForeignKey = @ForeignKey(name = "fk_pautaparticipantes_pessoa"))
    private Set<Pessoa> participantes;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;
}
