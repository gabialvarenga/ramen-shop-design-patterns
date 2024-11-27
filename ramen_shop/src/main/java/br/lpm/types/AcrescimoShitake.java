package br.lpm.types;

import br.lpm.decorators.AcrescimoDecorator;
import br.lpm.model.Pedido;

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
