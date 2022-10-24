package entidade;

import java.io.Serializable;
import java.util.Objects;

public class TipoAnimal implements Serializable {
    private String tipo;

    public TipoAnimal() {
    }
    
    public TipoAnimal(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.tipo);
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
        final TipoAnimal other = (TipoAnimal) obj;
        return Objects.equals(this.tipo, other.tipo);
    }
}
