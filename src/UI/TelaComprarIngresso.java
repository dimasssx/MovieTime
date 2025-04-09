package UI;

import fachada.FachadaCliente;
import negocio.Exceptions.*;
import negocio.entidades.*;
import negocio.SessoesNegocio;

import java.util.ArrayList;
import java.util.Scanner;


public class TelaComprarIngresso {
    private FachadaCliente fachada;
    private Scanner scanner;

    public TelaComprarIngresso(FachadaCliente fachada) {
        this.fachada = fachada;
        this.scanner = new Scanner(System.in);

    }

    public void iniciar() throws AssentoIndisponivelException, SessaoNaoEncontradaException {
        
        Sessao sessaoescolhida = null;
        while (sessaoescolhida == null) {

            System.out.println("Dia desejado dd-MM");
            String dia = scanner.nextLine();
            System.out.println("Filme desejado");
            String nome = scanner.nextLine();
            System.out.println("horario desejado hh:mm");
            String horario = scanner.nextLine();

            try {
                sessaoescolhida = checarSessao(dia,nome,horario);
            } catch (Exception e) {
                System.out.println(sessaoescolhida);
                System.err.println(e);;
            }
        }

        int quantidade_ingressos;

        System.out.println("Quantos ingressos deseja comprar? ");
        quantidade_ingressos = scanner.nextInt();
        scanner.nextLine();

        TelaEscolhaAssentos telaAssentosSala = new TelaEscolhaAssentos(sessaoescolhida,quantidade_ingressos,fachada);
        telaAssentosSala.iniciar();
    }

    public Sessao checarSessao(String dia, String nome, String horario) throws SessaoNaoEncontradaException {
        return fachada.checarSessao(dia,nome, horario);
    }
}
