import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public TableWithButton(Object[][] data, String[] title, ArrayList<EventAbstract> events) {
        this.events = events;
        //Creation Jtable
        table = new JTable(new DefaultTableModel(data, title));

        //ajout bouton a la derniere colone
        table.getColumnModel().getColumn(title.length - 1).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(title.length - 1).setCellEditor(new ButtonEditor(new JTextField(), this));
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

    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            //SET BUTTON PROPERTIES
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
                                                       boolean selected, boolean focused, int row, int col) {
            //SET PASSED OBJECT AS BUTTON TEXT
            setText((obj == null) ? "" : obj.toString());
            return this;
        }

    }

    private class ButtonEditor extends DefaultCellEditor {
        protected JButton btn;
        private String Text;
        private Boolean clicked;
        private TableWithButton panel;

        public ButtonEditor(JTextField txt, TableWithButton panel) {
            super(txt);
            this.panel = panel;
            btn = new JButton();


            //WHEN BUTTON IS CLICKED
            btn.addActionListener((ActionEvent e) -> fireEditingStopped());
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
                                                     boolean selected, int row, int col) {

            //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
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
                //dialogue informative  (renvoie 1 ou 0)
                if (JOptionPane.showConfirmDialog(null, this.panel.getEvents().get(select).toString() + "\nEvenement terminé ?", "Detail",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    //supprime evenement
                    this.panel.getEvents().remove(select);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    System.out.println(select);
                    System.out.println(table.getRowCount());
                    model.removeRow(select);//supprimer ligne de la table
                } //sinon on fait rien
            }
            clicked = false;

            return Text;
        }
    }

}