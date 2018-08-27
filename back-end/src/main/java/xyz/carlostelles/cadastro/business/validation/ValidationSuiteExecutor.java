package xyz.carlostelles.cadastro.business.validation;

import xyz.carlostelles.cadastro.business.validation.unit.ValidationUnit;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidationSuiteExecutor {

    private static final String ERROR_ON_CREATE_A_ENTITY = "Error on create a %s Entity: ";
    private static final String ERROR_ON_UPDATE_A_ENTITY = "Error on update a %s Entity: ";

    public <E> void runUnitsCreate(List<ValidationUnit<E>> units, E entity) {
        List<String> violations = units.stream()
                .map(unit -> unit.validateCreate(entity))
                .filter(item -> !item.isEmpty())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!violations.isEmpty()) {
            throw new ValidationException(String.format(ERROR_ON_CREATE_A_ENTITY, entity.getClass().getName()), violations);
        }
    }

    public <E> void runUnitsUpdate(List<ValidationUnit<E>> units, E entity) {
        List<String> violations = units.stream()
                .map(unit -> unit.validateUpdate(entity))
                .filter(item -> !item.isEmpty())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!violations.isEmpty()) {
            throw new ValidationException(String.format(ERROR_ON_UPDATE_A_ENTITY, entity.getClass().getName()), violations);
        }
    }
}
