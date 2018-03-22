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
import guitest.RowColorRenderer;

public class GuiTest extends JPanel{
    private boolean DEBUG = false;
    JButton add,delete;
    JTextField inputField,inputField1,inputField2, inputField3 ;
    JLabel name,checkInDate,checkOutDate,email;
    public static final int ValidationCol = 4;
    public GuiTest(){
        super(new GridLayout(2,3,0,5));

//*creates a colname variable*//        
        String[] colNames ={"Name","Check in date",
                            "Check out date","Email",
                              "Turned In ?"};
       
//* Stores informtion from the input textfield*// 
        Object[][]data={{"Random Cadet Name","MM/DD/YY",
                        "MM/DD/YY","random.email@email.com",
                        " "}};
        
//*Creating the table to use the arguements of the colName and data object*//
       
         DefaultTableModel model = new DefaultTableModel(data, colNames);
         JTable table  = new JTable(model);
         table.setPreferredScrollableViewportSize(new Dimension(700,300));
         table.setFillsViewportHeight(true);
         table.getColumnModel().getColumn(4).setCellRenderer(new RowColorRenderer());
         JScrollPane scrollPane = new JScrollPane(table);
         
        JPanel inputBox = new JPanel();
        inputBox.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        TableColumn turnedInCol = table.getColumnModel().getColumn(4);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Yes");
        comboBox.addItem("No");
        turnedInCol.setCellEditor(new DefaultCellEditor(comboBox));
        
        JPanel title = new JPanel();
        JLabel name = new JLabel("Last name, First");
        title.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;             
        inputBox.add(name, gbc);
        
        JLabel checkOut = new JLabel("Check Out Date");
        title.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;                
        inputBox.add(checkOut, gbc);
        
        JLabel checkIn = new JLabel("Check In Date");
        title.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;              
        inputBox.add(checkIn, gbc);
        
        JLabel email = new JLabel("Enter your Email");
        title.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;                
        inputBox.add(email, gbc);
       
        JLabel logo = new JLabel("Form 48 Tracker");
        title.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        inputBox.add(logo,gbc);
        
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
        gbc.gridy =1;        
        inputBox.add(inputField, gbc);
        
        inputField1 = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =2;        
        inputBox.add(inputField1, gbc);
        
        inputField2 = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =3;        
        inputBox.add(inputField2, gbc);
        
        inputField3 = new JTextField(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(35,5,5,5);
        gbc.gridx =1;
        gbc.gridy =4;        
        inputBox.add(inputField3, gbc);
        
        add(inputBox);
        add(scrollPane);
    } 
    
    @Override
    public void paintComponent(Graphics g){
     g.setFont(new Font("TimesRoman", Font.BOLD,48));
     super.paintComponent(g);
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
