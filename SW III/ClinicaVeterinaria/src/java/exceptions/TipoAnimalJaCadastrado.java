package exceptions;

public class TipoAnimalJaCadastrado extends Exception {

    public TipoAnimalJaCadastrado() {
        super("Este tipo de animal já está cadastrado");
    }
    
}
