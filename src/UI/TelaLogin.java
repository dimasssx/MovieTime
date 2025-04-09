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

    public void iniciar() throws ClienteNaoEncontradoException, ClienteJaExisteException {
        System.out.println("Bem-Vindo ao MovieTime!");
        System.out.println("---------------------------");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Não possue uma conta? Cadastre-se");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (!autenticou) {
            switch (opcao) {
                case 1:
                    lerCredenciais();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                default:
                    System.out.println("opcao invalida");
            }
        }
    }

    public void cadastrarCliente() throws ClienteJaExisteException {
        System.out.println("Digite o login do cliente:");
        String login = scanner.nextLine();
        System.out.println("Digite a senha do cliente:");
        String senha = scanner.nextLine();
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        fachada.cadastrarCliente(nome, login, senha);
    }

    public void lerCredenciais() throws ClienteNaoEncontradoException {
        System.out.println("Digite o nome de usuario");
        String login = scanner.nextLine();
        System.out.println("Digite a senha");
        String senha = scanner.nextLine();
        checarCredenciais(login, senha);
    }

    public void checarCredenciais(String login, String senha) throws ClienteNaoEncontradoException {

        if (login.equals("user") && senha.equals("123")){
            TelaCliente cliente = new TelaCliente();
            cliente.iniciar();
        }
        int tipoLogin = fachada.autenticar(login, senha);
        if (tipoLogin == 1) {
            TelaGerente telaGerente = new TelaGerente(fachada.getFachadaGerente());
            telaGerente.iniciar();
        }else if(tipoLogin == 2) {
//            TelaCliente telaCliente = new TelaCliente(fachada.getFachadaCliente());
//            telaCliente.iniciar();

        }
        autenticou = true;

    }
}

