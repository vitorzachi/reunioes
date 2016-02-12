package br.com.camtwo.reunioes.model;

import br.com.camtwo.reunioes.model.basic.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by vitor on 27/01/16.
 */
@Data
@Entity
@Table(name = "GRUPO")
public class Grupo  implements Serializable {

    @javax.persistence.Id
    @EmbeddedId
    @GeneratedValue
    private Id id;

    @Column(length = 150, nullable =false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idadmin", foreignKey = @ForeignKey(name = "fk_grupo_admin"), nullable = false)
    @NotNull(message = "grupo.admin.obrigatorio")
    private Pessoa admin;

    @Column(nullable = false)
    private boolean bloqueado;

    @OneToMany
    @JoinTable(name = "GRUPO_PESSOAS", joinColumns = @JoinColumn(name = "idgrupo"), inverseJoinColumns = @JoinColumn(name = "idpessoa"),
        foreignKey = @ForeignKey(name = "fk_grupopessoas_grupo"), inverseForeignKey = @ForeignKey(name = "fk_grupopessoas_pessoa"))
    private Set<Pessoa> pessoas;

    @Version
    @Setter(AccessLevel.PROTECTED)
    private long version;
}
