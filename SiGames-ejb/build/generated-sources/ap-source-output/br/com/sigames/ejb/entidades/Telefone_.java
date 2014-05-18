package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.TipoTelefone;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-16T20:50:47")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, TipoTelefone> tipoTelefone;
    public static volatile SingularAttribute<Telefone, Pessoa> pessoa;
    public static volatile SingularAttribute<Telefone, Long> numero;
    public static volatile SingularAttribute<Telefone, Integer> IdTelefone;

}