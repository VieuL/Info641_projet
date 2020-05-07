import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    private String batAlarme;
    private int niveauAlarme;
    private String typeG;
    private int radioV;
    public Fenetre(){
        this.setTitle("Application");
        this.setSize(getToolkit().getScreenSize());


        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Déclancher une alarme");


        JMenuItem gaz = new JMenuItem(new GraphGaz(this, "Alarme de type gaz"));
        menu1.add(gaz);

        JMenuItem feu = new JMenuItem(new GraphFeu(this, "Alarme de type incendie"));
        menu1.add(feu);

        JMenuItem radio = new JMenuItem(new GraphRadio(this, "Alarme de type radioactivité"));
        menu1.add(radio);

        //menu batiment
        JMenu menu2 = new JMenu("Menu des batiments");
        for(int nbreBatiment=0; nbreBatiment<Batiment.liste.size();nbreBatiment++) {

            menu2.add(new JMenuItem(new GraphBatiment(this, Batiment.liste.get(nbreBatiment).getNom(),Batiment.liste.get(nbreBatiment))));

        }
        menuBar.add(menu1);
        menuBar.add(menu2);
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
    public void setbatAlarmee(String form){
        this.batAlarme = form;
    }
    public void setNiveauAlarme(int form){
        this.niveauAlarme = form;
    }
    public String getBatAlarme() {
        return batAlarme;
    }
    public int getNiveauAlarme() {
        return niveauAlarme;
    }

    public String getTypeG() {
        return typeG;
    }

    public void setTypeG(String typeG) {
        this.typeG = typeG;
    }

    public int getRadioV() {
        return radioV;
    }

    public void setRadioV(int µ){
        this.radioV = µ;
    }
}