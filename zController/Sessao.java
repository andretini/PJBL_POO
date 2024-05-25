package zController;

public class Sessao {
    public static boolean usuarioLogado = false;
    public static int id;
    public static void setId(int ID){
        id = ID;
        usuarioLogado = true;
    }
    public static int getId(){
        return id;
    }
    public static void encerrarSecao(){
        id = 0;
        usuarioLogado = false;
    }
}
