package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author joseaugusto
 */
@Stateless
public class ProdutoEJB {

    @PersistenceContext
    private EntityManager em;
    private List<Produto> produtos;

    public String salvar(Produto produto) {

        try {

            em.merge(produto);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    private String remover(Integer idProduto) {
        try {

            em.remove(em.find(Produto.class, idProduto));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public void recuperaIdProduto(Integer idProduto) {

        TypedQuery<Produto> produtoQuery
                = em.createQuery("select t from Produto t where t.idProduto = :idProduto",
                        Produto.class).setParameter("idProduto", idProduto);

        produtos = new ArrayList<>();
        produtos = produtoQuery.getResultList();

        for (Produto produto : produtos) {

            remover(produto.getIdProduto());
        }
    }

    public List<Produto> listarProduto() {

        TypedQuery<Produto> produtoQuery
                = em.createQuery("select p from Produto as p",
                        Produto.class);

        return produtoQuery.getResultList();
    }
}
