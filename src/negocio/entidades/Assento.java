package negocio.entidades;

import negocio.Exceptions.AssentoIndisponivelException;

import java.io.Serializable;

public class Assento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int fileira;
    private int poltrona;
    private boolean reservado;

    public Assento(int fileira, int poltrona) {
        this.fileira = fileira;
        this.poltrona = poltrona;
        this.reservado = false;
    }

    public int getFileira() {
        return fileira;
    }

    public int getPoltrona() {
        return poltrona;
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
        return "" + (char) ('A' + (8 - fileira)) + poltrona + (reservado ? "(R)" : "");
    }

}

