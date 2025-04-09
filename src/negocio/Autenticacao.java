package negocio;

import java.util.ArrayList;

public class Autenticacao {
    public boolean autenticar(String nome) {
        return nome.equals("admin");
    }
}
