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
        
        if(value instanceof String){
            String s = (String) value;
            if(s.equals("Yes")){
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
            }else
                setBackground(Color.WHITE);
            setHorizontalAlignment(CENTER);
            setText(s);
        }
        return this;
    }
}
