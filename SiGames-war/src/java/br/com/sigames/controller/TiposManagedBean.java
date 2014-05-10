package br.com.sigames.controller;

import br.com.sigames.ejb.Ejb.TipoDocumentoEJB;
import br.com.sigames.ejb.Ejb.TipoLogradouroEJB;
import br.com.sigames.ejb.Ejb.TipoTelefoneEJB;
import br.com.sigames.ejb.Ejb.UfEJB;
import br.com.sigames.ejb.entidades.Uf;
import br.com.sigames.ejb.entidades.TipoDocumento;
import br.com.sigames.ejb.entidades.TipoLogradouro;
import br.com.sigames.ejb.entidades.TipoTelefone;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("tiposManagedBean")
@RequestScoped
public class TiposManagedBean {


    @EJB
    private TipoDocumentoEJB tpEjb;

    @EJB
    private TipoLogradouroEJB tlEjb;
    
    @EJB
    private TipoTelefoneEJB tleEjb;
    
    @EJB
    private UfEJB ufEjb;

    public List<TipoDocumento> listarTipoDocumento() {

        return tpEjb.listarTipoDocumento();
    }

    public List<TipoLogradouro> listarTipoLogradouro() {

        return tlEjb.listarTipoLogradouro();
    }
    
    public List<TipoTelefone> listarTipoTelefone() {

        return tleEjb.listarTiposTelefone();
    }
    
    public List<Uf> listarUF() {

        return ufEjb.listarUf();
    }
    
}
