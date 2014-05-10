package br.com.sigames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.sigames.ejb.entidades.TipoTelefone;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joseaugusto
 */
@FacesConverter(value = "tipoTelefoneConverter", forClass = TipoTelefone.class)
public class TipoTelefoneConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            if (value == null || value.isEmpty()) {
                return null;
            }

            TipoTelefone tipoTelefone = new TipoTelefone();
            tipoTelefone.setIdTipoTelefone(Short.valueOf(value));
            return tipoTelefone;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.getClass() != TipoTelefone.class) {
            return null;
        }

        try {
            TipoTelefone tipoTelefone = (TipoTelefone) value;
            return tipoTelefone.getIdTipoTelefone().toString();
        } catch (Exception e) {
            return null;
        }
    }
}
