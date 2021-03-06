import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
/**
 * classe de l'onglet du formulaire pour les alertes
 * lié à un gaz
 */
public class GraphGaz extends AbstractAction {
    private Fenetre fenetre;
    private int µ = 0;
    private HashMap<String,Batiment> batim = new HashMap<>();

    // Pour la liste déroulante
    private JComboBox choix = new JComboBox();
    private JLabel label = new JLabel("Choix du batiement");

    // Création de Jpanel
    private JPanel titre = new JPanel();
    private JPanel bat = new JPanel();
    private JPanel grpRadio = new JPanel();
    private JPanel bou = new JPanel();
    private JPanel txt = new JPanel();

    // Pour les radio
    private ButtonGroup bgRadio = new ButtonGroup();
    private JRadioButton case1 = new JRadioButton("Niveau 1");
    private JRadioButton case2 = new JRadioButton("Niveau 2");
    private JRadioButton case3 = new JRadioButton("Niveau 3");
    // Pour le boutton
    private JButton valider = new JButton("Valider");

    //Pour la zone de texte
    JTextField textField = new JTextField();

    public GraphGaz(Fenetre fenetre, String texte){
        super(texte);
        this.fenetre = fenetre;
    }




    /**
     * Construction des panel et incorporation dans une fenetre
     */
    public void rea() {
        // Initialisation

        µ = 0;
        this.titre = new JPanel();
        this.bat = new JPanel();
        this.grpRadio = new JPanel();
        this.bou = new JPanel();
        this.txt = new JPanel();
        this.batim = new HashMap<>();
        this.choix = new JComboBox();
        this.case1 = new JRadioButton("Niveau 1");
        this.case2 = new JRadioButton("Niveau 2");
        this.case3 = new JRadioButton("Niveau 3");
        this.valider = new JButton("Valider");
        this.textField = new JTextField();

        fenetre.remove(titre);
        fenetre.setTitle("Administration");
        //fenetre.setLocationRelativeTo(null);

        bat.setMaximumSize(new Dimension(400, 200));
        bat.setLayout(new BoxLayout(bat, BoxLayout.Y_AXIS));

        // creation de la combo - Box
        if(µ==0) {
            choixBat();
            µ++;
        }

        choix.add(label);
        choix.addActionListener(new GraphGaz.ItemAction());

        bat.add(choix);


        // Création d'une check box
        grpRadio.setMaximumSize(new Dimension(100, 100));

        grpRadio.setLayout(new BoxLayout(grpRadio, BoxLayout.Y_AXIS));
        bgRadio.add(case1);
        bgRadio.add(case2);
        bgRadio.add(case3);

        case1.addActionListener(new GraphGaz.RadioListener());
        case2.addActionListener(new GraphGaz.RadioListener());
        case3.addActionListener(new GraphGaz.RadioListener());

        grpRadio.add(case1);
        grpRadio.add(case2);
        grpRadio.add(case3);

        // Crétion du boutton valider
        valider.addActionListener(new GraphGaz.ButtonListener());
        bou.setLayout(new BoxLayout(bou, BoxLayout.Y_AXIS));
        bou.add(valider);

        textField.setColumns(10);

        textField.setLayout(new FlowLayout());
        txt.add(textField);


        titre.setBorder(BorderFactory.createTitledBorder(" Pour créer une alarme pour le gaz veuillez remplir le formulaire suivant "));
        txt.setBorder(BorderFactory.createTitledBorder(" Nom du gaz "));
        grpRadio.setBorder(BorderFactory.createTitledBorder("importance  "));
        bat.setBorder(BorderFactory.createTitledBorder("localisation "));

        titre.add(bat);
        titre.add(grpRadio);
        titre.add(txt);
        titre.add(bou);

        fenetre.setContentPane(titre);
        fenetre.setVisible(true);

    }



    // creation de la combo - Box
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




    // Création d'une classe interne
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
            CréationAlarme.gazG.generateGazEvent(batim.get(fenetre.getBatAlarme()),fenetre.getNiveauAlarme(),textField.getText());
            // Mise a jour des fenetes
            for (FenetreType i : Fenetre.gta){i.reinitialisation();}
            for (FenetreType j : Fenetre.gtb){j.reinitialisation();}
            //Initialisation de la fenetre
            new GraphGaz(fenetre,"gaz").rea();
            }
    }



}

