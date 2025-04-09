//Augusto
package negocio.pagamento;

public class CartaoCredito implements MetodoPagamento {
    @Override
    public String getTipo() { return "Cartão de Crédito"; }

    @Override
    public boolean processarPagamento(double valor) {
        boolean aprovado = valor <= 1000.00; 
        System.out.println("[CARTÃO] " + (aprovado ? "Aprovado" : "Recusado"));
        return aprovado;
    }
}