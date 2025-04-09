package negocio.Exceptions;

public class CodigoSalaJaExisteException extends Exception {
    public CodigoSalaJaExisteException(String mensagem) {
        super(mensagem);
    }
}