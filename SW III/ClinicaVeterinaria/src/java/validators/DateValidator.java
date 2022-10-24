package validators;

import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "dateValidator")
public class DateValidator implements Validator<Date> {

    @Override
    public void validate(FacesContext context, UIComponent component, Date data) throws ValidatorException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
   
        boolean diaValido = diaSemana >= Calendar.TUESDAY &&
                            diaSemana <= Calendar.THURSDAY;
        
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        
        boolean horaValida = hora >= 8 && hora <= 17;
        boolean minValido = hora != 17 || min <= 45;
        
        if (!diaValido || !horaValida || !minValido) {
            throw new ValidatorException(new FacesMessage("Data/hora inválida"));
        }
    }
    
}
