package dados;
import negocio.entidades.*;

import java.util.ArrayList;

public interface IRepositorioUsuarios {

    public void adicionarUsuario(Usuario usuario);
    public boolean validarAutenticacao(String login, String senha);
    public ArrayList<Usuario> listarUsuarios();
    public void imprimir();
    public boolean existe(Usuario usuario);

}
