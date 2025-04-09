package UI;

import dados.RepositorioSalas;
import fachada.FachadaGerente;
import negocio.entidades.Sala;
import negocio.entidades.Sala2D;
import negocio.entidades.Sala3D;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaCadastroSalas {
    private Scanner scanner;
    private FachadaGerente fachada;

    public TelaCadastroSalas(FachadaGerente fachada){
        this.scanner = new Scanner(System.in);
        this.fachada = fachada;
    }

    public void iniciar(){
        System.out.println("Tela Cadastro Salas");
        while (true){
            System.out.println("1 - Adicionar Sala");
            System.out.println("2 - Remover Sala");
            System.out.println("3 - Listar Salas");
            System.out.println("4 - Voltar");


            int opcao = -1;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Digite um número");
                scanner.nextLine();
                continue;
            }

            switch (opcao){
                case 1:
                    adicionarSala();
                    break;
                case 2:
                    removerSala();
                    break;
                case 3:
                    listarSalas();
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Opção Inválida");

            }
        }
    }

    private void adicionarSala(){

        System.out.println("Código da Sala:");
        String codigo = scanner.nextLine();

        System.out.println("Tipo da Sala (2D/3D)");
        String tipo = scanner.nextLine();

        int linhas = 0, colunas = 0;

        while(true){
            try {
                System.out.println("Quantidade de linhas de poltronas:");
                linhas = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Digite um numero valido");
                scanner.nextLine();
            }
        }

        while(true){
            try {
                System.out.println("Quantidade de colunas de poltronas:");
                colunas = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Digite um numero valido");
                scanner.nextLine();
            }
        }
        Sala sala = null;

        if(tipo.equalsIgnoreCase("2D")) {
            sala = new Sala2D(codigo, linhas, colunas);
        } else if (tipo.equalsIgnoreCase("3D")) {
            sala = new Sala3D(codigo, linhas, colunas);
        }
        try {
            fachada.adicionarSala(sala);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            }
        }

    private void removerSala(){
        System.out.println("O código da sala que será removida");
        String codigo = scanner.nextLine();
        try {
            fachada.removerSala(codigo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void listarSalas(){
        fachada.imprimirSalas();
    }
}
