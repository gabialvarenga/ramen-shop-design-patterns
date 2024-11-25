package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.AcrescimoDecorator;

public class AcrescimoProteinaExtra extends AcrescimoDecorator {
    private static final double PRECO = 4.00;

    public AcrescimoProteinaExtra(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(" Proteína Extra, ");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
