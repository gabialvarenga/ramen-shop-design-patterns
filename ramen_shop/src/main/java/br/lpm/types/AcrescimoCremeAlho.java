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
        StringBuilder sb = new StringBuilder();
        sb.append(super.exibirDetalhes());
        sb.append(", Creme de Alho");
        return sb.toString();
    }


 
    @Override
    public double calcularPrecoTotal() {
        return getPedido().calcularPrecoTotal() + PRECO;
    }
}

