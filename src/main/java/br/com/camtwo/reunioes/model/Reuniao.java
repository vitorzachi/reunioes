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
@Table(name = "REUNIAO")
public class Reuniao  implements Serializable {

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    @Column(name = "datahorainicio", nullable = false)
    private DataHora dataHoraInicio;

    @Column(name = "datahorafim")
    private DataHora dataHoraFim;

    @ManyToOne
    @JoinColumn(name = "idpauta", foreignKey = @ForeignKey(name = "fk_reuniao_pauta"), nullable = false, updatable = false)
    private Pauta pauta;

    @ManyToOne
    @JoinColumn(name = "idcriador", foreignKey = @ForeignKey(name = "fk_reuniao_criador"), nullable = false, updatable = false)
    private Pessoa criador;

    @OneToMany
    @JoinTable(name = "REUNIAO_PARTICIPANTES", joinColumns = @JoinColumn(name = "idreuniao"), inverseJoinColumns = @JoinColumn(name = "idpessoa"),
            foreignKey = @ForeignKey(name = "fk_reuniaoparticipantes_reuniao"), inverseForeignKey = @ForeignKey(name = "fk_reuniaoparticipantes_pessoa"))
    private Set<Pessoa> participantes;

    @OneToMany(mappedBy = "reuniao")
    private Set<Decisao> decisoes;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;
}
