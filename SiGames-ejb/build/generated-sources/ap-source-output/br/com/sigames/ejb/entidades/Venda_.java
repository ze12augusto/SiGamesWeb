package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Cliente;
import br.com.sigames.ejb.entidades.ItemVenda;
import br.com.sigames.ejb.entidades.ParcelaVenda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-10T19:11:33")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Date> dataVenda;
    public static volatile ListAttribute<Venda, ParcelaVenda> parcelaVendaList;
    public static volatile ListAttribute<Venda, ItemVenda> itemVendaList;
    public static volatile SingularAttribute<Venda, Integer> idVenda;

}