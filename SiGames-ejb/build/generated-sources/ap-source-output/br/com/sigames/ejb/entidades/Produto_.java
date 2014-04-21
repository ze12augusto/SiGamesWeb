package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.ItemVenda;
import br.com.sigames.ejb.entidades.ProdutoFornecedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-21T17:59:19")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Integer> idProduto;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile ListAttribute<Produto, ItemVenda> itemVendaList;
    public static volatile ListAttribute<Produto, ProdutoFornecedor> produtoFornecedorList;
    public static volatile SingularAttribute<Produto, String> tipoProduto;

}