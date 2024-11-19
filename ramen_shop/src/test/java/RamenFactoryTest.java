import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;
import br.lpm.types.RamenMedio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RamenFactoryTest {

    @Test
    public void testCriarRamenMedio() {
        Pedido ramen = RamenFactory.criarRamen("medio", "Frango");
        assertTrue(ramen instanceof RamenMedio);
    }

    @Test
    public void testCriarRamenComProteinaCorreta() {
        Pedido ramen = RamenFactory.criarRamen("pequeno", "Tofu");
        String detalhes = ramen.exibirDetalhes();
        assertTrue(detalhes.contains("Tofu"));
    }
}
