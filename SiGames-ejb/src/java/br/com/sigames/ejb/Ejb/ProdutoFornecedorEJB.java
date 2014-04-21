package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.ProdutoFornecedor;
import br.com.sigames.ejb.entidades.ProdutoFornecedorPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author joseaugusto
 */
@Stateless
public class ProdutoFornecedorEJB {

@PersistenceContext
    private EntityManager em;
 private List<ProdutoFornecedor> produtoFornecedores;

    public String salvar(ProdutoFornecedor produtoFornecedor) {

        try {

            em.merge(produtoFornecedor);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    private String remover(ProdutoFornecedorPK pk) {
        try {

            em.remove(em.find(ProdutoFornecedor.class, pk));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public void recuperaIdProdutoFornecedorPorIdFornecedor(Integer idPessoa){
    
         TypedQuery<ProdutoFornecedor> produtoFornecedorQuery
                = em.createQuery("select t from ProdutoFornecedor t where t.fornecedor.idPessoa = :idPessoa", 
                        ProdutoFornecedor.class);
         produtoFornecedorQuery.setParameter("idPessoa", idPessoa);
         
         produtoFornecedores = new ArrayList<>();
         produtoFornecedores = produtoFornecedorQuery.getResultList();
         
         for(ProdutoFornecedor produtoFornecedor : produtoFornecedores){
         
             remover(produtoFornecedor.getProdutoFornecedorPK());
         }
    }
    
      public void recuperaIdProdutoFornecedorPorIdProduto(Integer idProduto){
    
         TypedQuery<ProdutoFornecedor> produtoFornecedorQuery
                = em.createQuery("select t from ProdutoFornecedor t where t.produto.idProduto = :idProduto", 
                        ProdutoFornecedor.class);
         produtoFornecedorQuery.setParameter("idProduto", idProduto);
         
         produtoFornecedores = new ArrayList<>();
         produtoFornecedores = produtoFornecedorQuery.getResultList();
         
         for(ProdutoFornecedor produtoFornecedor : produtoFornecedores){
         
             remover(produtoFornecedor.getProdutoFornecedorPK());
         }
    }
    
    
    public List<ProdutoFornecedor> listarProdutoFornecedor(){
    
         TypedQuery<ProdutoFornecedor> produtoFornecedorQuery
                = em.createQuery("select t from ProdutoFornecedor t inner join t.produto p",
                        ProdutoFornecedor.class);

        return produtoFornecedorQuery.getResultList();
    }
}