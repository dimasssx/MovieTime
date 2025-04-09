package dados;

import java.time.LocalTime;
import java.time.MonthDay;
import java.util.ArrayList;

import negocio.Exceptions.SalaNaoEncontradaException;
import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.entidades.Sala;
import negocio.entidades.Sessao;

public interface IRepositorioSessoes {
    void adicionarSessao(Sessao sessao);
    void removerSessao(Sessao sessao);
    void removerSessao(LocalTime horario, String sala, MonthDay dia);
    Sessao buscarSessao(LocalTime horario, String sala, MonthDay dia);
    void atualizarSessao(Sessao sessao);
    ArrayList<Sessao> BuscarSessoesDoDia(MonthDay dia);
    boolean existe (Sessao sessao);
    Sessao procurarSessao(Sessao sessao);
    ArrayList<Sessao> procurarSessao(String filme);
    void listarTodos();//debug
}
