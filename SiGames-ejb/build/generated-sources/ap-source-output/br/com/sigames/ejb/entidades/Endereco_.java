package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.TipoLogradouro;
import br.com.sigames.ejb.entidades.Uf;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-16T20:50:47")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, Integer> IdEndereco;
    public static volatile SingularAttribute<Endereco, Uf> uf;
    public static volatile SingularAttribute<Endereco, String> cidade;
    public static volatile SingularAttribute<Endereco, Pessoa> pessoa;
    public static volatile SingularAttribute<Endereco, Short> numero;
    public static volatile SingularAttribute<Endereco, String> logradouro;
    public static volatile SingularAttribute<Endereco, String> bairro;
    public static volatile SingularAttribute<Endereco, TipoLogradouro> tipoLogradouro;

}