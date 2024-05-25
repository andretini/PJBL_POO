package zViews;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;


public class Produtos extends JFrame implements ActionListener{
    JFrame frame;
    JTextField pesquisa;
    JPanel painel_produto;
    JLabel error_message;
    JButton pesquisar_button;

    public Produtos(){
        frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        pesquisa = new JTextField();
        pesquisa.setBounds(90, 25, 250, 40);

        painel_produto = new JPanel();
        painel_produto.setBounds(50, 100, 400, 100);;
        painel_produto.setBackground(Color.GRAY);

        pesquisar_button = new JButton("Pesquisar");
        pesquisar_button.setBounds(340, 25, 75, 40);
        pesquisar_button.addActionListener(this);

        error_message = new JLabel("ERRO PRODUTO NÃO ENCONTRADO");
        error_message.setVisible(false);
        error_message.setBounds(100, 200, 300, 20);
        painel_produto.add(error_message);

        frame.add(painel_produto);
        frame.add(pesquisa);
        frame.add(pesquisar_button);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pesquisar_button){
            //Painel para quando não tiver produtos no banco de dados
            JOptionPane.showMessageDialog(null, "Produto não encontrado ou fora de estoque", "ERRO", JOptionPane.ERROR_MESSAGE);
            error_message.setVisible(true);
            
        }
        
    }

}