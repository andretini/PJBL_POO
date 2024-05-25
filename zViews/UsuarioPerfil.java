import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;


public class UsuarioPerfil extends JFrame implements ActionListener{
    JButton excluirPerfil;
    JFrame paginaPerfil;
    JLabel nome_usuario;
    JLabel email_usuario;
    JLabel sexo_usuario;
    JLabel senha_usuario;
    JPanel painel;

    public UsuarioPerfil(){
        paginaPerfil = new JFrame();
        paginaPerfil.setSize(500,500);
        paginaPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new JPanel();
        painel.setBounds(0, 0, 500, 500);
        painel.setLayout(null);

        JLabel pagina_nome = new JLabel("PERFIL");
        pagina_nome.setBounds(210, 25, 300, 20);
        pagina_nome.setFont(new Font(null, Font.BOLD, 20));

        JLabel nome = new JLabel("NOME:");
        JLabel email = new JLabel("EMAIL:");
        JLabel sexo = new JLabel("SEXO:");
        JLabel senha = new JLabel("SENHA:");

        nome.setBounds(50, 100, 200, 50);
        nome.setFont(new Font(null, Font.BOLD, 20));

        nome_usuario = new JLabel("Bryan Strey");
        nome_usuario.setBounds(125, 100, 300, 50);
        nome_usuario.setFont(new Font(null, Font.BOLD, 20));

        email.setBounds(50, 150, 300, 50);
        email.setFont(new Font(null, Font.BOLD, 20));

        email_usuario = new JLabel("bryanstrey@gmail.com");
        email_usuario.setBounds(125, 150, 300, 50);
        email_usuario.setFont(new Font(null, Font.BOLD, 20));

        sexo.setBounds(50, 200, 300, 50);
        sexo.setFont(new Font(null, Font.BOLD, 20));

        sexo_usuario = new JLabel("Masculino");
        sexo_usuario.setBounds(125, 200, 300, 50);
        sexo_usuario.setFont(new Font(null, Font.BOLD, 20));

        senha.setBounds(50, 250, 300, 50);
        senha.setFont(new Font(null, Font.BOLD, 20));
        senha.setFont(new Font(null, Font.BOLD, 20));

        senha_usuario = new JLabel("***************");
        senha_usuario.setBounds(130, 250, 300, 50);
        senha_usuario.setFont(new Font(null, Font.BOLD, 20));

        excluirPerfil = new JButton("Excluir");
        excluirPerfil.setBounds(150, 350, 200, 80);
        excluirPerfil.addActionListener(this);

        painel.add(pagina_nome);
        painel.add(nome);
        painel.add(nome_usuario);
        painel.add(email);
        painel.add(email_usuario);
        painel.add(sexo);
        painel.add(sexo_usuario);
        painel.add(senha);
        painel.add(senha_usuario);
        painel.add(excluirPerfil);

        paginaPerfil.add(painel);
        paginaPerfil.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == excluirPerfil){
            JOptionPane.showMessageDialog(null, "Conta Excluida com Sucesso", "Conta Excluida", JOptionPane.INFORMATION_MESSAGE);
            PaginaInicial novaConta = new PaginaInicial();
            paginaPerfil.dispose();
        }

    }
    
}