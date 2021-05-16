import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsosiyOyna extends JFrame implements ActionListener {
    JLabel username, parol, piclb;
    JButton regbtn, logbtn, resetbtn;
    JTextField logintf;
    JPasswordField parolpf;
    ImageIcon picture;

    public AsosiyOyna() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 440);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Registration");
        setIconImage(new ImageIcon("registration.png").getImage());
        setResizable(false);

        picture = new ImageIcon("registration.png");
        piclb = new JLabel(picture);
        piclb.setBounds(0, 0, picture.getIconWidth(), picture.getIconHeight());

        username = new JLabel("username:");
        username.setBounds(600, 100, 80, 30);

        logintf = new HintedTextField("username");
        logintf.setBounds(680, 100, 210, 30);
        logintf.addActionListener(this);

        parol = new JLabel("password:");
        parol.setBounds(600, 150, 80, 30);

        parolpf = new HintedPasswordField("password");
        parolpf.setBounds(680, 150, 210, 30);

        logbtn = new JButton("Login");
        logbtn.setBounds(650, 200, 100, 30);
        logbtn.setFocusable(false);
        logbtn.addActionListener(this);

        regbtn = new JButton("Registration");
        regbtn.setBounds(750, 200, 110, 30);
        regbtn.setFocusable(false);
        regbtn.addActionListener(this);

        resetbtn = new JButton("Reset");
        resetbtn.setBounds(705, 250, 100, 30);
        resetbtn.setFocusable(false);
        resetbtn.addActionListener(this);

        add(piclb);
        add(username);
        add(logintf);
        add(parol);
        add(parolpf);
        add(logbtn);
        add(regbtn);
        add(resetbtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Royhat royhat = new Royhat();
        if (e.getSource() == logbtn) {
            if (royhat.logininfo.containsKey(logintf.getText())) {
                if (royhat.logininfo.get(logintf.getText()).equals(String.valueOf(parolpf.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login successful", "Login", JOptionPane.INFORMATION_MESSAGE);
                    new WelcomePage(logintf.getText());
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed", "Login", JOptionPane.ERROR_MESSAGE);
                    reset();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login failed", "Login", JOptionPane.ERROR_MESSAGE);
                reset();
            }
        }
        if (e.getSource() == regbtn) {
            String str = String.valueOf(parolpf.getPassword());
            if (logintf.getText().length() != 0 && str.length() != 0) {
                if (!royhat.logininfo.containsKey(logintf.getText())) {
                    JOptionPane.showMessageDialog(null, "Registration successful", "Registration", JOptionPane.INFORMATION_MESSAGE);
                    royhat.put(logintf.getText(), String.valueOf(parolpf.getPassword()));
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Username has already used", "Registration", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login or password is empty!", "Registration", JOptionPane.ERROR_MESSAGE);
                reset();
            }
        }
        if (e.getSource() == resetbtn) {
            reset();
        }
    }

    private void reset() {
        logintf.setText("");
        parolpf.setText("");
    }

    private static class HintedTextField extends JTextField {
        private final JTextField hintField;

        public HintedTextField(String hint) {
            hintField = new JTextField(hint);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty()) {
                hintField.setBounds(getBounds());
                hintField.setForeground(getDisabledTextColor());
                hintField.setOpaque(false);
                hintField.paint(g);
            }
        }
    }

    private static class HintedPasswordField extends JPasswordField {
        private final JTextField hintField;

        public HintedPasswordField(String hint) {
            hintField = new JTextField(hint);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getPassword().length == 0) {
                hintField.setBounds(getBounds());
                hintField.setForeground(getDisabledTextColor());
                hintField.setOpaque(false);
                hintField.paint(g);
            }
        }
    }
}