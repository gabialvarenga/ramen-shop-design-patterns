package br.lpm.types;

import br.lpm.decorators.AcrescimoDecorator;
import br.lpm.model.Pedido;

public class AcrescimoTofu extends AcrescimoDecorator {
     private static final double PRECO = 2.70;

    public AcrescimoTofu(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(" Tofu, ");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
