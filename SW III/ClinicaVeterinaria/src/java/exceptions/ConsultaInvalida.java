package exceptions;

public class ConsultaInvalida extends Exception {
    
    public ConsultaInvalida() {
        super("Este veterinário não está disponível neste horário");
    }
}
