import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

public class GraphFeu extends AbstractAction {
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

    public void actionPerformed(ActionEvent e) {
        fenetre.setTitle("Incendie");
        fenetre.setLocationRelativeTo(null);

        bat.setLayout(new BoxLayout(bat, BoxLayout.Y_AXIS));

        // creation de la combo - Box
        choixBat();
        choix.setMaximumSize(new Dimension(120, 50));
        choix.add(label);
        choix.addActionListener(new ItemAction());
        bat.add(choix);


        // Création d'une check box
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
        bou.add(valider);

        // ------------------------------------------------------------
        titre.setPreferredSize(new Dimension(300, 220));
        titre.setLayout(new BoxLayout(titre, BoxLayout.Y_AXIS));
        titre.setBorder(BorderFactory.createTitledBorder(" Pour créer une alarme pour le feu veuillez remplir le formulaire suivant "));


        titre.add(bat);
        titre.add(grpRadio);
        titre.add(bou);


        fenetre.setContentPane(titre);
        fenetre.setVisible(true);
    }


    private void choixBat() {
        choix.setPreferredSize(new Dimension(100, 20));
        for (Batiment a : Batiment.liste) {
            choix.addItem(a.getNom());
            batim.put(a.getNom(),a);
        }
    }


    // Création d'une classe interne
    class ItemAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fenetre.setbatAlarmee(choix.getSelectedItem().toString());
            System.out.println(fenetre.getBatAlarme());

        }
    }

    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fenetre.setNiveauAlarme(Integer.parseInt(Character.toString(e.getActionCommand().charAt(e.getActionCommand().length() - 1))));
            System.out.println("Radios changées - nouvelle valeur : " + fenetre.getNiveauAlarme());
        }


    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CréationAlarme alarme = new CréationAlarme();
            alarme.getIncendieG().generateIncendieEvent(batim.get(fenetre.getBatAlarme()),fenetre.getNiveauAlarme());
        }


    }
}
/*
        //Définition de sa couleur de fond
        fenetre.setTitle("Alarme de type Feu");
        pan.setLayout(new BorderLayout());
        pan.setBackground(new Color(255,255,224));
        fenetre.setLocationRelativeTo(null);
        //On prévient notre JFrame que notre JPanel sera son content pane
        pan.setLayout(new FlowLayout());
        JLabel coucou = new JLabel("Pour créer une alarme pour le feu veuillez remplir le formulaire suivant");
        pan2.setPreferredSize(new Dimension(100, 20));
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
        choixBat();
        choix.addActionListener(new ItemAction());
        pan.add(coucou);
        pan2.add(choix);
        this.fenetre.setContentPane(pan);
        this.fenetre.setContentPane(pan2);
        this.fenetre.setVisible(true);
 */