import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fenetre extends JFrame {
    private String batAlarme;
    private int niveauAlarme;
    private String typeG;
    private int radioV;

    public static ArrayList<GraphTypeA> gta = new ArrayList<>();
    public static ArrayList<GraphTypeA> gtb = new ArrayList<>();

    private GraphTypeA ta;
    private GraphTypeA tb;

    private int a;
    public Fenetre(){

        this.setTitle("Application");
        this.setSize(getToolkit().getScreenSize());

        //Menu des alarmes
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Déclancher une alarme");


        JMenuItem gaz = new JMenuItem(new GraphGaz(this, "Alarme de type gaz"));
        menu1.add(gaz);

        JMenuItem feu = new JMenuItem(new GraphFeu(this, "Alarme de type incendie"));
        menu1.add(feu);

        JMenuItem radio = new JMenuItem(new GraphRadio(this, "Alarme de type radioactivité"));
        menu1.add(radio);

        //Menu batiment
        JMenu menu2 = new JMenu("Menu des batiments");
        for(int nbreBatiment=0; nbreBatiment<Batiment.liste.size();nbreBatiment++) {

            menu2.add(new JMenuItem(new GraphBatiment(this, Batiment.liste.get(nbreBatiment).getNom(),Batiment.liste.get(nbreBatiment))));

        }
        //Menu des differents type d'alarme

        for(AtypeListener i : Inscription.aType){
            gta.add(new GraphTypeA("Type A",i.events));}
//            this.setTa(new GraphTypeA("Type A",AtypeListener.events));}

        for(BtypeListener u : Inscription.bType) {
            gtb.add(new GraphTypeA("Type B",u.events));
        }
//            this.tb = new GraphTypeA("Type B",BtypeListener.events);}




        menuBar.add(menu1);
        menuBar.add(menu2);

        setJMenuBar(menuBar);

        //page  principale
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel coucou = new JLabel("Bonjour et bienvenue, grace à cette application vous pouvez créer des alarmes et les visualiser ");
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

    public GraphTypeA getTa() {
        return ta;
    }

    public void setTa(GraphTypeA ta) {this.ta = ta; }

    public int getA() {
        return a;
    }

    public void setA(int a) { this.a = a;}

    public GraphTypeA getTb(){return tb;}



}