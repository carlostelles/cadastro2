package xyz.carlostelles.cadastro.business.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.carlostelles.cadastro.business.validation.unit.PessoaValidator;
import xyz.carlostelles.cadastro.persistence.Pessoa;

@Component
public class PessoaValidationSuite extends ValidationGenericSuite<Pessoa, PessoaValidator>
        implements ValidationSuite<Pessoa> {

    @Autowired
    public PessoaValidationSuite(PessoaValidator validator) {
        super(validator);
    }
}
