package zModel;

import BancoDados.DatabasePOO;
import zController.Sessao;
import zController.aLoja;

import java.sql.SQLException;

public class ItemPedido {

    
    private int IdPedido;
    private int Quantidade;
    private int fk_Carrinho_Compras_Id_Carrinho;
    private int fk_Produto_Id_Produto;


    public ItemPedido(int IdPedido,int quantidade, int IdCarrinho, int IdProduto){
        if (IdPedido == -1){
            if(!aLoja.pedidos.isEmpty()){
                this.setIdPedido(aLoja.pedidos.get(aLoja.pedidos.size() - 1).getIdPedido() +1);
            }
            else{
                this.setIdPedido(1);
            }
        }
        else{
            this.setIdPedido(IdPedido);
        }

        this.setQuantidade(quantidade);
        this.setFk_Carrinho_Compras_Id_Carrinho(IdCarrinho);
        this.setFk_Produto_Id_Produto(IdProduto);
    }
    public void Delete(){
        try {
            DatabasePOO.querry(String.format("DELETE FROM item_pedido WHERE Id_Pedido = %d;", getIdPedido()));
            Sessao.encerrarSecao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void Migrate(boolean update) {
        if (!update) {
            try {
                DatabasePOO.querry(String.format("INSERT INTO item_pedido(Quantidade, fk_Carrinho_Compras_Id_Carrinho, fk_Produto_Id_Produto) VALUES(%d, %d, %d)", getQuantidade(), getFk_Carrinho_Compras_Id_Carrinho(), getFk_Produto_Id_Produto()));
                System.out.println("Inserção realizada com Sucesso" + getIdPedido());
            } catch (Exception ex) {
                System.out.println("ERRO INSERIR" + ex);
            }
        } else {
            try {
                DatabasePOO.querry(String.format("UPDATE item_pedido SET Quantidade = Quantidade + %d", getQuantidade()));
                System.out.println("Atualização realizada com Sucesso");
            } catch (Exception ex) {
                System.out.println("ERRO ATUALIZAR");
            }

        }
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public int getFk_Carrinho_Compras_Id_Carrinho() {
        return fk_Carrinho_Compras_Id_Carrinho;
    }

    public void setFk_Carrinho_Compras_Id_Carrinho(int fk_Carrinho_Compras_Id_Carrinho) {
        this.fk_Carrinho_Compras_Id_Carrinho = fk_Carrinho_Compras_Id_Carrinho;
    }

    public int getFk_Produto_Id_Produto() {
        return fk_Produto_Id_Produto;
    }

    public void setFk_Produto_Id_Produto(int fk_Produto_Id_Produto) {
        this.fk_Produto_Id_Produto = fk_Produto_Id_Produto;
    }
}
