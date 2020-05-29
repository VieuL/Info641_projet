import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * classe qui permet de visualiser les evenements lié à
 * un batiment dans la fenetre administration
 */
public class GraphBatiment extends AbstractAction implements ActionListener {
    private Fenetre fenetre;
    private Batiment batiment;
    public static ArrayList<GraphBatiment> ListeBatiments = new ArrayList<>();

    /**
     *
     * @param fenetre
     * @param texte
     * titre de la fenetre
     * @param batiment
     */
    public GraphBatiment(Fenetre fenetre, String texte, Batiment batiment) {
        super(texte);
        ListeBatiments.add(this);
        this.batiment = batiment;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.initialisation();
    }

    /**
     *methode permettant de creer le tableau sur la fenetre
     */
    public void initialisation() {
        int taille = batiment.getEvents().size();
        if (taille != 0) {
            this.fenetre.setTitle(batiment.getNom());
            Object[][] data = new Object[taille][5];
            for (int i = 0; i < taille; i++) {
                data[i][0] = String.valueOf(i + 1);
                data[i][1] = batiment.getEvents().get(i).getType();
                data[i][2] = String.valueOf(batiment.getEvents().get(i).getLevel());
                data[i][3] = String.valueOf(batiment.getEvents().get(i).getDate().getTime());
                data[i][4] = "Detail";
            }
            String[] title = {"Position", "Type", "Level", "Date", "Detail"};
            fenetre.setContentPane(new TableWithButton(data, title, batiment.getEvents()));
        } else {
            //affichage lorsque qu'il y a pas d'evenement
            JPanel pan = new JPanel();
            pan.add(new JLabel("Il n'y a pas d'alarme non traité"));
            fenetre.setContentPane(pan);
        }
        fenetre.setVisible(true);

    }
    //! ---- Définition des accesseurs (getter/setter) ----
    public Batiment getBatiment() {
        return batiment;
    }

}
