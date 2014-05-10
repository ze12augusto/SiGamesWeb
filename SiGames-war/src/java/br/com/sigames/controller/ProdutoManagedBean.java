package br.com.sigames.controller;

import br.com.sigames.ejb.Ejb.FornecedorEJB;
import br.com.sigames.ejb.Ejb.ProdutoEJB;
import br.com.sigames.ejb.entidades.Fornecedor;
import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.Produto;
import java.util.ArrayList;
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
@Named("produtoManagedBean")
@RequestScoped
public class ProdutoManagedBean {

    private Produto produto;
    private Produto produtoSelecionado;
    private Fornecedor fornecedor;
    private List<Produto> produtos;
    private List<Fornecedor> fornecedores;
    private List<Pessoa> pessoas;

    @EJB
    private ProdutoEJB produtoService;

    @EJB
    private FornecedorEJB fornecedorEjb;

    public ProdutoManagedBean() {
        pessoas = new ArrayList<>();
        produto = new Produto();
        produtos = new ArrayList<>();
        fornecedores = new ArrayList<>();
    }

    public List<Produto> listar() {

        return produtoService.listarProduto();
    }

    public void salvar() {

        recuperaFornecedores();
        produto.setFornecedorList(fornecedores);
        fornecedor = fornecedorEjb.recuperaPorId(fornecedor.getIdPessoa());
        produtos = fornecedor.getProdutoList();
        produtos.add(produto);
        String erro = fornecedorEjb.salvar(fornecedor);

        if (erro == null) {

            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Produto salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        produto = new Produto();
        pessoas = new ArrayList<>();
        produtos = new ArrayList<>();
        fornecedores = new ArrayList<>();
    }

    public void excluir() {

        produtoService.recuperaIdProduto(produtoSelecionado.getIdProduto());
    }

    private void recuperaFornecedores() {

        for (Pessoa pessoaInList : pessoas) {

            fornecedor = fornecedorEjb.recuperaPorId(pessoaInList.getIdPessoa());
            fornecedores.add(fornecedor);
        }

    }

    public Produto getProduto() {
        return produto;
    }

    public void editar() {
        produto = produtoSelecionado;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionada) {
        this.produtoSelecionado = produtoSelecionada;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
