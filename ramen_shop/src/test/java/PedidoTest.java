import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    public void setup() {
       pedido = RamenFactory.criarRamen("pequeno", "Vegano");
    }

    @Test
    public void testCalcularPrecoTotal() {
        assertEquals(25.0, pedido.calcularPrecoTotal(), 0.01);
    }

    @Test
    public void testExibirDetalhes() {
        assertEquals("Ramen Médio com carne de boi e tofu", pedido.exibirDetalhes());
    }
}
