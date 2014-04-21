package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.TipoDocumento;
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
public class TipoDocumentoEJB {

   @PersistenceContext
    private EntityManager em;

    public String salvar(String descricao) {

        TipoDocumento tp = new TipoDocumento();
        tp.setDescricao(descricao);
        tp.setIdTipoDocumento(Short.MIN_VALUE);

        try {

            em.merge(tp);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public TipoDocumento recuperaTipoDocumento(){
    
         TypedQuery<TipoDocumento> tipoDocumentoQuery
                = em.createQuery("select t from TipoDocumento as t where t.descricao = 'CPF'",
                        TipoDocumento.class);

        return tipoDocumentoQuery.getSingleResult();
    }
    
    public List<TipoDocumento> listarTipoDocumento(){
    
         TypedQuery<TipoDocumento> tipoDocumentoQuery
                = em.createQuery("select t from TipoDocumento as t",
                        TipoDocumento.class);

        return tipoDocumentoQuery.getResultList();
    }
}