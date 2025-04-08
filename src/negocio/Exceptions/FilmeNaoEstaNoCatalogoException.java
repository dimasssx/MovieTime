package negocio.Exceptions;

public class FilmeNaoEstaNoCatalogoException extends Exception {
    public FilmeNaoEstaNoCatalogoException() {
        super("O filme nao esta no catalogo");
    }
}
