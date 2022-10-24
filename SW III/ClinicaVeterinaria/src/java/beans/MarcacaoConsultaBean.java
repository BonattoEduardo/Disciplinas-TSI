package beans;

import dao.ConsultaDAO;
import dao.TipoAnimalDAO;
import dao.VeterinarioDAO;
import entidade.Consulta;
import exceptions.ConsultaInvalida;
import exceptions.ConsultaJaCadastrada;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Named(value = "marcacaoConsultaBean")
@SessionScoped
public class MarcacaoConsultaBean implements Serializable {
    private Consulta consulta;
    
    @Inject
    VeterinarioDAO veterinarioDAO;
    @Inject
    TipoAnimalDAO tipoAnimalDAO;
    @Inject
    ConsultaDAO consultaDAO;
    
    public MarcacaoConsultaBean() {
        this.consulta = new Consulta();
    }
    
    public Consulta getConsulta() {
        return this.consulta;
    }
    
    public List<SelectItem> getTiposItens() {
        return tipoAnimalDAO.getTiposItens();
    }
    
    public List<SelectItem> getVeterinariosItens() {
        return veterinarioDAO.getVeterinariosItens(consulta.getTipoAnimal());
    }
    
    public String marcar() {
        boolean isValid = true;
        for (Consulta c : consultaDAO.getConsultas()) {
            if (consulta.getVeterinario().equals(c.getVeterinario())) {
                if (consulta.getDataHora().equals(c.getDataHora())) {
                    isValid = false;
                    break;
                }
            }
        }
        
        try {
            if (!isValid) {
                throw new ConsultaInvalida();
            }

            consultaDAO.incluir(consulta);
            consulta = new Consulta();
        } catch (ConsultaInvalida | ConsultaJaCadastrada ex) {
                        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    ex.getMessage(),
                    ""
                )
            );
        }
        return null;
    }
    
    public String limpar() {
        consulta = new Consulta();
        return null;
    }
    
    public String desmarcar(Consulta consulta) {
        consultaDAO.remover(consulta);
        return null;
    }
    
}
