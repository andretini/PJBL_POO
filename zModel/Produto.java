package zModel;

import zController.aLoja;

public class Produto {
    public static int incrementer = 0;

    private int IdProduto;
    private String Nome;
    private String Descricao;
    private String Validade;
    private float Valor;


    public Produto(int IdProduto, String Nome, float Valor, String Descricao, String Validade){
        if (IdProduto == -1){
            if(!aLoja.pedidos.isEmpty()){
                if(incrementer < aLoja.produtos.get(aLoja.produtos.size() - 1).getIdProduto()){
                    this.setIdProduto(aLoja.pedidos.get(aLoja.pedidos.size() - 1).getIdPedido() +1);
                    incrementer = this.getIdProduto();
                }
                else{
                    this.setIdProduto(incrementer + 1);
                    incrementer ++;
                }

            }
            else{
                this.setIdProduto(1);
            }
        }
        else{
            this.setIdProduto(IdProduto);
        }

        this.setNome(Nome);
        this.setValor(Valor);
        this.setDescricao(Descricao);
        this.setValidade(Validade);
    
    }


    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        Valor = valor;
    }
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    
    public String getValidade() {
        return Validade;
    }

    public void setValidade(String validade) {
        Validade = validade;
    }

}
