package zModel;

import BancoDados.DatabasePOO;

import java.sql.SQLException;

public class GenerericModel {

    public void Delete(){
        try {
            DatabasePOO.querry(String.format("DELETE FROM item_pedido WHERE Id_Pedido = %d;", 2));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void Migrate(boolean update) {
        if (!update) {
            try {
                DatabasePOO.querry(String.format("INSERT INTO item_pedido(Quantidade, fk_Carrinho_Compras_Id_Carrinho, fk_Produto_Id_Produto) VALUES(%d, %d, %d)", 2, 3, 2));
                System.out.println("Inserção realizada com Sucesso" + 2);
            } catch (Exception ex) {
                System.out.println("ERRO INSERIR" + ex);
            }
        } else {
            try {
                DatabasePOO.querry(String.format("UPDATE item_pedido SET Quantidade = Quantidade + %d", 2));
                System.out.println("Atualização realizada com Sucesso");
            } catch (Exception ex) {
                System.out.println("ERRO ATUALIZAR");
            }

        }
    }
}
