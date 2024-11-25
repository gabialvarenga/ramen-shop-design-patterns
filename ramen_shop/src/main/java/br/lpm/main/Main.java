package br.lpm.main;

import br.lpm.core.BalancoFinal;
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

        // Cria os pedidos
        Pedido pedido1 = RamenFactory.criarRamen("medio", "Boi");
        pedido1 = new AcrescimoCremeAlho(pedido1);
        pedido1 = new AcrescimoTofu(pedido1);
        pedido1 = new AcrescimoCroutons(pedido1);

        Pedido pedido2 = RamenFactory.criarRamen("grande", "Porco");
        pedido2 = new AcrescimoCremeAlho(pedido2);
        pedido2 = new AcrescimoChilli(pedido2);
        pedido2 = new AcrescimoProteinaExtra(pedido2);

        Pedido pedido3 = RamenFactory.criarRamen("pequeno", "Vegano");
        pedido3 = new AcrescimoShitake(pedido3);

        // Adiciona os pedidos
        System.out.println("\n=== Pedidos Adicionados ===");
        pedidos.adicionarPedido(pedido1);
        pedidos.adicionarPedido(pedido2);
        pedidos.adicionarPedido(pedido3);

        // Exibe a fila de pedidos
        pedidos.exibirFila();

        // Processa o primeiro pedido
        pedidos.processarProximoPedido();
        pedidos.processarProximoPedido();
        pedidos.processarProximoPedido();

        // Marca como retirado e exibe o balanço
        pedidos.marcarPedidoComoRetirado(pedido1);

        // Exibe o balanço final
        BalancoFinal balancoFinal = new BalancoFinal(pedidos);
        System.out.println("\n=== Balanço Final do Restaurante ===");
        balancoFinal.exibirBalanco();
    }
}
