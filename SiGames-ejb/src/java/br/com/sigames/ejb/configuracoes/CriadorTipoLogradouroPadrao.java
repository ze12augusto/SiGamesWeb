package br.com.sigames.ejb.configuracoes;

import br.com.sigames.ejb.Ejb.TipoLogradouroEJB;
import br.com.sigames.ejb.entidades.TipoLogradouro;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */

@Named("criadorTipoLogradouroPadrao")
@RequestScoped
public class CriadorTipoLogradouroPadrao {

    @EJB
    private TipoLogradouroEJB tlEJB;
    private List<TipoLogradouro> tiposLogradouro;

    private void salvarTipoLogradouro(String descricao) {

        String erro = tlEJB.salvar(descricao);

        if (erro == null) {

            System.out.println("tipo logradouro salvo -> " + descricao);

        } else {

            System.out.println("Erro ao salvar tipo logradouro -> " + descricao);
        }
    }

    public void criadorTipoLogradouro() {

        tiposLogradouro = tlEJB.listarTipoLogradouro();

        if (tiposLogradouro.isEmpty()) {
           
            salvarTipoLogradouro("Rua");
            salvarTipoLogradouro("Avenida");
        }
    }

}

