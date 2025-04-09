package negocio;

import dados.IRepositorioSessoes;
import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.Exceptions.SessaojaExisteException;
import negocio.entidades.Sessao;

public class SessoesNegocio {

    IRepositorioSessoes sessoes;

    public SessoesNegocio(IRepositorioSessoes sessoes){
        this.sessoes = sessoes;
    }

    public void adicionarSessao(Sessao sessao) throws SessaojaExisteException{
        if (sessoes.existe(sessao)){
            throw new SessaojaExisteException();
        }else sessoes.adicionarSessao(sessao);
    }
    public void removerSessao(Sessao sessao) throws SessaoNaoEncontradaException {
        if(sessoes.existe(sessao))  sessoes.removerSessao(sessao);
        else throw new SessaoNaoEncontradaException();

    }
    public void atualizarSessao(Sessao sessao)throws SessaoNaoEncontradaException{
        Sessao s = sessoes.procurarSessao(sessao);
        if (s != null) sessoes.atualizarSessao(sessao);
        else throw new SessaoNaoEncontradaException();

    }
    public Sessao procurarSessao(Sessao sessao) throws SessaoNaoEncontradaException {
        Sessao s = sessoes.procurarSessao(sessao);
        if (s != null) return s;
        else throw new SessaoNaoEncontradaException();
    }
    public Sessao procurarSessao(String filme) throws SessaoNaoEncontradaException {
        Sessao s = sessoes.procurarSessao(filme);
        if (s != null) return s;
        else throw new SessaoNaoEncontradaException();
    }


}
