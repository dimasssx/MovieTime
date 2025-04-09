package UI;

import java.util.Scanner;

import negocio.Exceptions.SessaoNaoEncontradaException;
import negocio.entidades.*;
import negocio.SessoesNegocio;
import fachada.FachadaCliente;
import negocio.Exceptions.AssentoIndisponivelException;


public class TelaEscolhaAssentos {
    private final Scanner scanner;
    private Sessao sessao;
    private int quantidadeIngressos;
    FachadaCliente fachada;

   public TelaEscolhaAssentos(Sessao sessao, int quantidadeIngressos, FachadaCliente fachada) {
        this.sessao = sessao;
        this.quantidadeIngressos = quantidadeIngressos;
        this.scanner = new Scanner(System.in);
        this.fachada = fachada;
    }

   public void iniciar() throws SessaoNaoEncontradaException, AssentoIndisponivelException {
       for(int i = 0; i < quantidadeIngressos; i++) {
           try {
               fachada.mostrarAssentosDaSessao(sessao);
           } catch (SessaoNaoEncontradaException e) {
               System.err.println(e.getMessage());
           }

           try {
               System.out.println("Escolha a poltrona: (Ex: A2)");
               String poltrona = scanner.nextLine();
               fachada.reservarAssento(sessao, poltrona);
           } catch (AssentoIndisponivelException e) {
               System.err.println(e.getMessage());
           }
       }
   }
}
