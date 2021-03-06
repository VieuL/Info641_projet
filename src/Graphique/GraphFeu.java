import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * classe de l'onglet du formulaire pour les alertes
 * lié à un incendie
 */
public class GraphFeu extends AbstractAction {
    private int µ = 0;
    private HashMap<String,Batiment> batim = new HashMap<>();

    private Fenetre fenetre;

    private JComboBox choix = new JComboBox();
    private JLabel label = new JLabel("Choix du batiement");

    private JPanel titre = new JPanel();
    private JPanel bat = new JPanel();

    private JPanel grpRadio = new JPanel();
    private JPanel bou = new JPanel();

    private ButtonGroup bgRadio = new ButtonGroup();
    private JRadioButton case1 = new JRadioButton("Niveau 1");
    private JRadioButton case2 = new JRadioButton("Niveau 2");
    private JRadioButton case3 = new JRadioButton("Niveau 3");

    private JButton valider = new JButton("Valider");

    public GraphFeu(Fenetre fenetre, String texte) {

        super(texte);
        this.fenetre = fenetre;

    }




    /**
     * Construction des panel et incorporation dans une fenetre
     */
    public void rea() {

        // Initialisation
        µ = 0;
        titre = new JPanel();
        bat = new JPanel();
        grpRadio = new JPanel();
        bou = new JPanel();
        batim = new HashMap<>();
        choix = new JComboBox();
        bgRadio = new ButtonGroup();
        case1 = new JRadioButton("Niveau 1");
        case2 = new JRadioButton("Niveau 2");
        case3 = new JRadioButton("Niveau 3");
        valider = new JButton("Valider");




        fenetre.remove(titre);
        fenetre.setTitle("Administration");
        //fenetre.setLocationRelativeTo(null);

        bat.setLayout(new BoxLayout(bat, BoxLayout.Y_AXIS));

        // creation de la combo - Box
        if(µ==0) {
            choixBat();
            µ++;
        }
        choix.setMaximumSize(new Dimension(120, 50));
        choix.add(label);
        choix.addActionListener(new ItemAction());
        bat.add(choix);


        // Création d'une check box
        grpRadio.setMaximumSize(new Dimension(100, 100));
        grpRadio.setLayout(new BoxLayout(grpRadio, BoxLayout.Y_AXIS));
        bgRadio.add(case1);
        bgRadio.add(case2);
        bgRadio.add(case3);

        case1.addActionListener(new RadioListener());
        case2.addActionListener(new RadioListener());
        case3.addActionListener(new RadioListener());

        grpRadio.add(case1);
        grpRadio.add(case2);
        grpRadio.add(case3);

        // Crétion du boutton valider
        valider.addActionListener(new ButtonListener());
        bou.setLayout(new BoxLayout(bou, BoxLayout.Y_AXIS));
        bou.add(valider);

        // ------------------------------------------------------------
//        titre.setPreferredSize(new Dimension(0, 0));
//        titre.setLayout(new BoxLayout(titre, BoxLayout.Y_AXIS));
        titre.setBorder(BorderFactory.createTitledBorder(" Pour créer une alarme pour le feu veuillez remplir le formulaire suivant "));
        grpRadio.setBorder(BorderFactory.createTitledBorder("importance  "));
        bat.setBorder(BorderFactory.createTitledBorder(" localisation "));


        //Ajout des JPanel secondaire dans le Jpanl princiapale
        titre.add(bat);
        titre.add(grpRadio);
        titre.add(bou);

        // Set le pan dans la fenetre
        fenetre.setContentPane(titre);
        fenetre.setVisible(true);
    }


    // Création d'une fonction qui récup les batiment pour crée la liste dérou
    private void choixBat() {
        choix.setPreferredSize(new Dimension(100, 20));
        choix.addItem("choix du bâtiment");
        for (Batiment a : Batiment.liste) {
            choix.addItem(a.getNom());
            batim.put(a.getNom(),a);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.rea();
    }




    // Création d'une classe interne actionListener pour le choix des batiment
    class ItemAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fenetre.setbatAlarmee(choix.getSelectedItem().toString());
            System.out.println(fenetre.getBatAlarme());
        }
    }





    // Création d'une classe interne actionListener pour le niveau
    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fenetre.setNiveauAlarme(Integer.parseInt(Character.toString(e.getActionCommand().charAt(e.getActionCommand().length() - 1))));
            System.out.println("Radios changées - nouvelle valeur : " + fenetre.getNiveauAlarme());
        }
    }





   // Création d'une classe interne actionListener pour le boutton
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            //Génération de l'alarme
            CréationAlarme.IncendieG.generateIncendieEvent(batim.get(fenetre.getBatAlarme()),fenetre.getNiveauAlarme());
            // Mise a jour des fenetes
            for (FenetreType i : Fenetre.gta){i.reinitialisation();}
            //Initialisation de la fenetre
            new GraphFeu(fenetre,"feu").rea();

        }
    }
}
