package negocio.Exceptions;

public class SalaNaoEncontradaException extends Exception {
    public SalaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}