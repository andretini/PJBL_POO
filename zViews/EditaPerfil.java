import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditaPerfil extends JFrame implements ActionListener {
    JFrame paginaEdita;
    JTextField nome_usuario;
    JTextField email_usuario;
    JTextField sexo_usuario;
    JTextField senha_usuario;
    JPanel painel;
    JButton salvarInfo;

    public EditaPerfil(){
        paginaEdita = new JFrame();
        paginaEdita.setSize(500,500);
        paginaEdita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new JPanel();
        painel.setBounds(0, 0, 500, 500);
        painel.setLayout(null);

        JLabel pagina_nome = new JLabel("DIGITE AS NOVAS INFORMAÇÕES");
        pagina_nome.setBounds(100, 25, 500, 20);
        pagina_nome.setFont(new Font(null, Font.BOLD, 20));

        JLabel nome = new JLabel("NOME:");
        JLabel email = new JLabel("EMAIL:");
        JLabel sexo = new JLabel("SEXO:");
        JLabel senha = new JLabel("SENHA:");

        nome.setBounds(50, 100, 200, 50);
        nome.setFont(new Font(null, Font.BOLD, 20));

        nome_usuario = new JTextField();
        nome_usuario.setBounds(125, 100, 300, 50);
        nome_usuario.setFont(new Font(null, Font.BOLD, 20));

        email.setBounds(50, 150, 300, 50);
        email.setFont(new Font(null, Font.BOLD, 20));

        email_usuario = new JTextField();
        email_usuario.setBounds(125, 150, 300, 50);
        email_usuario.setFont(new Font(null, Font.BOLD, 20));

        sexo.setBounds(50, 200, 300, 50);
        sexo.setFont(new Font(null, Font.BOLD, 20));

        sexo_usuario = new JTextField();
        sexo_usuario.setBounds(125, 200, 300, 50);
        sexo_usuario.setFont(new Font(null, Font.BOLD, 20));

        senha.setBounds(50, 250, 300, 50);
        senha.setFont(new Font(null, Font.BOLD, 20));
        senha.setFont(new Font(null, Font.BOLD, 20));

        senha_usuario = new JTextField();
        senha_usuario.setBounds(130, 250, 300, 50);
        senha_usuario.setFont(new Font(null, Font.BOLD, 20));

        salvarInfo = new JButton("Salvar");
        salvarInfo.setBounds(150, 350, 200, 80);
        salvarInfo.addActionListener(this);

        painel.add(pagina_nome);
        painel.add(nome);
        painel.add(nome_usuario);
        painel.add(email);
        painel.add(email_usuario);
        painel.add(sexo);
        painel.add(sexo_usuario);
        painel.add(senha);
        painel.add(senha_usuario);
        painel.add(salvarInfo);

        paginaEdita.add(painel);
        paginaEdita.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salvarInfo){
            JOptionPane.showMessageDialog(null, "Conta Modificada com Sucesso", "Conta Alterada", JOptionPane.INFORMATION_MESSAGE);
            //PaginaInicial novaConta = new PaginaInicial(); esta comentado pois não estou com o código completo nesse pc
            paginaEdita.dispose();
        }

    }
}
