import br.lpm.core.Pedido;
import br.lpm.factories.RamenFactory;
import br.lpm.types.AcrescimoChilli;
import br.lpm.types.AcrescimoCremeAlho;
import br.lpm.types.AcrescimoCroutons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcrescimosTest {

    @Test
    public void testAdicionarApenasUmAcrescimo() {
        Pedido ramen = RamenFactory.criarRamen("medio", "Frango");
        ramen = new AcrescimoCremeAlho(ramen);

        double precoTotal = ramen.calcularPrecoTotal();
        assertEquals(14.4, precoTotal, 0.01, "O preço total com creme de alho deve ser 14.4");
    }

    @Test
    public void testAdicionarMultiplosAcrescimos() {
        Pedido ramen = RamenFactory.criarRamen("grande", "Porco");
        ramen = new AcrescimoCremeAlho(ramen);
        ramen = new AcrescimoChilli(ramen);
        ramen = new AcrescimoCroutons(ramen);

        double precoTotal = ramen.calcularPrecoTotal();
        assertEquals(27.8, precoTotal, 0.01, 
        "O preço total com creme de alho, chilli e croutons deve ser 27.8");
    }
}
