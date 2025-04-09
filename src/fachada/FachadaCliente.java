package fachada;

import dados.*;
import negocio.CatalogoNegocio;
import negocio.SessoesNegocio;
import negocio.Exceptions.*;
import negocio.entidades.*;


public class FachadaCliente {

    private CatalogoNegocio catalogo;
    private SessoesNegocio sessoes;
    private Cliente cliente;

    public FachadaCliente() {}
    public FachadaCliente(Cliente cliente) {
         this.cliente = cliente;
        this.catalogo = new CatalogoNegocio(new Catalogo());
        this.sessoes = new SessoesNegocio(new RepositorioSessoes());
   }

     //Operações de consulta
    public Filme consultarFilme(String codigo) throws FilmeNaoEstaNoCatalogoException {
        return catalogo.procurarFilme(codigo);
   }

   public void listarCatalogo() {catalogo.listarCatalogo();
   }

//   public Sessao consultarSessao(String codigo) throws SessaoNaoEncontradaException {
//       return sessoes.procurar
//   }

  // Operações de compra
//
//  public Ingresso comprarIngresso(Sessao sessao, Assento assento)
//            throws AssentoOcupadoException, SessaoLotadaException {
//        return sessoes.comprarIngresso(sessao, assento, cliente);
//    }
//
//    public void cancelarIngresso(Ingresso ingresso) throws IngressoNaoEncontradoException {
//        sessoes.cancelarIngresso(ingresso);
//    }
}