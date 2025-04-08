package main;

import negocio.Exceptions.SessaoNaoEncontradaException;
import dados.Catalogo;
import negocio.entidades.Filme;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//     negocio.entidades.Filme filme1 = new negocio.entidades.Filme("Vitória", "Drama", "1h52", "16 anos");
//        negocio.entidades.Filme filme2 = new negocio.entidades.Filme("Mickey 17", "Ficção Científica", "2h19", "16 anos");
//       negocio.entidades.Filme filme3 = new negocio.entidades.Filme("O Macaco", "Terror", "1h35", "18 anos");
       Filme filme4 = new Filme("Capitão América: Admirável Mundo Novo", "Ação", "1h59", "14 anos");
      Filme filme6 = new Filme("Mickey 17", "Animação", "2h19", "10 anos");
//
//
       Sala sala1 = new Sala();
//       sala.imprime();
//
//        System.out.println(sala.isDisponivel());

        Catalogo catalogo = new Catalogo();

        catalogo.imprimir();

        Sessao sessao2 = new Sessao(filme4,"18:30",sala1);
        RepositorioSessoes sessoes = new RepositorioSessoes();

        try {
            sessoes.removerSessao(sessao2);
        }  catch (SessaoNaoEncontradaException e) {
            throw new RuntimeException(e);
        }
        System.out.println("________________________________");

        sessoes.imprimir();
    }
}