package negocio;

import dados.IRepositorioSalas;
import dados.IRepositorioSessoes;
import negocio.Exceptions.AssentoIndisponivelException;
import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.Exceptions.SessaojaExisteException;
import negocio.entidades.Sala;
import negocio.entidades.Sessao;

import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    public void removerSessao(String shorario, String ssala, String sdia) throws SessaoNaoEncontradaException {

        LocalTime horario = LocalTime.parse(shorario);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM");
        MonthDay dia = MonthDay.parse(sdia, formater);

        Sessao sessaoprocurada = sessoes.buscarSessao(horario,ssala,dia);
        if(sessaoprocurada != null)  sessoes.removerSessao(sessaoprocurada);
        else throw new SessaoNaoEncontradaException();

    }
    public void atualizarSessao(Sessao sessao)throws SessaoNaoEncontradaException{
        Sessao s = sessoes.procurarSessao(sessao);
        if (s != null) sessoes.atualizarSessao(sessao);
        else throw new SessaoNaoEncontradaException();

    }
    public Sessao procurarSessao(String sdia, String filme, String shorario) throws SessaoNaoEncontradaException {
        LocalTime horario = LocalTime.parse(shorario);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM");
        MonthDay dia = MonthDay.parse(sdia, formater);

        Sessao sessaoprocurada = sessoes.procurarSessao(dia,filme,horario);
        if (sessaoprocurada!= null) return sessaoprocurada;
        else throw new SessaoNaoEncontradaException();

    }
    public ArrayList<Sessao> procurarSessao(String titulo) throws SessaoNaoEncontradaException {
        ArrayList<Sessao> s = sessoes.procurarSessao(titulo);
        if (s != null) return s;
        else throw new SessaoNaoEncontradaException();
    }
    public ArrayList<Sessao> procurarSessaodoDia(String sdia) throws SessaoNaoEncontradaException {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM");
        MonthDay dia = MonthDay.parse(sdia,formater);
        ArrayList<Sessao> s = sessoes.BuscarSessoesDoDia(dia);
        if (s != null) return s;
        else throw new SessaoNaoEncontradaException();
    }

    public void mostrarAssentosDaSessao(Sessao sessao) throws SessaoNaoEncontradaException {
        sessao.mostrarAssentos();
    }

    public void reservarAssento(Sessao sessao, int fileira, int poltrona) throws AssentoIndisponivelException {
        boolean reservado = sessao.reservarAssento(fileira, poltrona);
        if (reservado) {
            sessoes.atualizarSessao(sessao);
        } else {
            throw new AssentoIndisponivelException("Assento indisponivel");
        }
    }


    public ArrayList<Sessao> imprimeSessoes(){
        return sessoes.Buscartodas();
    }

}
