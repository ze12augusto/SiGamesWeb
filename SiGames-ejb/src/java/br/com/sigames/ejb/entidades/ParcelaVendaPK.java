/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joseaugusto
 */
@Embeddable
public class ParcelaVendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ParcelaIdParcela", nullable = false)
    private short parcelaIdParcela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VendaIdVenda", nullable = false)
    private int vendaIdVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataVencimento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;

    public ParcelaVendaPK() {
    }

    public ParcelaVendaPK(short parcelaIdParcela, int vendaIdVenda, Date dataVencimento) {
        this.parcelaIdParcela = parcelaIdParcela;
        this.vendaIdVenda = vendaIdVenda;
        this.dataVencimento = dataVencimento;
    }

    public short getParcelaIdParcela() {
        return parcelaIdParcela;
    }

    public void setParcelaIdParcela(short parcelaIdParcela) {
        this.parcelaIdParcela = parcelaIdParcela;
    }

    public int getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(int vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) parcelaIdParcela;
        hash += (int) vendaIdVenda;
        hash += (dataVencimento != null ? dataVencimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParcelaVendaPK)) {
            return false;
        }
        ParcelaVendaPK other = (ParcelaVendaPK) object;
        if (this.parcelaIdParcela != other.parcelaIdParcela) {
            return false;
        }
        if (this.vendaIdVenda != other.vendaIdVenda) {
            return false;
        }
        if ((this.dataVencimento == null && other.dataVencimento != null) || (this.dataVencimento != null && !this.dataVencimento.equals(other.dataVencimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.ParcelaVendaPK[ parcelaIdParcela=" + parcelaIdParcela + ", vendaIdVenda=" + vendaIdVenda + ", dataVencimento=" + dataVencimento + " ]";
    }
    
}
