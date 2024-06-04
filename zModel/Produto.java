package zModel;

import zController.aLoja;

public class Produto {
    public static int incrementer = 0;
    private int IdProduto;
    private String Nome;
    private float Valor;

    public Produto(int IdProduto,String Nome, float Valor){
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
}
