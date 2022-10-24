package exceptions;

public class VeterinarioJaCadastrado extends Exception {

    public VeterinarioJaCadastrado() {
        super("Este veterinário já está cadastrado");
    }
    
}
