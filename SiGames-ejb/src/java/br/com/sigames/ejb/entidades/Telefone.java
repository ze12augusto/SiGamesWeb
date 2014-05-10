/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigames.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joseaugusto
 */
@Entity
@Table(name = "Telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTelefone", nullable = false)
    private Integer IdTelefone;
    @NotNull(message = "Informe o telefone")
    @Column(name = "Numero", nullable = false)
    private Long numero;
    @JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "IdTipoTelefone", referencedColumnName = "IdTipoTelefone", nullable = false)
    @ManyToOne(optional = false)
    private TipoTelefone tipoTelefone;

    public Telefone() {
    }

    public Telefone(Integer idTelefone) {
        this.IdTelefone = idTelefone;
    }

    public Telefone(Integer idTelefone, Long numero) {
        this.IdTelefone = idTelefone;
        this.numero = numero;
    }

    public Integer getIdTelefone() {
        return IdTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.IdTelefone = idTelefone;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IdTelefone != null ? IdTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.IdTelefone == null && other.IdTelefone != null) || (this.IdTelefone != null && !this.IdTelefone.equals(other.IdTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.Telefone[ idPessoa=" + IdTelefone + " ]";
    }

}
