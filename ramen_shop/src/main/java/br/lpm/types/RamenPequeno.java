package br.lpm.types;

import br.lpm.core.Ramen;

public class RamenPequeno extends Ramen {
    public RamenPequeno(String proteina){
        super(proteina);
        this.setPrecoBase(9.90);;
    }
}
