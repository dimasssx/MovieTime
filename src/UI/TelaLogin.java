package UI;

import fachada.Cinema;
import fachada.FachadaGerente;
import negocio.Autenticacao;
import negocio.Exceptions.ClienteJaExisteException;
import negocio.Exceptions.ClienteNaoEncontradoException;

import java.util.Scanner;

public class TelaLogin {

    private Scanner scanner;
    private boolean autenticou = false;
    private Cinema fachada;
    private Autenticacao autenticador;

    public TelaLogin(Cinema fachada) {
        this.scanner = new Scanner(System.in);
        this.fachada = fachada;
    }

    public void iniciar() {
        System.out.println("Bem-Vindo ao MovieTime!");
        System.out.println("---------------------------");

        while (!autenticou) {
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Não possue uma conta? Cadastre-se");
            System.out.println("3 - Sair");

            int opcao = -1;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Digite um número");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        lerCredenciais();
                    }catch (ClienteNaoEncontradoException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        cadastrarCliente();
                    } catch (ClienteJaExisteException e) {
                        System.out.println(e.getMessage());;
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.err.println("Opção Invalida");
            }
        }
    }

    public void cadastrarCliente() throws ClienteJaExisteException{
        System.out.println("-------------");
        System.out.println("Cadastro");
        System.out.println("Nome de usuario:");
        String login = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();
        System.out.println("Nome:");
        String nome = scanner.nextLine();

        fachada.cadastrarCliente(nome, login, senha);
        System.out.println("Cadastro realizado!");
    }

    public void lerCredenciais() throws ClienteNaoEncontradoException {
        System.out.println("Login");
        System.out.println("-----------------------");
        System.out.println("Digite o nome de usuario");
        String login = scanner.nextLine();
        System.out.println("Digite a senha");
        String senha = scanner.nextLine();
        checarCredenciais(login, senha);
    }

    public void checarCredenciais(String login, String senha) throws ClienteNaoEncontradoException {

        int tipoLogin = fachada.autenticar(login, senha);
        if (tipoLogin == 1) {
            TelaGerente telaGerente = new TelaGerente(fachada.getFachadaGerente());
            telaGerente.iniciar();
            System.out.println("Logout concluido, retornando ao menu de login...");
            iniciar();
        } else if (tipoLogin == 2) {
          //tela clienteVIP
        } else if(tipoLogin == 3) {
            TelaCliente telaCliente = new TelaCliente(fachada.getFachadaCliente());
            telaCliente.iniciar();
            System.out.println("Logout concluido, retornando ao menu de login...");
            iniciar();


        }
        autenticou = true;

    }
}

