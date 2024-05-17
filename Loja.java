import BancoDados.DatabasePOO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loja {
    public static void main(String[] args){
        try {
            DatabasePOO.createConnection();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados");
        }
        PaginaInicial paginaInicial = new PaginaInicial();
        
    }
}
