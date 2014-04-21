/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joseaugusto
 */
@Embeddable
public class ProdutoFornecedorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdProduto", nullable = false)
    private int idProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FornecedorIdPessoa", nullable = false)
    private int fornecedorIdPessoa;

    public ProdutoFornecedorPK() {
    }

    public ProdutoFornecedorPK(int idProduto, int fornecedorIdPessoa) {
        this.idProduto = idProduto;
        this.fornecedorIdPessoa = fornecedorIdPessoa;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getFornecedorIdPessoa() {
        return fornecedorIdPessoa;
    }

    public void setFornecedorIdPessoa(int fornecedorIdPessoa) {
        this.fornecedorIdPessoa = fornecedorIdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduto;
        hash += (int) fornecedorIdPessoa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoFornecedorPK)) {
            return false;
        }
        ProdutoFornecedorPK other = (ProdutoFornecedorPK) object;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        if (this.fornecedorIdPessoa != other.fornecedorIdPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.ProdutoFornecedorPK[ idProduto=" + idProduto + ", fornecedorIdPessoa=" + fornecedorIdPessoa + " ]";
    }
    
}
