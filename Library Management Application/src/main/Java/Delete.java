import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//Establishing JFrame
public class Delete extends JFrame {
    public Delete(){
        //Title of the frame
        setTitle("Delete");
        //Panel for contents in the frame
        JPanel panel = new JPanel();
        //Setting the layout of the panel
        SpringLayout layout = new SpringLayout();

        //Setting layout of the label
        JLabel l1=new JLabel("Enter a book name to delete: ");
        layout.putConstraint(SpringLayout.WEST, l1, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l1, 5, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField q= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, q, 15, SpringLayout.EAST, l1);
        layout.putConstraint(SpringLayout.NORTH, q, 5, SpringLayout.NORTH, l1);

        //Setting layout of the label
        JLabel l2=new JLabel("<html><b><i>This will delete all information related to the book!!!</i></b>");
        layout.putConstraint(SpringLayout.WEST, l2, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l2, 35, SpringLayout.NORTH, panel);

        //Button declaration
        JButton a=new JButton("Delete");
        a.addActionListener(e -> {
            //Instantiating the file
            File file = new File("data.txt");

            try {
                //Getting the lines from the file
                List<String> out = Files.lines(file.toPath())
                        //Filtering the lines for the book name
                        .filter(line -> !line.contains(q.getText()))
                        .collect(Collectors.toList());
                Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                //Clear the user input in the fields
                q.setText("");

            } catch (Exception ex) {
                //Fail case
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Confirmation message
            JOptionPane.showMessageDialog(null, "Book Deleted!");
        });
        //Setting layout of button
        layout.putConstraint(SpringLayout.WEST, a, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, a, 100, SpringLayout.NORTH, panel);

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
        panel.add(a);
        panel.add(b);
        //Setting frame size
        setSize(400,180);
        //Setting frame location
        setLocationRelativeTo(null);
        //Setting closing case
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}