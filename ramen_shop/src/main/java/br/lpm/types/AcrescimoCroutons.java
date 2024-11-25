package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.AcrescimoDecorator;

public class AcrescimoCroutons extends AcrescimoDecorator{
     private static final double PRECO = 2.00;

    public AcrescimoCroutons(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(", Croutons");
        return sb.toString();
    }


    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
