package guitest;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
references were based from http://www.informit.com/articles/article.aspx?p=24130&seqNum=9
https://stackoverflow.com/questions/24848314/change-background-color-of-jtable-row-based-on-column-value
https://stackoverflow.com/questions/31585718/change-background-color-of-jtable-whole-row-based-on-column-value?rq=1
*/

//class to implement color in the 'Turned in ?' cell//
class RowColorRenderer extends DefaultTableCellRenderer{
    RowColorRenderer(){
        setOpaque(true);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
       
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
            String s = (String) table.getModel().getValueAt(row, 4);
            if("Yes".equals(s)){
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
            }else{
                setBackground(table.getBackground());
                setForeground(table.getForeground());
                setHorizontalAlignment(CENTER);
                setText(s);            
        }
        return this;
    }
}
     
