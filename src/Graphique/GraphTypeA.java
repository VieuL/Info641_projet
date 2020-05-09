import javax.swing.*;
import java.awt.event.ActionEvent;

public class GraphTypeA extends AbstractAction {
    private Fenetre fenetre;


    public GraphTypeA(Fenetre fenetre, String texte) {
        super(texte);
        this.fenetre = fenetre;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.actualisation();
    }
    public void actualisation(){
        this.fenetre.setTitle("Type A");
        int taille= AtypeListener.events.size();
        Object data[][] = new Object[taille][5];
        for(int i =0 ; i<taille; i++){
            data[i][0] = String.valueOf(i+1);
            data[i][1] = AtypeListener.events.get(i).getType();
            data[i][2] = String.valueOf(AtypeListener.events.get(i).getLevel());
            data[i][3] = String.valueOf(AtypeListener.events.get(i).getDate().getTime());
            data[i][4] = "Detail";
        }
        String[] title ={"Position","Type","Level","Date","Detail"};
        fenetre.setContentPane(new TableWithButton(data,title));
        fenetre.setVisible(true);


    }

}
