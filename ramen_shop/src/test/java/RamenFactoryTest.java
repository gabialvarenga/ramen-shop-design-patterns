import br.lpm.core.Ramen;
import br.lpm.factories.RamenFactory;
import br.lpm.types.RamenGrande;
import br.lpm.types.RamenMedio;
import br.lpm.types.RamenPequeno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RamenFactoryTest {

    @Test
    public void testCriarRamenMedio() {
        Ramen ramen = RamenFactory.criarRamen("medio", "Frango");
        assertTrue(ramen instanceof RamenMedio, "O ramen deve ser do tipo médio.");
    }

    @Test
    public void testCriarRamenGrande() {
        Ramen ramen = RamenFactory.criarRamen("grande", "Boi");
        assertTrue(ramen instanceof RamenGrande, "O ramen deve ser do tipo grande.");
    }

    @Test
    public void testCriarRamenPequeno() {
        Ramen ramen = RamenFactory.criarRamen("pequeno", "Vegano");
        assertTrue(ramen instanceof RamenPequeno, "O ramen deve ser do tipo pequeno.");
    }

  
}
