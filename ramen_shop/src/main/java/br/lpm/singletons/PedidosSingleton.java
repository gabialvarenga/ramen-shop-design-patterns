package br.lpm.singletons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import br.lpm.core.Pedido;
import br.lpm.utils.PedidoFormatter; 
import br.lpm.utils.PedidoNotifier;

public class PedidosSingleton {
    private static final PedidosSingleton INSTANCE = new PedidosSingleton();
    private final Queue<Pedido> pedidosEmFila = new LinkedList<>();
    private final List<Pedido> pedidosConcluidos;
    private static int proximoNumero = 1;
    private PedidoNotifier notifier = new PedidoNotifier();  

    private PedidosSingleton() {
        pedidosConcluidos = new ArrayList<>();
    }

    public static PedidosSingleton getInstance() {
        return INSTANCE;
    }

    public List<Pedido> getPedidosConcluidos() {
        return pedidosConcluidos;
    }

    public void adicionarPedido(Pedido pedido) {
        Pedido pedidoComNumero = new PedidoComNumero(pedido, proximoNumero++);
        pedidosEmFila.add(pedidoComNumero);
        System.out.println(PedidoFormatter.formatarPedido(pedidoComNumero));
    }

    public void exibirFila() {
        System.out.println("\n=== Fila de Pedidos ===");
        if (pedidosEmFila.isEmpty()) {
            System.out.println("Nenhum pedido na fila.");
        } else {
            pedidosEmFila.forEach(pedido -> System.out.println(PedidoFormatter.formatarPedido(pedido)));
        }
    }

    public void processarProximoPedido() {  
        Pedido pedido = pedidosEmFila.poll();  
        if (pedido != null) {  
            pedidosConcluidos.add(pedido);  
            System.out.println("\n=== Preparando o Pedido ===");  
            System.out.println(PedidoFormatter.formatarPedido(pedido));  
            notifier.notificarCliente(pedido); // utiliza a nova classe de notificação  
        } else {  
            System.out.println("Nenhum pedido na fila.");  
        }  
    }  


    public void marcarPedidoComoRetirado(Pedido pedido) {
        if (pedidosConcluidos.contains(pedido)) {
            System.out.println("\n=== Pedido Já Retirado ===");
            System.out.println(pedido.exibirDetalhes());

        } else if (removerDaFilaParaConcluido(pedido)) {
            System.out.println("\n=== Pedido Marcado como Retirado ===");
            System.out.println(pedido.exibirDetalhes());

        } else {
            System.out.println("Pedido não encontrado na fila de espera.");
        }
    }

    private boolean removerDaFilaParaConcluido(Pedido pedido) {
        if (pedidosEmFila.remove(pedido)) {
            pedidosConcluidos.add(pedido);
            return true;
        }
        return false;
    }

    public void processarPedidos() {
        System.out.println("\n=== Processando Pedidos ===");
        while (!pedidosEmFila.isEmpty()) {
            Pedido pedido = pedidosEmFila.poll();
            pedidosConcluidos.add(pedido);
            System.out.println(PedidoFormatter.formatarPedido(pedido));
        }
    }

    private static class PedidoComNumero implements Pedido {
        private final Pedido pedidoOriginal;
        private final int numero;

        public PedidoComNumero(Pedido pedidoOriginal, int numero) {
            this.pedidoOriginal = pedidoOriginal;
            this.numero = numero;
        }

        @Override
        public String exibirDetalhes() {
            return "Pedido #" + numero + ": " + pedidoOriginal.exibirDetalhes();
        }

        @Override
        public double calcularPrecoTotal() {
            throw new UnsupportedOperationException("Unimplemented method 'calcularPrecoTotal'");
        }
    }

    public Queue<Pedido> getPedidosEmFila() {
        return pedidosEmFila;
    }

    public void limparPedidos() {
        pedidosConcluidos.clear();
        System.out.println("\n=== Pedidos Limpos ===");
        System.out.println("Todos os pedidos concluídos foram removidos.");

    }

}