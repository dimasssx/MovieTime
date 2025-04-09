package fachada;

import dados.*;
import negocio.CatalogoNegocio;
import negocio.Exceptions.*;
import negocio.SalasNegocio;
import negocio.SessoesNegocio;
import negocio.entidades.*;

import java.util.ArrayList;

public class FachadaGerente {
    private CatalogoNegocio cadastroFilmes;
    private SalasNegocio cadastroSalas;
    private SessoesNegocio cadastroSessoes;

    public FachadaGerente(){
        cadastroFilmes = new CatalogoNegocio(new Catalogo());
        cadastroSalas = new SalasNegocio(new RepositorioSalas());
        cadastroSessoes = new SessoesNegocio(new RepositorioSessoes());
    }

    //operacoes de gerenciamento de filmes

    public void adicionarFilme(Filme filme) throws FilmeJaEstanoCatalogoException {
        cadastroFilmes.adicionarFilme(filme);
    }
    public void removerFilme(String filme) throws FilmeNaoEstaNoCatalogoException {
        cadastroFilmes.removerFilme(filme);
    }
    public void atualizarFilme(Filme filme) throws FilmeNaoEstaNoCatalogoException {
        cadastroFilmes.atualizarFilme(filme);
    }
    public Filme procurarFilme(String filme) throws FilmeNaoEstaNoCatalogoException {
        return cadastroFilmes.procurarFilme(filme);
    }
    public ArrayList<Filme> imprimirCatalogo() {

        return cadastroFilmes.listarCatalogo();
    }


    //gerenciamento sessoes

    public void adicionarSessao(Sessao sessao) throws SessaojaExisteException {
        cadastroSessoes.adicionarSessao(sessao);
    }
    public void removerSessao(String horario,String codigo, String dia) throws SessaoNaoEncontradaException {
        cadastroSessoes.removerSessao(horario,codigo,dia);
    }
    public void atualizarSessao(Sessao sessao) throws SessaoNaoEncontradaException {
        cadastroSessoes.atualizarSessao(sessao);
    }
    public ArrayList<Sessao> procurarSessaoporDia(String dia) throws SessaoNaoEncontradaException {
        return cadastroSessoes.procurarSessaodoDia(dia);
    }
    public ArrayList<Sessao> procurarSessaoTitulo(String titulo) throws SessaoNaoEncontradaException {
        return cadastroSessoes.procurarSessao(titulo);
    }
    public ArrayList imprimirSessoes(){
        return cadastroSessoes.imprimeSessoes();
    }


    //operacoes de gerenciamento de salas

    public void adicionarSala(Sala sala) throws CodigoSalaJaExisteException, LimiteSalasExcedidoException {
        cadastroSalas.adicionarSala(sala);
    }
    public void removerSala(String codigo) throws SalaNaoEncontradaException {
        cadastroSalas.removerSala(codigo);
    }
    public void imprimirSalas(){
        cadastroSalas.imprimirSalas();
    }
    public Sala procuraSala(String codigo) throws SalaNaoEncontradaException {
        return cadastroSalas.procurarSala(codigo);
    }
}

