package dados;

import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.Exceptions.SessaojaExisteException;
import negocio.entidades.Filme;
import negocio.entidades.Sessao;

public interface IRepositorioSessoes {
    void adicionarSessao(Sessao sessao);
    void removerSessao(Sessao sessao);
    void atualizarSessao(Sessao sessao);
    Sessao procurarSessao(Sessao sessao);
    Sessao procurarSessao(String filme);
    boolean existe(Sessao sessao);
    void imprimir();//fazerretornar o array

}
