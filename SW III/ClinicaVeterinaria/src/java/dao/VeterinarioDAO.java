package dao;

import java.util.List;

import entidade.Veterinario;
import entidade.TipoAnimal;
import exceptions.VeterinarioJaCadastrado;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

public class VeterinarioDAO implements Serializable {
    
    private final List<Veterinario> veterinarios = new ArrayList<>();
    
    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }
        
    public void incluir(Veterinario v) throws VeterinarioJaCadastrado  {
        if (veterinarios.contains(v)) {
            throw new VeterinarioJaCadastrado();
        }
        veterinarios.add(v);
    }
    
    public void remover(Veterinario v) {
        veterinarios.remove(v);
    }
    public Veterinario buscar(String busca) {
        for (Veterinario vet : veterinarios) {
            if (vet.getNome().equals(busca)) {
                return vet;
            }
        }
        return null;
    }
    
    public List<SelectItem> getVeterinariosItens(TipoAnimal tipo) {
        List<SelectItem> veterinariosItens = new ArrayList<>();
        veterinariosItens.add(new SelectItem(null, "Selecione uma opção"));
        for (Veterinario vet : veterinarios) {
            if (vet.getTipoAnimal().equals(tipo)) {
                veterinariosItens.add(new SelectItem(vet, vet.getNome()));
            }
        }
        return veterinariosItens;
    }
    
}
