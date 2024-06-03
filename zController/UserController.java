package zController;
import BancoDados.DatabasePOO;
import com.mysql.cj.Session;
import zModel.CarrinhoModel;
import zModel.UserModel;
import zController.aLoja;
import zViews.Produtos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserController {
    public static void create(String name, String senha){
        UserModel user = new UserModel(name, senha, -1);
        aLoja.users.add(user);
        user.Migrate(false);
        CarrinhoController.create(user.Id);
        System.out.println("Logado");
        Sessao.setId(1);
        new Produtos();
    }
    public static void login(String name, String senha){

        try {
            for(UserModel user: aLoja.users){
                if(Objects.equals(user.getNome(), name) && Objects.equals(user.getSenha(), senha)){
                    System.out.println("Logado");
                    Sessao.setId(user.getId());
                    new Produtos();
                    break;
                }
            }
            /*
            ResultSet res = DatabasePOO.querrySelect(String.format("SELECT * FROM USUARIO " +
                    "where nome = '%s'", name));
            while (res.next()){
                if (Objects.equals(res.getString("Senha"), senha)) {
                    System.out.println("Logado");
                    Sessao.setId(res.findColumn("Id_Usuario"));
                    new Produtos();
                    break;
                }
            }*/
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void update(String name, String senha, int Id){
        for(UserModel user: aLoja.getUsers()){
            if(Objects.equals(user.getId(), Id)){
                user.setNome(name);
                user.setSenha(senha);
                user.Migrate(true);
                break;
            }
        }
    }
    public static void delete(int Id){
        UserModel us = null;
        CarrinhoModel ca = null;
        for (UserModel user : aLoja.getUsers()) {
            if (Objects.equals(user.getId(), id)) {
                for (CarrinhoModel cart : aLoja.getCarrinhos()) {
                    if (cart.getFkUsuarioIdUsuario() == user.getId()) {
                        cart.Delete();
                        ca = cart;
                    }
                }
                user.Delete();
                us = user;
            }
        }
        if(ca != null && us != null){
            aLoja.getUsers().remove(us);
            aLoja.getCarrinhos().remove(ca);
        }
    }
}
