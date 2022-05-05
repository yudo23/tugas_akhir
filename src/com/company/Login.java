package com.company;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login implements ActionListener {
    public JFrame jframe;
    public Container content;
    public JLabel lb_username;
    public JLabel lb_password;
    public JTextField tf_username;
    public JTextField tf_password;
    public JPanel panel_login;
    public JButton btnLogin;
    public String valid_username = "kasir";
    public String valid_password = "kasir";
    public Boolean wrong_login = false;

    public Login() {
        frame_open();
        showing_form();
        frame_close();
    }

    public void frame_open() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame();
        jframe.setTitle("TOKO MYW");
        jframe.setBounds(0, 0, screenSize.width, screenSize.height);
        jframe.setDefaultCloseOperation(3);
        jframe.setResizable(false);
        content = jframe.getContentPane();
        content.setLayout((LayoutManager)null);
    }

    public void frame_close() {
        JLabel footer = new JLabel();
        footer.setText("DEVELOPED BY MUJAHIDDIN A.A (210533616011),YUDO DENDY(210533616046) ,WINDI WAHYU(210533616037) - S1 PENDIDIKAN TEKNIK INFORMATIKA B");
        footer.setBounds(15, 810, 1000, 100);
        footer.setFont(new Font("Arial", 1, 12));
        content.add(footer);
        jframe.setVisible(true);
    }

    public void showing_form() {
        panel_login = new JPanel();
        panel_login.setLayout((LayoutManager)null);
        JLabel title = new JLabel();
        title.setText("LOGIN AREA");
        title.setFont(new Font("Arial", 1, 30));
        title.setBounds(550, 25, 500, 50);
        content.add(title);
        showing_username();
        showing_password();
        showing_button();
        panel_login.setBackground(Color.lightGray);
        panel_login.setBounds(350, 120, 600, 300);
        content.add(panel_login);
    }

    public void showing_username() {
        lb_username = new JLabel();
        lb_username.setText("Username");
        lb_username.setBounds(40, 80, 100, 50);
        tf_username = new JTextField();
        tf_username.setBounds(200, 90, 300, 30);
        panel_login.add(lb_username);
        panel_login.add(tf_username);
    }

    public void showing_password() {
        lb_password = new JLabel();
        lb_password.setText("Password");
        lb_password.setBounds(40, 120, 100, 50);
        tf_password = new JTextField();
        tf_password.setBounds(200, 130, 300, 30);
        panel_login.add(lb_password);
        panel_login.add(tf_password);
    }

    public void showing_button() {
        btnLogin = new JButton();
        btnLogin.setText("Submit");
        btnLogin.setBounds(250, 200, 100, 30);
        btnLogin.addActionListener(this::actionPerformed);
        panel_login.add(btnLogin);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            validate();
        }

    }

    public void validate() {
        if (!tf_username.getText().equals(valid_username)) {
            wrong_login = true;
        }

        if (!tf_password.getText().equals(valid_password)) {
            wrong_login = true;
        }

        if (tf_username.getText().equals(valid_username) && tf_password.getText().equals(valid_password)) {
            wrong_login = false;
        }

        if (wrong_login) {
            JOptionPane.showMessageDialog((Component)null, "Login gagal...Username atau password salah", "Error", 1);
        } else {
            jframe.setVisible(false);
            Main main = new Main();
            main.is_logined = true;
            main.transaksi_page();
        }

    }
}
