import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PaginaCarrinho extends JFrame implements ActionListener{
    JFrame carrinhoPage;
    JButton comprar;
    JButton removerProduto;
    JTextField quantidadeProduto;
    JPanel itensCarrinho;
    JLabel nomeProdutoCarrinho;
    JLabel descricaoProdutoCarrinho;
    JLabel precoProdutoCarrinho;
    JLabel carrinhoVazio;

    public PaginaCarrinho(){
        carrinhoPage = new JFrame();
        carrinhoPage.setSize(500,500);
        carrinhoPage.setLayout(null);
        carrinhoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("Carrinho");
        titulo.setBounds(200, 13, 100, 20);
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));

        //painel dos produtos que iram aparecer
        itensCarrinho = new JPanel();
        itensCarrinho.setLayout(null);
        itensCarrinho.setBounds(5, 50, 474, 80);
        itensCarrinho.setBackground(Color.GRAY);

        //placeholders dos produtos
        JLabel nome = new JLabel("NOME");
        nome.setBounds(15, 10, 100, 20);

        JLabel descricao = new JLabel("DESCRIÇÃO");
        descricao.setBounds(135, 10, 100, 20);

        JLabel preco = new JLabel("PREÇO");
        preco.setBounds(310, 10, 100, 20);

        JLabel quantidade = new JLabel("QTDE");
        quantidade.setBounds(370, 10, 100, 20);

        //nome produto
        nomeProdutoCarrinho = new JLabel();
        nomeProdutoCarrinho.setText("Melancia");
        nomeProdutoCarrinho.setBounds(6,30, 100, 20 );

        //descricao produto
        descricaoProdutoCarrinho = new JLabel();
        descricaoProdutoCarrinho.setText("Uma fruta verde com interior vermelho");
        descricaoProdutoCarrinho.setBounds(70, 30, 300, 20);

        //preço produto
        precoProdutoCarrinho = new JLabel();
        precoProdutoCarrinho.setText("R$9.75");
        precoProdutoCarrinho.setBounds(310, 30,300, 20);

        //quantidade Produto
        quantidadeProduto = new JTextField("1");
        quantidadeProduto.setBounds(375, 30, 20,20);
        quantidadeProduto.setBackground(Color.GRAY);
        quantidadeProduto.setBorder(null);

        //botao de remover produto
        removerProduto = new JButton("X");
        removerProduto.setBounds(420, 30, 50, 20);
        removerProduto.addActionListener(this);
        removerProduto.setBackground(Color.GRAY);
        removerProduto.setBorder(null);
        
        //botao de compra
        comprar = new JButton("COMPRAR");
        comprar.setBounds(190, 400, 100, 40);
        comprar.addActionListener(this);

        //itens do painel
        itensCarrinho.add(nome);
        itensCarrinho.add(descricao);
        itensCarrinho.add(preco);
        itensCarrinho.add(quantidade);
        itensCarrinho.add(nomeProdutoCarrinho);
        itensCarrinho.add(descricaoProdutoCarrinho);
        itensCarrinho.add(precoProdutoCarrinho);
        itensCarrinho.add(quantidadeProduto);
        itensCarrinho.add(removerProduto);

        //memsagem de carrinho vazio
        carrinhoVazio = new JLabel("CARRINHO VAZIO");
        carrinhoVazio.setBounds(135,175, 500, 40);
        carrinhoVazio.setFont(new Font("Arial", Font.PLAIN, 25));
        carrinhoVazio.setVisible(false);

        carrinhoPage.add(comprar);
        carrinhoPage.add(titulo);
        carrinhoPage.add(itensCarrinho);
        carrinhoPage.add(carrinhoVazio);
        carrinhoPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comprar){
            itensCarrinho.setVisible(false);
            carrinhoVazio.setVisible(true);
            JOptionPane.showConfirmDialog(null, "COMPRA REALIZADA COM SUCESSO", "COMPRA BEM SUCEDIDA", JOptionPane.PLAIN_MESSAGE);
        }
        else if(e.getSource() == removerProduto){
            itensCarrinho.setVisible(false);
            carrinhoVazio.setVisible(true);
        }
    }
}