package negocio.Exceptions;

public class SessaoNaoEncontradaException extends Exception {
    public SessaoNaoEncontradaException() {
        super("Sessao nao foi encontrada");
    }
}
