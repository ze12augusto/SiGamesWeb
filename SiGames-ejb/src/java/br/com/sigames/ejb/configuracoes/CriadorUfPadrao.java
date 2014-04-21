package br.com.sigames.ejb.configuracoes;

import br.com.sigames.ejb.Ejb.UfEJB;
import br.com.sigames.ejb.entidades.Uf;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("criadorUfPadrao")
@RequestScoped
public class CriadorUfPadrao {

    @EJB
    private UfEJB ufEJB;
    private List<Uf> ufs;

    private void salvarUF(String uf, String estado) {

        String erro = ufEJB.salvar(uf, estado);

        if (erro == null) {

            System.out.println("uf salva -> " + uf);

        } else {

            System.out.println("Erro ao salvar uf -> " + uf);
        }
    }

    public void criadorUF() {

        ufs = ufEJB.listarUf();

        if (ufs.isEmpty()) {
            salvarUF("AC", "Acre");
            salvarUF("AL", "Alagoas");
            salvarUF("AP", "Amapá");
            salvarUF("AM", "Amazonas");
            salvarUF("BA", "Bahia");
            salvarUF("CE", "Ceará");
            salvarUF("DF", "Distrito Federal");
            salvarUF("ES", "Espírito Santo");
            salvarUF("GO", "Goiás");
            salvarUF("MA", "Maranhão");
            salvarUF("MT", "Mato Grosso");
            salvarUF("MS", "Mato Grosso do Sul");
            salvarUF("MG", "Minas Gerais");
            salvarUF("PA", "Pará");
            salvarUF("PB", "Paraíba");
            salvarUF("PR", "Paraná");
            salvarUF("PE", "Pernambuco");
            salvarUF("PI", "Piauí");
            salvarUF("RJ", "Rio de Janeiro");
            salvarUF("RN", "Rio Grande do Norte");
            salvarUF("RS", "Rio Grande do Sul");
            salvarUF("RO", "Rondônia");
            salvarUF("RR", "Roraima");
            salvarUF("RO", "Rondônia");
            salvarUF("SC", "Santa Catarina");
            salvarUF("SP", "São Paulo");
            salvarUF("SE", "Sergipe");
            salvarUF("TO", "Tocantins");
        }
    }

}
