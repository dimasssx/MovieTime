package UI;

import fachada.FachadaCliente;
import fachada.FachadaGerente;
import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.entidades.Cliente;
import negocio.entidades.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaCliente {
   // private FachadaCliente fachada;
    private Scanner scanner;

    public TelaCliente() {
         scanner = new Scanner(System.in);
    }

    public void iniciar()  {
        System.out.println("Bem-vindo ao MovieTime");
        System.out.println("---------------------------");
        exibirCatalogo();
        while(true){
            System.out.println("1 - Comprar ingresso");
            System.out.println("2 - Buscar Filme");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    //comprarIngresso();
                    break;
                case 2:
               //    buscarFilme();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }
    public void exibirCatalogo() {
        System.out.println("Catalogo de Filmes:");
        System.out.println("--------------");
        FachadaGerente fachadaCliente = new FachadaGerente();
        ArrayList<Filme> filmes = fachadaCliente.imprimirCatalogo();

        for (Filme filme : filmes) {
            try {
                ArrayList<Sessao> sessoes = fachadaCliente.procurarSessaoTitulo(filme.getTitulo());
                if (sessoes.isEmpty()) {
                    continue;
                }
                System.out.println("Filme: " + filme);
                System.out.println("Sessoes disponiveis:");
                for (Sessao sessao : sessoes) {
                    System.out.println(sessao.getSala().getCodigo() + " " + sessao.getSala().getTipo() + " " + sessao.getHorario() + " - " + sessao.getDiaFormatado());
                }
            } catch (SessaoNaoEncontradaException e) {
            }
        }
    }
}
