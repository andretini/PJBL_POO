package zViews;

import BancoDados.DatabasePOO;
import zController.UserController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JFrame frame;
    JButton cadastrar_button;
    JButton entrar_button;
    JTextField name_field;
    JTextField password_field;

    int userId;

    public Login(int _userId) {
        userId = _userId;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        JLabel cadastro = new JLabel("Não possui uma conta? ");
        cadastro.setBounds(170, 365, 200, 40);
        cadastro.setFont(new Font(null, Font.BOLD, 13));

        cadastrar_button = new JButton("Cadastre-se");
        cadastrar_button.setBounds(200, 400, 100, 35);
        cadastrar_button.setFocusable(false);
        cadastrar_button.addActionListener(this);
        cadastrar_button.setBackground(Color.LIGHT_GRAY);
        cadastrar_button.setOpaque(true);

        JLabel label = new JLabel();
        label.setText("LOGIN");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(190, 40, 100, 100);
        label.setBackground(Color.LIGHT_GRAY);
        label.setFont(new Font(null, Font.BOLD, 25));

        name_field = new JTextField();
        name_field.setBounds(125, 160, 250, 60);
        name_field.setCaretColor(Color.BLACK);

        JLabel login_info = new JLabel("Nome");
        login_info.setBounds(130, 143, 100, 20);

        password_field = new JTextField();
        password_field.setBounds(125, 240, 250, 60);

        JLabel password_info = new JLabel("Senha");
        password_info.setBounds(130, 225, 100, 20);

        entrar_button = new JButton("Entrar");
        entrar_button.setBounds(125, 310, 250, 60);
        entrar_button.setBackground(Color.LIGHT_GRAY);
        entrar_button.addActionListener(this);

        frame.add(cadastrar_button);
        frame.add(label);
        frame.add(name_field);
        frame.add(password_field);
        frame.add(entrar_button);
        frame.add(cadastro);
        frame.add(login_info);
        frame.add(password_info);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrar_button) {
            frame.dispose();
            new CriarConta();
        } 
        else if (e.getSource() == entrar_button) {
            try {
                UserController.login(name_field.getText(), password_field.getText());
                frame.dispose();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
