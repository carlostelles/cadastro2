package xyz.carlostelles.cadastro.business.validation.unit;

import java.util.List;

public interface ValidationUnit<T> {

    String VIOLATION_CREATE_ID_MESSAGE = "O ID deve ser nulo";
    String VIOLATION_UPDATE_ID_MESSAGE = "O ID não pode ser nulo e já deve estar registrado";
    String VIOLATION_TEXT_MESSAGE = "O campo %s não podem ser nulo ou vazio";

    List<String> validateCreate(T entity);

    List<String> validateUpdate(T entity);
}
