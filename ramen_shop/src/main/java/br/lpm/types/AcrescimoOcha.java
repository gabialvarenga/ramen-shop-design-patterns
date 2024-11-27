package br.lpm.types;

import br.lpm.decorators.BebidaDecorator;
import br.lpm.model.Pedido;

public class AcrescimoOcha extends BebidaDecorator {
     private static final double PRECO = 3.90;

    public AcrescimoOcha(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(" O-cha, ");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
