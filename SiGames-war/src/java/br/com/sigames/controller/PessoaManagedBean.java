package br.com.sigames.controller;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.Ejb.ClienteEJB;
import br.com.sigames.ejb.Ejb.PessoaEJB;
import br.com.sigames.ejb.Ejb.EnderecoEJB;
import br.com.sigames.ejb.Ejb.TelefoneEJB;
import br.com.sigames.ejb.Ejb.DocumentoEJB;
import br.com.sigames.ejb.Ejb.FornecedorEJB;
import br.com.sigames.ejb.entidades.Documento;
import br.com.sigames.ejb.entidades.Endereco;
import br.com.sigames.ejb.entidades.Telefone;
import java.util.ArrayList;
import java.util.Date;
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
    private Endereco endereco;
    private List<Endereco> enderecos;
    private Telefone telefone;
    private List<Telefone> telefones;
    private Documento documento;
    private List<Documento> documentos;

    @EJB
    private ClienteEJB clienteService;

    @EJB
    private FornecedorEJB fornecedorService;

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
        endereco = new Endereco();
        telefone = new Telefone();
        documento = new Documento();
        enderecos = new ArrayList<>();
        documentos = new ArrayList<>();
        telefones = new ArrayList<>();
    }

    public List<Pessoa> listarClientes() {

        return pessoaService.listarClientes();
    }

    public List<Pessoa> listarFornecedores() {

        return pessoaService.listarFornecedores();
    }

    private String salvarPessoa() {

        pessoa.setDataCadastro(new Date());
        String erro = pessoaService.salvar(pessoa);

        if (erro == null) {

            pessoa = pessoaService.recuperaIdPessoaPorNome(pessoa.getNome());

            endereco.setPessoa(pessoa);
            telefone.setPessoa(pessoa);
            documento.setPessoa(pessoa);

            enderecos.add(endereco);
            telefones.add(telefone);
            documentos.add(documento);

            pessoa.setDocumentos(documentos);
            pessoa.setEnderecos(enderecos);
            pessoa.setTelefones(telefones);

            return pessoaService.salvar(pessoa);

        } else {

            return null;
        }
    }

    public void salvarCliente() {

        String erro = salvarPessoa();

        if (erro == null) {

            String erroC = clienteService.salvar(recuperaIdPessoaPorNome(pessoa.getNome()));

            if (erroC == null) {

                msgAoSalvar(1,"Cliente salvo com sucesso!!!");
            } else {

                msgAoSalvar(2,erroC);
            }

        } else {
            msgAoSalvar(2,erro);
        }
        instanciaDados();
    }

    private void msgAoSalvar(int tipo, String msg) {

        if (tipo == 1) {

            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            msg, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            msg, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    private void instanciaDados() {

        pessoa = new Pessoa();
        endereco = new Endereco();
        telefone = new Telefone();
        documento = new Documento();
        enderecos = new ArrayList<>();
        documentos = new ArrayList<>();
        telefones = new ArrayList<>();
    }

    public void salvarFornecedor() {

        String erro = salvarPessoa();

        if (erro == null) {

            String errof = fornecedorService.salvar(recuperaIdPessoaPorNome(pessoa.getNome()));

            if (errof == null) {

                msgAoSalvar(1,"Fornecedor salvo com sucesso!!!");
            } else {

                msgAoSalvar(2,errof);
            }

        } else {
            msgAoSalvar(2,erro);
        }
        instanciaDados();
    }

    public void excluirCliente() {

        documentoEjb.recuperaIdDocumentoPorIdPessoa(pessoaSelecionada.getIdPessoa());
        telefoneEjb.recuperaIdTelefonePorIdPessoa(pessoaSelecionada.getIdPessoa());
        enderecoEjb.recuperaEnderecoPorIdPessoa(pessoaSelecionada.getIdPessoa());
        clienteService.remover(pessoaSelecionada.getIdPessoa());
        pessoaService.remover(pessoaSelecionada.getIdPessoa());
    }

    public void excluirFornecedor() {

        documentoEjb.recuperaIdDocumentoPorIdPessoa(pessoaSelecionada.getIdPessoa());
        telefoneEjb.recuperaIdTelefonePorIdPessoa(pessoaSelecionada.getIdPessoa());
        enderecoEjb.recuperaEnderecoPorIdPessoa(pessoaSelecionada.getIdPessoa());
        fornecedorService.remover(pessoaSelecionada.getIdPessoa());
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

}
