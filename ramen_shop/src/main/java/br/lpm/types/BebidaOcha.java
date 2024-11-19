package br.lpm.types;

import br.lpm.core.Pedido;
import br.lpm.decorators.BebidaDecorator;

public class BebidaOcha extends BebidaDecorator {
     private static final double PRECO = 3.90;

    public BebidaOcha(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        return getPedido().exibirDetalhes() + ", Bebida O-Cha";
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
