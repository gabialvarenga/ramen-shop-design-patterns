package br.lpm.main;

import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;
import br.lpm.singletons.PedidosSingleton;
import br.lpm.types.AcrescimoChilli;
import br.lpm.types.AcrescimoCremeAlho;
import br.lpm.types.AcrescimoCroutons;
import br.lpm.types.AcrescimoShitake;
import br.lpm.types.AcrescimoTofu;
import br.lpm.types.AcrescimoProteinaExtra;

public class Main {
    public static void main(String[] args) {
        PedidosSingleton pedidos = PedidosSingleton.getInstance();

        Pedido ramen1 = RamenFactory.criarRamen("medio", "Boi");
        ramen1 = new AcrescimoCremeAlho(ramen1);
        ramen1 = new AcrescimoTofu(ramen1);
        ramen1 = new AcrescimoCroutons(ramen1);
        pedidos.adicionarPedido(ramen1);

        Pedido ramen2 = RamenFactory.criarRamen("grande", "Porco");
        ramen2 = new AcrescimoCremeAlho(ramen2);
        ramen2 = new AcrescimoChilli(ramen2);
        ramen2 = new AcrescimoProteinaExtra(ramen2);
        pedidos.adicionarPedido(ramen2);

        Pedido ramen3 = RamenFactory.criarRamen("pequeno", "Tofu");
        ramen3 = new AcrescimoShitake(ramen3);
        pedidos.adicionarPedido(ramen3);

        System.out.println("Fila de pedidos:");
        pedidos.getPedidosEmFila().forEach(pedido -> {
            System.out.println(pedido.exibirDetalhes() + " | Preço total: R$ " + pedido.calcularPrecoTotal());
        });

        System.out.println("\nProcessando pedidos...");
        while (!pedidos.getPedidosEmFila().isEmpty()) {
            Pedido pedido = pedidos.getPedidosEmFila().poll();
            pedidos.getPedidosConcluidos().add(pedido);
        }

        System.out.println("\nBalanço geral:");
        pedidos.exibirBalanco();
    }
}
