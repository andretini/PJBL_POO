package zViews;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import zController.UserController;

public class CriarConta extends JFrame implements ActionListener {
    JFrame frame;
    JButton cadastro_button_02;
    JTextField name_field;
    JTextField password_field;

    public CriarConta() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        JLabel titulo = new JLabel("Cadastro");
        titulo.setHorizontalTextPosition(JLabel.CENTER);
        titulo.setVerticalTextPosition(JLabel.TOP);
        titulo.setOpaque(true);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBounds(190, 45, 120, 100);
        titulo.setBackground(Color.LIGHT_GRAY);
        titulo.setFont(new Font(null, Font.BOLD, 25));

        name_field = new JTextField();
        name_field.setBounds(125, 160, 250, 60);
        name_field.setCaretColor(Color.BLACK);

        JLabel info_nome = new JLabel("Digite seu nome completo");
        info_nome.setBounds(130, 143, 300, 20);

        password_field = new JTextField();
        password_field.setBounds(125, 240, 250, 60);

        JLabel info_senha = new JLabel("Digite sua senha");
        info_senha.setBounds(130, 225, 300, 20);

        cadastro_button_02 = new JButton("Cadastrar");
        cadastro_button_02.setBounds(125, 310, 250, 60);
        cadastro_button_02.setBackground(Color.LIGHT_GRAY);
        cadastro_button_02.addActionListener(this);

        frame.add(info_nome);
        frame.add(info_senha);
        frame.add(name_field);
        frame.add(password_field);
        frame.add(cadastro_button_02);
        frame.add(titulo);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastro_button_02) {
            UserController.create(name_field.getText(), password_field.getText());
            frame.dispose();
        }
    }
}
