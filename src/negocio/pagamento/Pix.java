//Augusto
package negocio.pagamento;

public class Pix implements MetodoPagamento {
    @Override
    public String getTipo() { return "PIX"; }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("[PIX] Processando: R$ " + valor);
        return true; 
    }
}