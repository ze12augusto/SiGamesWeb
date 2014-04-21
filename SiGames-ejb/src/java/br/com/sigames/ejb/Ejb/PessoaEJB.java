package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Pessoa;
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
public class PessoaEJB {

    @PersistenceContext
    private EntityManager em;

    public String salvar(Pessoa pessoa) {

        try {

            em.merge(pessoa);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public String remover(Integer idPessoa) {
        try {

            em.remove(em.find(Pessoa.class, idPessoa));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public Pessoa recuperaIdPessoaPorNome(String nome) {

        TypedQuery<Pessoa> pessoaQuery
                = em.createQuery("select p from Pessoa as p where p.nome = :nome",
                        Pessoa.class);

        return pessoaQuery.setParameter("nome", nome).getSingleResult();
    }

    public List<Pessoa> listarClientes() {

        TypedQuery<Pessoa> clienteQuery
                = em.createQuery("select p from Pessoa as p inner join p.cliente as c",
                        Pessoa.class);

        return clienteQuery.getResultList();
    }
    
    public List<Pessoa> listarFornecedores() {

        TypedQuery<Pessoa> fornecedorQuery
                = em.createQuery("select p from Pessoa as p inner join p.fornecedor as f",
                        Pessoa.class);

        return fornecedorQuery.getResultList();
    }

}
