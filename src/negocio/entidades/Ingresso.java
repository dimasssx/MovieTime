//Augusto
package negocio.entidades;

public class Ingresso {
    private Sessao sessao;
    private Assento assento;
    private boolean vip;
    
    public Ingresso(Sessao sessao, Assento assento, boolean vip) {
        this.sessao = sessao;
        this.assento = assento;
        this.vip = vip;
    }
    
    public double getPreco() {
        double precoBase = 30.00; 
        return vip ? precoBase * 0.9 : precoBase; 
    }
    
    // Getters
    public Sessao getSessao() { return sessao; }
    public Assento getAssento() { return assento; }
}