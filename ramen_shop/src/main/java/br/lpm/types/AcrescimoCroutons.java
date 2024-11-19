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
        return getPedido().exibirDetalhes() + ", Croutons";
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
