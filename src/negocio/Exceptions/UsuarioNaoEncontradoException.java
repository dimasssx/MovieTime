package negocio.Exceptions;

public class UsuarioNaoEncontradoException extends Exception{
    public UsuarioNaoEncontradoException() {
        super("negocio.entidades.Usuario nao foi encontrado");
    }
}
