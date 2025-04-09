package dados;
import negocio.Exceptions.FilmeJaEstanoCatalogoException;
import negocio.Exceptions.FilmeNaoEstaNoCatalogoException;
import negocio.entidades.Filme;
import java.util.ArrayList;

public interface ICatalogo {

    void adicionarFilme(Filme filme);
    void removerFilme(String nome) ;
    void removerFilme(Filme filme) ;
    void atualizaFilme(Filme filme);
    Filme procurarFilme(Filme filme);
    Filme procurarFilme(String nome);
    boolean existe (Filme filme);
    void imprimir(); //fazerretornararray

}
