package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Fornecedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseaugusto
 */
@Stateless
public class FornecedorEJB {


    @PersistenceContext
    private EntityManager em;


    public String salvar(Integer idPessoa) {

        Fornecedor fornecedor = new Fornecedor(idPessoa);
        
        try {

            em.merge(fornecedor);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public String remover(Integer idFornecedor) {
        try {

            em.remove(em.find(Fornecedor.class, idFornecedor));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

}
