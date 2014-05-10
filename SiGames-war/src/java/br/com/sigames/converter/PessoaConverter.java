package br.com.sigames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.sigames.ejb.entidades.Pessoa;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joseaugusto
 */
@FacesConverter(value = "pessoaConverter", forClass = Pessoa.class)
public class PessoaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            if (value == null || value.isEmpty()) {
                return null;
            }

            Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(Integer.valueOf(value));
            return pessoa;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.getClass() != Pessoa.class) {
            return null;
        }

        try {
            Pessoa pessoa = (Pessoa) value;
            return pessoa.getIdPessoa().toString();
        } catch (Exception e) {
            return null;
        }
    }
}
