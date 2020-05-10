import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GraphTypeA extends AbstractAction {
    private Fenetre fenetre;
    private String texte;
    ArrayList<EventAbstract> events;

    public GraphTypeA(Fenetre fenetre, String texte, ArrayList<EventAbstract> events) {
        super(texte);
        this.fenetre = fenetre;
        this.events = events;
        this.texte=texte;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.initialisation();
    }

    public void initialisation() {
        this.fenetre.setTitle(texte);
        int taille = events.size();
        if (taille != 0) {
            Object data[][] = new Object[taille][5];
            for (int i = 0; i < taille; i++) {
                data[i][0] = String.valueOf(i + 1);
                data[i][1] = events.get(i).getType();
                data[i][2] = String.valueOf(events.get(i).getLevel());
                data[i][3] = String.valueOf(events.get(i).getDate().getTime());
                data[i][4] = "Detail";
            }
            String[] title = {"Position", "Type", "Level", "Date", "Detail"};
            fenetre.setContentPane(new TableWithButton(data, title, events));


        } else {
            //affichage lorsque qu'il y a pas d'evenement
            JPanel pan = new JPanel();
            pan.add(new JLabel("Il n'y a pas d'alarme non traité"));
            fenetre.setContentPane(pan);

        }
        fenetre.setVisible(true);
    }
}
