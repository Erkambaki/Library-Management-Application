import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Establishing JFrame
public class Edit extends JFrame {
    public Edit(){
        //Title of the frame
        setTitle("Edit");
        //Panel for contents in the frame
        JPanel panel = new JPanel();
        //Setting the layout of the panel
        SpringLayout layout = new SpringLayout();

        //Setting layout of the label
        JLabel l1=new JLabel("Title: ");
        layout.putConstraint(SpringLayout.WEST, l1, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l1, 5, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField q= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, q, 34, SpringLayout.EAST, l1);
        layout.putConstraint(SpringLayout.NORTH, q, 5, SpringLayout.NORTH, l1);

        //Setting layout of the label
        JLabel l2=new JLabel("Author(s): ");
        layout.putConstraint(SpringLayout.WEST, l2, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l2, 35, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField w= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, w, 5, SpringLayout.EAST, l2);
        layout.putConstraint(SpringLayout.NORTH, w, 5, SpringLayout.NORTH, l2);

        //Setting layout of the label
        JLabel l3=new JLabel("Publisher: ");
        layout.putConstraint(SpringLayout.WEST, l3, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l3, 65, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField x= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, x, 5, SpringLayout.EAST, l3);
        layout.putConstraint(SpringLayout.NORTH, x, 5, SpringLayout.NORTH, l3);

        //Setting layout of the label
        JLabel l4=new JLabel("Subject: ");
        layout.putConstraint(SpringLayout.WEST, l4, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l4, 95, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField y= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, y, 53, SpringLayout.EAST, l4);
        layout.putConstraint(SpringLayout.NORTH, y, 5, SpringLayout.NORTH, l4);

        //Setting layout of the label
        JLabel l5=new JLabel("Publication date: ");
        layout.putConstraint(SpringLayout.WEST, l5, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l5, 125, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField z= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, z, 5, SpringLayout.EAST, l5);
        layout.putConstraint(SpringLayout.NORTH, z, 5, SpringLayout.NORTH, l5);

        //Button declaration
        JButton a=new JButton("Confirm");
        a.addActionListener(e -> {
            //Instantiating the file
            String filePath = "data.txt";
            try {
                //Instantiating the Scanner class to read the file
                Scanner sc = new Scanner(new File(filePath));
                //instantiating the StringBuffer class
                StringBuilder buffer = new StringBuilder();
                //Reading lines of the file and appending them to StringBuffer
                    while (sc.hasNextLine()) {
                        buffer.append(sc.nextLine()).append(System.lineSeparator());
                    }
                String fileContents = buffer.toString();
                //closing the Scanner object
                sc.close();
                String oldLine = q.getText();
                String newLine = q.getText() + " / " + w.getText() + " / " + x.getText() + " / " + y.getText() + " / " + z.getText();
                //Replacing the old line with new line
                fileContents = fileContents.replaceAll(oldLine, newLine);
                //instantiating the FileWriter class
                FileWriter writer = new FileWriter(filePath);
                writer.append(fileContents);
                writer.flush();
                //Clear the user input in the fields
                q.setText("");
                w.setText("");
                x.setText("");
                y.setText("");
                z.setText("");

            } catch (Exception ex) {
                //Fail case
                Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Confirmation message
            JOptionPane.showMessageDialog(null, "Changes Saved!");
        });
        layout.putConstraint(SpringLayout.WEST, a, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, a, 165, SpringLayout.NORTH, panel);

        //Button declaration
        JButton b=new JButton("Return");
        //Return to Menu
        b.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the Menu
            Menu page0 = new Menu();

            //make page visible to the user
            page0.setVisible(true);
        });
        //Setting layout of button
        layout.putConstraint(SpringLayout.WEST, b, 30, SpringLayout.EAST, a);
        layout.putConstraint(SpringLayout.NORTH, b, 0, SpringLayout.NORTH, a);

        //Adding the panel to the frame
        add(panel);
        //Adding the layout to the panel
        panel.setLayout(layout);
        //Adding the contents to the panel
        panel.add(l1);
        panel.add(q);
        panel.add(l2);
        panel.add(w);
        panel.add(l3);
        panel.add(x);
        panel.add(l4);
        panel.add(y);
        panel.add(l5);
        panel.add(z);
        panel.add(a);
        panel.add(b);
        //Setting frame size
        setSize(400,250);
        //Setting frame location
        setLocationRelativeTo(null);
        //Setting closing case
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}