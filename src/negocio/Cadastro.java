package negocio;

import negocio.Exceptions.ClienteJaExisteException;
import negocio.entidades.Cliente;

public class Cadastro {
    private ClienteNegocio negocioCLiente;

    public Cadastro() {

    }

    public void cadastrarCliente(String nome, String login, String senha) throws ClienteJaExisteException {
        negocioCLiente.adicionarCliente(nome, login, senha);
    }


}
