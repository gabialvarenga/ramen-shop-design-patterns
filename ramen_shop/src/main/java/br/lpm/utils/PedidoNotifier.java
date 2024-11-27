package br.lpm.utils;

import br.lpm.model.Pedido;

public class PedidoNotifier {  
    public void notificarCliente(Pedido pedido) {  
        System.out.println("\n=== Notificação ===");  
        System.out.println("Pedido pronto! Cliente, venha retirar: " + pedido.exibirDetalhes());  
    }  
}  