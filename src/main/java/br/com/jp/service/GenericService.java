package br.com.jp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author JP on 10/10/17.
 */
public interface GenericService<T, ID> {

    List<T> findAll();
    T save(T entity);
    void update(T entity);
    void deleteById(ID id);
    T findById(ID id);
    Page<T> findAllPaginated(int var1, int var2, Sort.Direction var3, String var4);
}