package xyz.carlostelles.cadastro.business.validation;

public interface ValidationSuite<E> {
    void validateToCreate(E entity);
    void validateToUpdate(E entity);
}
