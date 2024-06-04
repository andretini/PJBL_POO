package zController;

import zModel.ItemPedido;

import java.util.Objects;

public class ItemPedidoController {
    public static void create(int IdPedido,int quantidade, int IdCarrinho, int IdProduto){
        ItemPedido pedido = new ItemPedido(IdPedido, quantidade, IdCarrinho,IdProduto);
        aLoja.pedidos.add(pedido);
        pedido.Migrate(false);
    }


    public static void update(int Quantidade, int Id){
        for(ItemPedido pedido: aLoja.pedidos){
            if(Objects.equals(pedido.getIdPedido(), Id)){
                pedido.setQuantidade(Quantidade);
                pedido.Migrate(true);
                break;
            }
        }
    }

    public static void delete(int Id){
        ItemPedido pe = null;
        for(ItemPedido pedido: aLoja.pedidos){
            if(Objects.equals(pedido.getIdPedido(), Id)){

                pedido.Delete();
                pe = pedido;
            }
        }
        System.out.println("Removido");
        if(pe != null){
            aLoja.pedidos.remove(pe);
        }
    }
    public static void delete(ItemPedido pe){

        pe.Delete();
        aLoja.pedidos.remove(pe);
    }
}
