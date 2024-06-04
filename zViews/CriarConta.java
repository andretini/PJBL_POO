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
    JTextField email_field;
    JTextField sexo_field;
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

        email_field = new JTextField();
        email_field.setBounds(125, 240, 250, 60);
        email_field.setCaretColor(Color.BLACK);

        JLabel info_email = new JLabel("Digite seu email");
        info_email.setBounds(130, 223, 300, 20);

        sexo_field = new JTextField();
        sexo_field.setBounds(125, 320, 250, 60);
        sexo_field.setCaretColor(Color.BLACK);

        JLabel info_sexo = new JLabel("Digite seu sexo");
        info_sexo.setBounds(130, 303, 300, 20);

        password_field = new JTextField();
        password_field.setBounds(125, 400, 250, 60);

        JLabel info_senha = new JLabel("Digite sua senha");
        info_senha.setBounds(130, 385, 300, 20);

        cadastro_button_02 = new JButton("Cadastrar");
        cadastro_button_02.setBounds(125, 520, 250, 60);
        cadastro_button_02.setBackground(Color.LIGHT_GRAY);
        cadastro_button_02.addActionListener(this);

        frame.add(info_nome);
        frame.add(info_email);
        frame.add(info_sexo);
        frame.add(info_senha);
        frame.add(name_field);
        frame.add(email_field);
        frame.add(sexo_field);
        frame.add(password_field);
        frame.add(cadastro_button_02);
        frame.add(titulo);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastro_button_02) {
            UserController.create(name_field.getText(), password_field.getText(), email_field.getText(), sexo_field.getText());
            frame.dispose();
        }
    }
}
