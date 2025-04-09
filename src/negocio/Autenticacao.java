package negocio;

import negocio.Exceptions.ClienteNaoEncontradoException;

public class Autenticacao {

    private ClienteNegocio negocioCliente;

    public Autenticacao() {
    }

    public boolean autenticarGerente(String login, String senha) {
        return login.equals("admin") && senha.equals("123");
    }

    public boolean autenticarCliente(String login, String senha) throws ClienteNaoEncontradoException {
        return negocioCliente.validarCliente(login, senha);
    }

    public int autenticar(String login, String senha) throws ClienteNaoEncontradoException {
        if (login.equals("admin") && senha.equals("123")) {
            return 1; // Gerente
        } else if (negocioCliente.validarCliente(login, senha)) {
            if(negocioCliente.buscarCliente(login, senha).getIsVIP()) {
                return 2; // Cliente VIP
            } else {
                return 3; // Cliente Comum
            }
        }
        return 0; // Cliente não encontrado
    }
}