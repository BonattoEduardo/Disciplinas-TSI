package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entidade.TipoAnimal;
import exceptions.TipoAnimalJaCadastrado;
import javax.faces.model.SelectItem;

public class TipoAnimalDAO implements Serializable {
    
    private final List<TipoAnimal> tiposAnimal = new ArrayList<>();
    
    public void incluir(TipoAnimal tipoAnimal) throws TipoAnimalJaCadastrado {
        if (tiposAnimal.contains(tipoAnimal)) {
            throw new TipoAnimalJaCadastrado();
        }
        tiposAnimal.add(tipoAnimal);
    }
    
    public void remover(TipoAnimal tipoAnimal) {
        tiposAnimal.remove(tipoAnimal);
    }
    
    public TipoAnimal buscar(String busca) {
        for (TipoAnimal tipo : tiposAnimal) {
            if (tipo.getTipo().equals(busca)) {
                return tipo;
            }
        }
        return null;
    }
    
    public List<TipoAnimal> getTiposAnimal() {
        return tiposAnimal;
    }
    
    public List<SelectItem> getTiposItens() {
        List<SelectItem> tiposItens = new ArrayList<>();
        tiposItens.add(new SelectItem(null, "Selecione uma opção"));
        for (TipoAnimal tipo : tiposAnimal) {
            tiposItens.add(new SelectItem(tipo, tipo.getTipo()));
        }
        return tiposItens;
    }
}
