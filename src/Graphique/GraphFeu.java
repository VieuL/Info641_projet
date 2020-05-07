import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
/*
pane.setLayout(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();
*/

public class GraphFeu extends AbstractAction {
    private int µ = 0;
    private HashMap<String,Batiment> batim = new HashMap<>();

    private Fenetre fenetre;
    private JComboBox choix = new JComboBox();
    private JLabel label = new JLabel("Choix du batiement");

    private JPanel titre = new JPanel(new GridBagLayout());
    private JPanel bat = new JPanel(new GridBagLayout());

    private JPanel grpRadio = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    private JPanel bou = new JPanel(new GridBagLayout());

    private ButtonGroup bgRadio = new ButtonGroup();
    private JRadioButton case1 = new JRadioButton("Niveau 1");
    private JRadioButton case2 = new JRadioButton("Niveau 2");
    private JRadioButton case3 = new JRadioButton("Niveau 3");

    private JButton valider = new JButton("Valider");

    GridBagConstraints d = new GridBagConstraints();
    GridBagConstraints f = new GridBagConstraints();
    public GraphFeu(Fenetre fenetre, String texte) {

        super(texte);
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        fenetre.remove(titre);
        fenetre.setTitle("Incendie");
        fenetre.setLocationRelativeTo(null);
        c.fill = GridBagConstraints.HORIZONTAL;
        d.fill = GridBagConstraints.HORIZONTAL;
        f.fill = GridBagConstraints.HORIZONTAL;
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
        titre.setPreferredSize(new Dimension(1000, 1000));
//        titre.setLayout(new BoxLayout(titre, BoxLayout.Y_AXIS));
        titre.setBorder(BorderFactory.createTitledBorder(" Pour créer une alarme pour le feu veuillez remplir le formulaire suivant "));
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 0;       //reset to default
//        c.weighty = 1.0;   //request any extra vertical space
//        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
//        c.insets = new Insets(10,50,0,50);  //top padding
//        c.gridx = 0;       //aligned with button 2
//        c.gridwidth = 2;   //2 columns wide
//        c.gridy = 10;
//        d.gridy = 200;       //third row
//        d.gridx = 0;       //aligned with button 2
//        f.gridy = 20;
//        f.gridx = 0;       //aligned with button 2
//        c.gridwidth = 2;   //2 columns wide

        titre.add(bat,c);
        titre.add(grpRadio,d);
        titre.add(bou,f);

//        fenetre.add(bat);
//        fenetre.add(grpRadio,c);
//        fenetre.add(bou);

        fenetre.setContentPane(titre);
        fenetre.setVisible(true);
    }


    private void choixBat() {
        choix.setPreferredSize(new Dimension(100, 20));
        choix.addItem("choix du bâtiment");
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
