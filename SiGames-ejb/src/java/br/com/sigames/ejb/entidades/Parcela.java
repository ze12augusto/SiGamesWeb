/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joseaugusto
 */
@Entity
@Table(name = "Parcela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcela.findAll", query = "SELECT p FROM Parcela p"),
    @NamedQuery(name = "Parcela.findByIdParcela", query = "SELECT p FROM Parcela p WHERE p.idParcela = :idParcela"),
    @NamedQuery(name = "Parcela.findByValorParcela", query = "SELECT p FROM Parcela p WHERE p.valorParcela = :valorParcela")})
public class Parcela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdParcela", nullable = false)
    private Short idParcela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorParcela", nullable = false)
    private BigInteger valorParcela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parcela")
    private List<ParcelaVenda> parcelaVendaList;

    public Parcela() {
    }

    public Parcela(Short idParcela) {
        this.idParcela = idParcela;
    }

    public Parcela(Short idParcela, BigInteger valorParcela) {
        this.idParcela = idParcela;
        this.valorParcela = valorParcela;
    }

    public Short getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Short idParcela) {
        this.idParcela = idParcela;
    }

    public BigInteger getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigInteger valorParcela) {
        this.valorParcela = valorParcela;
    }

    @XmlTransient
    public List<ParcelaVenda> getParcelaVendaList() {
        return parcelaVendaList;
    }

    public void setParcelaVendaList(List<ParcelaVenda> parcelaVendaList) {
        this.parcelaVendaList = parcelaVendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParcela != null ? idParcela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcela)) {
            return false;
        }
        Parcela other = (Parcela) object;
        if ((this.idParcela == null && other.idParcela != null) || (this.idParcela != null && !this.idParcela.equals(other.idParcela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.Parcela[ idParcela=" + idParcela + " ]";
    }
    
}
