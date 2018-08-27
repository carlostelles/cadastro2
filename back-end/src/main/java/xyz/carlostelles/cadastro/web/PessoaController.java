package xyz.carlostelles.cadastro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.carlostelles.cadastro.business.service.PessoaService;
import xyz.carlostelles.cadastro.business.validation.PessoaValidationSuite;
import xyz.carlostelles.cadastro.persistence.Pessoa;
import xyz.carlostelles.cadastro.persistence.PessoaRepository;
import xyz.carlostelles.cadastro.web.converter.PessoaConverter;
import xyz.carlostelles.cadastro.web.domain.PessoaViewBean;

@Component
@RestController
@CrossOrigin
@RequestMapping("/pessoa")
public class PessoaController extends CrudController<Pessoa, PessoaViewBean, PessoaConverter,
        PessoaRepository, PessoaValidationSuite, PessoaService> {

    @Autowired
    public PessoaController(PessoaService service, PessoaConverter converter) {
        super(service, converter);
    }

}