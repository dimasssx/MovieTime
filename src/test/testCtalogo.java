package test;

import negocio.entidades.*;
import dados.Catalogo;
import dados.ICatalogo;

public class testCtalogo {
    public static void main(String[] args) {

        Filme filme4 = new Filme("Capitão América: Admirável Mundo Novo", "Ação", "1h59", "14 anos");
        Filme filme6 = new Filme("Mickey 17", "Animação", "2h19", "10 anos");
        dados.Catalogo catalogo = new dados.Catalogo();

        catalogo.imprimir();


    }

}
