package br.com.sigames.ejb.model;

/**
 *
 * @author joseaugusto
 */
public class GraficoModel {

    private String nomeFornecedor;
    private int qtdProdutos;

    public GraficoModel(String nomeFornecedor, int qtdProdutos) {
        this.nomeFornecedor = nomeFornecedor;
        this.qtdProdutos = qtdProdutos;
    }

    
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }
    
    
    
}
