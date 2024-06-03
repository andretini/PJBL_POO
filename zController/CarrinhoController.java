package zController;

import zModel.CarrinhoModel;
import zModel.UserModel;

public class CarrinhoController {
    public static void create(int fk_Usuario_Id_Usuario){
        CarrinhoModel carrinho = new CarrinhoModel(-1, fk_Usuario_Id_Usuario);
        aLoja.carrinhos.add(carrinho);
        carrinho.Migrate(false);
    }
}
