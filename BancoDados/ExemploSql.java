package BancoDados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploSql {
    public static void main(String[] args) {


        try {
            DatabasePOO.createConnection();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados");
        }

        //EXEMPLO INSERÇÃO
        try {
            DatabasePOO.querry("INSERT INTO usuario(Nome, Senha) " +
                                   "VALUES('Joao', '123')");
            System.out.println("Inserção realizada com Sucesso");
        }catch (Exception e ){
            System.out.println("ERRO INSERIR");
        }
        //EXEMPLO SELEÇÃO
        try {
            ResultSet res = DatabasePOO.querrySelect("SELECT * FROM USUARIO " +
                                                         "where Id_Usuario = 'Joao'");
            while(res.next()){
                System.out.println(res.getString("Nome"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        //EXEMPLO EDIÇÃo
        try {
            DatabasePOO.querry("UPDATE USUARIO\n" +
                                   "SET nome = 'Maria'\n" +
                                   "WHERE Id_Usuario = 2;");
        } catch (Exception e) {
            System.out.println(e);
        }

        //EXEMPLO DELEÇÃO
        try {
            DatabasePOO.querry("DELETE FROM USUARIO WHERE Id_Usuario = 2;");
        } catch (Exception e) {
            System.out.println(e);
        }




    }
}
