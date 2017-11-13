package br.com.jp.service.impl;

import br.com.jp.domain.Pojo;
import br.com.jp.exceptions.EntityInvalidException;
import br.com.jp.repository.PojoRepository;
import br.com.jp.service.PojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JP on 10/10/17.
 */
@Service
public class PojoServiceImpl extends GenericServiceImpl<Pojo, Long> implements PojoService {

    @Autowired
    private PojoRepository repository;

    @Override
    public Pojo save(Pojo entity) {
        validateEntityNotNull(entity);
        validateUniqueNome(entity.getNome());

        return repository.save(entity);
    }

    private void validateUniqueNome(String nome) {

        Pojo pojo = repository.findByNome(nome);
        if (pojo != null)
            throw new EntityInvalidException(messageService.get("pojo.nome.repetido"));
    }
}

