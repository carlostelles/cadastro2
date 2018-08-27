package xyz.carlostelles.cadastro.web.converter;

import org.springframework.stereotype.Component;
import xyz.carlostelles.cadastro.business.data.Risco;
import xyz.carlostelles.cadastro.persistence.Pessoa;
import xyz.carlostelles.cadastro.web.domain.PessoaViewBean;

@Component
public class PessoaConverter extends Converter<Pessoa, PessoaViewBean> {

    public PessoaViewBean encode(Pessoa entity) {
        PessoaViewBean viewBean = new PessoaViewBean();
        viewBean.setId(entity.getId());
        viewBean.setNome(entity.getNome());
        viewBean.setRisco(entity.getRisco());
        viewBean.setLimiteCredito(entity.getLimiteCredito());
        viewBean.setTaxaJuros(entity.getTaxaJuros());

        return viewBean;
    }

    public Pessoa decode(PessoaViewBean viewBean) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(viewBean.getId());
        pessoa.setNome(viewBean.getNome());
        pessoa.setLimiteCredito(viewBean.getLimiteCredito());
        pessoa.setRisco(viewBean.getRisco());
        pessoa.setTaxaJuros(Risco.valueOf(viewBean.getRisco()).getPerc());

        return pessoa;
    }
}
