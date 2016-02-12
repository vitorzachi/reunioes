package br.com.camtwo.reunioes.model.basic;

import lombok.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Vitor Zachi Junior
 * @since 27/01/2016
 */
@Data
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Id  implements Serializable, Comparable<Id> {
    private Long id;

    @Override
    public int compareTo(Id o) {
        return Optional.ofNullable(id).orElse(0l).compareTo(o.getId());
    }
}
