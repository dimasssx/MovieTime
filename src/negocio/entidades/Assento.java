package negocio.entidades;

import java.io.Serializable;

public class Assento implements Serializable {
    private int linha;
    private int coluna;
    private boolean reservado;

    public Assento(int linha,int coluna){
        this.linha=linha;
        this.coluna = coluna;
        this.reservado = false;
    }
    public boolean isReservado(){
        return reservado;
    }
    @Override
    public String toString() {
        return  "" + (char)('A'+(8-linha))+coluna ;
    }
    public void reservar() { //Augusto
        this.reservado = true;
    }
}
