import br.lpm.factories.RamenFactory;
import br.lpm.model.Pedido;
import br.lpm.singleton.ListaDeEspera;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.BeforeEach;

public class PedidosSingletonTest {
    private ListaDeEspera pedidos;

    @BeforeEach
    void setUp() {
        pedidos = ListaDeEspera.getInstance();
        pedidos.limparPedidos();
    }

    @Test  
    public void testAdicionarPedidoNaFila() {  
        Pedido pedido = RamenFactory.criarRamen("medio", "Frango");  
        pedidos.adicionarPedido(pedido);  
        assertTrue(pedidos.getPedidosEmFila().contains(pedido),   
        "O pedido deve estar na lista de espera.");  
    }
    @Test
    void testProcessarProximoPedido() {
        Pedido pedido = RamenFactory.criarRamen("grande", "Tofu");
        pedidos.adicionarPedido(pedido);

        pedidos.processarProximoPedido();

        assertTrue(pedidos.getPedidosEmFila().isEmpty(), "A lista de espera deve estar vazia.");
        assertTrue(pedidos.getPedidosConcluidos().contains(pedido), 
        "O pedido deve estar na lista de pedidos concluídos.");
    }

    @Test
    void testMarcarPedidoComoRetirado() {
        Pedido pedido = RamenFactory.criarRamen("grande", "Boi");
        pedidos.adicionarPedido(pedido);

        pedidos.processarProximoPedido();
        pedidos.marcarPedidoComoRetirado(pedido);

        assertTrue(pedidos.getPedidosConcluidos().contains(pedido), 
        "O pedido deve estar na lista de pedidos concluídos.");
    }

    @Test
    public void testMoverPedidoParaConcluidos() {
        Pedido pedido = RamenFactory.criarRamen("grande", "Boi");
        pedidos.adicionarPedido(pedido);

        boolean resultado = pedidos.getPedidosEmFila().remove(pedido);

        assertTrue(resultado, "O pedido deve ser removido da lista de espera.");
        assertFalse(pedidos.getPedidosEmFila().contains(pedido), 
        "O pedido não deve estar na lista de espera.");
    }

     @Test
    void testUnicidadeDaInstancia() {
        ListaDeEspera instance1 = ListaDeEspera.getInstance();
        ListaDeEspera instance2 = ListaDeEspera.getInstance();
        assertSame(instance1, instance2, "A lista de espera deve ser única.");
    }

}
