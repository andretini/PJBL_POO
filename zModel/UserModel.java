package zModel;

import BancoDados.DatabasePOO;
import zController.aLoja;
import java.sql.ResultSet;

public class UserModel {
    public int Id;
    public String nome;
    public String senha;
    public UserModel(String nome, String senha, int _id){
        if (_id == -1){
            this.Id = aLoja.users.get(aLoja.users.size() - 1).Id+1;
        }
        else{
            this.Id = _id;
        }
        this.nome = nome;
        this.senha = senha;
        System.out.println(Id);
    }
    public void Migrate(){
        try {
            DatabasePOO.querry(String.format("INSERT INTO usuario(Nome, Senha) VALUES('%s', '%s')", nome, senha));
            System.out.println("Inserção realizada com Sucesso");
        } catch (Exception ex) {
            System.out.println("ERRO INSERIR");
        }
    }
}
