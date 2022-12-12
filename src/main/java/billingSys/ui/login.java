package billingSys.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            // To-do: explanation of its functionality
            public void run() {
                try {
                    login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login() {
        // Setting Icon, Title, Dimension of Login Form

        setIconImage(Toolkit.getDefaultToolkit().getImage(""));
        setTitle("Energy Billing System GmbH");
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Username Title and Text field positions, dimensions
        JLabel labNewLabel = new JLabel("Username");
        labNewLabel.setIcon(new ImageIcon(""));
        labNewLabel.setBounds(40, 145, 72, 14);
        getContentPane().add(labNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBounds(135, 145, 165,18);
        getContentPane().add(textField);
        textField.setColumns(12);

        // Password Title and Text field positions, dimensions
        JLabel labPassword = new JLabel("Password");
        labPassword.setFont(new Font("Tahoma", Font.PLAIN,15));
        labPassword.setBounds(40, 185, 72, 14);
        getContentPane().add(labPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(136, 185, 164, 16);
        getContentPane().add(passwordField);

        JButton buttLogIn = new JButton("Login");

        buttLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            //    BillCalc bC = new BillCalc();
            //    bC.setVisible(true);
            }
        });
        buttLogIn.setBounds(172, 212, 88, 22);
        getContentPane().add(buttLogIn);
    }
}