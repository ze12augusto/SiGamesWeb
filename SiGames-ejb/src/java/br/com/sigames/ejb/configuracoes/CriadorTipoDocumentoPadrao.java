package br.com.sigames.ejb.configuracoes;

import br.com.sigames.ejb.Ejb.TipoDocumentoEJB;
import br.com.sigames.ejb.entidades.TipoDocumento;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("criadorTipoDocumentoPadrao")
@RequestScoped
public class CriadorTipoDocumentoPadrao {

    @EJB
    private TipoDocumentoEJB tpEJB;
    private List<TipoDocumento> tiposDocumento;

    private void salvarTipoDocumento(String descricao) {

        String erro = tpEJB.salvar(descricao);

        if (erro == null) {

            System.out.println("tipo documento salvo -> " + descricao);

        } else {

            System.out.println("Erro ao salvar tipo documento -> " + descricao);
        }
    }

    public void criadorTipoDocumento() {

        tiposDocumento = tpEJB.listarTipoDocumento();

        if (tiposDocumento.isEmpty()) {
            salvarTipoDocumento("CPF");
            salvarTipoDocumento("RG");
            salvarTipoDocumento("CNPJ");
            salvarTipoDocumento("CNH");
            salvarTipoDocumento("Inscrição Estadual");
        }
    }

}
