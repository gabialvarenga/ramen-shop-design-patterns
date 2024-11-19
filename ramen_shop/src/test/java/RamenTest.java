import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.lpm.core.Ramen;
import br.lpm.factories.RamenFactory;

class RamenTest {
    @Test
    void testCalculoPreco() {
        Ramen ramen = RamenFactory.criarRamen("medio", "Vegano");
        assertEquals(16.80, ramen.calcularPrecoTotal());
    }
}
