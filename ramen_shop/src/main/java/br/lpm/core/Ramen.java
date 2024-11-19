package br.lpm.core;

import java.util.Map;

public abstract class Ramen implements Pedido{
    private double precoBase; 
    private String proteina;
    private double precoProteina;
    private static final Map<String, Double> PRECO_PROTEINA = Map.of(
        "Vegano", 3.90,
        "Porco", 5.90,
        "Boi", 7.90
    );

    public Ramen(String proteina) {
        this.proteina = proteina;
        this.precoProteina = PRECO_PROTEINA.getOrDefault(proteina, 0.0);
        //O método getOrDefault() é usado para obter o valor associado à chave proteina no mapa PRECO_PROTEINA.
    }

    @Override
    public String exibirDetalhes() {
        return "Ramen com " + proteina + ", preço base: " + precoBase;
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

