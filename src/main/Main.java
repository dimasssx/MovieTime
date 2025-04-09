
package main;

import UI.TelaLogin;
import fachada.Cinema;
import negocio.Exceptions.ClienteJaExisteException;
import negocio.Exceptions.ClienteNaoEncontradoException;

public class Main {
    public static void main(String[] args) throws ClienteNaoEncontradoException, ClienteJaExisteException {

        Cinema cinema = new Cinema();
        TelaLogin telalogin = new TelaLogin(cinema);
        telalogin.iniciar();
    }
}
