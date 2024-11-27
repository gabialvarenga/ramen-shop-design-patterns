package br.lpm.decorators;

import br.lpm.model.Pedido;

public abstract class BebidaDecorator implements Pedido{
    private Pedido pedido;

    public BebidaDecorator(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String exibirDetalhes() {
        return getPedido().exibirDetalhes();
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
    
