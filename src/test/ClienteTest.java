package test;

import dados.IRepositorioClientes;
import dados.RepositorioClientes;
import fachada.Cinema;
import fachada.FachadaCliente;
import negocio.ClienteNegocio;
import negocio.Exceptions.ClienteJaExisteException;
import negocio.Exceptions.ClienteNaoEncontradoException;
import negocio.entidades.Cliente;

public class ClienteTest {
    public static void main(String[] args) throws ClienteNaoEncontradoException {
        // Instanciar o repositório e a lógica de negócio
        IRepositorioClientes repositorio = new RepositorioClientes();
        ClienteNegocio clienteNegocio = new ClienteNegocio(repositorio);
        FachadaCliente cliente = new FachadaCliente();
        Cinema cinema = new Cinema();
        System.out.println(cinema.autenticar("hjao","123"));
        System.out.println(clienteNegocio.buscarCliente("hjao", "123"));
    }
}
//        try {
//            // Cadastrar clientes
//            clienteNegocio.adicionarCliente("João", "joao123", "senha123");
//            clienteNegocio.adicionarCliente("Maria", "maria456", "senha456");
//
//            // Imprimir clientes após cadastro
//            System.out.println("Clientes após cadastro:");
//            clienteNegocio.imprimirClientes();
//
//        } catch (ClienteJaExisteException e) {
//            System.out.println("Erro: Cliente já existe.");
//        }
//
//        try {
//            // Cadastrar clientes
//            clienteNegocio.adicionarCliente("João", "joao321", "senha123");
//            clienteNegocio.adicionarCliente("Wesley", "joao123", "senha123");
//
//
//            // Imprimir clientes após cadastro
//            System.out.println("Clientes após cadastro:");
//            clienteNegocio.imprimirClientes();
//
//        } catch (ClienteJaExisteException e) {
//            System.out.println("Erro: Cliente já existe.");
//        }
//
//        try {
//            // Cadastrar clientes
//            clienteNegocio.adicionarCliente("Wesley", "wesley123", "senha123");
//
//
//            // Imprimir clientes após cadastro
//            System.out.println("Clientes após cadastro:");
//            clienteNegocio.imprimirClientes();
//
//        } catch (ClienteJaExisteException e) {
//            System.out.println("Erro: Cliente já existe.");
//        }
//    }
//}
