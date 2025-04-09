// Augusto
package negocio.Exceptions;

public class SalaLotadaException extends Exception {
    public SalaLotadaException() {
        super("Não há assentos disponíveis nesta sessão!");
    }
}