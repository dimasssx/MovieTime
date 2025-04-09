package negocio.Exceptions;

public class OpcaoInvalidaException extends Exception{
    public OpcaoInvalidaException() {
        super("Opcao invalida selecionada");
    }
}
