package negocio;

import negocio.Exceptions.ClienteJaExisteException;
import dados.RepositorioClientes;

public class Cadastro {
    private ClienteNegocio negocioCliente;

    public Cadastro() {
        this.negocioCliente = new ClienteNegocio(new RepositorioClientes());
    }

    public void cadastrarCliente(String nome, String login, String senha) throws ClienteJaExisteException {
        negocioCliente.adicionarCliente(nome, login, senha);
    }

}
