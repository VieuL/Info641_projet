import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class GraphRadio extends AbstractAction {
    private Fenetre fenetre;
    public GraphRadio(Fenetre fenetre, String texte){
        super(texte);

        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
//     JOptionPane.showMessageDialog(fenetre, "Ce programme a été développé par <Nom du développeur>");
        JPanel pan = new JPanel();
        //Définition de sa couleur de fond
        pan.setBackground(Color.GREEN);
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.fenetre.setContentPane(pan);
        this.fenetre.setVisible(true);


    }
}
