package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.BebidaDecorator;

public class BebidaRefrigerante extends BebidaDecorator {
     private static final double PRECO = 5.90;

    public BebidaRefrigerante(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        return getPedido().exibirDetalhes() + ", Refrigerante";
    }

    //VOLTAR AQUI
    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPedido()).append(this.cnpj);
        return sb.toString();
    }*/

    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}
