package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Cliente;
import br.com.sigames.ejb.entidades.Endereco;
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
public class EnderecoEJB {

    @PersistenceContext
    private EntityManager em;
    private List<Endereco> enderecos;

    public String salvar(Endereco endereco) {

        try {

            em.merge(endereco);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    private String remover(Integer idEndereco) {
        try {

            em.remove(em.find(Endereco.class, idEndereco));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public void recuperaEnderecoPorIdPessoa(Integer idPessoa) {

        TypedQuery<Endereco> enderecoQuery
                = em.createQuery("select e from Endereco as e where e.pessoa.idPessoa = :idPessoa",
                        Endereco.class).setParameter("idPessoa", idPessoa);
        enderecos = new ArrayList<>();
        enderecos = enderecoQuery.getResultList();

        for (Endereco endereco : enderecos) {

            remover(endereco.getIdEndereco());
        }

    }

    public List<Endereco> listarEnderecos() {

        TypedQuery<Endereco> enderecoQuery
                = em.createQuery("select e from Endereco as e",
                        Endereco.class);

        return enderecoQuery.getResultList();
    }
}
