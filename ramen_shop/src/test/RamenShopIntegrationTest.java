import br.lpm.core.*;
import br.lpm.singleton.PedidosSingleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RamenShopIntegrationTest {
    @Test
    void testSistemaCompleto() {
        // Criar pedidos
        Pedido pedido1 = new Ramen("Vegano", "Pequeno");
        pedido1.setPrecoBase(9.90);
        pedido1 = new ProteinaExtra(pedido1); // Decorator
        pedido1 = new Chilli(pedido1);       // Decorator

        Pedido pedido2 = new Ramen("Boi", "Médio");
        pedido2.setPrecoBase(12.90);

        // Adicionar à lista de espera (Singleton)
        PedidosSingleton listaDeEspera = PedidosSingleton.getInstance();
        listaDeEspera.adicionarPedido(pedido1);
        listaDeEspera.adicionarPedido(pedido2);

        // Verificar a lista de espera
        assertEquals(2, listaDeEspera.getListaDePedidos().size());

        // Marcar pedido como retirado e verificar balanço final
        BalancoFinal balanco = new BalancoFinal();
        balanco.adicionarPedido(listaDeEspera.removerPedido(pedido1));
        balanco.adicionarPedido(listaDeEspera.removerPedido(pedido2));

        assertEquals(2, balanco.getQuantidadePedidos());
        assertEquals(29.70, balanco.calcularReceitaTotal(), 0.01);
        assertEquals(14.85, balanco.calcularTicketMedio(), 0.01);
    }
}
