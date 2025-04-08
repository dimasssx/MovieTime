package dados;

import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.entidades.Sessao;

public interface IRepositorioSessoes {
    void adicionarSessao(Sessao sessao);
    void removerSessao(Sessao sessao);
    void atualizarSessao(Sessao sessao) throws SessaoNaoEncontradaException;
    Sessao procurarSessao(Sessao sessao) throws SessaoNaoEncontradaException;
}
