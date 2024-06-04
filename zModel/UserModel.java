package zModel;

import BancoDados.DatabasePOO;
import zController.Sessao;
import zController.aLoja;
import java.sql.SQLException;

public class UserModel {
    private int Id;
    private String nome;
    private String senha;
    //private String email;
    //private String sexo;

    public UserModel(String nome, String senha, int _id){
        if (_id == -1){
            if(!aLoja.users.isEmpty()){
                this.Id = aLoja.users.get(aLoja.users.size() - 1).Id+1;
            }
            else{
                this.Id = 1;
            }
        }
        else{
            this.Id = _id;
        }
        this.nome = nome;
        this.senha = senha;
        System.out.println(Id);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    public void delete() {
        try {
            DatabasePOO.querry(String.format("DELETE FROM USUARIO WHERE Id_Usuario = %d;", getId()));
            Sessao.encerrarSecao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void Migrate(boolean update){
        if(!update){
            try {
                DatabasePOO.querry(String.format("INSERT INTO usuario(Nome, Senha) VALUES('%s', '%s')", nome, senha));
                System.out.println("Inserção realizada com Sucesso");
            } catch (Exception ex) {
                System.out.println("ERRO INSERIR");
            }
        }
        else{
            try {
                DatabasePOO.querry(String.format("UPDATE usuario SET Nome = '%s', Senha = '%s' WHERE Id_Usuario = %d", nome, senha, Id));
                System.out.println("Atualização realizada com Sucesso");
            } catch (Exception ex) {
                System.out.println("ERRO ATUALIZAR");
            }
        }

    }
}
