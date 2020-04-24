import javax.swing.*;
import java.awt.Toolkit;
public class Fenetre extends JFrame {

    public Fenetre(){
        this.setTitle("Activation des alarmes");
        this.setSize(getToolkit().getScreenSize());


        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Déclancher une alarme");


        JMenuItem feu = new JMenuItem("Alarme de type incendie");
        menu1.add(feu);

        JMenuItem radio = new JMenuItem("Alarme de type radioactivité");
        menu1.add(radio);

        JMenuItem gaz = new JMenuItem(new GrphGaz(this, "Alarme de type gaz"));
        menu1.add(gaz);


        menuBar.add(menu1);
        setJMenuBar(menuBar);


        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

}