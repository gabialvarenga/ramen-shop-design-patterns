package br.lpm.factories;

import br.lpm.core.Pedido;
import br.lpm.decorators.BebidaDecorator;
import br.lpm.types.BebidaKocha;
import br.lpm.types.BebidaOcha;
import br.lpm.types.BebidaRefrigerante;

public class BebidaFactory {
    public static BebidaDecorator criarBebida(String tipo, Pedido pedido){
        return switch (tipo.toLowerCase()){
            case "refrigerante" -> new BebidaRefrigerante(pedido);
            case "ocha" -> new BebidaOcha(pedido);
            case "kocha" -> new BebidaKocha(pedido);
            default -> throw new IllegalArgumentException("Tipo de bebida inválida");
        };
    }
}
