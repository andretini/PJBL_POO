package zController;

import zModel.CarrinhoModel;
import zModel.UserModel;
import zViews.Produtos;
import java.util.Objects;

public class UserController {
    public static void create(String name, String senha, String email, String sexo){
        UserModel user = new UserModel(name, senha, -1, email, sexo);
        aLoja.users.add(user);
        user.Migrate(false);
        CarrinhoController.create(user.getId());
        System.out.println("Logado");
        Sessao.setId(user.getId());
        new Produtos();
    }
    public static void login(String name, String senha){

        try {
            for(UserModel user: aLoja.users){
                if(user != null){
                    if(Objects.equals(user.getNome(), name) && Objects.equals(user.getSenha(), senha)){
                        System.out.println("Logado");
                        Sessao.setId(user.getId());
                        new Produtos();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void update(String name, String senha, int Id, String email, String sexo){
        for(UserModel user: aLoja.getUsers()){
            if(Objects.equals(user.getId(), Id)){
                user.setNome(name);
                user.setEmail(email);
                user.setSexo(sexo);
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
            if (Objects.equals(user.getId(), Id)) {
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
