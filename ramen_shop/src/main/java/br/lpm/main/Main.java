package br.lpm.main;

import br.lpm.core.BalancoFinal;
import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;
import br.lpm.singletons.PedidosSingleton;
import br.lpm.types.*;

public class Main {
    public static void main(String[] args) {

   
        PedidosSingleton pedidos = PedidosSingleton.getInstance();

        // Cria os pedidos
        Pedido pedido1 = RamenFactory.criarRamen("medio", "Boi");
        pedido1 = new AcrescimoCremeAlho(pedido1);
        pedido1 = new AcrescimoTofu(pedido1);
        pedido1 = new AcrescimoCroutons(pedido1);
        pedido1 = new AcrescimoRefrigerante(pedido1);

        Pedido pedido2 = RamenFactory.criarRamen("grande", "Porco");
        pedido2 = new AcrescimoCremeAlho(pedido2);
        pedido2 = new AcrescimoChilli(pedido2);
        pedido2 = new AcrescimoProteinaExtra(pedido2);
        pedido2 = new AcrescimoOcha(pedido2);

        Pedido pedido3 = RamenFactory.criarRamen("pequeno", "Vegano");
        pedido3 = new AcrescimoShitake(pedido3);
        pedido3 = new AcrescimoKocha(pedido3);

        // Adiciona os pedidos ao sistema
        System.out.println("\n=== Pedidos Adicionados ===");
        pedidos.adicionarPedido(pedido1);
        pedidos.adicionarPedido(pedido2);
        pedidos.adicionarPedido(pedido3);

        // Exibe a fila de pedidos
        pedidos.exibirFila();

        // Processa os pedidos
        pedidos.processarProximoPedido();
        pedidos.processarProximoPedido();
        pedidos.processarProximoPedido();

        // Marca o primeiro pedido como retirado
        pedidos.marcarPedidoComoRetirado(pedido1);

        // Exibe o balanço final do restaurante
        BalancoFinal balancoFinal = new BalancoFinal(pedidos);
        System.out.println("\n=== Balanço Final do Restaurante ===");
        balancoFinal.exibirBalanco();
    }
}
