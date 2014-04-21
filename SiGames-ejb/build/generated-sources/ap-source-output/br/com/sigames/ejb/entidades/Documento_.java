package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Pessoa;
import br.com.sigames.ejb.entidades.TipoDocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-21T17:59:19")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<Documento, Pessoa> pessoa;
    public static volatile SingularAttribute<Documento, Integer> idDocumento;
    public static volatile SingularAttribute<Documento, String> documento;

}