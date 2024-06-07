package zModel;

public abstract class ProdutoAbstrato {
    private int IdProduto;
    private String Nome;
    private String Descricao;
    private String Validade;
    private float Valor;

    public abstract int getIdProduto();
    public abstract void setIdProduto(int idProduto);
    public abstract String getNome();
    public abstract void setNome(String nome);
    public abstract float getValor();
    public abstract void setValor(float valor);
    public abstract String getDescricao();
    public abstract void setDescricao(String descricao);
    public abstract String getValidade();
    public abstract void setValidade(String validade);

}
