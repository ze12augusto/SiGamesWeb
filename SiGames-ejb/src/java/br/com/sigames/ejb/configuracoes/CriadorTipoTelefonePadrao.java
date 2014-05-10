package br.com.sigames.ejb.configuracoes;

import br.com.sigames.ejb.Ejb.TipoTelefoneEJB;
import br.com.sigames.ejb.entidades.TipoTelefone;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("criadorTipoTelefonePadrao")
@RequestScoped
public class CriadorTipoTelefonePadrao {
    
    @EJB
    private TipoTelefoneEJB tpEJB;
    private List<TipoTelefone> tiposTelefone;
    
    private void salvarTipoTelefone(String descricao){
    
       String erro = tpEJB.salvar(descricao);
        
       if(erro == null){

           System.out.println("Tipo telefone salvo -> " + descricao);
       
       }else{
       
           System.out.println("Erro ao salvar tipo telefone -> " + descricao);
       }
       
    }
    
    public void criarTipoTelefone(){
    
        tiposTelefone = tpEJB.listarTiposTelefone();
        
        if(tiposTelefone.isEmpty()){
        
            salvarTipoTelefone("Comercial");
            salvarTipoTelefone("Residencial");
            salvarTipoTelefone("Móvel");
        }
        
    }
    
}
