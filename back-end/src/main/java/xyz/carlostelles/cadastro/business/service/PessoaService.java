package xyz.carlostelles.cadastro.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.carlostelles.cadastro.business.validation.PessoaValidationSuite;
import xyz.carlostelles.cadastro.persistence.Pessoa;
import xyz.carlostelles.cadastro.persistence.PessoaRepository;

@Service
public class PessoaService extends GenericService<Pessoa, PessoaRepository, PessoaValidationSuite> {

    @Autowired
    public PessoaService(PessoaRepository repository, PessoaValidationSuite validator) {
        super(repository, validator);
    }
}
