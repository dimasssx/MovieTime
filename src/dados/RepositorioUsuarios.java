package dados;

import negocio.entidades.Usuario;
import java.io.*;
import java.util.ArrayList;

public class RepositorioUsuarios implements IRepositorioUsuarios, Serializable {

    @Serial
    private static final long serialVersionUID = -4009776605163947716L;
    private ArrayList<Usuario> usuarios;
    private File file;

    public RepositorioUsuarios() {
        file = new File("usuarios.dat");
        if (file.exists()) {
            lerUsuarios();
        } else {
            usuarios = new ArrayList<Usuario>();
            escritaUsuarios();
        }
    }

    public void lerUsuarios() {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            usuarios = (ArrayList<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            usuarios = new ArrayList<Usuario>();
        }
    }

    public void escritaUsuarios() {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutput oos = new ObjectOutputStream(fos);
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            usuarios = new ArrayList<Usuario>();
        }
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        escritaUsuarios();
    }

    @Override
    public boolean validarAutenticacao(String login, String senha) {
        boolean usuarioEncontrado = false;
        for(Usuario u : usuarios){
            if(login == u.getLogin() && senha == u.getSenha()){
                usuarioEncontrado = true;
                return usuarioEncontrado;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void imprimir() {
        for (Usuario s : usuarios) {
            System.out.println(s);
        }
    }

    @Override
    public boolean existe(Usuario usuario) {
        return usuarios.contains(usuario);
    }
}
