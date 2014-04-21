package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.ProdutoFornecedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-21T12:25:53")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile SingularAttribute<Fornecedor, Integer> idPessoa;
    public static volatile SingularAttribute<Fornecedor, Pessoa> pessoa;
    public static volatile ListAttribute<Fornecedor, ProdutoFornecedor> produtoFornecedorList;

}