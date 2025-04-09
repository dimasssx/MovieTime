package fachada;

import negocio.Autenticacao;
import negocio.Cadastro;
import negocio.Exceptions.ClienteJaExisteException;
import negocio.Exceptions.ClienteNaoEncontradoException;
import negocio.entidades.Cliente;

public class Cinema {
    private Autenticacao autenticacao;
    private Cliente negocioCliente;
    private Cadastro cadastro;
    private FachadaCliente fachadaCliente;
    private FachadaClienteVIP fachadaClienteVIP;
    private FachadaGerente fachadaGerente;

    public Cinema(){
        this.autenticacao = new Autenticacao();
        this.cadastro = new Cadastro();
        this.fachadaCliente = new FachadaCliente();
        this.fachadaClienteVIP = new FachadaClienteVIP();
        this.fachadaGerente = new FachadaGerente();
    }
    public int autenticar(String login, String senha) throws ClienteNaoEncontradoException {
        return autenticacao.autenticar(login, senha);
    }
    public void cadastrarCliente(String nome, String login, String senha) throws ClienteJaExisteException {
        cadastro.cadastrarCliente(nome, login, senha);
    }

    public FachadaGerente getFachadaGerente() {
        return fachadaGerente;
    }

    public FachadaCliente getFachadaCliente() {
        return fachadaCliente;
    }

    public FachadaClienteVIP getFachadaClienteVIP() {
        return fachadaClienteVIP;
    }


}
