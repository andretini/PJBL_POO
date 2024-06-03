package zModel;

import BancoDados.DatabasePOO;
import zController.Sessao;
import zController.aLoja;

import java.sql.SQLException;

public class ItemPedido {
    public int IdPedido;
    public int Quantidade;
    public int fk_Carrinho_Compras_Id_Carrinho;
    public int fk_Produto_Id_Produto;

    public ItemPedido(int IdPedido,int quantidade, int IdCarrinho, int IdProduto){
        if (IdPedido == -1){
            if(!aLoja.pedidos.isEmpty()){
                this.IdPedido = aLoja.pedidos.get(aLoja.pedidos.size() - 1).IdPedido+1;
            }
            else{
                this.IdPedido = 1;
            }
        }
        else{
            this.IdPedido = IdPedido;
        }

        this.Quantidade = quantidade;
        this.fk_Carrinho_Compras_Id_Carrinho = IdCarrinho;
        this.fk_Produto_Id_Produto = IdProduto;
    }
    public void Delete(){
        try {
            DatabasePOO.querry(String.format("DELETE FROM item_pedido WHERE Id_Pedido = %d;", IdPedido));
            Sessao.encerrarSecao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void Migrate(boolean update) {
        if (!update) {
            try {
                DatabasePOO.querry(String.format("INSERT INTO item_pedido(Quantidade, fk_Carrinho_Compras_Id_Carrinho, fk_Produto_Id_Produto) VALUES(%d, %d, %d)", Quantidade, fk_Carrinho_Compras_Id_Carrinho, fk_Produto_Id_Produto));
                System.out.println("Inserção realizada com Sucesso" + IdPedido);
            } catch (Exception ex) {
                System.out.println("ERRO INSERIR" + ex);
            }
        } else {
            try {
                DatabasePOO.querry(String.format("UPDATE item_pedido SET Quantidade = Quantidade + %d", Quantidade));
                System.out.println("Atualização realizada com Sucesso");
            } catch (Exception ex) {
                System.out.println("ERRO ATUALIZAR");
            }

        }
    }
}
