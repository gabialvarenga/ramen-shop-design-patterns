package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.BebidaDecorator;

public class AcrescimoRefrigerante extends BebidaDecorator {
     private static final double PRECO = 5.90;

    public AcrescimoRefrigerante(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(" Refrigerante, ");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
