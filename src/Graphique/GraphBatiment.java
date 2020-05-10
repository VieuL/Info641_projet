import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphBatiment extends AbstractAction implements ActionListener {
    private Fenetre fenetre;
    private Batiment batiment;

    public GraphBatiment(Fenetre fenetre, String texte, Batiment batiment) {
        super(texte);
        this.batiment = batiment;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.initialisation();
    }

    public void initialisation() {

        this.fenetre.setTitle(batiment.getNom());
        int taille = batiment.getEvents().size();
        Object data[][] = new Object[taille][5];
        for (int i = 0; i < taille; i++) {
            data[i][0] = String.valueOf(i + 1);
            data[i][1] = batiment.getEvents().get(i).getType();
            data[i][2] = String.valueOf(batiment.getEvents().get(i).getLevel());
            data[i][3] = String.valueOf(batiment.getEvents().get(i).getDate().getTime());
            data[i][4] = "Detail";
        }
        String[] title = {"Position", "Type", "Level", "Date", "Detail"};
        fenetre.setContentPane(new TableWithButton(data, title, batiment.getEvents()));
        fenetre.setVisible(true);
    }
}