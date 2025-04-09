//Augusto
package negocio.pagamento;

public interface MetodoPagamento {
    String getTipo();
    boolean processarPagamento(double valor);
}