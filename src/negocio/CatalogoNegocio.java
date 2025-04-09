package negocio;

import dados.*;
import negocio.Exceptions.FilmeJaEstanoCatalogoException;
import negocio.Exceptions.FilmeNaoEstaNoCatalogoException;
import negocio.entidades.Filme;

import java.util.ArrayList;

public class CatalogoNegocio {

    ICatalogo catalogo;

    public CatalogoNegocio(ICatalogo catalogo){
        this.catalogo = catalogo;
    }

    public void adicionarFilme(Filme filme) throws FilmeJaEstanoCatalogoException {
        if (catalogo.existe(filme)){
            throw new FilmeJaEstanoCatalogoException();
        }else{
            catalogo.adicionarFilme(filme);
        }
    }

    public void removerFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException {
        boolean isFilmeNoCatalogo = catalogo.existe(filme);
        if (isFilmeNoCatalogo) catalogo.removerFilme(filme);
        else throw new FilmeNaoEstaNoCatalogoException();

    }
    public void removerFilme(String filme) throws FilmeNaoEstaNoCatalogoException {
        Filme filmeprocurado = catalogo.procurarFilme(filme);
        if (filmeprocurado != null) catalogo.removerFilme(filme);
        else throw new FilmeNaoEstaNoCatalogoException();
    }

    public void atualizarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException{
        Filme filmedesejado = catalogo.procurarFilme(filme);
        if (filmedesejado != null) catalogo.atualizaFilme(filme);
        else throw new FilmeNaoEstaNoCatalogoException();
    }
    public Filme procurarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException {
        Filme filmeprocurado = catalogo.procurarFilme(filme);
        if (filmeprocurado == null){
            throw new FilmeNaoEstaNoCatalogoException();
        }else return filmeprocurado;
    }
    public Filme procurarFilme(String filme) throws FilmeNaoEstaNoCatalogoException {
        Filme filmeprocurado = catalogo.procurarFilme(filme);
        if (filmeprocurado == null){
            throw new FilmeNaoEstaNoCatalogoException();
        }else return filmeprocurado;
    }
    public ArrayList<Filme> listarCatalogo(){
        return catalogo.listarFilmes();
    }

}
