package br.com.sigames.controller;

import br.com.sigames.ejb.entidades.Cliente;
import br.com.sigames.ejb.Ejb.ClienteEJB;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("clienteManagedBean")
@RequestScoped
public class ClienteManagedBean {

     private Cliente cliente;
     private Cliente clienteSelecionado;

    @EJB
    private ClienteEJB clienteService;

    public ClienteManagedBean(){
        cliente = new Cliente();
    }

    public void salvar(Integer idPessoa) {
        String erro = clienteService.salvar(idPessoa);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cliente salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        cliente = new Cliente();
    }
    
    public void excluir(){
        String erro = clienteService.remover(clienteSelecionado.getIdPessoa());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cliente excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void editar(){
        cliente = clienteSelecionado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionada) {
        this.clienteSelecionado = clienteSelecionada;
    }
    
    

}
