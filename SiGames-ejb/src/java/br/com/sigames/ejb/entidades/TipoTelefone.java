/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joseaugusto
 */
@Entity
@Table(name = "Tipo_Telefone")
public class TipoTelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "IdTipoTelefone", nullable = false)
    private Short idTipoTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Descricao", nullable = false, length = 20)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTelefone")
    private List<Telefone> telefoneList;

    public TipoTelefone() {
    }

    public TipoTelefone(Short idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    public TipoTelefone(Short idTipoTelefone, String descricao) {
        this.idTipoTelefone = idTipoTelefone;
        this.descricao = descricao;
    }

    public Short getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(Short idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idTipoTelefone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoTelefone other = (TipoTelefone) obj;
        if (!Objects.equals(this.idTipoTelefone, other.idTipoTelefone)) {
            return false;
        }
        return true;
    }
}
