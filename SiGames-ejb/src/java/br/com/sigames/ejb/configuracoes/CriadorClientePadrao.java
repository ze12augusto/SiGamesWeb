package br.com.sigames.ejb.configuracoes;

import br.com.sigames.ejb.Ejb.*;
import br.com.sigames.ejb.entidades.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("criadorClientePadrao")
@RequestScoped
public class CriadorClientePadrao {

    @EJB
    private PessoaEJB pessoaEjb;

    @EJB
    private ClienteEJB clienteEjb;

    @EJB
    private UfEJB ufEjb;

    @EJB
    private TipoDocumentoEJB tipoDocumentoEjb;

    @EJB
    private TipoLogradouroEJB tipoLogradouroEjb;

    @EJB
    private TipoTelefoneEJB tipoTelefoneEjb;

    private Endereco endereco;
    private Documento documento;
    private Telefone telefone;
    private Pessoa pessoa, pessoaSelecionada;

    private List<Pessoa> pessoas;
    private List<Documento> documentos;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    public void criadorClientePadrao(){
    
        pessoas = pessoaEjb.listar();
        if(pessoas.isEmpty()){
        
            criadorPessoaPadrao();
        }
    }
    
    private void criadorPessoaPadrao() {

        String nome = "José Augusto Martins Regis";
        
        pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setDataCadastro(new Date());
        pessoa.setIdPessoa(Integer.SIZE);
        String erro = pessoaEjb.salvar(pessoa);

        if (erro == null) {

            pessoaSelecionada = pessoaEjb.recuperaIdPessoaPorNome(nome);
            pessoa.setIdPessoa(pessoaSelecionada.getIdPessoa());
            criadorDocumentoPadrao();
            criadorEnderecoPadrao();
            criadorTelefonePadrao();
            clienteEjb.salvar(pessoa.getIdPessoa());
            pessoaEjb.salvar(pessoa);
            System.out.println("salvando pessoa -> id = " +pessoa.getIdPessoa()
                    +"nome = " + pessoa.getNome()
                    + " ,telefone = " + telefone.getNumero() + " ,tipo telefone = " 
                    + telefone.getTipoTelefone().getDescricao()
                    + " ,documento = " + documento.getDocumento()
                    + " ,tipo documento = " + documento.getTipoDocumento().getDescricao()
                    + " ,endereco = " + endereco.getLogradouro());

        } else {

            System.out.println("erro ao salvar pessoa -> " + pessoa.getNome());
        }
    }

    private void criadorEnderecoPadrao() {

        endereco = new Endereco();
        endereco.setBairro("Bela Vista");
        endereco.setCidade("Lagoa Formosa");
        endereco.setLogradouro("José Marciano");
        endereco.setNumero(new Short("20"));
        endereco.setPessoa(pessoa);
        endereco.setUf(ufEjb.recuperaUf());
        endereco.setTipoLogradouro(tipoLogradouroEjb.recuperaTipoLogradouro());
        enderecos = new ArrayList<>();
        enderecos.add(endereco);
        pessoa.setEnderecos(enderecos);
    }

    private void criadorTelefonePadrao() {

        telefone = new Telefone();
        telefone.setPessoa(pessoa);
        telefone.setNumero(3492003982l);
        telefone.setTipoTelefone(tipoTelefoneEjb.recuperaTipoTelefone());
        telefones = new ArrayList<>();
        telefones.add(telefone);
        pessoa.setTelefones(telefones);
    }

    private void criadorDocumentoPadrao() {

        documento = new Documento();
        documento.setDocumento("113.943.496-96");
        documento.setTipoDocumento(tipoDocumentoEjb.recuperaTipoDocumento());
        documento.setIdDocumento(Integer.MIN_VALUE);
        documento.setPessoa(pessoa);
        documentos = new ArrayList<>();
        documentos.add(documento);
        pessoa.setDocumentos(documentos);
    }
}
