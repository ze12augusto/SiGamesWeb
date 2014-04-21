package br.com.sigames.controller;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.Ejb.ClienteEJB;
import br.com.sigames.ejb.Ejb.PessoaEJB;
import br.com.sigames.ejb.Ejb.EnderecoEJB;
import br.com.sigames.ejb.Ejb.TelefoneEJB;
import br.com.sigames.ejb.Ejb.DocumentoEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("pessoaManagedBean")
@RequestScoped
public class PessoaManagedBean {

    private Pessoa pessoa;
    private Pessoa pessoaSelecionada;

    @EJB
    private ClienteEJB clienteService;

    @EJB
    private PessoaEJB pessoaService;
    
    @EJB
    private EnderecoEJB enderecoEjb;
    
    @EJB
    private DocumentoEJB documentoEjb;
    
    @EJB
    private TelefoneEJB telefoneEjb;

    public PessoaManagedBean() {
        pessoa = new Pessoa();
    }

    public List<Pessoa> listar(){
    
        return pessoaService.listar();
    }
    
    public void salvarCliente() {

        String erro = pessoaService.salvar(pessoa);

        if (erro == null) {

            clienteService.salvar(recuperaIdPessoaPorNome(pessoa.getNome()));

        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        pessoa = new Pessoa();
    }

    public void salvarFornecedor() {

        String erro = pessoaService.salvar(pessoa);
        pessoa = new Pessoa();
    }

    public void excluir() {
        
        documentoEjb.recuperaIdDocumentoPorIdPessoa(pessoaSelecionada.getIdPessoa());
        telefoneEjb.recuperaIdTelefonePorIdPessoa(pessoaSelecionada.getIdPessoa());
        enderecoEjb.recuperaEnderecoPorIdPessoa(pessoaSelecionada.getIdPessoa());
        clienteService.remover(pessoaSelecionada.getIdPessoa());
        pessoaService.remover(pessoaSelecionada.getIdPessoa());
    }

    public Integer recuperaIdPessoaPorNome(String nome) {

        pessoa = pessoaService.recuperaIdPessoaPorNome(nome);
        return pessoa.getIdPessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void editar() {
        pessoa = pessoaSelecionada;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

}
