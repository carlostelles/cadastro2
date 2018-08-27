package xyz.carlostelles.cadastro.business.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import xyz.carlostelles.cadastro.business.validation.ValidationSuite;

public class GenericService<E, R extends CrudRepository<E, Long>, V extends ValidationSuite<E>> {

    private final R repository;
    private final V validator;

    GenericService(R repository, V validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public R getRepository() {
        return repository;
    }

    public E create(E entity) {
        validator.validateToCreate(entity);

        return repository.save(entity);
    }

    public E update(E entity) {
        validator.validateToUpdate(entity);

        return repository.save(entity);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public List<E> get() {
        ArrayList<E> entities = new ArrayList<>();

        repository.findAll().forEach(entities::add);

        return entities;
    }

    public E get(Long id) {
        return repository.findById(id).get();
    }
}