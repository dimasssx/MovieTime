package dados;

import negocio.Exceptions.FilmeJaEstanoCatalogoException;
import negocio.Exceptions.FilmeNaoEstaNoCatalogoException;
import negocio.entidades.Filme;

import java.io.*;
import java.util.ArrayList;

public class Catalogo implements ICatalogo,Serializable {

    @Serial
    private static final long serialVersionUID = -4009776605163947716L;
    private ArrayList<Filme> catalogo;
    private File file;

    public Catalogo(){
        file = new File("Catalogo_Filmes.dat");
        if (file.exists()){
            lerCatalogoFilmes();
        }else {
            catalogo = new ArrayList<Filme>();
            escritaCatalogoFilmes();
        }
    }

    public void lerCatalogoFilmes(){
        try(FileInputStream fis = new FileInputStream(file)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            catalogo = (ArrayList<Filme>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
            catalogo = new ArrayList<Filme>();
        }
    }
    public void escritaCatalogoFilmes(){
        try(FileOutputStream fos = new FileOutputStream(file)){
            ObjectOutput oos = new ObjectOutputStream(fos);
            oos.writeObject(catalogo);
        }catch (IOException e){
            System.err.println(e.getMessage());
            catalogo = new ArrayList<Filme>();
        }
    }

    @Override
    public void adicionarFilme(Filme filme){
        catalogo.add(filme);
        escritaCatalogoFilmes();
    }

    @Override
    public void removerFilme(Filme filme) {
        int index = catalogo.indexOf(filme);
        if (index != -1){
            catalogo.remove(filme);
            escritaCatalogoFilmes();
        }
    }
    @Override
    public void removerFilme(String nome) {
        Filme filmeDesejado = null;
        for (Filme filme: catalogo){
            if(filme.getTitulo().equals(nome)){
                filmeDesejado = filme;
                break;
            }
        }
        int index = catalogo.indexOf(filmeDesejado);
        if (index != -1){
            catalogo.remove(filmeDesejado);
            escritaCatalogoFilmes();
        }
    }

    @Override
    public void atualizaFilme(Filme filme)  {
        int index = catalogo.indexOf(filme);
        if (index != -1){
            catalogo.set(index,filme);
            escritaCatalogoFilmes();
        }
    }

    @Override
    public Filme procurarFilme(Filme filme) {
        Filme filmeDesejado = null;
        int index = catalogo.indexOf(filme);
        if (index != -1) {
            filmeDesejado = catalogo.get(index);
        }
        return filmeDesejado;
    }
    public Filme procurarFilme(String nome) {
        Filme filmeDesejado = null;
        for (Filme filme: catalogo){
            if(filme.getTitulo().equals(nome)){
                filmeDesejado = filme;
                break;
            }
        }
        return filmeDesejado;
    }
    @Override
    public void imprimir(){
        for (Filme filme : catalogo) {
            System.out.println(filme);
        }
    }

    @Override
    public boolean existe(Filme filme){
        return catalogo.contains(filme);
    }
}
