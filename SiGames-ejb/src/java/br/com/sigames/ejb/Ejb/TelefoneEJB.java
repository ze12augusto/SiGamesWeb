package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.Telefone;
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
public class TelefoneEJB {

 @PersistenceContext
    private EntityManager em;
 private List<Telefone> telefones;

    public String salvar(Telefone telefone) {

        try {

            em.merge(telefone);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    private String remover(Integer idTelefone) {
        try {

            em.remove(em.find(Telefone.class, idTelefone));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public void recuperaIdTelefonePorIdPessoa(Integer idPessoa){
    
         TypedQuery<Telefone> telefoneQuery
                = em.createQuery("select t from Telefone as t where t.pessoa.idPessoa = :idPessoa",
                        Telefone.class).setParameter("idPessoa", idPessoa);
         
         telefones = new ArrayList<>();
         telefones = telefoneQuery.getResultList();
         
         for(Telefone telefone : telefones){
         
             remover(telefone.getIdTelefone());
         }
    }
    
    public List<Telefone> listarTelefone(){
    
         TypedQuery<Telefone> telefoneQuery
                = em.createQuery("select t from Telefone as t",
                        Telefone.class);

        return telefoneQuery.getResultList();
    }
}
