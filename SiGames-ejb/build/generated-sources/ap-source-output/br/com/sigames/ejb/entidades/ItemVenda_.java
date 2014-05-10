package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.ItemVendaPK;
import br.com.sigames.ejb.entidades.Produto;
import br.com.sigames.ejb.entidades.Venda;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-10T19:11:33")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, BigInteger> precoVenda;
    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, Produto> produto;
    public static volatile SingularAttribute<ItemVenda, ItemVendaPK> itemVendaPK;
    public static volatile SingularAttribute<ItemVenda, Short> quantidade;

}