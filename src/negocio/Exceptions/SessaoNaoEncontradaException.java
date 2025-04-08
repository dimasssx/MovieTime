package negocio.Exceptions;

public class SessaoNaoEncontradaException extends Exception {
    public SessaoNaoEncontradaException() {
        super("negocio.entidades.Sessao nao foi encontrada");
    }
}
