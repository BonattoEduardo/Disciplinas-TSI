package lavadorpratos;

public class Prato {
    private int numSerie;
    private NivelSugeira nivelSugeira;

    public Prato(int numSerie, NivelSugeira nivelSugeira) {
        this.numSerie = numSerie;
        this.nivelSugeira = nivelSugeira;
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
