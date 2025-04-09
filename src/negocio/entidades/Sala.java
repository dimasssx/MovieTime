package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable {
    private static final int LINHAS = 8;
    private static final int COLUNAS = 8;
    @Serial
    private static final long serialVersionUID = 7641162938185600740L;
    private Assento[][] assentos;
    private final String  CODIGO;
    public static  int ID = 1;
    private boolean disponivel;

    public Sala(){
        CODIGO = "SALA" + ID++;
        assentos = new Assento[LINHAS][COLUNAS];
        for (int i = 0;i<LINHAS;i++){
            for (int j= 0;j<COLUNAS;j++){
                assentos[i][j]= new Assento(i+1,j+1);
            }

        }
    }
    public boolean isDisponivel(){
        for (int i = 0;i<LINHAS;i++){
            for (int j = 0;j<COLUNAS;j++){
                if (!(assentos[i][j].isReservado())) return true;
            }
        }
        //
        return false;
    }

    @Override
    public String toString() {
        return CODIGO;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(CODIGO, sala.CODIGO);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CODIGO);
    }

    public void imprime(){
        for (int i = 0;i<LINHAS;i++){
            for (int j = 0;j<COLUNAS;j++){
                System.out.print(assentos[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public Assento[][] getAssentos() { //Augusto
        return this.assentos;
    }
    public boolean temAssentosDisponiveis() {
        for (Assento[] fileira : assentos) {
            for (Assento a : fileira) {
                if (!a.isReservado()) return true;
            }
        }
        return false;
    }
}
