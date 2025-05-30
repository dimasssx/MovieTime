package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import dados.RepositorioSalas;
import negocio.Exceptions.CodigoSalaJaExisteException;
import negocio.Exceptions.LimiteSalasExcedidoException;
import negocio.Exceptions.SalaNaoEncontradaException;

public abstract class Sala implements Serializable {
    @Serial
    private static final long serialVersionUID = -4009776605163947716L;

    private static final RepositorioSalas repositorio = new RepositorioSalas();
    private final String codigo;
    private final int fileiras;
    private final int assentosPorFileira;
    protected double precoBaseIngresso;

    public Sala(String codigo, int fileiras, int assentosPorFileira) {
        this.codigo = codigo;
        this.fileiras = fileiras;
        this.assentosPorFileira = assentosPorFileira;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getFileiras() {
        return fileiras;
    }

    public int getAssentosPorFileira() {
        return assentosPorFileira;
    }

    public abstract double calcularPrecoIngresso();
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Codigo Sala: " + codigo +
                ", Fileiras" + fileiras +
                ", Assentos Por Fileiras" + assentosPorFileira;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(codigo, sala.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}

