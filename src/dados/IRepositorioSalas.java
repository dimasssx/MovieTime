package dados;

import negocio.Exceptions.CodigoSalaJaExisteException;
import negocio.Exceptions.SalaNaoEncontradaException;
import negocio.entidades.Sala;

import java.io.Serializable;
import java.util.List;

public interface IRepositorioSalas {
    void adicionarSala(Sala sala);
    void removerSala(Sala sala) ;
    void atualizarSala(Sala sala);
    Sala procurarSala(String codigo);
    List<Sala> listarSalas();
    void imprimir();
    boolean existe(Sala sala);
}