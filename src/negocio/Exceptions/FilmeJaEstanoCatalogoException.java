package negocio.Exceptions;

public class FilmeJaEstanoCatalogoException extends Exception {
    public FilmeJaEstanoCatalogoException() {
        super("Filme ja esta no catalogo");
    }
}
