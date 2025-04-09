//// Augusto
//package negocio.entidades;
//
//import negocio.vip.BeneficioVIP;
//import negocio.vip.BeneficioMeiaEntrada;
//
//public class ClienteVIP extends Cliente {
//    private BeneficioVIP beneficioVIP;
//    private BeneficioMeiaEntrada beneficioMeia;
//
//    public boolean temDireitoAMeiaEntrada;
//
//    @Override
//    public double calcularTotal() {
//        double totalComDesconto = total;
//        if (temDireitoAMeiaEntrada) {
//            totalComDesconto = beneficioMeia.aplicarDesconto(total);
//        } else {
//            totalComDesconto = beneficioVIP.aplicarDesconto(total);
//        }
//        return totalComDesconto;
//    }
//}