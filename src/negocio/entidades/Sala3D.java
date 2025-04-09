package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;

public class Sala3D extends Sala implements Serializable {
    @Serial
    private static final long serialVersionUID = -4009776605163947716L;

    public Sala3D(String codigo, int linhas, int colunas) {
        super(codigo, linhas, colunas);
    }

    @Override
    public double calcularPrecoIngresso() {
            return precoBaseIngresso * 1.8;
    }

    @Override
    public String toString() {
        return "Sala3D{" +
                "codigo='" + getCodigo() + '\'' +
                ", linhas=" + getLinhas() +
                ", colunas=" + getColunas() +
                '}';
        }
    }


