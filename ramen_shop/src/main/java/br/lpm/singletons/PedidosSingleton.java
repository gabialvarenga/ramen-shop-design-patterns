package br.lpm.singletons;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.lpm.core.Pedido;

public class PedidosSingleton {
    private static final PedidosSingleton INSTANCE = new PedidosSingleton();
    private final Queue<Pedido> pedidosEmFila = new LinkedList<>();
    private final List<Pedido> pedidosConcluidos = new LinkedList<>();

    private PedidosSingleton() {
    }

    public static PedidosSingleton getInstance() {
        return INSTANCE;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidosEmFila.add(pedido);
    }

    // Voltar aqui
    public void exibirFila() {
        pedidosEmFila.forEach(p -> System.out.println(p.exibirDetalhes()));
    }

    public void exibirBalanco() {
        double total = pedidosConcluidos.stream()
                .mapToDouble(Pedido::calcularPrecoTotal)
                .sum();
        System.err.println("Total arrecadado: " + total);
    }

    public Queue<Pedido> getPedidosEmFila() {
        return pedidosEmFila;
    }

    public List<Pedido> getPedidosConcluidos() {
        return pedidosConcluidos;
    }

}
