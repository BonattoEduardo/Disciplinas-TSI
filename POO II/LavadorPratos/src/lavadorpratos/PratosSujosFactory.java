package lavadorpratos;

public class PratosSujosFactory {
    private int numerosSerie = 0;

    public Prato novoPrato() {
        double probability = Math.random();
        NivelSugeira nivelSugeira;

        if (probability < 0.3) {
            nivelSugeira = NivelSugeira.BAIXO;
        } else if (probability < 0.9) {
            nivelSugeira = NivelSugeira.MEDIO;
        } else {
            nivelSugeira = NivelSugeira.ENGORDURADO;
        }

        return new Prato(numerosSerie++, nivelSugeira);
    }
}
