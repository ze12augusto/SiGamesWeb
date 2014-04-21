package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Cliente;
import br.com.sigames.ejb.entidades.Documento;
import br.com.sigames.ejb.entidades.Endereco;
import br.com.sigames.ejb.entidades.Fornecedor;
import br.com.sigames.ejb.entidades.Telefone;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-20T23:22:25")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, Integer> idPessoa;
    public static volatile SingularAttribute<Pessoa, Cliente> cliente;
    public static volatile ListAttribute<Pessoa, Documento> documentos;
    public static volatile ListAttribute<Pessoa, Endereco> enderecos;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Pessoa, Date> dataCadastro;
    public static volatile ListAttribute<Pessoa, Telefone> telefones;

}