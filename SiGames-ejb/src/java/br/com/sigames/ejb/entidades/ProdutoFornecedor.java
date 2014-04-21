/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joseaugusto
 */
@Entity
@Table(name = "Produto_Fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoFornecedor.findAll", query = "SELECT p FROM ProdutoFornecedor p"),
    @NamedQuery(name = "ProdutoFornecedor.findByIdProduto", query = "SELECT p FROM ProdutoFornecedor p WHERE p.produtoFornecedorPK.idProduto = :idProduto"),
    @NamedQuery(name = "ProdutoFornecedor.findByPrecoUnitario", query = "SELECT p FROM ProdutoFornecedor p WHERE p.precoUnitario = :precoUnitario"),
    @NamedQuery(name = "ProdutoFornecedor.findByFornecedorIdPessoa", query = "SELECT p FROM ProdutoFornecedor p WHERE p.produtoFornecedorPK.fornecedorIdPessoa = :fornecedorIdPessoa")})
public class ProdutoFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoFornecedorPK produtoFornecedorPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoUnitario", nullable = false)
    private BigInteger precoUnitario;
    @JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "FornecedorIdPessoa", referencedColumnName = "IdPessoa", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;

    public ProdutoFornecedor() {
    }

    public ProdutoFornecedor(ProdutoFornecedorPK produtoFornecedorPK) {
        this.produtoFornecedorPK = produtoFornecedorPK;
    }

    public ProdutoFornecedor(ProdutoFornecedorPK produtoFornecedorPK, BigInteger precoUnitario) {
        this.produtoFornecedorPK = produtoFornecedorPK;
        this.precoUnitario = precoUnitario;
    }

    public ProdutoFornecedor(int idProduto, int fornecedorIdPessoa) {
        this.produtoFornecedorPK = new ProdutoFornecedorPK(idProduto, fornecedorIdPessoa);
    }

    public ProdutoFornecedorPK getProdutoFornecedorPK() {
        return produtoFornecedorPK;
    }

    public void setProdutoFornecedorPK(ProdutoFornecedorPK produtoFornecedorPK) {
        this.produtoFornecedorPK = produtoFornecedorPK;
    }

    public BigInteger getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigInteger precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoFornecedorPK != null ? produtoFornecedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoFornecedor)) {
            return false;
        }
        ProdutoFornecedor other = (ProdutoFornecedor) object;
        if ((this.produtoFornecedorPK == null && other.produtoFornecedorPK != null) || (this.produtoFornecedorPK != null && !this.produtoFornecedorPK.equals(other.produtoFornecedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.ProdutoFornecedor[ produtoFornecedorPK=" + produtoFornecedorPK + " ]";
    }
    
}
