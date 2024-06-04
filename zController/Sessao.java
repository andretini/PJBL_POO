package zController;

import zModel.UserModel;



public class Sessao {
    private static boolean usuarioLogado = false;
    private static int id;

    public static void setId(int ID){
        id = ID;
        setUsuarioLogado(true);
    }
    public static int getId(){
        return id;
    }
    public static void encerrarSecao(){
        id = 0;
        setUsuarioLogado(false);
    }
    
    public static boolean isUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(boolean usuarioLogado) {
        Sessao.usuarioLogado = usuarioLogado;
    }


}
