import javax.swing.*;
import java.awt.*;

public class Territorio extends JPanel{
    private static final int ALTURA_BARRA_TITULO=20;
    private int contador = 0;

    private JFrame frame;

    public Territorio(String nome){
        frame = new JFrame(nome);
        frame.add(this);
        frame.setSize(400,300 + ALTURA_BARRA_TITULO);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d= (Graphics2D) g;
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana",Font.BOLD, 16));
        g2d.drawString("Contador: " + String.valueOf(contador), 10, 30);

        /* desenho de um retangulo
        g2d.setColor(Color.GREEN);
        g2d.fillRect(30, 60, 40, 20);
         */
        
    }

    public void jogar(){
        boolean jogando = true;

        while(jogando){
            contador ++;
            if (contador == 10) {
                System.out.println("largura: " + getWidth() + ",altura" + getHeight());
                jogando = false;
            } 
            repaint();
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        game_over();
    }

    public void game_over(){
        String mensagem= "Parabens";
        JOptionPane.showMessageDialog(this, mensagem, "Game Over", JOptionPane.YES_NO_OPTION);
    }
}
