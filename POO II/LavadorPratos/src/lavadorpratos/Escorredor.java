package lavadorpratos;

public class Escorredor {
    private Prato[] pratos;
    private int tamanho;
    private int cont;
    private int posicaoTirar;
    private int posicaoColocar;

    public Escorredor(int tamanho) {
        this.tamanho = tamanho;
        this.pratos = new Prato[tamanho];
    }
    
    public void colocarPrato(Prato prato) throws Exception {
        pratos[posicaoColocar] = prato;
        posicaoColocar++;
        cont++;

        
        if (cont > tamanho) {
            throw new Exception("Limites do escorredor violados");
        }

        if (cont == tamanho) {
            System.out.println("O escorredor está cheio");
        }
        if (posicaoColocar == tamanho) {
            posicaoColocar = 0;
        }
    }

    public Prato tirarPrato() throws Exception {
        Prato prato = pratos[posicaoTirar];
        posicaoTirar++;
        cont--;

        if (cont < 0) {
            throw new Exception("Limites do escorredor violados");
        }

        if (cont == 0) {
            System.out.println("O escorredor está vazio");
        }
        if (posicaoTirar == tamanho) {
            posicaoTirar = 0;
        }

        return prato;
    }

    public boolean vazio() {
        return cont == 0  ;
    }
    
    public boolean cheio() {
        return cont == tamanho;
    }
}
