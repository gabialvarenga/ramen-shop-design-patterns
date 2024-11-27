package br.lpm.types;

import br.lpm.decorators.BebidaDecorator;
import br.lpm.model.Pedido;

public class AcrescimoKocha extends BebidaDecorator {
     private static final double PRECO = 0.00;

    public AcrescimoKocha(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(" Kocha, ");
        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
