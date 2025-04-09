//Augusto
package negocio.Exceptions;

public class AssentoOcupadoException extends Exception {
    public AssentoOcupadoException(String codigoAssento) {
        super("Assento " + codigoAssento + " já está ocupado!");
    }
}