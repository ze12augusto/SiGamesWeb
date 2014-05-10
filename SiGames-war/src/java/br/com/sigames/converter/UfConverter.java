package br.com.sigames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.sigames.ejb.entidades.Uf;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joseaugusto
 */
@FacesConverter(value = "uFConverter", forClass = Uf.class)
public class UfConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            if (value == null || value.isEmpty()) {
                return null;
            }

            Uf uF = new Uf();
            uF.setUf(value);
            return uF;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.getClass() != Uf.class) {
            return null;
        }

        try {
            Uf uF = (Uf) value;
            return uF.getUf();
        } catch (Exception e) {
            return null;
        }
    }
}
