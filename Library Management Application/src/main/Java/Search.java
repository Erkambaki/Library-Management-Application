import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

//Establishing JFrame
public class Search extends JFrame {
    public Search(){
        //Title of the frame
        setTitle("Search");
        //Panel for contents in the frame
        JPanel panel1 = new JPanel();
        //Panel for contents in the frame
        JPanel panel2 = new JPanel();
        //Setting the layout of the panel
        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);

        //Setting table to display the database
        JTable x = new JTable();
        //Adding scrollPane to the table
        JScrollPane sp = new JScrollPane(x);

        //Drop-down menu for sorting algorithm options
        String[] choices = { "Default", "Bubble Sort","Merge Sort", "Radix Sort" };

        //Adding actions to the drop-down menu
        final JComboBox<String> c = new JComboBox<>(choices);
        c.addActionListener(e -> {
            JComboBox<String> comboBox = (JComboBox<String>)e.getSource();
            Object o = comboBox.getSelectedItem();
            //Instantiating the file
            File file = new File("data.txt");
            //Instantiating the sorted file
            File fileSorted = new File("sorted.txt");

            try {
                //Unsorted database
                if(o != null && o.equals("Default")) {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    //Get the first line
                    //Get the column name from the first line
                    //Set column names to the JTable model
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) x.getModel();
                    model.setColumnIdentifiers(columnsName);
                    //Get the line from data.txt file
                    Object[] tableLines = br.lines().toArray();

                    //Extract data from lines
                    //Set data to JTable model
                    for (Object tableLine : tableLines) {
                        String line = tableLine.toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }
                //Bubble sorted database
                } else if (o != null && o.equals("Bubble Sort")) {
                    Integration bubble = new Integration();
                    bubble.bubbleAlgo();
                    BufferedReader br = new BufferedReader(new FileReader(fileSorted));
                    //Get the first line
                    //Get the column name from the first line
                    //Set column names to the JTable model
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) x.getModel();
                    model.setColumnIdentifiers(columnsName);
                    //Get the line from sorted.txt file
                    Object[] tableLines = br.lines().toArray();

                    //Extract data from lines
                    //Set data to JTable model
                    for (Object tableLine : tableLines) {
                        String line = tableLine.toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }
                //Merge sorted database
                } else if (o != null && o.equals("Merge Sort")) {
                    Integration merge = new Integration();
                    merge.mergeAlgo();
                    BufferedReader br = new BufferedReader(new FileReader(fileSorted));
                    //Get the first line
                    //Get the column name from the first line
                    //Set column names to the JTable model
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) x.getModel();
                    model.setColumnIdentifiers(columnsName);
                    //Get the line from sorted.txt file
                    Object[] tableLines = br.lines().toArray();

                    //Extract data from lines
                    //Set data to JTable model
                    for (Object tableLine : tableLines) {
                        String line = tableLine.toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }
                } else if (o != null && o.equals("Radix Sort")) {
                    RadixSortAlgorithm.Radix();
                    BufferedReader br = new BufferedReader(new FileReader(fileSorted));
                    //Get the first line
                    //Get the column name from the first line
                    //Set column names to the JTable model
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) x.getModel();
                    model.setColumnIdentifiers(columnsName);
                    //Get the line from sorted.txt file
                    Object[] tableLines = br.lines().toArray();

                    //Extract data from lines
                    //Set data to JTable model
                    for (Object tableLine : tableLines) {
                        String line = tableLine.toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }
                }
            } catch(Exception ex) {
                //Fail case
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE,null,ex);
            }
        });

        //Button declaration
        JButton a=new JButton("Display");
        //Displaying database in the table
        a.addActionListener(e -> {
            //Instantiating the file
            File file = new File("data.txt");
            //Displaying the unsorted database
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                //Get the first line
                //Get the column name from the first line
                //Set column names to the JTable model
                String firstLine = br.readLine().trim();
                String[] columnsName = firstLine.split(",");
                DefaultTableModel model = (DefaultTableModel)x.getModel();
                model.setColumnIdentifiers(columnsName);

                //Get the line from data.txt file
                Object[] tableLines = br.lines().toArray();

                //Extract data from lines
                //Set data to JTable model
                for (Object tableLine : tableLines) {
                    String line = tableLine.toString().trim();
                    String[] dataRow = line.split("/");
                    model.addRow(dataRow);
                }

            } catch(Exception ex) {
                //Fail case
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE,null,ex);
            }
        });


        //Button declaration
        JButton b=new JButton("Clear");
        //Clearing the table
        b.addActionListener(e -> x.setModel(new DefaultTableModel(null, new String[]{"Title", "Author(s)", "Publisher", "Subject", "Publishing Date"})));

        //Button declaration
        JButton d=new JButton("Return");
        //Return to Menu
        d.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the Menu
            Menu page0 = new Menu();

            //make page visible to the user
            page0.setVisible(true);
        });

        //Adding the panel to the frame
        add(panel1);
        //Adding the layout to the panel
        panel1.setLayout(layout1);
        //Adding the panel to the frame
        add(panel2);
        //Adding the contents to the panel
        panel1.add(c);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(a);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(b);
        panel1.add(Box.createRigidArea(new Dimension(0, 80)));
        panel1.add(d);
        panel2.add(sp);
        //Setting the layout of the frame
        setLayout(new FlowLayout());
        //Setting frame size
        setSize(800,500);
        //Setting frame location
        setLocationRelativeTo(null);
        //Setting closing case
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}