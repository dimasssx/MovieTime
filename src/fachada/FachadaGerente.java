package fachada;

import dados.*;
import negocio.CatalogoNegocio;
import negocio.Exceptions.FilmeJaEstanoCatalogoException;
import negocio.Exceptions.FilmeNaoEstaNoCatalogoException;
import negocio.SalasNegocio;
import negocio.SessoesNegocio;
import negocio.entidades.Filme;
import negocio.entidades.Sala;

public class FachadaGerente {
    private CatalogoNegocio cadastroFilmes;
    private SalasNegocio cadastroSalas;
    private SessoesNegocio cadastroSessoes;

    public FachadaGerente(){
        cadastroFilmes = new CatalogoNegocio(new Catalogo());
        cadastroSalas = new SalasNegocio(new RepositorioSalas());
        cadastroSessoes = new SessoesNegocio(new RepositorioSessoes());
    }
    public void adicionarFilme(Filme filme) throws FilmeJaEstanoCatalogoException {
        cadastroFilmes.adicionarFilme(filme);
    }
    public void removerFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException {
        cadastroFilmes.removerFilme(filme);
    }
    public void atualizarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException {
        cadastroFilmes.atualizarFilme(filme);
    }
    public void procurarFilme(String filme) throws FilmeNaoEstaNoCatalogoException {
        cadastroFilmes.procurarFilme(filme);
    }

    public void adicionarSessao(){}
    public void removerSessao(){}
    public void atualizarSessao(){}
    public void procurarSessao(){}

    //public void reservarSala(){
    }

