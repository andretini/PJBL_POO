package zController;

import BancoDados.DatabasePOO;
import zModel.CarrinhoModel;
import zModel.ItemPedido;
import zModel.Produto;
import zModel.UserModel;
import zViews.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class aLoja {

    public static ArrayList<UserModel> users = new ArrayList<>();
    public static ArrayList<CarrinhoModel> carrinhos = new ArrayList<>();
    public static ArrayList<ItemPedido> pedidos = new ArrayList<>();
    public static ArrayList<Produto> produtos = new ArrayList<>();


    public static ArrayList<UserModel> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<UserModel> users) {
        aLoja.users = users;
    }

    public static ArrayList<CarrinhoModel> getCarrinhos() {
        return carrinhos;
    }

    public static void setCarrinhos(ArrayList<CarrinhoModel> carrinhos) {
        aLoja.carrinhos = carrinhos;
    }

    public static void main(String[] args){

        try {
            DatabasePOO.createConnection();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados");
        }
        Migrate();

        int userId = -1;
        Login login = new Login(userId);

    }

    public static void Migrate(){
        try {
            ResultSet res = DatabasePOO.querrySelect("SELECT * FROM USUARIO");
            while (res.next()){
                users.add(new UserModel(res.getString("Nome"), res.getString("Senha"), res.getInt("Id_Usuario")));
            }
            res = DatabasePOO.querrySelect("SELECT * FROM carrinho_compras");
            while (res.next()){
                carrinhos.add(new CarrinhoModel(res.getInt("Id_Carrinho"), res.getInt("fk_Usuario_Id_Usuario")));
            }
            res = DatabasePOO.querrySelect("SELECT * FROM item_pedido");
            while (res.next()){
                pedidos.add(new ItemPedido(res.getInt("Id_Pedido"), res.getInt("Quantidade"), res.getInt("fk_Carrinho_Compras_Id_Carrinho"), res.getInt("fk_Produto_Id_Produto")));
            }
            res = DatabasePOO.querrySelect("SELECT * FROM produto");
            while (res.next()){
                produtos.add( new Produto(res.getInt("Id_Produto"), res.getString("Nome"), res.getFloat("Valor")) );
            }


        } catch (SQLException e) {
            System.out.println("erro Query");
        }
    }
}
