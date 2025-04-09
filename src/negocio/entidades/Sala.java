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
    private final int linhas;
    private final int colunas;
    protected double precoBaseIngresso;
    protected Assento[][] assentos;


    public Sala(String codigo, int linhas, int colunas) {
        this.codigo = codigo;
        this.linhas = linhas;
        this.colunas = colunas;
        this.assentos = new Assento[linhas][colunas];
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                assentos[i][j] = new Assento(i + 1, j + 1);
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Assento[][] getAssentos() {
        return assentos;
    }

    public abstract double calcularPrecoIngresso();

    @Override
    public String toString() {
        return "Sala{" +
                "codigo='" + codigo + '\'' +
                ", linhas=" + linhas +
                ", colunas=" + colunas +
                '}';
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

