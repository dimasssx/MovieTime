package dados;
import negocio.Exceptions.FilmeJaEstanoCatalogoException;
import negocio.Exceptions.FilmeNaoEstaNoCatalogoException;
import negocio.entidades.Filme;
import java.util.ArrayList;

public interface ICatalogo {

    void adicionarFilme(Filme filme) throws FilmeJaEstanoCatalogoException;
    void removerFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException;
    void atualizaFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException;
    void imprimir();
    Filme procurarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException;

}
