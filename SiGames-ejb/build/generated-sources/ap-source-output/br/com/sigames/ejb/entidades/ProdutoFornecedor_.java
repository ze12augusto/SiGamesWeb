package br.com.sigames.ejb.entidades;

import br.com.sigames.ejb.entidades.Fornecedor;
import br.com.sigames.ejb.entidades.Produto;
import br.com.sigames.ejb.entidades.ProdutoFornecedorPK;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-21T17:59:19")
@StaticMetamodel(ProdutoFornecedor.class)
public class ProdutoFornecedor_ { 

    public static volatile SingularAttribute<ProdutoFornecedor, BigInteger> precoUnitario;
    public static volatile SingularAttribute<ProdutoFornecedor, Produto> produto;
    public static volatile SingularAttribute<ProdutoFornecedor, ProdutoFornecedorPK> produtoFornecedorPK;
    public static volatile SingularAttribute<ProdutoFornecedor, Fornecedor> fornecedor;

}