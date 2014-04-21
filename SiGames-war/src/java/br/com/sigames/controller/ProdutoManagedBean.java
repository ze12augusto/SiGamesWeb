package br.com.sigames.controller;

import br.com.sigames.ejb.Ejb.ProdutoEJB;
import br.com.sigames.ejb.Ejb.ProdutoFornecedorEJB;
import br.com.sigames.ejb.entidades.Produto;
import br.com.sigames.ejb.entidades.ProdutoFornecedor;
import br.com.sigames.ejb.entidades.ProdutoFornecedorPK;
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
    private ProdutoFornecedor pf;
    private ProdutoFornecedorPK pk;

    @EJB
    private ProdutoEJB produtoService;

    @EJB
    private ProdutoFornecedorEJB pfEjb;

    public ProdutoManagedBean() {
        produto = new Produto();
        pf = new ProdutoFornecedor();
        pk = new ProdutoFornecedorPK();
    }

    public List<Produto> listar() {

        return produtoService.listarProduto();
    }

    public void salvar() {
        String erro = produtoService.salvar(produto);
        if (erro == null) {

            pk.setFornecedorIdPessoa(pf.getFornecedor().getIdPessoa());
            pk.setIdProduto(produto.getIdProduto());
            pf.setProdutoFornecedorPK(pk);
            String erroPF = pfEjb.salvar(pf);

            if (erroPF == null) {
                FacesMessage fm
                        = new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Produto salvo com sucesso", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);

            } else {
                FacesMessage fm
                        = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                erroPF, null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }

        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        produto = new Produto();
        pf = new ProdutoFornecedor();
        pk = new ProdutoFornecedorPK();
    }

    public void excluir() {

        pfEjb.recuperaIdProdutoFornecedorPorIdProduto(produtoSelecionado.getIdProduto());
        produtoService.recuperaIdProdutoPorIdFornecedor(produtoSelecionado.getIdProduto());
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

    public ProdutoFornecedor getPf() {
        return pf;
    }

    public void setPf(ProdutoFornecedor pf) {
        this.pf = pf;
    }

}
