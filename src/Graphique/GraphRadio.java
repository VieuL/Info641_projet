import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * classe de l'onglet du formulaire pour les alertes
 * lié au radiation
 */
public class GraphRadio extends AbstractAction {
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
    private JPanel sli = new JPanel();
    private JPanel groupSlide = new JPanel();
    private JPanel groupProgressBar = new JPanel();
    // Pour les radio
    private ButtonGroup bgRadio = new ButtonGroup();
    private JRadioButton case1 = new JRadioButton("Niveau 1");
    private JRadioButton case2 = new JRadioButton("Niveau 2");
    private JRadioButton case3 = new JRadioButton("Niveau 3");

    // Pour le boutton
    private JButton valider = new JButton("Valider");


    // Slider

    private JLabel labelSlide = new JLabel("Niveau : ");
    private JSlider slide = new JSlider(0, 100);
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private JLabel pourcentage = new JLabel("0");

    public GraphRadio(Fenetre fenetre, String texte){
        super(texte);
        this.fenetre = fenetre;
    }




    /**
     * Construction des panel et incorporation dans une fenetre
     */
    public void rea() {
        µ = 0;
        this.titre = new JPanel();
        this.bat = new JPanel();
        this.grpRadio = new JPanel();
        this.bou = new JPanel();
        this.batim = new HashMap<>();
        this.choix = new JComboBox();
        this.case1 = new JRadioButton("Niveau 1");
        this.case2 = new JRadioButton("Niveau 2");
        this.case3 = new JRadioButton("Niveau 3");

        this.valider = new JButton("Valider");
        fenetre.remove(titre);
        fenetre.setTitle("Administration");



        bat.setLayout(new BoxLayout(bat, BoxLayout.Y_AXIS));

        // creation de la combo - Box
        if(µ==0) {
            choixBat();
            µ++;
        }
        choix.setMaximumSize(new Dimension(120, 50));
        choix.add(label);
        choix.addActionListener(new GraphRadio.ItemAction());
        bat.add(choix);


        // Création d'une check box
        grpRadio.setMaximumSize(new Dimension(100, 100));
        grpRadio.setLayout(new BoxLayout(grpRadio, BoxLayout.Y_AXIS));
        bgRadio.add(case1);
        bgRadio.add(case2);
        bgRadio.add(case3);

        case1.addActionListener(new GraphRadio.RadioListener());
        case2.addActionListener(new GraphRadio.RadioListener());
        case3.addActionListener(new GraphRadio.RadioListener());

        grpRadio.add(case1);
        grpRadio.add(case2);
        grpRadio.add(case3);

        // Crétion du boutton valider
        valider.addActionListener(new GraphRadio.ButtonListener());
        bou.setLayout(new BoxLayout(bou, BoxLayout.Y_AXIS));
        bou.add(valider);

        // SLIDER
        slide.setValue(0);
        slide.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = ((JSlider)e.getSource()).getValue();
                fenetre.setRadioV(value);
                progressBar.setValue(value);
                pourcentage.setText(value + "");
            }
        });

        groupSlide.add(labelSlide);
        groupSlide.add(slide);
        groupSlide.setMaximumSize(new Dimension(300, 20));


        // PROGRESSBAR
        pourcentage.setPreferredSize(new Dimension(30, 15));
        pourcentage.setHorizontalTextPosition(JLabel.RIGHT);

        progressBar.setPreferredSize(new Dimension(210, 20));

        groupProgressBar.add(progressBar);
        groupProgressBar.add(pourcentage);

//        sli.setPreferredSize(new Dimension(1000, 1000));
        sli.setLayout(new BoxLayout(sli, BoxLayout.Y_AXIS));
        sli.add(groupSlide);
        sli.add(groupProgressBar);

        titre.setBorder(BorderFactory.createTitledBorder(" Pour créer une alarme pour le radioactivité veuillez remplir le formulaire suivant "));
        sli.setBorder(BorderFactory.createTitledBorder(" niveau de radiation "));
        grpRadio.setBorder(BorderFactory.createTitledBorder(" Importance  "));
        bat.setBorder(BorderFactory.createTitledBorder(" localisation "));

        titre.add(bat);
        titre.add(grpRadio);
        titre.add(sli);
        titre.add(bou);

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
            CréationAlarme.radiationG.generateRadiationEvent(batim.get(fenetre.getBatAlarme()),fenetre.getNiveauAlarme(),fenetre.getRadioV());
            // Mise a jour des fenetes
            for (FenetreType j : Fenetre.gtb){j.reinitialisation();}
            //Initialisation de la fenetre
            new GraphRadio(fenetre,"radio").rea();

        }
    }




    class ProgressListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }
}
