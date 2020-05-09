import java.awt.Component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;


public class TableWithButton extends JPanel {
    private JTable table;
    public TableWithButton(Object[][] data,String[]title){

        //Creation Jtable
        table=new JTable(data,title);
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField(),this ));

        //ajout du scroll
        JScrollPane pane=new JScrollPane(table);
        this.add(pane);
    }
    public JTable getTable() {
        return table;
    }
    public void refresh(){
        this.revalidate();
    }
}


class ButtonRenderer extends JButton implements  TableCellRenderer {

    public ButtonRenderer() {
        //SET BUTTON PROPERTIES
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj,
                                                   boolean selected, boolean focused, int row, int col) {
        //SET PASSED OBJECT AS BUTTON TEXT
        setText((obj==null) ? "":obj.toString());
        return this;
    }

}


class ButtonEditor extends DefaultCellEditor{
    protected JButton btn;
    private String lbl;
    private Boolean clicked;
    private  TableWithButton pan;

    public ButtonEditor(JTextField txt,TableWithButton pan) {
        super(txt);
        this.pan=pan;
        btn=new JButton();


        //WHEN BUTTON IS CLICKED
        btn.addActionListener(e -> fireEditingStopped());
    }



    //OVERRIDE A COUPLE OF METHODS
    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
                                                 boolean selected, int row, int col) {

        //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
        lbl=(obj==null) ? "":obj.toString();
        btn.setText(lbl);
        clicked=true;
        return btn;
    }

    //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if(clicked)
        {

            //info bulle (renvoie 1 ou 0)
            if (JOptionPane.showConfirmDialog(null, AtypeListener.events.get(this.pan.getTable().getSelectedRow()).toString()+"\nEvenement terminé ?", "Detail",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //supprimer evenement
                AtypeListener.events.remove(this.pan.getTable().getSelectedRow());
                this.pan.getTable().remove(this.pan.getTable().getSelectedRow());


            } else {
                // On fait rien
            }
        }
        clicked=false;
        return new String(lbl);
    }


}