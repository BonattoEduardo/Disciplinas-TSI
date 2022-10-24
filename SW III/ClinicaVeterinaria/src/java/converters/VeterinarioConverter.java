
package converters;

import dao.VeterinarioDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import entidade.Veterinario;

@Named(value = "veterinarioConverter")
@ApplicationScoped
public class VeterinarioConverter implements Converter<Veterinario> {
    
    @Inject
    VeterinarioDAO veterinarioDAO;

    @Override
    public Veterinario getAsObject(FacesContext context, UIComponent component, String value) {
        return veterinarioDAO.buscar(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Veterinario value) {
        if (value == null) {
            return null;
        }
        return value.getNome();
    }
    
}
