package negocio;

import dados.*;
import negocio.Exceptions.CodigoSalaJaExisteException;
import negocio.Exceptions.LimiteSalasExcedidoException;
import negocio.Exceptions.SalaNaoEncontradaException;
import negocio.entidades.Sala;
import negocio.entidades.Sala2D;
import negocio.entidades.Sala3D;

public class SalasNegocio {

     IRepositorioSalas salas;

     public SalasNegocio(IRepositorioSalas salas){
         this.salas = salas;
     }

    public void adicionarSala(Sala sala) throws CodigoSalaJaExisteException, LimiteSalasExcedidoException {

        if (salas.listarSalas().stream().anyMatch(s -> s.getCodigo().equals(sala.getCodigo()))) {
            throw new CodigoSalaJaExisteException("O código " + sala.getCodigo() + " já existe.");
        }

        if (sala instanceof Sala2D && salas.listarSalas().stream().filter(s -> s instanceof Sala2D).count() >= 2) {
            throw new LimiteSalasExcedidoException("O limite de 2 salas 2D já foi atingido.");
        }

        if (sala instanceof Sala3D && salas.listarSalas().stream().filter(s -> s instanceof Sala3D).count() >= 1) {
            throw new LimiteSalasExcedidoException("O limite de 1 sala 3D já foi atingido.");
        }

        salas.adicionarSala(sala);
    }

    public void removerSala(String codigo) throws SalaNaoEncontradaException {
         Sala salaDesejada = salas.procurarSala(codigo);
         salas.removerSala(salaDesejada);
    }

    public void imprimirSalas(){
         salas.imprimir();
    }
    public Sala procurarSala(String codigo) throws SalaNaoEncontradaException {
         Sala saladesejada = salas.procurarSala(codigo);
         if (saladesejada != null){
             return saladesejada;
         }else throw new SalaNaoEncontradaException("Sala nao foi encontrada");
    }
}

