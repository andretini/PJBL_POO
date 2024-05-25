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

    public Produtos(){
        paginaProduto = new JFrame();
        paginaProduto.setSize(500,500);
        paginaProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginaProduto.setLayout(null);
        
        pesquisa = new JTextField();
        pesquisa.setBounds(90, 25, 250, 40);

        painel_produto = new JPanel();
        painel_produto.setBounds(50, 100, 400, 100);;
        painel_produto.setBackground(Color.GRAY);
        painel_produto.setLayout(null);

        pesquisar_button = new JButton("Pesquisar");
        pesquisar_button.setBounds(340, 25, 75, 40);
        pesquisar_button.addActionListener(this);

        error_message = new JLabel("ERRO PRODUTO NÃO ENCONTRADO");
        error_message.setVisible(false);
        error_message.setBounds(100, 200, 300, 20);

        produtos_nome = new JLabel();
        produtos_nome.setText("Alface");
        produtos_nome.setVisible(true);
        //produtos_nome.setBounds(100, 200, 300, 20);

        produtos_descricao = new JLabel();
        produtos_descricao.setText("Umas folhas verdes ai");

        produtos_preco = new JLabel();
        produtos_preco.setText("4.75");

        painel_produto.add(produtos_descricao);
        painel_produto.add(error_message);
        painel_produto.add(produtos_nome);
        painel_produto.add(produtos_descricao);
        painel_produto.add(produtos_preco);

        paginaProduto.add(painel_produto);
        paginaProduto.add(pesquisa);
        paginaProduto.add(pesquisar_button);


        //botao para pagina de perfil
        perfil = new JButton("Perfil");
        perfil.setBounds(5, 10, 50, 20);
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
    }

}