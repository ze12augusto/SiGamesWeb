package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Fornecedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    public String salvar(Fornecedor fornecedor) {

        try {

            em.merge(fornecedor);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public Fornecedor recuperaPorId(Integer id) {

        TypedQuery<Fornecedor> query
                = em.createQuery("select f from Fornecedor as f where f.idPessoa = :id",
                        Fornecedor.class);

        return query.setParameter("id", id).getSingleResult();
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
