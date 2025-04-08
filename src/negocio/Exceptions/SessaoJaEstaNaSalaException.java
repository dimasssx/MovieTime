package negocio.Exceptions;

public class SessaoJaEstaNaSalaException extends Exception {
    public SessaoJaEstaNaSalaException(){
        super("negocio.entidades.Sessao ja cadastrada");
    }
}
