package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.BebidaDecorator;

public class BebidaKocha extends BebidaDecorator {
     private static final double PRECO = 0.00;

    public BebidaKocha(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(", Kocha");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
