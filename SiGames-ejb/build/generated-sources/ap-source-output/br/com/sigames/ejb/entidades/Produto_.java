package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Fornecedor;
import br.com.sigames.ejb.entidades.ItemVenda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-10T19:11:33")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> precoUnitario;
    public static volatile SingularAttribute<Produto, Integer> idProduto;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile ListAttribute<Produto, ItemVenda> itemVendaList;
    public static volatile ListAttribute<Produto, Fornecedor> fornecedorList;
    public static volatile SingularAttribute<Produto, String> tipoProduto;

}