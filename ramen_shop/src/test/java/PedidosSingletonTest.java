import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;
import br.lpm.singletons.PedidosSingleton;
import br.lpm.types.AcrescimoChilli;
import br.lpm.types.AcrescimoCremeAlho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidosSingletonTest {

    @Test
    public void testAdicionarPedidoNaFila() {
        PedidosSingleton pedidos = PedidosSingleton.getInstance();

        Pedido ramen = RamenFactory.criarRamen("medio", "Frango");
        pedidos.adicionarPedido(ramen);

        assertEquals(1, pedidos.getPedidosEmFila().size());
    }

    @Test
    public void testMoverPedidoParaConcluidos() {
        PedidosSingleton pedidos = PedidosSingleton.getInstance();

        Pedido ramen = RamenFactory.criarRamen("grande", "Boi");
        ramen = new AcrescimoCremeAlho(ramen);
        pedidos.adicionarPedido(ramen);

        Pedido processado = pedidos.getPedidosEmFila().poll();
        pedidos.getPedidosConcluidos().add(processado);

        assertEquals(0, pedidos.getPedidosEmFila().size());
        assertEquals(1, pedidos.getPedidosConcluidos().size());
    }

    @Test
    public void testCalcularBalancoCorretamente() {
        PedidosSingleton pedidos = PedidosSingleton.getInstance();

        Pedido ramen1 = RamenFactory.criarRamen("pequeno", "Vegano");
        ramen1 = new AcrescimoCremeAlho(ramen1);
        pedidos.adicionarPedido(ramen1);

        Pedido ramen2 = RamenFactory.criarRamen("medio", "Boi");
        ramen2 = new AcrescimoChilli(ramen2);
        pedidos.adicionarPedido(ramen2);

        pedidos.getPedidosConcluidos().addAll(pedidos.getPedidosEmFila());
        pedidos.getPedidosEmFila().clear();

        double total = pedidos.getPedidosConcluidos().stream()
                .mapToDouble(Pedido::calcularPrecoTotal)
                .sum();

        assertEquals(38.6, total, 0.01);
    }
}
