package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Documento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-16T20:50:47")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile ListAttribute<TipoDocumento, Documento> documentoList;
    public static volatile SingularAttribute<TipoDocumento, Short> idTipoDocumento;
    public static volatile SingularAttribute<TipoDocumento, String> descricao;

}