import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;


public class Produtos extends JFrame implements ActionListener{
    JFrame paginaProduto;
    JTextField pesquisa;
    JPanel painel_produto;
    JLabel error_message;
    JLabel produtos_nome;
    JLabel produtos_descricao;
    JLabel produtos_preco;
    JButton pesquisar_button;
    JButton perfil;
    JButton adicionaCarrinho;
    JButton carrinhoPagina;

    public Produtos(){
        paginaProduto = new JFrame();
        paginaProduto.setSize(500,500);
        paginaProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginaProduto.setLayout(null);
        
        pesquisa = new JTextField();
        pesquisa.setBounds(90, 25, 250, 40);

        painel_produto = new JPanel();
        painel_produto.setBounds(50, 100, 400, 100);
        painel_produto.setBackground(Color.GRAY);
        painel_produto.setLayout(null);

        pesquisar_button = new JButton("Pesquisar");
        pesquisar_button.setBounds(340, 25, 75, 40);
        pesquisar_button.addActionListener(this);

        error_message = new JLabel("ERRO PRODUTO NÃO ENCONTRADO");
        error_message.setVisible(false);
        error_message.setBounds(100, 200, 300, 20);

        //placeholders do produto
        JLabel nome = new JLabel("NOME");
        nome.setBounds(20, 5, 50, 20);

        JLabel descricao = new JLabel("DESCRIÇÃO");
        descricao.setBounds(110, 5, 100, 20);

        JLabel preco = new JLabel("PREÇO");
        preco.setBounds(230, 5, 100,20);

        //atributos dos produtos
        produtos_nome = new JLabel("Alface");
        produtos_nome.setBounds(20, 30, 100, 20); 

        produtos_descricao = new JLabel("Umas folhas verdes ai");
        produtos_descricao.setBounds(80, 30, 300, 20); 

        produtos_preco = new JLabel("4.75");
        produtos_preco.setBounds(240, 30, 100, 20); 

        //botao para adicionar ao carrinho
        adicionaCarrinho = new JButton("Add");
        adicionaCarrinho.setBounds(300, 30, 60, 20);
        adicionaCarrinho.addActionListener(this);

        //botao para ir para a pagina do carrinho
        carrinhoPagina = new JButton("Carrinho");
        carrinhoPagina.setBounds(5, 10, 80, 20);
        carrinhoPagina.addActionListener(this);

        painel_produto.add(nome);
        painel_produto.add(descricao);
        painel_produto.add(preco);
        painel_produto.add(adicionaCarrinho);
        painel_produto.add(produtos_nome);
        painel_produto.add(produtos_descricao);
        painel_produto.add(produtos_preco);
        painel_produto.add(error_message);

        paginaProduto.add(pesquisa);
        paginaProduto.add(painel_produto);
        paginaProduto.add(pesquisar_button);
        paginaProduto.add(carrinhoPagina);


        //botao para pagina de perfil
        perfil = new JButton("Perfil");
        perfil.setBounds(440, 10, 50, 20);
        perfil.addActionListener(this);

        paginaProduto.add(perfil);

        paginaProduto.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pesquisar_button){
            //Painel para quando não tiver produtos no banco de dados
            JOptionPane.showMessageDialog(null, "Produto não encontrado ou fora de estoque", "ERRO", JOptionPane.ERROR_MESSAGE);
            //error_message.setVisible(true);
            
        }
        else if(e.getSource() == perfil){
            UsuarioPerfil pagina_perfil = new UsuarioPerfil();
            paginaProduto.dispose();
        }
        else if(e.getSource() == adicionaCarrinho){
            //código para mandar ao carrinho e para o banco de dados 
        }
        else if(e.getSource() == carrinhoPagina){
            PaginaCarrinho carrinho = new PaginaCarrinho();
            paginaProduto.dispose();
        }
    }

}