import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;
import br.lpm.types.AcrescimoChilli;
import br.lpm.types.AcrescimoKocha;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    public void setup() {
       pedido = RamenFactory.criarRamen("pequeno", "Vegano");
       pedido = new AcrescimoChilli(pedido);
       pedido = new AcrescimoKocha(pedido);
    }

    @Test
    public void testCalcularPrecoTotal() {
        assertEquals(16.3, pedido.calcularPrecoTotal(), 0.01);
    }

}
