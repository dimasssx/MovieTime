package negocio.Exceptions;

public class SessaoJaEstaNaSalaException extends Exception {
    public SessaoJaEstaNaSalaException(){
        super("Sessao ja cadastrada");
    }
}
