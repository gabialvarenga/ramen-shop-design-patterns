package br.lpm.types;

import br.lpm.model.Ramen;

public class RamenPequeno extends Ramen {
    public RamenPequeno(String proteina){
        super(proteina, "Pequeno");
        this.setPrecoBase(9.90);;
    }
}
