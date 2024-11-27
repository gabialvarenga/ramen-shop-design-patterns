package br.lpm.types;

import br.lpm.decorators.BebidaDecorator;
import br.lpm.model.Pedido;

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
