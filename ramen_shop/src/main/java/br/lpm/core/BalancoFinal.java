package br.lpm.core;

import br.lpm.singletons.PedidosSingleton;

public class BalancoFinal {
    private final PedidosSingleton pedidosSingleton;

    public BalancoFinal(PedidosSingleton pedidosSingleton) {
        this.pedidosSingleton = pedidosSingleton;
    }

    public void exibirBalanco() {
        double receitaTotal = pedidosSingleton.getPedidosConcluidos()
                             .stream()
                             .mapToDouble(Pedido::calcularPrecoTotal)
                             .sum();
        int quantidadePedidos = pedidosSingleton.getPedidosConcluidos().size();
        double ticketMedio = quantidadePedidos > 0 ? receitaTotal / quantidadePedidos : 0;

        System.out.println("Quantidade de pedidos: " + quantidadePedidos);
        System.out.println("Receita total: R$ " + receitaTotal);
        System.out.println("Ticket médio: R$ " + String.format("%.2f", ticketMedio));
    }
}
