package beans;

import dao.TipoAnimalDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import entidade.Veterinario;
import exceptions.VeterinarioJaCadastrado;
import java.util.List;
import javax.faces.model.SelectItem;

@Named(value = "cadastroVeterinario")
@SessionScoped
public class CadastroVeterinario implements Serializable {
    private boolean editando = false;
    private Veterinario veterinario;
    
    @Inject
    VeterinarioBean veterinarioBean;
    
    @Inject
    TipoAnimalDAO tipoAnimalDAO;
    
    public CadastroVeterinario() {
        this.veterinario = new Veterinario();
    }
    
    public boolean getEditando() {
        return editando;
    }
    
    public Veterinario getVeterinario() {
        return veterinario;
    }
    
    public List<SelectItem> getTiposItens() {
        return tipoAnimalDAO.getTiposItens();
    }
    
    public String cadastrar() throws VeterinarioJaCadastrado {
        if (!editando) {
            veterinarioBean.getVeterinarioDAO().incluir(veterinario);
        }
        this.veterinario = new Veterinario();
        this.editando = false;
        return null;
    }
    
    public String remover(Veterinario vet) {
        veterinarioBean.getVeterinarioDAO().remover(vet);
        return null;
    }
        
    public String editar(Veterinario vet) {
        this.veterinario = vet;
        this.editando = true;
        return null;
    }
}
