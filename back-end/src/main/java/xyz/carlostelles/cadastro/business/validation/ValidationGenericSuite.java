package xyz.carlostelles.cadastro.business.validation;

import xyz.carlostelles.cadastro.business.validation.unit.ValidationUnit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class ValidationGenericSuite<E, V extends ValidationUnit<E>> implements ValidationSuite<E>{
    private final V validator;

    @Autowired
    private ValidationSuiteExecutor executor;

    ValidationGenericSuite(V validator) {
        this.validator = validator;
    }

    public void validateToCreate(E entity) {
        List<ValidationUnit<E>> units = Collections.singletonList(validator);

        executor.runUnitsCreate(units, entity);
    }

    public void validateToUpdate(E entity) {
        List<ValidationUnit<E>> units = Collections.singletonList(validator);

        executor.runUnitsUpdate(units, entity);
    }
}
