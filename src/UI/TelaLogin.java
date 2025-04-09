package UI;

import fachada.Cinema;
import fachada.FachadaGerente;

import java.util.Scanner;

public class TelaLogin {

    private Scanner scanner;
    private boolean autenticou = false;
    private Cinema fachada;

    public TelaLogin(Cinema fachada) {
        this.scanner = new Scanner(System.in);
        this.fachada = fachada;
    }

    public void iniciar() {
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
        String user = scanner.nextLine();
        checarCredenciais(user);
    }

    public void checarCredenciais(String user) {
        boolean isGerente = fachada.autenticar(user);
        if (isGerente){
            TelaGerente telaGerente = new TelaGerente(fachada.getFachadaGerente());
            telaGerente.iniciar();
        }else{
            System.out.println("Cliente");

        }
        autenticou = true;

    }
}

