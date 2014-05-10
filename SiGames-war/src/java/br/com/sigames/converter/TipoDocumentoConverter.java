package br.com.sigames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.sigames.ejb.entidades.TipoDocumento;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joseaugusto
 */
@FacesConverter(value = "tipoDocumentoConverter", forClass = TipoDocumento.class)
public class TipoDocumentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            if (value == null || value.isEmpty()) {
                return null;
            }

            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setIdTipoDocumento(Short.valueOf(value));
            return tipoDocumento;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.getClass() != TipoDocumento.class) {
            return null;
        }

        try {
            TipoDocumento tipoDocumento = (TipoDocumento) value;
            return tipoDocumento.getIdTipoDocumento().toString();
        } catch (Exception e) {
            return null;
        }
    }
}
