package zModel;

import zController.aLoja;

public class Produto {
    public static int incrementer = 0;
    public int IdProduto;
    public String Nome;
    public String Descricao;
    public String Validade;
    public float Valor;

    public Produto(int IdProduto, String Nome, float Valor, String Descricao, String Validade){
        if (IdProduto == -1){
            if(!aLoja.pedidos.isEmpty()){
                if(incrementer < aLoja.produtos.get(aLoja.produtos.size() - 1).IdProduto){
                    this.IdProduto = aLoja.pedidos.get(aLoja.pedidos.size() - 1).getIdPedido() +1;
                    incrementer = this.IdProduto;
                }
                else{
                    this.IdProduto = incrementer + 1;
                    incrementer ++;
                }

            }
            else{
                this.IdProduto = 1;
            }
        }
        else{
            this.IdProduto = IdProduto;
        }

        this.Nome = Nome;
        this.Valor = Valor;
        this.Descricao = Descricao;
        this.Validade = Validade;
    }
}
