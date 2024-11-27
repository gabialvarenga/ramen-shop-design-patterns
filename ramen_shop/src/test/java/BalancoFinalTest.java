import br.lpm.factories.RamenFactory;
import br.lpm.model.BalancoFinal;
import br.lpm.model.ListaDeEspera;
import br.lpm.model.Pedido;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

class BalancoFinalTest {

    private ListaDeEspera pedidos;
    private BalancoFinal balancoFinal;

    @BeforeEach
    void setUp() {
        pedidos = ListaDeEspera.getInstance();
        balancoFinal = new BalancoFinal(pedidos);
    }

    @Test
    void testExibirBalancoComPedidos() {
        Pedido pedido1 = RamenFactory.criarRamen("pequeno", "Vegano");
        Pedido pedido2 = RamenFactory.criarRamen("grande", "Porco");

        pedidos.adicionarPedido(pedido1);
        pedidos.adicionarPedido(pedido2);
        pedidos.processarPedidos();

        double receitaEsperada = 35.6;
        int quantidadeEsperada = 2;
        double ticketMedioEsperado = receitaEsperada / quantidadeEsperada;

        balancoFinal.exibirBalanco();

        assertEquals(receitaEsperada,
                pedidos.getPedidosConcluidos()
                        .stream()
                        .mapToDouble(Pedido::calcularPrecoTotal)
                        .sum(),
                0.01,
                "A receita total deve ser a soma dos preços dos pedidos concluídos.");
        assertEquals(quantidadeEsperada,
                pedidos.getPedidosConcluidos().size(),
                "A quantidade de pedidos concluídos deve ser igual ao número de pedidos processados.");
        assertEquals(ticketMedioEsperado,
                pedidos.getPedidosConcluidos()
                        .stream()
                        .mapToDouble(Pedido::calcularPrecoTotal)
                        .average()
                        .orElse(0.0),
                0.01,
                "O ticket médio deve ser igual à receita total dividida pela quantidade de pedidos.");
    }

    @Test
    void testExibirBalancoSemPedidos() {
        pedidos.limparPedidos();
        balancoFinal.exibirBalanco();

        assertEquals(0.0,
                pedidos.getPedidosConcluidos()
                        .stream()
                        .mapToDouble(Pedido::calcularPrecoTotal)
                        .sum(),
                0.01,
                "A receita total deve ser 0 quando não há pedidos concluídos.");
        assertEquals(0,
                pedidos.getPedidosConcluidos().size(),
                "A quantidade de pedidos concluídos deve ser 0 quando não há pedidos processados.");
        assertEquals(0.0,
                pedidos.getPedidosConcluidos()
                        .stream()
                        .mapToDouble(Pedido::calcularPrecoTotal)
                        .average()
                        .orElse(0.0),
                0.01,
                "O ticket médio deve ser 0 quando não há pedidos concluídos.");
    }
}
