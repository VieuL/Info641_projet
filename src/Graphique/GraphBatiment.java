import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphBatiment extends AbstractAction implements ActionListener {

    private Fenetre fenetre;
    private ArrayList<JButton>jButtons;
    private Batiment batiment;

    public GraphBatiment(Fenetre fenetre, String texte,Batiment batiment){
        super(texte);
        this.batiment=batiment;

        jButtons=new ArrayList<>();
        this.fenetre = fenetre;
        ;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.actualisation();
        for(int i=0; i<jButtons.size();i++){
            if (e.getSource().equals(jButtons.get(i))){
                new GraphDetail(batiment.getEvents().get(i).toString(), batiment.getEvents().get(i),this,jButtons.get(i));
            }
        }
    }
    public void actualisation() {

        JPanel pan = new JPanel();
        pan.setLayout(new GridBagLayout());
        for (int i = 0; i < batiment.getEvents().size(); i++) {
            jButtons.add(new JButton("Détail evenement " +batiment.getEvents().get(i).affichageBatiment()));
            pan.add(jButtons.get(i));
            jButtons.get(i).addActionListener(this);
        }

        this.fenetre.setContentPane(pan);
        this.fenetre.setVisible(true);

    }

    public void removeButton(JButton b){
        jButtons.remove(b);
        jButtons = new ArrayList<JButton>();
        this.actualisation();

    }
    public void addButton(EventAbstract event){

         jButtons.add(new JButton("Détail evenement " +event.toString()));
         jButtons.get(jButtons.size()-1).addActionListener(this);
         this.actualisation();

    }

    public void dj(){
        for(JButton µ : this.jButtons){
            System.out.println(µ.getActionCommand());
        }
    }

    public void setjButtons(ArrayList<JButton> jButtons) {
        this.jButtons = jButtons;
    }
}
