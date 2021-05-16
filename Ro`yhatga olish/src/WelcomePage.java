import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {
    JLabel welcomelb;
    JButton logoutbtn;

    public WelcomePage(String login) {
        String str = "Hello " + login;
        welcomelb = new JLabel();
        welcomelb.setText(str);
        welcomelb.setBounds(250 - str.length() * 3, 100, str.length() * 7, 30);
        add(welcomelb);

        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(200, 400, 100, 30);
        logoutbtn.setFocusable(false);
        logoutbtn.addActionListener(this);
        add(logoutbtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Registration");
        setIconImage(new ImageIcon("registration.png").getImage());
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutbtn) {
            new AsosiyOyna();
            dispose();
        }
    }
}
