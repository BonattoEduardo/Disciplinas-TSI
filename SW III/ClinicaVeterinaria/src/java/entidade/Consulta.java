package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Consulta implements Serializable {
    private TipoAnimal tipoAnimal;
    private Veterinario veterinario;
    private String nomeTutor;
    private String nomeAnimal;
    private String motivo;
    private String telefoneTutor;
    private Date dataHora;

    public Consulta() {
    }
    public Consulta(TipoAnimal tipoAnimal, Veterinario veterinario, String nomeTutor, String nomeAnimal, String motivo, String telefoneTutor, Date dataHora) {
        this.tipoAnimal = tipoAnimal;
        this.veterinario = veterinario;
        this.nomeTutor = nomeTutor;
        this.nomeAnimal = nomeAnimal;
        this.motivo = motivo;
        this.telefoneTutor = telefoneTutor;
        this.dataHora = dataHora;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTelefoneTutor() {
        return telefoneTutor;
    }

    public void setTelefoneTutor(String telefoneTutor) {
        this.telefoneTutor = telefoneTutor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.veterinario);
        hash = 37 * hash + Objects.hashCode(this.nomeAnimal);
        hash = 37 * hash + Objects.hashCode(this.dataHora);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.nomeAnimal, other.nomeAnimal)) {
            return false;
        }
        if (!Objects.equals(this.veterinario, other.veterinario)) {
            return false;
        }
        return Objects.equals(this.dataHora, other.dataHora);
    }
    
    
}
