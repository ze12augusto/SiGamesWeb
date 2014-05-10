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
@Table(name = "Endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEndereco", nullable = false)
    private Integer IdEndereco;
    @JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @NotNull(message = "Informe o logradouro")
    @Column(name = "Logradouro", nullable = false, length = 40)
    private String logradouro;
    @NotNull(message = "Informe o número")
    @Column(name = "Numero", nullable = false)
    private short numero;
    @NotNull(message = "Informe a cidade")
    @Column(name = "Cidade", nullable = false, length = 30)
    private String cidade;
    @NotNull(message = "Informe o bairro")
    @Column(name = "Bairro", nullable = false, length = 40)
    private String bairro;
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro", nullable = false)
    @ManyToOne(optional = false)
    private TipoLogradouro tipoLogradouro;
    @JoinColumn(name = "UF", referencedColumnName = "UF", nullable = false)
    @ManyToOne(optional = false)
    private Uf uf;

    public Endereco() {
    }

    public Endereco(Integer idPessoa) {
        this.IdEndereco = idPessoa;
    }

    public Endereco(Integer idPessoa, String logradouro, short numero, String cidade, String bairro) {
        this.IdEndereco = idPessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public Integer getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.IdEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IdEndereco != null ? IdEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.IdEndereco == null && other.IdEndereco != null) || (this.IdEndereco != null && !this.IdEndereco.equals(other.IdEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sigames.ejb.entidades.Endereco[ idPessoa=" + IdEndereco + " ]";
    }
    
}
