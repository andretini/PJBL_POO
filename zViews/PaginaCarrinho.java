package zViews;

import zController.ItemPedidoController;
import zController.Sessao;
import zController.aLoja;
import zModel.CarrinhoModel;
import zModel.ItemPedido;
import zModel.Produto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;

public class PaginaCarrinho extends JFrame implements ActionListener {
    JFrame carrinhoPage;
    JButton comprar;
    JPanel carrinhoPanel;
    ArrayList<JPanel> carrinhosPanel = new ArrayList<>();
    JLabel carrinhoVazio;
    private int IdCart = -1; 

    public int getIdCart() {
        return IdCart;
    }

    public void setIdCart(int idCart) {
        IdCart = idCart;
    }

    public PaginaCarrinho() {
        carrinhoPage = new JFrame();
        carrinhoPage.setSize(500, 500);
        carrinhoPage.setLayout(null);
        carrinhoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("Carrinho");
        titulo.setBounds(200, 13, 100, 20);
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));

        carrinhoVazio = new JLabel("CARRINHO VAZIO");
        carrinhoVazio.setBounds(135, 175, 500, 40);
        carrinhoVazio.setFont(new Font("Arial", Font.PLAIN, 25));
        carrinhoVazio.setVisible(false);

        IdCart = -1;
        for (CarrinhoModel ca : aLoja.carrinhos) {
            if (ca.getFkUsuarioIdUsuario() == Sessao.getId()) {
                IdCart = ca.getIdCarrinho();
                break;
            }
        }


        var c = 0;
        for (ItemPedido pe: aLoja.pedidos){
            Produto produto = null;
            for(Produto p: aLoja.produtos){
                if(p.getIdProduto() == pe.getFk_Produto_Id_Produto()){
                    produto = p;
                }
            }
            if (produto != null){
                carrinhoPanel = new JPanel();
                carrinhoPanel.setLayout(null);
                carrinhoPanel.setBounds(5, 50 + 100 * c, 474, 80);
                carrinhoPanel.setBackground(Color.GRAY);

                JPanel itensCarrinho = new JPanel();
                itensCarrinho.setLayout(null);
                itensCarrinho.setBounds(0, 0, 474, 80);
                itensCarrinho.setBackground(Color.GRAY);

                JLabel nome = new JLabel("NOME");
                nome.setBounds(15, 10, 100, 20);

                JLabel descricao = new JLabel("DESCRIÇÃO");
                descricao.setBounds(135, 10, 100, 20);

                JLabel preco = new JLabel("PREÇO");
                preco.setBounds(310, 10, 100, 20);

                JLabel quantidade = new JLabel("QTDE");
                quantidade.setBounds(370, 10, 100, 20);

                JLabel nomeProdutoCarrinho = new JLabel(String.valueOf(produto.getNome()));
                nomeProdutoCarrinho.setBounds(15, 30, 100, 20);

                JLabel descricaoProdutoCarrinho = new JLabel(String.valueOf(pe.getFk_Produto_Id_Produto()));
                descricaoProdutoCarrinho.setBounds(135, 30, 300, 20);

                JLabel precoProdutoCarrinho = new JLabel("R$ " + String.valueOf(produto.getValor()));
                precoProdutoCarrinho.setBounds(310, 30, 100, 20);

                JTextField quantidadeProduto = new JTextField(String.valueOf(pe.getQuantidade()));
                quantidadeProduto.setBounds(375, 30, 20, 20);
                quantidadeProduto.setBackground(Color.GRAY);
                quantidadeProduto.setBorder(null);

                JButton removerProduto = new JButton("X");
                removerProduto.setBounds(420, 30, 50, 20);
                removerProduto.addActionListener(this);
                removerProduto.setBackground(Color.GRAY);
                removerProduto.setBorder(null);
                removerProduto.putClientProperty("produtoId", pe.getIdPedido());

                itensCarrinho.add(nome);
                itensCarrinho.add(descricao);
                itensCarrinho.add(preco);
                itensCarrinho.add(quantidade);
                itensCarrinho.add(nomeProdutoCarrinho);
                itensCarrinho.add(descricaoProdutoCarrinho);
                itensCarrinho.add(precoProdutoCarrinho);
                itensCarrinho.add(quantidadeProduto);
                itensCarrinho.add(removerProduto);

                carrinhoPanel.add(itensCarrinho);
                carrinhosPanel.add(carrinhoPanel);
                carrinhoPage.add(carrinhoPanel);


            }
            c ++;
        }

        comprar = new JButton("COMPRAR");
        comprar.setBounds(190, 400, 100, 40);
        comprar.putClientProperty("carrinhoId", getIdCart()); // Usando o getter para obter o IdCart
        comprar.addActionListener(this);

        carrinhoPage.add(comprar);
        carrinhoPage.add(titulo);
        carrinhoPage.add(carrinhoVazio);
        carrinhoPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("COMPRAR")) {
                try {
                    ArrayList<ItemPedido> pedido = new ArrayList<>();
                    for (ItemPedido pe: aLoja.pedidos){
                        if (Integer.valueOf(pe.getFk_Carrinho_Compras_Id_Carrinho()) == (int)source.getClientProperty("carrinhoId")){

                            pedido.add(pe);
                        }
                    }
                    if(!pedido.isEmpty()){
                        for(ItemPedido pe: pedido){
                            ItemPedidoController.delete(pe);
                        }
                    }
                    new Produtos();
                    carrinhoPage.dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                // Implementar lógica de compra aqui
                JOptionPane.showMessageDialog(null, "COMPRA REALIZADA COM SUCESSO", "COMPRA BEM SUCEDIDA", JOptionPane.PLAIN_MESSAGE);
            } else if (source.getText().equals("X")) {
                // Implementar lógica de remoção de produto aqui
                try {
                    ItemPedido pedido = null;
                    for (ItemPedido pe: aLoja.pedidos){
                        if ( Objects.equals(pe.getIdPedido(), (Integer)source.getClientProperty("produtoId")) ){
                            pedido = pe;
                        }
                    }
                    if(pedido != null){
                        ItemPedidoController.delete(pedido);
                    }
                    new PaginaCarrinho();
                    carrinhoPage.dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Produto removido do carrinho", "Produto removido", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
