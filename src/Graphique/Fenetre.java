import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    public Fenetre(){
        this.setTitle("Activation des alarmes");
        this.setSize(getToolkit().getScreenSize());


        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Déclancher une alarme");


        JMenuItem gaz = new JMenuItem(new GraphGaz(this, "Alarme de type gaz"));
        menu1.add(gaz);

        JMenuItem feu = new JMenuItem(new GraphFeu(this, "Alarme de type incendie"));
        menu1.add(feu);

        JMenuItem radio = new JMenuItem(new GraphRadio(this, "Alarme de type radioactivité"));
        menu1.add(radio);


        menuBar.add(menu1);
        setJMenuBar(menuBar);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel coucou = new JLabel("Bonjour et bienvenue, garce à cette application vous pouvez créer des alarmes ");
        panel.add(coucou);

        setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

}