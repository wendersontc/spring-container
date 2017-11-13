package br.com.jp.service.impl;

import br.com.jp.exceptions.EntityInvalidException;
import br.com.jp.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;

/**
 * @author JP on 10/10/17.
 */
@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    public MessageService messageService;

    public GenericServiceImpl() {
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        validateEntityNotNull(entity);

        return repository.save(entity);
    }

    @Override
    public void update(T entity) {
        validateEntityNotNull(entity);

        repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {

        getOrValidateEntityById(id);
        repository.delete(id);
    }

    @Override
    public T findById(ID id) {
        return getOrValidateEntityById(id);
    }

    public Page<T> findAllPaginated(int page, int count, Sort.Direction direction, String sortProperty) {
        return this.repository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
    }

    protected void validateEntityNotNull(T entity) {
        if (entity == null)
            throw new EntityInvalidException(messageService.get("entidade.nulo"));
    }

    protected T getOrValidateEntityById(ID id) {
        if (id == null)
            throw new EntityInvalidException(messageService.get("id.nulo"));

        T entity = repository.findOne(id);
        if (entity == null)
            throw new EntityNotFoundException(messageService.get("entidade.nao.existe"));

        return entity;
    }
}

