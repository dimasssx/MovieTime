//Augusto
package fachada;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dados.IRepositorioSessoes;
import negocio.Exceptions.AssentoOcupadoException;
import negocio.Exceptions.SalaLotadaException;
import negocio.entidades.Assento;
import negocio.entidades.Filme;
import negocio.entidades.Ingresso;
import negocio.entidades.Sala;
import negocio.entidades.Sessao;
import negocio.pagamento.MetodoPagamento;

public class Cliente {
    private IRepositorioSessoes repoSessoes;
    private List<Ingresso> ingressos = new ArrayList<>();
    private List<String> lanches = new ArrayList<>(); 
    private double total;
    private boolean isVip;

    public Cliente(IRepositorioSessoes repoSessoes, String usuarioLogado, boolean isVip) {
        this.repoSessoes = repoSessoes;
        this.usuarioLogado = usuarioLogado;
        this.isVip = isVip;
}
    
    //Casos de Uso

    // UC02 - Visualizar Catálogo 
    public void visualizarCatalogo() {
        System.out.println("\n--- CATÁLOGO DE FILMES ---");
        System.out.println("TÍTULO | GÊNERO | DURAÇÃO | CLASSIFICAÇÃO");
        System.out.println("----------------------------------------");
        
        for (Sessao sessao : repoSessoes.listarTodasSessoes()) {
            Filme filme = sessao.getFilme();
            System.out.println(
                filme.getTitulo() + " | " +
                filme.getGenero() + " | " +
                filme.getDuracao() + " min | " +
                filme.getClassificacao()
            );
        }
    }
    
    // UC03 - Visualizar Assentos
    public void visualizarAssentos(Sessao sessao) {
        System.out.println("\n--- ASSENTOS DISPONÍVEIS ---");
        System.out.println("Filme: " + sessao.getFilme().getTitulo());
        System.out.println("Sala: " + sessao.getSala().getCODIGO());
        
        Assento[][] assentos = sessao.getSala().getAssentos();
        System.out.println("\nLegenda: [ ] = Livre  [X] = Ocupado\n");
        
        // Cabeçalho com números das colunas
        System.out.print("   ");
        for (int col = 1; col <= assentos[0].length; col++) {
            System.out.print(" " + col + "  ");
        }
        System.out.println();
        
        // Mapa de assentos
        for (int i = 0; i < assentos.length; i++) {
            System.out.print((char)('A' + i) + "  "); 
            for (int j = 0; j < assentos[i].length; j++) {
                System.out.print(assentos[i][j].isReservado() ? "[X] " : "[ ] ");
            }
            System.out.println();
        }
    }
    
    // UC04 - Comprar Ingresso 
    public void adicionarIngresso(Sessao sessao, String codigoAssento) 
            throws SalaLotadaException, AssentoOcupadoException {
        
        if (!sessao.getSala().temAssentosDisponiveis()) {
            throw new SalaLotadaException();
        }

        int linha = codigoAssento.charAt(0) - 'A';
        int coluna = Integer.parseInt(codigoAssento.substring(1)) - 1;
        
        if (linha < 0 || linha >= sessao.getSala().getAssentos().length || 
            coluna < 0 || coluna >= sessao.getSala().getAssentos()[0].length) {
            throw new IllegalArgumentException("Assento inválido!");
        }

        Assento assento = sessao.getSala().getAssentos()[linha][coluna];
        if (assento.isReservado()) {
            throw new AssentoOcupadoException(codigoAssento);
        }

        assento.reservar();
        Ingresso ingresso = new Ingresso(sessao, assento, isVip);
        ingressos.add(ingresso);
        total += ingresso.getPreco();
    }

    // UC05 - Comprar Lanches 
    public void adicionarLanche(String nome, double preco) {
        lanches.add(nome + " (R$ " + preco + ")");
        total += preco;
        System.out.println(
            nome + " adicionado." +
            "\nTotal parcial: R$ " + total
        );
    }

    public void finalizarCompra(MetodoPagamento metodo) {
        if (ingressos.isEmpty() && lanches.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        double valorFinal = isVip ? total * 0.9 : total; 

        if (metodo.processarPagamento(valorFinal)) {
            System.out.println("Pagamento via " + metodo.getTipo() + " aprovado!");
            limparCarrinho();
        } else {
            System.out.println("Pagamento recusado.");
        }
    }

    public void verCarrinho() {
        System.out.println("\n--- ITENS NO CARRINHO ---");
        if (ingressos.isEmpty() && lanches.isEmpty()) {
            System.out.println("(Vazio)");
            return;
        }
        
        ingressos.forEach(i -> System.out.println(
            "[INGRESSO] " + i.getSessao().getFilme().getTitulo() + 
            " | Assento " + i.getAssento() + 
            " | R$ " + i.getPreco()
        ));
        
        lanches.forEach(l -> System.out.println("[LANCHE] " + l));
        
        System.out.printf("\nTOTAL PARCIAL: R$ %.2f\n", total);
    }

    private void limparCarrinho() {
        ingressos.clear();
        lanches.clear();
        total = 0;
    }
}
