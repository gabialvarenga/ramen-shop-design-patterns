package br.lpm.types;

import br.lpm.decorators.AcrescimoDecorator;
import br.lpm.core.Pedido; // Adjust the package name as necessary


public class AcrescimoCremeAlho extends AcrescimoDecorator {
    private static final double PRECO = 1.50;

    public AcrescimoCremeAlho(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String exibirDetalhes() {
        return getPedido().exibirDetalhes() + ", Creme de Alho";
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

