package UI;

import fachada.Cinema;

import java.util.Scanner;

public class TelaLogin {

    private Scanner scanner;
    private boolean autenticou = false;
    private String user;

    public TelaLogin(Cinema fachada) {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Cadastrar");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        while (!autenticou) {
            switch (opcao) {
                case 1:
                    lerCredenciais();

                    break;
                case 2:
                    System.out.println("cadastro");
                    break;
                default:
                    System.out.println("opcao invalida");
            }
        }
    }

    public void lerCredenciais() {
        System.out.println("Digite o nome de usuario");
        this.user = scanner.nextLine();
        checarCredenciais();
    }

    public void checarCredenciais() {
        if (this.user.equals("admin")){
            System.out.println("tela gerente");
        }
        else {
            System.out.println("verificar cliente");
        }
    }
}

