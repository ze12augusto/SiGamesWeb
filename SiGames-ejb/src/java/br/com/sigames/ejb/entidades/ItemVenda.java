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
@Table(name = "Item_Venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i"),
    @NamedQuery(name = "ItemVenda.findByIdVenda", query = "SELECT i FROM ItemVenda i WHERE i.itemVendaPK.idVenda = :idVenda"),
    @NamedQuery(name = "ItemVenda.findByIdProduto", query = "SELECT i FROM ItemVenda i WHERE i.itemVendaPK.idProduto = :idProduto"),
    @NamedQuery(name = "ItemVenda.findByQuantidade", query = "SELECT i FROM ItemVenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemVenda.findByPrecoVenda", query = "SELECT i FROM ItemVenda i WHERE i.precoVenda = :precoVenda")})
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemVendaPK itemVendaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade", nullable = false)
    private short quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoVenda", nullable = false)
    private BigInteger precoVenda;
    @JoinColumn(name = "IdVenda", referencedColumnName = "IdVenda", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;
    @JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public ItemVenda() {
    }

    public ItemVenda(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public ItemVenda(ItemVendaPK itemVendaPK, short quantidade, BigInteger precoVenda) {
        this.itemVendaPK = itemVendaPK;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public ItemVenda(int idVenda, int idProduto) {
        this.itemVendaPK = new ItemVendaPK(idVenda, idProduto);
    }

    public ItemVendaPK getItemVendaPK() {
        return itemVendaPK;
    }

    public void setItemVendaPK(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public BigInteger getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigInteger precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemVendaPK != null ? itemVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.itemVendaPK == null && other.itemVendaPK != null) || (this.itemVendaPK != null && !this.itemVendaPK.equals(other.itemVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.ItemVenda[ itemVendaPK=" + itemVendaPK + " ]";
    }
    
}
