package zModel;

import zController.aLoja;

public class Produto extends ProdutoAbstrato {
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

    @Override
    public int getIdProduto() {
        return IdProduto;
    }

    @Override
    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
    }

    @Override
    public String getNome() {
        return Nome;
    }

    @Override
    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public float getValor() {
        return Valor;
    }

    @Override
    public void setValor(float valor) {
        Valor = valor;
    }

    @Override
    public String getDescricao() {
        return Descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    @Override
    public String getValidade() {
        return Validade;
    }

    @Override
    public void setValidade(String validade) {
        Validade = validade;
    }

}
