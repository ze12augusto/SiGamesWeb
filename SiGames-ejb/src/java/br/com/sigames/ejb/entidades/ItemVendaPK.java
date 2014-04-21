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
public class ItemVendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdVenda", nullable = false)
    private int idVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdProduto", nullable = false)
    private int idProduto;

    public ItemVendaPK() {
    }

    public ItemVendaPK(int idVenda, int idProduto) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVenda;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVendaPK)) {
            return false;
        }
        ItemVendaPK other = (ItemVendaPK) object;
        if (this.idVenda != other.idVenda) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.ItemVendaPK[ idVenda=" + idVenda + ", idProduto=" + idProduto + " ]";
    }
    
}
