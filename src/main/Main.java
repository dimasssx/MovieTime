package main;

import UI.TelaLogin;
import fachada.Cinema;
import negocio.Exceptions.SessaoNaoEncontradaException;
import dados.Catalogo;
import negocio.entidades.Filme;
public class Main {
    public static void main(String[] args) {

        Cinema cinema = new Cinema();
        TelaLogin telalogin = new TelaLogin(cinema);
        telalogin.iniciar();


    }
}