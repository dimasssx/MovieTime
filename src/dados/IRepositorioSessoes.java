package dados;

import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.Exceptions.SessaojaExisteException;
import negocio.entidades.Sessao;

public interface IRepositorioSessoes {
    void adicionarSessao(Sessao sessao);
    void removerSessao(Sessao sessao);
    void atualizarSessao(Sessao sessao);
    void imprimir();//fazerretornar o array
    Sessao procurarSessao(Sessao sessao);
    boolean existe(Sessao sessao);
}
