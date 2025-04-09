package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;

public class Sala2D extends Sala implements Serializable {
    @Serial
    private static final long serialVersionUID = -4009776605163947716L;

    public Sala2D(String codigo, int linhas, int colunas) {
        super(codigo, linhas, colunas);
    }

    @Override
    public double calcularPrecoIngresso() {
            return precoBaseIngresso;
    }

    @Override
    public String toString() {
        return "Sala2D{" +
                "codigo='" + getCodigo() + '\'' +
                ", linhas=" + getLinhas() +
                ", colunas=" + getColunas() +
                '}';
        }
    }

