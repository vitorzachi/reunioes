package br.com.camtwo.reunioes.config.springdata;

import br.com.camtwo.reunioes.model.basic.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Vitor Zachi Junior
 * @since 09/02/16
 */
@NoRepositoryBean
public interface DefaultRepository<T> extends JpaRepository<T, Id>, JpaSpecificationExecutor<T> {
}
