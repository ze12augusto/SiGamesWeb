package br.com.sigames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.sigames.ejb.entidades.TipoLogradouro;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joseaugusto
 */
@FacesConverter(value = "tipoLogradouroConverter", forClass = TipoLogradouro.class)
public class TipoLogradouroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            if (value == null || value.isEmpty()) {
                return null;
            }

            TipoLogradouro tipoLogradouro = new TipoLogradouro();
            tipoLogradouro.setIdTipoLogradouro(Short.valueOf(value));
            return tipoLogradouro;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.getClass() != TipoLogradouro.class) {
            return null;
        }

        try {
            TipoLogradouro tipoLogradouro = (TipoLogradouro) value;
            return tipoLogradouro.getIdTipoLogradouro().toString();
        } catch (Exception e) {
            return null;
        }
    }
}
