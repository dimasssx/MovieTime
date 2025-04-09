package fachada;

import dados.*;
import negocio.CatalogoNegocio;
import negocio.ClienteNegocio;
import negocio.SessoesNegocio;
import negocio.Exceptions.*;
import negocio.entidades.*;
import java.util.ArrayList;


public class FachadaCliente {
    private CatalogoNegocio catalogo;
    private SessoesNegocio sessoes;
    private ClienteNegocio clientes;

    public FachadaCliente() {
        clientes = new ClienteNegocio (new RepositorioClientes());
        this.catalogo = new CatalogoNegocio(new Catalogo());
        this.sessoes = new SessoesNegocio(new RepositorioSessoes());
   }

     //Operações de consulta
    public Filme consultarFilme(String codigo) throws FilmeNaoEstaNoCatalogoException {
        return catalogo.procurarFilme(codigo);
   }

   public void listarCatalogo() throws NenhumFilmeEncontradoException {catalogo.listarCatalogo();
   }
    public ArrayList<Sessao> procurarSessaoTitulo(String titulo) throws SessaoNaoEncontradaException {
        return sessoes.procurarSessao(titulo);
    }
   public Sessao checarSessao(String dia, String nome, String horario) throws SessaoNaoEncontradaException {
       return sessoes.procurarSessao(dia,nome,horario);
   }

    public void mostrarAssentosDaSessao(Sessao s) throws SessaoNaoEncontradaException {
        sessoes.mostrarAssentosDaSessao(s);
    }
    public ArrayList<Filme> imprimirCatalogo() throws NenhumFilmeEncontradoException {
        return catalogo.listarCatalogo();
    }
    public void reservarAssento(Sessao s, String assento) throws AssentoIndisponivelException {
        int fileira = assento.charAt(0) - 'A'; // 'A' -> 0, 'B' -> 1...
        int poltrona = Integer.parseInt(assento.substring(1)) - 1;
        sessoes.reservarAssento(s, fileira, poltrona);
    }

//   public Sessao consultarSessao(String codigo) throws SessaoNaoEncontradaException {
//       return sessoes.procurar
//   }

  // Operações de compra
//
//  public void comprarIngresso(Cliente cliente, Sessao sessao, int fileira, int assento) throws IngressoIndisponivelException {
//    }

//public ArrayList<Sessao> imprimirSessoesDisponiveis() {
   // Retorna todas as sessões disponíveis
//}
//
//    public void cancelarIngresso(Ingresso ingresso) throws IngressoNaoEncontradoException {
//        sessoes.cancelarIngresso(ingresso);
//    }
}