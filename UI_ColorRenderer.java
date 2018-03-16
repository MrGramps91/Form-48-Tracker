package guitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class GuiTest extends JPanel{
    private boolean DEBUG = false;
    JButton add,delete;
    JTextField inputField,inputField1,inputField2, inputField3 ;
    JLabel name,checkInDate,checkOutDate,email;
    public static final int ValidationCol = 4;
    public GuiTest(){
        super(new GridLayout(1,3,0,5));

//*creates a colname variable*//        
        String[] colNames ={"Name","Check in date",
                            "Check out date","Email",
                              "Turned In ?"};
       
//* Stores informtion from the input textfield*// 
        Object[][]data={{"Random Cadet Name","MM/DD/YY",
                        "MM/DD/YY","random.email@email.com",
                        "Click Box Below"}};
        
//*Creating the table to use the arguements of the colName and data object*//
       
         DefaultTableModel model = new DefaultTableModel(data, colNames);
         JTable table  = new JTable(model);
         table.setPreferredScrollableViewportSize(new Dimension(700,300));
         table.setFillsViewportHeight(true);
         JScrollPane scrollPane = new JScrollPane(table);
         
        JPanel inputBox = new JPanel();
        inputBox.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        TableColumn turnedInCol = table.getColumnModel().getColumn(4);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Yes");
        comboBox.addItem("No");
        turnedInCol.setCellEditor(new DefaultCellEditor(comboBox));
        
        
        
        add = new JButton("Add");
        gbc.fill = GridBagConstraints.RELATIVE;
        gbc.gridx =1;
        gbc.gridy =10;
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              if(e.getSource() == add){
            inputField.getText();
            inputField1.getText();
            inputField2.getText();
            inputField3.getText();
            Object[] row = {inputField.getText(),
            inputField1.getText(),
            inputField2.getText(),
            inputField3.getText()};
            model.addRow(row);
        }
            }
        });
        inputBox.add(add, gbc);
         
        /*delete = new JButton("Delete");
        gbc.fill = GridBagConstraints.BASELINE_TRAILING;
        gbc.gridx =2;
        gbc.gridy =0;
        inputBox.add(delete, gbc);*/
        
        name = new JLabel("Name");
        checkInDate = new JLabel("Check In Date");
        checkOutDate = new JLabel("Check Out Date");
        email = new JLabel("Email");
          
        inputField = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =0;
        
        inputBox.add(inputField, gbc);
        
        inputField1 = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =1;
        
        inputBox.add(inputField1, gbc);
        
        inputField2 = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =2;
        
        inputBox.add(inputField2, gbc);
        
        inputField3 = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =3;
        
        inputBox.add(inputField3, gbc);
          
        add(inputBox);
        add(scrollPane);
             
    }        
//class to implement color in the 'Turned in ?' cell//
public class MyTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String s = table.getModel().getValueAt(row, column).toString();
    if ("Yes".equals(s)){
        setBackground(Color.green);
    }else{
        setBackground(table.getBackground());
    }
     return this;
    }
}
       
    private static void createAndShowGui(){
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GuiTest contentPane = new GuiTest();
        contentPane.setOpaque(true);
        frame.setContentPane(contentPane);
        
        frame.pack();
        frame.setVisible(true);
    }
       
public static void main(String[] args) {    
          javax.swing.SwingUtilities.invokeLater(new Runnable(){
              public void run(){
                  createAndShowGui();
              }
          });
    }
}     
