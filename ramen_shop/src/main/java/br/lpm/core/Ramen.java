package br.lpm.core;

import java.util.Map;

public abstract class Ramen implements Pedido {
    private double precoBase;
    private String tamanho;
    private String proteina;
    private double precoProteina;
    private Pedido pedido;
    private static final Map<String, Double> PRECO_PROTEINA = Map.of(
            "Vegano", 3.90,
            "Porco", 5.90,
            "Boi", 7.90);

    public Ramen(String proteina, String tamanho) {
        this.proteina = proteina;
        this.precoProteina = PRECO_PROTEINA.getOrDefault(proteina, 0.0);
        this.tamanho = tamanho;
        this.pedido = this;
        // O método getOrDefault() é usado para obter o valor associado à chave proteina
        // no mapa PRECO_PROTEINA.
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ramen ").append(tamanho).append(", Proteina: ").append(proteina).append(" | ");

        return sb.toString();
    }

    @Override
    public double calcularPrecoTotal() {
        return precoBase + precoProteina;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
