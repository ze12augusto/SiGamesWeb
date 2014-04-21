package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.TipoLogradouro;
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
public class TipoLogradouroEJB {

    @PersistenceContext
    private EntityManager em;

    public String salvar(String descricao) {

        TipoLogradouro tl = new TipoLogradouro();
        tl.setDescricao(descricao);
        tl.setIdLogradouro(Short.MIN_VALUE);

        try {

            em.merge(tl);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public TipoLogradouro recuperaTipoLogradouro(){
    
    TypedQuery<TipoLogradouro> tipoLogradouroQuery
                = em.createQuery("select tl from TipoLogradouro as tl where tl.descricao = 'Rua'",
                       TipoLogradouro.class);

        return tipoLogradouroQuery.getSingleResult();
    }
    
    public List<TipoLogradouro> listarTipoLogradouro(){
    
         TypedQuery<TipoLogradouro> tipoLogradouroQuery
                = em.createQuery("select tl from TipoLogradouro as tl",
                       TipoLogradouro.class);

        return tipoLogradouroQuery.getResultList();
    }
}
