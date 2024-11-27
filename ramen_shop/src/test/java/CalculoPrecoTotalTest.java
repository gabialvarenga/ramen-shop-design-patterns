import br.lpm.factories.RamenFactory;
import br.lpm.model.Pedido;
import br.lpm.types.AcrescimoProteinaExtra;
import br.lpm.types.AcrescimoShitake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoPrecoTotalTest {

    @Test
    public void deveCalcularPrecoTotalComApenasBase() {
        Pedido ramen = RamenFactory.criarRamen("pequeno", "Boi");

        double precoTotal = ramen.calcularPrecoTotal();
        assertEquals(17.8, precoTotal, 0.01);
    }

    @Test
    public void deveCalcularPrecoTotalComAcréscimos() {
        Pedido ramen = RamenFactory.criarRamen("medio", "Porco");
        ramen = new AcrescimoShitake(ramen);
        ramen = new AcrescimoProteinaExtra(ramen);

        double precoTotal = ramen.calcularPrecoTotal();
        assertEquals(29.7, precoTotal, 0.01);
    }
}
