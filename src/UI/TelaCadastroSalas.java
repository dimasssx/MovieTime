package UI;

import dados.RepositorioSalas;
import fachada.FachadaGerente;
import negocio.entidades.Sala;
import negocio.entidades.Sala2D;
import negocio.entidades.Sala3D;

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


            int opcao = scanner.nextInt();
            scanner.nextLine();
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
                    TelaGerente telaGerente = new TelaGerente(fachada);
                    telaGerente.iniciar();
                    break;

            }
        }
    }

    private void adicionarSala(){
        System.out.println("Código");
        String codigo = scanner.nextLine();
        System.out.println("Tipo(2D/3D)");
        String tipo = scanner.nextLine();
        System.out.println("Quantidade de linhas de poltronas:");
        int linhas = scanner.nextInt();
        System.out.println("Quantidade de colunas de poltronas");
        int colunas = scanner.nextInt();
        if(tipo.equalsIgnoreCase("2D")) {
            Sala sala = new Sala2D(codigo, linhas, colunas);
            try {
                fachada.adicionarSala(sala);
            } catch (Exception e) {
                System.err.println(e.getMessage());

            }
        } else if (tipo.equalsIgnoreCase("3D")) {
            Sala sala = new Sala3D(codigo, linhas, colunas);
            try {
                fachada.adicionarSala(sala);
            } catch (Exception e) {
                System.err.println(e.getMessage());

            }
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
