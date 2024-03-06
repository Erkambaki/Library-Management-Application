import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
public class Books extends JFrame {
    public Books(){
        //Title of the frame
        setTitle("Books");
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

        //Button declaration
        JButton a=new JButton("Display");
        //Displaying database in the table
        a.addActionListener(e -> {
            //Instantiating the file
            File file = new File("data.txt");

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
                Logger.getLogger(Books.class.getName()).log(Level.SEVERE,null,ex);
            }
        });

        //Button declaration
        JButton b=new JButton("Clear");
        //Clearing the table
        b.addActionListener(e -> x.setModel(new DefaultTableModel(null, new String[]{ "Title", "Author(s)", "Publisher", "Subject", "Publishing Date" })));

        //Button declaration
        JButton c=new JButton("Return");
        //Return to Menu
        c.addActionListener(e -> {
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
        panel1.add(a);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(b);
        panel1.add(Box.createRigidArea(new Dimension(0, 80)));
        panel1.add(c);
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