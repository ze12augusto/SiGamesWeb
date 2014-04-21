package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Uf;
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
public class UfEJB {

    @PersistenceContext
    private EntityManager em;

    public String salvar(String ufEstado, String Estado) {

        Uf uf = new Uf();
        uf.setUf(ufEstado);
        uf.setEstado(Estado);

        try {

            em.merge(uf);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public Uf recuperaUf(){
    
        TypedQuery<Uf> ufQuery
                = em.createQuery("select u from Uf as u where u.uf = 'MG'",
                        Uf.class);

        return ufQuery.getSingleResult();
    }
    
    public List<Uf> listarUf(){
    
         TypedQuery<Uf> ufQuery
                = em.createQuery("select u from Uf as u",
                        Uf.class);

        return ufQuery.getResultList();
    }
}
