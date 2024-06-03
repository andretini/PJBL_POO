package zModel;

import BancoDados.DatabasePOO;
import zController.Sessao;
import zController.aLoja;
import zController.UserController;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrinhoModel {
    private int Id_Carrinho;
    private int fk_Usuario_Id_Usuario;
    private ArrayList<ItemPedido> itens;

    public CarrinhoModel(int cartId,int userId){
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

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public void delete() {
        try {
            DatabasePOO.querry(String.format("DELETE FROM carrinho_compras WHERE Id_Carrinho = %d;", idCarrinho));
            Sessao.encerrarSecao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void Migrate(boolean update){
        if(!update){
            try {
                System.out.println(fk_Usuario_Id_Usuario);
                DatabasePOO.querry(String.format("INSERT INTO carrinho_compras(fk_Usuario_Id_Usuario) VALUES('%d')", fk_Usuario_Id_Usuario));
                System.out.println("Inserção realizada com Sucesso" + fk_Usuario_Id_Usuario);
            } catch (Exception ex) {
                System.out.println("ERRO INSERIR" + ex);
            }
        }/*
        else{
            try {
                DatabasePOO.querry(String.format("UPDATE usuario SET Nome = '%s', Senha = '%s' WHERE Id_Usuario = %d", nome, senha, Id));
                System.out.println("Atualização realizada com Sucesso");
            } catch (Exception ex) {
                System.out.println("ERRO ATUALIZAR");
            }
       */
    }

}
