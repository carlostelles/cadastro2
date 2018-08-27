package xyz.carlostelles.cadastro.business.validation.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

import xyz.carlostelles.cadastro.persistence.Pessoa;
import xyz.carlostelles.cadastro.persistence.PessoaRepository;

@Component
public class PessoaValidator implements ValidationUnit<Pessoa> {

    private final PessoaRepository repository;

    public PessoaValidator(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> validateCreate(Pessoa entity) {
        List<String> message = new ArrayList<>();

        this.validateIdCreate(entity, message);
        this.validateNome(entity, message);
        this.validadeRisco(entity, message);
        this.validadeLimiteCredito(entity, message);

        return message;
    }

    @Override
    public List<String> validateUpdate(Pessoa entity) {
        List<String> message = new ArrayList<>();

        this.validateIdUpdate(entity, message);
        this.validateNome(entity, message);
        this.validadeRisco(entity, message);
        this.validadeLimiteCredito(entity, message);

        return message;
    }

    private void validateIdUpdate(Pessoa entity, List<String> message) {
        if (Objects.isNull(entity.getId()) || !repository.existsById(entity.getId())) {
            message.add(VIOLATION_UPDATE_ID_MESSAGE);
        }
    }

    private void validateIdCreate(Pessoa entity, List<String> message) {
        if (Objects.nonNull(entity.getId())) {
            message.add(VIOLATION_CREATE_ID_MESSAGE);
        }
    }

    private void validateNome(Pessoa entity, List<String> message) {
        if (Objects.isNull(entity.getNome())) {
            message.add(String.format(VIOLATION_TEXT_MESSAGE, "Nome"));
        }
    }

    private void validadeRisco(Pessoa entity, List<String> message) {
        if (Objects.isNull(entity.getRisco())) {
            message.add(String.format(VIOLATION_TEXT_MESSAGE, "Risco"));
        }
    }

    private void validadeLimiteCredito(Pessoa entity, List<String> message) {
        if (Objects.isNull(entity.getLimiteCredito())) {
            message.add(String.format(VIOLATION_TEXT_MESSAGE, "Limite de Crédito"));
        }
    }
}
