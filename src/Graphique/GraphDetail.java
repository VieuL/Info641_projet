import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphDetail extends JFrame implements ActionListener {

    private String texte;
    private JButton fini =new JButton("Event terminer");
    private EventAbstract event;
    private GraphBatiment Graph;
    private JButton b;

   public  GraphDetail(String texte,EventAbstract event, GraphBatiment Graph,JButton b){

       this.event = event;
       this.Graph=Graph;
       this.b=b;

       this.setTitle("Detail d'un événement");
       this.setSize(500,100);
       this.setLayout(new BorderLayout());
       JTextArea area = new JTextArea(texte);
       this.add(area,BorderLayout.CENTER);
        //ajout au listener
       fini.addActionListener(this);

       this.add(fini,BorderLayout.SOUTH);
       this.setLocationRelativeTo(null);
       this.setVisible(true);

   }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==fini){
            Graph.removeButton(this.b);
            this.event.getLocation().removeEvent(this.event);
            this.dispose();
        }
    }
}
