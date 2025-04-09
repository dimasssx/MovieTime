package negocio.entidades;

import negocio.Exceptions.AssentoIndisponivelException;

import java.io.Serializable;

public class Assento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int linha;
    private int coluna;
    private boolean reservado;

    public Assento(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.reservado = false;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean getReservado() {
        return reservado;
    }

    public void reservar() throws AssentoIndisponivelException {
        if (reservado) {
            throw new AssentoIndisponivelException("O assento já está reservado.");
        }
        reservado = true;
    }

    public void liberar() {
        reservado = false;
    }

    @Override
    public String toString() {
        return "" + (char) ('A' + (8 - linha)) + coluna + (reservado ? "(R)" : "");
    }
