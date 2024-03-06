import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;

//Establishing JFrame
public class Menu extends JFrame {
    public Menu() {
        //Title of the frame
        setTitle("Menu");
        //Panel for contents in the frame
        JPanel panel = new JPanel();
        //Button declaration
        JButton a = new JButton("Books");
        //Go to Books frame
        a.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the NewPage
            Books page1 = new Books();

            //make page visible to the user
            page1.setVisible(true);
        });

        //Button declaration
        JButton b = new JButton("Search");
        //Go to Search frame
        b.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the NewPage
            Search page2 = new Search();

            //make page visible to the user
            page2.setVisible(true);
        });

        //Button declaration
        JButton c = new JButton("Create");
        //Go to Create frame
        c.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the NewPage
            Create page3 = new Create();

            //make page visible to the user
            page3.setVisible(true);
        });

        //Button declaration
        JButton d = new JButton("Delete");
        //Go to Delete frame
        d.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the NewPage
            Delete page4 = new Delete();

            //make page visible to the user
            page4.setVisible(true);
        });

        //Button declaration
        JButton f = new JButton("Edit");
        //Go to Edit frame
        f.addActionListener(e -> {
            //make the current page invisible
            dispose();

            //create instance of the NewPage
            Edit page5 = new Edit();

            //make page visible to the user
            page5.setVisible(true);
        });

        //Adding the panel to the frame
        add(panel);
        //Setting the layout of the panel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Adding the contents to the panel
        panel.add(a);
        panel.add(b);
        panel.add(c);
        panel.add(d);
        panel.add(f);
        //Setting frame size
        setSize(400, 180);
        //Setting frame location
        setLocationRelativeTo(null);
        //Setting visibility of the frame
        setVisible(true);
        //Setting closing case
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}