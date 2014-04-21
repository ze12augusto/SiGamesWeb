package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-21T17:59:19")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> idPessoa;
    public static volatile SingularAttribute<Cliente, Pessoa> pessoa;
    public static volatile ListAttribute<Cliente, Venda> vendaList;

}