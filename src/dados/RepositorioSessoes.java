package dados;

import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.entidades.Sessao;

import java.io.*;
import java.util.ArrayList;


public class RepositorioSessoes implements IRepositorioSessoes,Serializable{
    @Serial
    private static final long serialVersionUID = 5527816120194523955L;
    ArrayList<Sessao> sessoes;
    private File file;

    public RepositorioSessoes(){
        file = new File("SalasSessoes.dat");
        if (file.exists()){
            lerSalas();
        }else {
            sessoes = new ArrayList<>();
            escreverSalas();
        }
    }

    public void lerSalas(){
        try(FileInputStream fis = new FileInputStream(file)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            sessoes = (ArrayList<Sessao>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
            sessoes = new ArrayList<>();
        }
    }
    public void escreverSalas(){
        try(FileOutputStream fos = new FileOutputStream(file)){
            ObjectOutput oos = new ObjectOutputStream(fos);
            oos.writeObject(sessoes);
        }catch (IOException e){
            System.err.println(e.getMessage());
            sessoes = new ArrayList<>();
        }
    }

    public void adicionarSessao(Sessao sessao){
        sessoes.add(sessao);
        escreverSalas();
    }
    
    public void removerSessao(Sessao sessao){
        sessoes.remove(sessao);
        escreverSalas();
    }

    public void atualizarSessao(Sessao sessao)  {
        int index = sessoes.indexOf(sessao);
        if (index != -1){
            sessoes.set(index,sessao);
            escreverSalas();
        }
    }
    public Sessao procurarSessao(Sessao sessao){
        Sessao sessaodesejada = null;
        int index = sessoes.indexOf(sessao);
        if (index != -1){
            sessaodesejada = sessoes.get(index);
        }
        return sessaodesejada;
    }

    @Override
    public boolean existe(Sessao sessao) {
        return sessoes.contains(sessao);
    }

    public void imprimir(){
        for (Sessao sessao : sessoes) {
            System.out.println(sessao);
        }
    }//mudar
}
