package br.lpm.utils;


import br.lpm.model.Pedido;

public class FormatarPedido {
    public static String formatarPedido(Pedido pedido) {
        String detalhes = pedido.exibirDetalhes();
        double precoTotal = pedido.calcularPrecoTotal();
        return String.format("%s| Preço total: R$ %.2f", detalhes, precoTotal);
    }
}