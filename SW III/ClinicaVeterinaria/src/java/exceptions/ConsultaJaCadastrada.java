package exceptions;

public class ConsultaJaCadastrada extends Exception {
    
    public ConsultaJaCadastrada() {
        super("Esta consulta já está cadastrada");
    }
    
}
