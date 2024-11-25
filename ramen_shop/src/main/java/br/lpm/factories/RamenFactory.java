package br.lpm.factories;

import br.lpm.core.Ramen;
import br.lpm.types.RamenGrande;
import br.lpm.types.RamenMedio;
import br.lpm.types.RamenPequeno;

public class RamenFactory {
    public static Ramen criarRamen(String tipo, String proteina){
        return switch (tipo.toLowerCase()){
            case "pequeno" -> new RamenPequeno(proteina);
            case "medio" -> new RamenMedio(proteina);
            case "grande" -> new RamenGrande(proteina);
            default -> throw new IllegalArgumentException("Tipo de ramen inválido");
        };
    }
}
