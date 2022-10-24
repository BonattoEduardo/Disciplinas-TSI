package entidade;

import java.io.Serializable;
import java.util.Objects;

public class Veterinario implements Serializable {
    private String nome;
    private TipoAnimal tipoAnimal;

    public Veterinario() {
        
    }
    public Veterinario(String nome, TipoAnimal tipoAnimal) {
        this.nome = nome;
        this.tipoAnimal = tipoAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.tipoAnimal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veterinario other = (Veterinario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.tipoAnimal, other.tipoAnimal);
    }
    
    
}
