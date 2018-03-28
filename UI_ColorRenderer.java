package GuiForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.*;
import java.util.logging.Level;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import GuiForm.RowColorRenderer;
import common.Logger;
import jxl.*;
import java.io.*;


public class Main extends JPanel{
    private boolean DEBUG = false;
    JButton add,loadBtn;
    JTextField inputField,inputField1,inputField2, inputField3 ;
    JLabel name,checkInDate,checkOutDate,email;
    public static final int ValidationCol = 4;
    public Main(){
        super(new GridLayout(2,3,0,5));

//*creates a colname variable*//        
       final String[] colNames ={"Name","Check in date",
                            "Check out date","Email",
                              "Turned In?"};
       
//* Stores informtion from the input textfield*// 
        Object[][]data={{}};
        
//*Creating the table to use the arguements of the colName and data object*//
       
         DefaultTableModel model = new DefaultTableModel(data, colNames);
         JTable table  = new JTable(model);
         table.setPreferredScrollableViewportSize(new Dimension(700,300));
         table.setFillsViewportHeight(true);
         table.getColumnModel().getColumn(4).setCellRenderer(new RowColorRenderer());
         model.setRowCount(0);
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
        gbc.gridy =5;
        add.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
            try {
            	String filePath = "C:\\Users\\Public\\testfile\\trackingInfotest.txt";
            	File file = new File(filePath);
            	if(!file.exists()) {
            		file.createNewFile();
            	}
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
            	
            		FileWriter fw = new FileWriter(file.getAbsolutePath());
            		BufferedWriter bw = new BufferedWriter(fw);
            		            		
            		for(int i = 0; i < table.getRowCount(); i++) {
            			for(int j = 0; j < table.getColumnCount(); j++) {
            				bw.write(table.getModel().getValueAt(i,j)+" ");
                 			}
            			bw.newLine();
            		}
            			bw.close();
            			fw.close();
            			JOptionPane.showMessageDialog(null,"Data Saved");
            			
            	} catch(Exception ex) {
            		ex.printStackTrace();
            	}
             
            }
        });
        inputBox.add(add, gbc);
         
        loadBtn = new JButton("Load File");
        gbc.fill = GridBagConstraints.BASELINE_TRAILING;
        gbc.gridx =2;
        gbc.gridy =5;
        loadBtn.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
            	
            	String filePath = "C:\\Users\\Public\\testfile\\trackingInfotest.txt";
            	File file = new File(filePath);
            	
            	try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String firstLine = br.readLine().trim();
					String[] colName = firstLine.split(",");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setColumnIdentifiers(colName);
					
					Object[]tableLines = br.lines().toArray();
					
					for(int i = 0; i < tableLines.length; i++) {
						
						String line = tableLines[i].toString().trim();
						String[] dataRow = line.split("/");
						model.addRow(dataRow);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            		
            	}
                        
        });
        inputBox.add(loadBtn, gbc);
        
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
        
        Main contentPane = new Main();
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
