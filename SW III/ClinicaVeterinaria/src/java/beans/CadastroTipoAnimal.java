package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import entidade.TipoAnimal;
import exceptions.TipoAnimalJaCadastrado;

@Named(value = "cadastroTipoAnimal")
@SessionScoped
public class CadastroTipoAnimal implements Serializable {
    private boolean editando = false;
    private TipoAnimal tipoAnimal;
    
    @Inject
    TipoAnimalBean tipoAnimalBean;
    
    public CadastroTipoAnimal() {
        this.tipoAnimal = new TipoAnimal();
    }
    
    public boolean getEditando() {
        return editando;
    }
    
    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }
    
    public String cadastrar() throws TipoAnimalJaCadastrado {
        if (!editando) {
            tipoAnimalBean.getTipoAnimalDAO().incluir(tipoAnimal);
        }
        this.tipoAnimal = new TipoAnimal();
        this.editando = false;
        return null;
    }
    
    public String remover(TipoAnimal tipo) {
        tipoAnimalBean.getTipoAnimalDAO().remover(tipo);
        return null;
    }
        
    public String editar(TipoAnimal tipo) {
        this.tipoAnimal = tipo;
        this.editando = true;
        return null;
    }
}
