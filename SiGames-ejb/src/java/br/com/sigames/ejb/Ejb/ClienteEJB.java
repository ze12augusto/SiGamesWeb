package br.com.sigames.ejb.Ejb;

import br.com.sigames.ejb.entidades.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseaugusto
 */
@Stateless
public class ClienteEJB{

    @PersistenceContext
    private EntityManager em;


    public String salvar(Integer idPessoa) {

        Cliente cliente = new Cliente(idPessoa);
        
        try {

            em.merge(cliente);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    public String remover(Integer idCliente) {
        try {

            em.remove(em.find(Cliente.class, idCliente));

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

}
