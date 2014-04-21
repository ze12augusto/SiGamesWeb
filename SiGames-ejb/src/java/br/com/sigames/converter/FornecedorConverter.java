package br.com.sigames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.sigames.ejb.entidades.Fornecedor;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author joseaugusto
 */
@Named("fornecedorConverter")
@FacesConverter(value = "fornecedorConverter", forClass = Fornecedor.class)
public class FornecedorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdPessoa(Integer.valueOf(value));
            return fornecedor;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Fornecedor) {

            return String.valueOf(((Fornecedor) value).getPessoa());
        }
        return null;
    }

}
