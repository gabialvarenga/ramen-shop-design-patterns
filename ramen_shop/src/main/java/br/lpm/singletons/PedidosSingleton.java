package br.lpm.singletons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.lpm.core.Pedido;

public class PedidosSingleton {
    private static final PedidosSingleton INSTANCE = new PedidosSingleton();
    private final Queue<Pedido> pedidosEmFila = new LinkedList<>();
    private final List<Pedido> pedidosConcluidos;

    private PedidosSingleton() {
        pedidosConcluidos = new ArrayList<>();
    }

    public static PedidosSingleton getInstance() {
        return INSTANCE;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidosEmFila.add(pedido);
    }

    public void exibirFila() {
        pedidosEmFila
                .forEach(p -> System.out.println(p.exibirDetalhes() /*
                                                                     * + " | Preço total: R$ " + p.calcularPrecoTotal()
                                                                     */));
    }

    public void processarProximoPedido() {
        Pedido pedido = pedidosEmFila.poll();
        if (pedido != null) {
            pedidosConcluidos.add(pedido);
            System.out.println("\nPedido processado: " + pedido.exibirDetalhes());
            notificarCliente(pedido); 
        } else {
            System.out.println("Nenhum pedido na fila.");
        }
    }

    private void notificarCliente(Pedido pedido) {
        System.out.println("\nNotificação: Pedido pronto para retirada - " + pedido.exibirDetalhes());
    }

    public void marcarPedidoComoRetirado(Pedido pedido) {
        if (pedidosConcluidos.contains(pedido)) {
            System.out.println("\nPedido já retirado: " + pedido.exibirDetalhes());
        } else if (removerDaFilaParaConcluido(pedido)) {
            System.out.println("\nPedido marcado como retirado: " + pedido.exibirDetalhes());
        } else {
            System.out.println("Pedido não encontrado na fila de espera.");
        }
    }
    

    public void processarPedidos() {
        while (!pedidosEmFila.isEmpty()) {
            Pedido pedido = pedidosEmFila.poll();
            pedidosConcluidos.add(pedido);
            System.out.println("\nPedido processado: " + pedido.exibirDetalhes());
        }
    }

    private boolean removerDaFilaParaConcluido(Pedido pedido) {
        if (pedidosEmFila.remove(pedido)) {
            pedidosConcluidos.add(pedido);
            return true;
        }
        return false;
    }

    public Queue<Pedido> getPedidosEmFila() {
        return pedidosEmFila;
    }

    public List<Pedido> getPedidosConcluidos() {
        return pedidosConcluidos;
    }

    public void limparPedidos() {
        pedidosConcluidos.clear();
    }
}
