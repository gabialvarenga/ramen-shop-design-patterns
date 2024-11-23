import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.lpm.core.Ramen;
import br.lpm.factories.RamenFactory;

class RamenTest {
    @Test
    void testCalculoPreco() {
        Ramen ramen = RamenFactory.criarRamen("medio", "Vegano");
        assertEquals(16.80, ramen.calcularPrecoTotal(), 0.01,
        "O preço total do ramen médio vegano deve ser 16.80.");
    }

    @Test
    void testCalcularPrecoTotalProteinaVegano() {
        Ramen ramen = RamenFactory.criarRamen("pequeno", "Vegano");
        assertEquals(13.80, ramen.calcularPrecoTotal(), 0.01, 
        "O preço total do ramen pequeno vegano deve ser 13.80.");
    }

    @Test
    void testCalcularPrecoTotalProteinaPorco() {
        Ramen ramen = RamenFactory.criarRamen("medio", "Porco");
        assertEquals(18.80, ramen.calcularPrecoTotal(), 0.01,
        "O preço total do ramen médio de porco deve ser 18.80.");
    }

    @Test
    void testCalcularPrecoTotalProteinaBoi() {
        Ramen ramen = RamenFactory.criarRamen("grande", "Boi");
        assertEquals(23.80, ramen.calcularPrecoTotal(), 0.01,
        "O preço total do ramen grande de boi deve ser 23.80.");
    }
}
