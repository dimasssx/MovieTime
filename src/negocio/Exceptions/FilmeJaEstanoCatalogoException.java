package negocio.Exceptions;

public class FilmeJaEstanoCatalogoException extends Exception {
    public FilmeJaEstanoCatalogoException() {
        super("O negocio.entidades.Filme ja esta no catalogo");
    }
}
