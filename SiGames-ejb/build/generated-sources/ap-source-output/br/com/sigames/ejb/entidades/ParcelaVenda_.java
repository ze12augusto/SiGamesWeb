package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Parcela;
import br.com.sigames.ejb.entidades.ParcelaVendaPK;
import br.com.sigames.ejb.entidades.Venda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-23T21:28:47")
@StaticMetamodel(ParcelaVenda.class)
public class ParcelaVenda_ { 

    public static volatile SingularAttribute<ParcelaVenda, Venda> venda;
    public static volatile SingularAttribute<ParcelaVenda, ParcelaVendaPK> parcelaVendaPK;
    public static volatile SingularAttribute<ParcelaVenda, Parcela> parcela;
    public static volatile SingularAttribute<ParcelaVenda, Date> dataBaixa;

}