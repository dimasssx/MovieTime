package negocio;

import dados.IRepositorioClientes;
import negocio.Exceptions.*;
import negocio.entidades.Assento;
import negocio.entidades.Cliente;
import negocio.entidades.Ingresso;
import negocio.entidades.Sessao;
import negocio.SessoesNegocio;

import java.util.Scanner;

public class ClienteNegocio {
    IRepositorioClientes clientes;
    Scanner scanner;

    public ClienteNegocio(IRepositorioClientes clientes) {
        this.clientes = clientes;
    }

    public void adicionarCliente(String nome, String login, String senha) throws ClienteJaExisteException {

        if (!clientes.existe(login)) {
            Cliente cliente = new Cliente(nome, login, senha);
            clientes.adicionarCliente(cliente);
        } else if (clientes.existe(login)) {
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
            throw new ClienteNaoEncontradoException();
        }
    }


    public Ingresso comprarIngresso(Cliente cliente, Sessao sessao, Scanner input) throws AssentoIndisponivelException {
        if (sessao.assentosDisponiveis() == 0) {
            System.out.println("Não há assentos disponíveis para esta sessão.");
            return null;
        }

        sessao.mostrarAssentos();

        while (true) {
            try {
                System.out.println("\nDigite o assento desejado ou 0 para cancelar");
                String entrada = scanner.nextLine().trim().toUpperCase();

                if (entrada.equals("0")) {
                    System.out.println("Operação cancelada");
                    return null;
                }

                int fileira = entrada.charAt(0) - 'A';
                int poltrona = Integer.parseInt(entrada.substring(1)) - 1;

                if (sessao.reservarAssento(fileira, poltrona)) {
                    Assento assento = sessao.getAssento(fileira, poltrona);
                    Ingresso ingresso = new Ingresso(sessao, assento);

//                    if(cliente.getIngressosComprados != null){
//                      cliente.adicionarIngresso(ingresso);
//                    }

                    System.out.println("Ingresso Adquirido para o assento "+ entrada);
                    ingresso.gerarIngresso();
                    return ingresso;
                }else{
                    System.out.println("Assento" + entrada + "indisponível");
                }


//          }  catch (AssentoInvalidoException e) {
//                System.out.println("Número do assento inválido");
            } catch (AssentoIndisponivelException e) {
                System.out.println("Erro ao fazer reserva: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }
}

