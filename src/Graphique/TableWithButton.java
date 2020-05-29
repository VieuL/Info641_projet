import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


/**
 * class gerant le tableau dynamique
 */
public class TableWithButton extends JPanel {

    private JTable table;
    ArrayList<EventAbstract> events;

    /**
     *
     * @param data
     * contient les lignes du tableau
     * @param title
     * Contient les noms des colones
     * @param events
     * liste des evenements à gerer
     */
    public TableWithButton(Object[][] data, String[] title, ArrayList<EventAbstract> events) {
        this.events = events;
        //Creation Jtable
        table = new JTable(new DefaultTableModel(data, title));

        //ajout bouton a la derniere colone
        table.getColumnModel().getColumn(title.length - 1).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(title.length - 1).setCellEditor(new ButtonEditor(new JTextField(), this.getEvents()));
        //ajout du scroll
        JScrollPane pane = new JScrollPane(table);
        this.add(pane);
    }

    public JTable getTable() {

        return table;
    }

    public ArrayList<EventAbstract> getEvents() {
        return events;
    }

    /**
     * classe pour le bouton de detail
     */
    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            //modification des propietes du bouton
            this.setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
                                                       boolean selected, boolean focused, int row, int col) {
            //ajout du texte sur le bouton
            this.setText((obj == null) ? "" : obj.toString());
            return this;
        }

    }

    /**
     * classe d'ecouteur du bouton et de l'action
     */
    private class ButtonEditor extends DefaultCellEditor {
        protected JButton btn;
        private String Text;
        private Boolean clicked;
        private ArrayList<EventAbstract> events;

        /**
         *
         * @param txt
         * contient le texte du  bouton
         * @param events
         * liste des evenements
         */

        public ButtonEditor(JTextField txt, ArrayList<EventAbstract> events) {
            super(txt);
            this.events =events;
            btn = new JButton();

            //quand le bouton est cliqué
            btn.addActionListener((ActionEvent e) -> fireEditingStopped());
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
                                                     boolean selected, int row, int col) {

            //ajout le texte sur le bouton
            Text = (obj == null) ? "" : obj.toString();
            btn.setText(Text);
            clicked = true;
            return btn;
        }
        @Override
        public Object getCellEditorValue() {
            if (clicked) {
                //numero de la ligne de la colonne choisit par l'utilisateur
                int select = table.getSelectedRow();
                //dialogue informative  (renvoie 1 ou 0 selon la réponse de l'utilisateur)
                if (JOptionPane.showConfirmDialog(null, this.events.get(select).toString() + "\nEvenement terminé ?", "Detail",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    //supprime evenement
                    Fenetre.updatingWithRemove(this.events.get(select));
                } //sinon on fait rien
            }
            clicked = false;
            return Text;
        }
    }

}