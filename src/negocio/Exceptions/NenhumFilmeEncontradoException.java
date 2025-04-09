package negocio.Exceptions;

public class NenhumFilmeEncontradoException extends Exception{
    public NenhumFilmeEncontradoException(){
        super("Nenhum filme foi encontrado");
    }
}
