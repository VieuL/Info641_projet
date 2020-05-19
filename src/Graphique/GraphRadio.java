import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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

    public void rea() {
        fenetre.remove(titre);
        fenetre.setTitle("Radioactivité");
        fenetre.setLocationRelativeTo(null);

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

        JPanel groupSlide = new JPanel();
        groupSlide.add(labelSlide);
        groupSlide.add(slide);
        groupSlide.setMaximumSize(new Dimension(300, 20));


        // PROGRESSBAR
        pourcentage.setPreferredSize(new Dimension(30, 15));
        pourcentage.setHorizontalTextPosition(JLabel.RIGHT);

        progressBar.setPreferredSize(new Dimension(210, 20));
        JPanel groupProgressBar = new JPanel();
        groupProgressBar.add(progressBar);
        groupProgressBar.add(pourcentage);

//        sli.setPreferredSize(new Dimension(1000, 1000));
        sli.setLayout(new BoxLayout(sli, BoxLayout.Y_AXIS));
        sli.add(groupSlide);
        sli.add(groupProgressBar);

        // ------------------------------------------------------------
//        titre.setPreferredSize(new Dimension(1000, 1000));
//        titre.setLayout(new BoxLayout(titre, BoxLayout.Y_AXIS));
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
            alarme.getRadiationG().generateRadiationEvent(batim.get(fenetre.getBatAlarme()),fenetre.getNiveauAlarme(),fenetre.getRadioV());
            new GraphRadio(fenetre,"radio").rea();
            for (GraphTypeA j : Fenetre.gtb){j.reinitialisation();}
        }
    }

    class ProgressListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }
}
