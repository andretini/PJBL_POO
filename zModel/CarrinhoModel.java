package zModel;

import BancoDados.DatabasePOO;
import zController.Sessao;
import zController.aLoja;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrinhoModel extends GenerericModel{
    private int Id_Carrinho;
    private int fk_Usuario_Id_Usuario;
    private ArrayList<ItemPedido> itens;

    public CarrinhoModel(int cartId,int userId){
        itens = new ArrayList<>();

        if (cartId == -1){
            if(!aLoja.carrinhos.isEmpty()){
                this.Id_Carrinho = aLoja.carrinhos.get(aLoja.carrinhos.size() - 1).Id_Carrinho+1;
            }
            else{
                this.Id_Carrinho = 1;
            }
        }
        else{
            this.Id_Carrinho = cartId;
        }
        this.fk_Usuario_Id_Usuario = userId;
        System.out.println(this.Id_Carrinho);
    }

    public int getIdCarrinho() {
        return Id_Carrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.Id_Carrinho = idCarrinho;
    }

    public int getFkUsuarioIdUsuario() {
        return fk_Usuario_Id_Usuario;
    }

    public void setFkUsuarioIdUsuario(int fkUsuarioIdUsuario) {
        this.fk_Usuario_Id_Usuario = fkUsuarioIdUsuario;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ItemPedido pe) {
        this.itens.add(pe);
    }

    @Override
    public void Delete() {
        try {
            DatabasePOO.querry(String.format("DELETE FROM carrinho_compras WHERE Id_Carrinho = %d;", getIdCarrinho()));
            Sessao.encerrarSecao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void Migrate(boolean update){
        if(!update){
            try {
                DatabasePOO.querry(String.format("INSERT INTO carrinho_compras(fk_Usuario_Id_Usuario) VALUES('%d')", fk_Usuario_Id_Usuario));
                System.out.println("Inserção realizada com Sucesso" + fk_Usuario_Id_Usuario);
            } 
            catch (Exception ex) {
                System.out.println("ERRO INSERIR" + ex);
            }
        }
    }

}
