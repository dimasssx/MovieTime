package negocio;

import dados.IRepositorioClientes;
import negocio.Exceptions.ClienteJaExisteException;
import negocio.Exceptions.ClienteNaoEncontradoException;
import negocio.entidades.Cliente;


public class ClienteNegocio {
    IRepositorioClientes clientes;

    public ClienteNegocio(IRepositorioClientes clientes) {
        this.clientes = clientes;
    }

    public void adicionarCliente(String nome, String login, String senha) throws ClienteJaExisteException {

        if (!clientes.existe(login)) {
            Cliente cliente = new Cliente(nome, login, senha);
            clientes.adicionarCliente(cliente);
        }
        else if (clientes.existe(login)) {
            throw new ClienteJaExisteException();
        }
    }

    public void imprimirClientes() {
        clientes.imprimir();
    }

    public Cliente buscarCliente(String login, String senha) {
        return clientes.retornarCliente(login, senha);
    }

    boolean validarCliente(String login, String senha) throws ClienteNaoEncontradoException {
        if (clientes.validarCliente(login, senha)) {
            return true;
        } else {
            return false;
        }
    }

    public void comprarIngresso() {

    }
}
