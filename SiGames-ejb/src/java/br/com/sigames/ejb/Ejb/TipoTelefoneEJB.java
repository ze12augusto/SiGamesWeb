package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.TipoTelefone;
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
public class TipoTelefoneEJB {

    @PersistenceContext
    private EntityManager em;

    public String salvar(String descricao) {

        TipoTelefone tp = new TipoTelefone();
        
        tp.setIdTipoTelefone(Short.MIN_VALUE);
        tp.setDescricao(descricao);
                
        try {

            em.merge(tp);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public TipoTelefone recuperaTipoTelefone(){
    
     TypedQuery<TipoTelefone> tipoTelefoneQuery
                = em.createQuery("select t from TipoTelefone as t where t.descricao = 'Móvel'",
                        TipoTelefone.class);

        return tipoTelefoneQuery.getSingleResult();
    }
    
    public List<TipoTelefone> listarTiposTelefone(){
    
         TypedQuery<TipoTelefone> tipoTelefoneQuery
                = em.createQuery("select t from TipoTelefone as t",
                        TipoTelefone.class);

        return tipoTelefoneQuery.getResultList();
    }
}
