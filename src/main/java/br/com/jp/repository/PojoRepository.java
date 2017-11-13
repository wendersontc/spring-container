package br.com.jp.repository;

import br.com.jp.domain.Pojo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JP on 10/10/17.
 */
public interface PojoRepository extends JpaRepository<Pojo, Long> {

    Pojo findByNome(String nome);
}