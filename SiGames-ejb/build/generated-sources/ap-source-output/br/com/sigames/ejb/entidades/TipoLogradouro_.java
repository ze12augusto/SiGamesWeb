package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-16T20:50:47")
@StaticMetamodel(TipoLogradouro.class)
public class TipoLogradouro_ { 

    public static volatile SingularAttribute<TipoLogradouro, Short> idTipoLogradouro;
    public static volatile ListAttribute<TipoLogradouro, Endereco> enderecoList;
    public static volatile SingularAttribute<TipoLogradouro, String> descricao;

}