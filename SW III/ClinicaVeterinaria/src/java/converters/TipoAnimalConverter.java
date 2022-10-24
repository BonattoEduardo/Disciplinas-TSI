
package converters;

import dao.TipoAnimalDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import entidade.TipoAnimal;

@Named(value = "tipoAnimalConverter")
@ApplicationScoped
public class TipoAnimalConverter implements Converter<TipoAnimal> {
    
    @Inject
    TipoAnimalDAO tipoAnimalDAO;

    @Override
    public TipoAnimal getAsObject(FacesContext context, UIComponent component, String value) {
        return tipoAnimalDAO.buscar(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, TipoAnimal value) {
        if (value == null) {
            return null;
        }
        return value.getTipo();
    }
    
}
