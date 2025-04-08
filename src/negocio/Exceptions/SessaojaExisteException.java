package negocio.Exceptions;

public class SessaojaExisteException extends Exception {
    public SessaojaExisteException(){
        super("A Sessao ja existe");
    }
}
