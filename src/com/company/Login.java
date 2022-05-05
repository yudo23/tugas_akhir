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
        this.frame_open();
        this.showing_form();
        this.frame_close();
    }

    public void frame_open() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.jframe = new JFrame();
        this.jframe.setTitle("TOKO MYW");
        this.jframe.setBounds(0, 0, screenSize.width, screenSize.height);
        this.jframe.setDefaultCloseOperation(3);
        this.jframe.setResizable(false);
        this.content = this.jframe.getContentPane();
        this.content.setLayout((LayoutManager)null);
    }

    public void frame_close() {
        JLabel footer = new JLabel();
        footer.setText("DEVELOPED BY MUJAHIDDIN A.A (210533616011),YUDO DENDY(210533616046) ,WINDI WAHYU(210533616037) - S1 PENDIDIKAN TEKNIK INFORMATIKA B");
        footer.setBounds(15, 810, 1000, 100);
        footer.setFont(new Font("Arial", 1, 12));
        this.content.add(footer);
        this.jframe.setVisible(true);
    }

    public void showing_form() {
        this.panel_login = new JPanel();
        this.panel_login.setLayout((LayoutManager)null);
        JLabel title = new JLabel();
        title.setText("LOGIN AREA");
        title.setFont(new Font("Arial", 1, 30));
        title.setBounds(550, 25, 500, 50);
        this.content.add(title);
        this.showing_username();
        this.showing_password();
        this.showing_button();
        this.panel_login.setBackground(Color.lightGray);
        this.panel_login.setBounds(350, 120, 600, 300);
        this.content.add(this.panel_login);
    }

    public void showing_username() {
        this.lb_username = new JLabel();
        this.lb_username.setText("Username");
        this.lb_username.setBounds(40, 80, 100, 50);
        this.tf_username = new JTextField();
        this.tf_username.setBounds(200, 90, 300, 30);
        this.panel_login.add(this.lb_username);
        this.panel_login.add(this.tf_username);
    }

    public void showing_password() {
        this.lb_password = new JLabel();
        this.lb_password.setText("Password");
        this.lb_password.setBounds(40, 120, 100, 50);
        this.tf_password = new JTextField();
        this.tf_password.setBounds(200, 130, 300, 30);
        this.panel_login.add(this.lb_password);
        this.panel_login.add(this.tf_password);
    }

    public void showing_button() {
        this.btnLogin = new JButton();
        this.btnLogin.setText("Submit");
        this.btnLogin.setBounds(250, 200, 100, 30);
        this.btnLogin.addActionListener(this::actionPerformed);
        this.panel_login.add(this.btnLogin);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnLogin) {
            this.validate();
        }

    }

    public void validate() {
        if (!this.tf_username.getText().equals(this.valid_username)) {
            this.wrong_login = true;
        }

        if (!this.tf_password.getText().equals(this.valid_password)) {
            this.wrong_login = true;
        }

        if (this.tf_username.getText().equals(this.valid_username) && this.tf_password.getText().equals(this.valid_password)) {
            this.wrong_login = false;
        }

        if (this.wrong_login) {
            JOptionPane.showMessageDialog((Component)null, "Login gagal...Username atau password salah", "Error", 1);
        } else {
            this.jframe.setVisible(false);
            Main main = new Main();
            main.is_logined = true;
            main.transaksi_page();
        }

    }
}
