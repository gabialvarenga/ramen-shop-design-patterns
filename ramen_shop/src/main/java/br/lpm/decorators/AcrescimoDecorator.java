package br.lpm.decorators;

import br.lpm.core.Pedido;

public abstract class AcrescimoDecorator implements Pedido{
    private Pedido pedido;

    public AcrescimoDecorator(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String exibirDetalhes() {
        return pedido.exibirDetalhes() + "Acréscimos" ;
    }

    @Override
    public double calcularPrecoTotal() {
        return pedido.calcularPrecoTotal();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
    
