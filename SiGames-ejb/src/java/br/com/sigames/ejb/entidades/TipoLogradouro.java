/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Tipo_Logradouro")
public class TipoLogradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLogradouro", nullable = false)
    private Short idLogradouro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Descricao", nullable = false, length = 40)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoLogradouro")
    private List<Endereco> enderecoList;

    public TipoLogradouro() {
    }

    public TipoLogradouro(Short idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public TipoLogradouro(Short idLogradouro, String descricao) {
        this.idLogradouro = idLogradouro;
        this.descricao = descricao;
    }

    public Short getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Short idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogradouro != null ? idLogradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLogradouro)) {
            return false;
        }
        TipoLogradouro other = (TipoLogradouro) object;
        if ((this.idLogradouro == null && other.idLogradouro != null) || (this.idLogradouro != null && !this.idLogradouro.equals(other.idLogradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.TipoLogradouro[ idLogradouro=" + idLogradouro + " ]";
    }
    
}
