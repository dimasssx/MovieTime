package fachada;

import negocio.Autenticacao;


public class Cinema {
    private Autenticacao autenticacao;
    private FachadaCliente fachadaCliente;
    private FachadaClienteVIP fachadaClienteVIP;
    private FachadaGerente fachadaGerente;

    public Cinema(){
        this.autenticacao = new Autenticacao();
        this.fachadaCliente = new FachadaCliente();
        this.fachadaClienteVIP = new FachadaClienteVIP();
        this.fachadaGerente = new FachadaGerente();
    }
    public boolean autenticar(String nome){
        return autenticacao.autenticar(nome);
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
