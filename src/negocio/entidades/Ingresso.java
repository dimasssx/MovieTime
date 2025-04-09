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

    public void gerarIngresso(){
        System.out.println("Seu Ingresso:");
        System.out.println("-----------------");
        System.out.println("Filme: " + sessao.getFilme());
        System.out.println("Fileira: " + assento.getFileira());
        System.out.println("Poltrona: " + assento.getPoltrona());
        System.out.println("Dia: " + sessao.getDia());
        System.out.println("Horario " + sessao.getHorario());
        System.out.println("-----------------");
    }
}