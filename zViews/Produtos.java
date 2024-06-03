package zViews;

import BancoDados.DatabasePOO;
import zController.Sessao;
import zController.aLoja;
import zModel.CarrinhoModel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;

public class Produtos extends JFrame implements ActionListener {
    JFrame paginaProduto;
    JTextField pesquisa;
    JPanel painel_produto;
    JLabel error_message;
    JButton pesquisar_button;
    JButton perfil;
    JButton carrinhoPagina;

    private JButton[] adicionar;
    private JLabel[] produtos_nome;
    private JLabel[] produtos_descricao;
    private JLabel[] produtos_preco;
    private int[] indexes;

    public Produtos() {
        paginaProduto = new JFrame();
        paginaProduto.setSize(500, 500);
        paginaProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginaProduto.setLayout(null);

        pesquisa = new JTextField();
        pesquisa.setBounds(90, 25, 250, 40);

        pesquisar_button = new JButton("Pesquisar");
        pesquisar_button.setBounds(340, 25, 75, 40);
        pesquisar_button.addActionListener(this);

        error_message = new JLabel("ERRO PRODUTO NÃO ENCONTRADO");
        error_message.setVisible(false);
        error_message.setBounds(100, 200, 300, 20);

        // Initialize arrays
        adicionar = new JButton[10];
        produtos_nome = new JLabel[10];
        produtos_descricao = new JLabel[10];
        produtos_preco = new JLabel[10];
        indexes = new int[10];

        JPanel[] painel_produtos = new JPanel[10];

        ResultSet res = null;
        try {
            res = DatabasePOO.querrySelect("SELECT * FROM produto where Nome like '%" + "Es" + "%'");
        } catch (SQLException e) {
            System.out.println(e);
        }

        try {
            int i = 0;
            while (res.next() && i < 10) {
                adicionar[i] = new JButton("Add");
                adicionar[i].setBounds(300, 30, 60, 20);
                adicionar[i].addActionListener(this);

                JLabel nome = new JLabel("NOME");
                nome.setBounds(20, 5, 50, 20);

                JLabel descricao = new JLabel("DESCRIÇÃO");
                descricao.setBounds(110, 5, 100, 20);

                JLabel preco = new JLabel("PREÇO");
                preco.setBounds(230, 5, 100, 20);

                produtos_nome[i] = new JLabel(res.getString("Nome"));
                produtos_nome[i].setBounds(20, 30, 100, 20);

                produtos_descricao[i] = new JLabel("Umas folhas");
                produtos_descricao[i].setBounds(110, 30, 300, 20);

                produtos_preco[i] = new JLabel(String.valueOf(res.getFloat("Valor")));
                produtos_preco[i].setBounds(230, 30, 100, 20);

                indexes[i] = res.getInt("Id_Produto");

                painel_produtos[i] = new JPanel();
                painel_produtos[i].setBounds(50, 100 + 110 * i, 400, 100);
                painel_produtos[i].setBackground(Color.GRAY);
                painel_produtos[i].setLayout(null);

                painel_produtos[i].add(nome);
                painel_produtos[i].add(descricao);
                painel_produtos[i].add(preco);
                painel_produtos[i].add(adicionar[i]);
                painel_produtos[i].add(produtos_nome[i]);
                painel_produtos[i].add(produtos_descricao[i]);
                painel_produtos[i].add(produtos_preco[i]);

                paginaProduto.add(painel_produtos[i]);
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        // Botao para ir para a pagina do carrinho
        carrinhoPagina = new JButton("Carrinho");
        carrinhoPagina.setBounds(5, 10, 80, 20);
        carrinhoPagina.addActionListener(this);

        paginaProduto.add(pesquisa);
        paginaProduto.add(pesquisar_button);
        paginaProduto.add(carrinhoPagina);

        // Botao para pagina de perfil
        perfil = new JButton("Perfil");
        perfil.setBounds(440, 10, 50, 20);
        perfil.addActionListener(this);

        paginaProduto.add(perfil);

        paginaProduto.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pesquisar_button) {
            // Painel para quando não tiver produtos no banco de dados
            JOptionPane.showMessageDialog(null, "Produto não encontrado ou fora de estoque", "ERRO", JOptionPane.ERROR_MESSAGE);
            // error_message.setVisible(true);

        } else if (e.getSource() == perfil) {
            UsuarioPerfil pagina_perfil = new UsuarioPerfil();
            paginaProduto.dispose();
        } else if (e.getSource() == carrinhoPagina) {
            PaginaCarrinho carrinho = new PaginaCarrinho();
            paginaProduto.dispose();
        }
        int c = 0;
        for (JButton b : adicionar) {
            if (e.getSource() == b) {
                System.out.println(indexes[c]);
                try {
                    int IdCart = -1;
                    for(CarrinhoModel ca: aLoja.carrinhos){
                        if (ca.fk_Usuario_Id_Usuario == Sessao.getId()){
                            IdCart = ca.Id_Carrinho;
                        }
                    }
                    System.out.println(IdCart);
                    System.out.println(indexes[c]);

                    DatabasePOO.querry(String.format("INSERT INTO item_pedido(Quantidade, fk_Carrinho_Compras_Id_Carrinho, fk_Produto_Id_Produto) VALUES(1, '%d', '%d')", IdCart, indexes[c]));
                    System.out.println("Inserção realizada com Sucesso");

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            c++;
        }
    }
}
