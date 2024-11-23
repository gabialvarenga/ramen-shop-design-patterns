import br.lpm.core.Pedido;
import br.lpm.decorators.BebidaDecorator;
import br.lpm.factories.BebidaFactory;
import br.lpm.factories.RamenFactory;
import br.lpm.types.BebidaKocha;
import br.lpm.types.BebidaOcha;
import br.lpm.types.BebidaRefrigerante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaFactoryTest {

    @Test
    void testCriarBebidaRefrigerante() {
        Pedido pedido = RamenFactory.criarRamen("medio", "Vegano");
        BebidaDecorator bebida = BebidaFactory.criarBebida("refrigerante", pedido);
        assertNotNull(bebida, "A bebida não deve ser nula.");
        assertTrue(bebida instanceof BebidaRefrigerante,  "A bebida deve ser um refrigerante.");
    }

    @Test
    void testCriarBebidaOcha() {
        Pedido pedido = RamenFactory.criarRamen("pequeno", "Frango");
        BebidaDecorator bebida = BebidaFactory.criarBebida("ocha", pedido);
        assertNotNull(bebida, "A bebida não deve ser nula.");
        assertTrue(bebida instanceof BebidaOcha);
    }

    @Test
    void testCriarBebidaKocha() {
        Pedido pedido = RamenFactory.criarRamen("grande", "Porco");
        BebidaDecorator bebida = BebidaFactory.criarBebida("kocha", pedido);
        assertNotNull(bebida, "A bebida não deve ser nula.");
        assertTrue(bebida instanceof BebidaKocha, "A bebida deve ser um kocha.");
    }

    @Test
    void testCriarBebidaTipoInvalido() {
        Pedido pedido = RamenFactory.criarRamen("pequeno", "Porco");
        assertThrows(IllegalArgumentException.class, () -> 
        BebidaFactory.criarBebida("agua", pedido), "Deve lançar uma exceção para tipo de bebida inválido.");
    }
}
