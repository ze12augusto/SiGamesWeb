/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joseaugusto
 */
@Entity
@Table(name = "Parcela_Venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParcelaVenda.findAll", query = "SELECT p FROM ParcelaVenda p"),
    @NamedQuery(name = "ParcelaVenda.findByParcelaIdParcela", query = "SELECT p FROM ParcelaVenda p WHERE p.parcelaVendaPK.parcelaIdParcela = :parcelaIdParcela"),
    @NamedQuery(name = "ParcelaVenda.findByVendaIdVenda", query = "SELECT p FROM ParcelaVenda p WHERE p.parcelaVendaPK.vendaIdVenda = :vendaIdVenda"),
    @NamedQuery(name = "ParcelaVenda.findByDataVencimento", query = "SELECT p FROM ParcelaVenda p WHERE p.parcelaVendaPK.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "ParcelaVenda.findByDataBaixa", query = "SELECT p FROM ParcelaVenda p WHERE p.dataBaixa = :dataBaixa")})
public class ParcelaVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParcelaVendaPK parcelaVendaPK;
    @Column(name = "DataBaixa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataBaixa;
    @JoinColumn(name = "ParcelaIdParcela", referencedColumnName = "IdParcela", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parcela parcela;
    @JoinColumn(name = "VendaIdVenda", referencedColumnName = "IdVenda", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public ParcelaVenda() {
    }

    public ParcelaVenda(ParcelaVendaPK parcelaVendaPK) {
        this.parcelaVendaPK = parcelaVendaPK;
    }

    public ParcelaVenda(short parcelaIdParcela, int vendaIdVenda, Date dataVencimento) {
        this.parcelaVendaPK = new ParcelaVendaPK(parcelaIdParcela, vendaIdVenda, dataVencimento);
    }

    public ParcelaVendaPK getParcelaVendaPK() {
        return parcelaVendaPK;
    }

    public void setParcelaVendaPK(ParcelaVendaPK parcelaVendaPK) {
        this.parcelaVendaPK = parcelaVendaPK;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parcelaVendaPK != null ? parcelaVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParcelaVenda)) {
            return false;
        }
        ParcelaVenda other = (ParcelaVenda) object;
        if ((this.parcelaVendaPK == null && other.parcelaVendaPK != null) || (this.parcelaVendaPK != null && !this.parcelaVendaPK.equals(other.parcelaVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.ParcelaVenda[ parcelaVendaPK=" + parcelaVendaPK + " ]";
    }
    
}
