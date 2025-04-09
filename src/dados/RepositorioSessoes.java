package dados;

import negocio.entidades.Filme;
import negocio.entidades.Sala;
import negocio.entidades.Sessao;

import java.io.*;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.ArrayList;


public class RepositorioSessoes implements IRepositorioSessoes, Serializable {
    @Serial
    private static final long serialVersionUID = 5527816120194523955L;
    ArrayList<Sessao> sessoes;
    private File file;


    public RepositorioSessoes() {
        file = new File("SalasSessoes.dat");
        if (file.exists()) {
            lerSalas();
        } else {
            sessoes = new ArrayList<>();
            escreverSalas();
        }
    }

    public void lerSalas() {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            sessoes = (ArrayList<Sessao>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            sessoes = new ArrayList<>();
        }
    }

    public void escreverSalas() {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutput oos = new ObjectOutputStream(fos);
            oos.writeObject(sessoes);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            sessoes = new ArrayList<>();
        }
    }

    @Override
    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
        escreverSalas();
    }


    @Override
    public void removerSessao(Sessao sessao) {
        int index = sessoes.indexOf(sessao);
        if (index != -1) {
            sessoes.remove(sessao);
            escreverSalas();
        }
    }

    @Override
    public void removerSessao(LocalTime horario, String sala, MonthDay dia) {
        for (Sessao s : sessoes) {
            if (s.getHorario().equals(horario) && s.getSala().getCodigo().equals(sala) && s.getDia().equals(dia)) {
                sessoes.remove(s);
            }
        }
    }

    public void atualizarSessao(Sessao sessao) {
        int index = sessoes.indexOf(sessao);
        if (index != -1) {
            sessoes.set(index, sessao);
            escreverSalas();
        }
    }

    public void imprimir() {
        for (Sessao sessao : sessoes) {
            System.out.println(sessao);
        }

    }

    public Sessao procurarSessao(Sessao sessao) {
        Sessao sessaodesejada = null;
        for (Sessao s : sessoes) {
            if (s.equals(sessao)) {
                sessaodesejada = s;
            }
        }
        return sessaodesejada;

    }

    public ArrayList<Sessao> procurarSessao(String filme) {
        ArrayList<Sessao> sessoesFilmes = new ArrayList<>();
        for (Sessao s : sessoes) {
            if (s.getFilme().getTitulo().equalsIgnoreCase(filme)) {
                sessoesFilmes.add(s);
            }
        }
        return sessoesFilmes;
    }

    public Sessao buscarSessao(LocalTime horario, String sala, MonthDay dia) {
        Sessao sessaodesejada = null;
        for (Sessao s : sessoes) {
            if (s.getHorario().equals(horario) && s.getSala().getCodigo().equals(sala) && s.getDia().equals(dia)) {
                sessaodesejada = s;
                break;
            }
        }
        return sessaodesejada;
    }

    public ArrayList<Sessao> BuscarSessoesDoDia(MonthDay dia) {
        ArrayList<Sessao> sessoesDoDia = new ArrayList<Sessao>();
        for (Sessao s : sessoes) {
            if (s.getDia().equals(dia)) {
                sessoesDoDia.add(s);
            }
        }
        return sessoesDoDia;
    }

    @Override
    public boolean existe(Sessao sessao) {
        return sessoes.contains(sessao);
    }

    @Override
    public ArrayList<Sessao> Buscartodas() {
        ArrayList<Sessao> sessoesFilmes = new ArrayList<>();
        for (Sessao s : sessoes) {
            if (s!= null) {
                sessoesFilmes.add(s);
            }
        }
        return sessoesFilmes;
    }
}


