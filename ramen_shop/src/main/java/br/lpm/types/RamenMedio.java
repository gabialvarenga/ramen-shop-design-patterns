package br.lpm.types;

import br.lpm.model.Ramen;

public class RamenMedio extends Ramen {
    public RamenMedio(String proteina){
        super(proteina, "Medio");
        this.setPrecoBase(12.90);
    }
}
