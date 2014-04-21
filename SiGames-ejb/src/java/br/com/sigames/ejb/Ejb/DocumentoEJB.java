package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Documento;
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
public class DocumentoEJB {

   @PersistenceContext
    private EntityManager em;
   private List<Documento> documentos;
   
    public String salvar(Documento documento) {

        try {

            em.merge(documento);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    private String remover(Integer idDocumento) {
        try {

            em.remove(em.find(Documento.class, idDocumento));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public void recuperaIdDocumentoPorIdPessoa(Integer idPessoa){
    
        TypedQuery<Documento> documentoQuery
                = em.createQuery("select d from Documento as d where d.pessoa.idPessoa = :idPessoa",
                        Documento.class).setParameter("idPessoa", idPessoa);

        documentos = documentoQuery.getResultList();
        
        for(Documento documento : documentos){
        
            remover(documento.getIdDocumento());
        }
        
    }
    
    public List<Documento> listarDocumento(){
    
         TypedQuery<Documento> documentoQuery
                = em.createQuery("select d from Documento as d",
                        Documento.class);

        return documentoQuery.getResultList();
    }
}
