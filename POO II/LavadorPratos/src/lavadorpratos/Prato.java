package lavadorpratos;

enum NivelSugeira {
    BAIXO,
    MEDIO,
    ENGORDURADO
}

public class Prato {
    private static int ultimoNumSerie = 0;
    private int numSerie;
    private NivelSugeira nivelSugeira;

    public Prato() {
        this.numSerie = Prato.ultimoNumSerie++;
        double probability = Math.random();

        if (probability < 0.3) {
            nivelSugeira = NivelSugeira.BAIXO;
        } else if (probability < 0.9) {
            nivelSugeira = NivelSugeira.MEDIO;
        } else {
            nivelSugeira = NivelSugeira.ENGORDURADO;
        }
    }

    public int getNumSerie() {
        return numSerie;
    }

    public NivelSugeira getNivelSugeira() {
        return nivelSugeira;
    }

    @Override
    public String toString() {
        return "Prato [numSerie=" + numSerie + ", nivelSugeira=" + nivelSugeira + "]";
    }
}
