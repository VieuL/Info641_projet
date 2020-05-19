import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GraphTypeA extends JFrame {

    private String texte;
    ArrayList<EventAbstract> events;

    public GraphTypeA( String texte, ArrayList<EventAbstract> events) {
        super(texte);

        this.events = events;
        this.texte=texte;
        this.initialisation();
        this.setSize(getToolkit().getScreenSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    public void initialisation() {
        int taille = events.size();
        if (taille != 0) {
            Object data[][] = new Object[taille][4];
            for (int i = 0; i < taille; i++) {
                data[i][0] = events.get(i).getType();
                data[i][1] = String.valueOf(events.get(i).getLevel());
                data[i][2] = String.valueOf(events.get(i).getDate().getTime());
                data[i][3] = "Detail";
            }
            String[] title = { "Type", "Level", "Date", "Detail"};
            this.setContentPane(new TableWithButton(data, title, events));


        } else {
            //affichage lorsque qu'il y a pas d'evenement
            JPanel pan = new JPanel();
            pan.add(new JLabel("Il n'y a pas d'alarme non traité"));
            this.setContentPane(pan);

        }
    }

    public void reinitialisation(){
//        System.out.println("coucou");
        this.initialisation();
        this.setVisible(true);
    }
}
