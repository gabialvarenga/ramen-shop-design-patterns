package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.AcrescimoDecorator;

public class AcrescimoShitake extends AcrescimoDecorator {
    private static final double PRECO = 6.90;

    public AcrescimoShitake(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(" Shitake, ");
        return sb.toString();
    }
    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
