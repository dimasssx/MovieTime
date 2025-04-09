package UI;

import fachada.FachadaGerente;

import java.util.Scanner;

public class TelaGerente {
    private FachadaGerente fachadaGerente;
    private Scanner scanner;

    public TelaGerente(FachadaGerente fachadaGerente){
        this.scanner = new Scanner(System.in);
        this.fachadaGerente = fachadaGerente;

    }

    public void iniciar(){
        System.out.println("Tela Gerente");
        System.out.println("1 - Gerenciar Filmes");
        System.out.println("2 - Gerenciar Salas");
        System.out.println("3 - Gerenciar Sessoes");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                TelaCadastroFilme telacadastro = new TelaCadastroFilme(fachadaGerente);
                telacadastro.iniciar();
                break;
            case 2:
               TelaCadastroSalas telaCadastrosala = new TelaCadastroSalas(fachadaGerente);
               telaCadastrosala.iniciar();
               break;
            case 3:
                TelaCadastroSessoes telacadastrosessoes = new TelaCadastroSessoes(fachadaGerente);
                telacadastrosessoes.iniciar();
        }


    }
}
