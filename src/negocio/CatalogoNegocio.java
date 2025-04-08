package negocio;

import dados.*;
import negocio.Exceptions.FilmeJaEstanoCatalogoException;
import negocio.Exceptions.FilmeNaoEstaNoCatalogoException;
import negocio.entidades.Filme;

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

    public void atualizarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException{
        boolean existe = catalogo.existe(filme);
        if (existe) catalogo.atualizaFilme(filme);
        else throw new FilmeNaoEstaNoCatalogoException();
    }
    public Filme procurarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException {
        boolean existe = catalogo.existe(filme);
        if (existe) return filme;
        else throw new FilmeNaoEstaNoCatalogoException();
    }


}
