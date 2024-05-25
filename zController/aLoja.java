package zController;

import BancoDados.DatabasePOO;
import zModel.UserModel;
import zViews.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class aLoja {

    public static ArrayList<UserModel> users = new ArrayList<>();


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
        } catch (SQLException e) {
            System.out.println("erro Query");
        }
    }
}
