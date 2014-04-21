/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joseaugusto
 */
@Entity
@Table(name = "Produto")

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProduto", nullable = false)
    private Integer idProduto;
    @NotNull(message = "Infome o nome")
    @Column(name = "Nome", nullable = false, length = 30)
    private String nome;
    @NotNull(message = "Informe um tipo")
    @Column(name = "TipoProduto", nullable = false, length = 30)
    private String tipoProduto;

    @OneToMany(mappedBy = "produto",
            fetch = FetchType.LAZY)
    private List<ItemVenda> itemVendaList;
    @OneToMany(mappedBy = "produto",
            fetch = FetchType.LAZY)
    private List<ProdutoFornecedor> produtoFornecedorList;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String nome, String tipoProduto) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @XmlTransient
    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    @XmlTransient
    public List<ProdutoFornecedor> getProdutoFornecedorList() {
        return produtoFornecedorList;
    }

    public void setProdutoFornecedorList(List<ProdutoFornecedor> produtoFornecedorList) {
        this.produtoFornecedorList = produtoFornecedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.Produto[ idProduto=" + idProduto + " ]";
    }

}
