package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.ParcelaVenda;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-16T20:50:47")
@StaticMetamodel(Parcela.class)
public class Parcela_ { 

    public static volatile SingularAttribute<Parcela, BigInteger> valorParcela;
    public static volatile ListAttribute<Parcela, ParcelaVenda> parcelaVendaList;
    public static volatile SingularAttribute<Parcela, Short> idParcela;

}