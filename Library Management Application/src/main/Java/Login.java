import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

//Establishing JFrame
public class Login extends JFrame {
    public Login() {
        //Title of the frame
        setTitle("Login");
        //Panel for contents in the frame
        JPanel panel = new JPanel();
        //Setting the layout of the panel
        SpringLayout layout = new SpringLayout();

        //Setting layout of the label
        JLabel l1=new JLabel("User Name: ");
        layout.putConstraint(SpringLayout.WEST, l1, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l1, 5, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField q= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, q, 5, SpringLayout.EAST, l1);
        layout.putConstraint(SpringLayout.NORTH, q, 5, SpringLayout.NORTH, l1);

        //Setting layout of the label
        JLabel l2=new JLabel("Password: ");
        layout.putConstraint(SpringLayout.WEST, l2, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, l2, 40, SpringLayout.NORTH, panel);
        //Setting layout of textField
        JTextField w= new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, w, 10, SpringLayout.EAST, l2);
        layout.putConstraint(SpringLayout.NORTH, w, 5, SpringLayout.NORTH, l2);

        //Button declaration
        JButton a=new JButton("Confirm");
        a.addActionListener(e -> {
            //Getting the input of credentials
            String UserName = q.getText();
            String Password = w.getText();

            //Determining if the user is authorized
            if (UserName.equals("admin") && Password.equals("1234")){
                dispose();
                Menu page0 = new Menu();
                page0.setVisible(true);
            }else{
                //Fail case
                JOptionPane.showMessageDialog(null,"Invalid Credentials!");
            }
        });
        //Setting layout of button
        layout.putConstraint(SpringLayout.WEST, a, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, a, 90, SpringLayout.NORTH, panel);

        //Adding the panel to the frame
        add(panel);
        //Adding the layout to the panel
        panel.setLayout(layout);
        //Adding the contents to the panel
        panel.add(l1);
        panel.add(q);
        panel.add(l2);
        panel.add(w);
        panel.add(a);
        //Setting frame size
        setSize(400,180);
        //Setting frame location
        setLocationRelativeTo(null);
        //Setting visibility of the frame
        setVisible(true);
        //Setting closing case
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}