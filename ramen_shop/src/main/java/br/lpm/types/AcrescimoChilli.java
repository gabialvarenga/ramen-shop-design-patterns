package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.AcrescimoDecorator;

public class AcrescimoChilli extends AcrescimoDecorator {
     private static final double PRECO = 2.50;

    public AcrescimoChilli(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        return getPedido().exibirDetalhes() + " , Chilli";
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
