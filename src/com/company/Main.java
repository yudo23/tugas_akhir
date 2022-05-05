package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Main extends Setting implements ActionListener{
    public JFrame jframe;
    public Container content;
    public JLabel title;
    public JPanel panel_sembako;
    public JPanel panel_pulsa;
    public JCheckBox cb_minyakgoreng;
    public JCheckBox cb_gula;
    public JCheckBox cb_beras;
    public JCheckBox cb_telur;
    public JCheckBox cb_susu;
    public JTextField tf_harga_minyakgoreng;
    public JTextField tf_harga_gula;
    public JTextField tf_harga_beras;
    public JTextField tf_harga_telur;
    public JTextField tf_harga_susu;
    public JTextField tf_pcs_minyakgoreng;
    public JTextField tf_pcs_gula;
    public JTextField tf_pcs_beras;
    public JTextField tf_pcs_telur;
    public JTextField tf_pcs_susu;
    public JLabel lb_pcs_minyakgoreng;
    public JLabel lb_pcs_gula;
    public JLabel lb_pcs_beras;
    public JLabel lb_pcs_telur;
    public JLabel lb_pcs_susu;
    public JTextField tf_total_minyakgoreng;
    public JTextField tf_total_gula;
    public JTextField tf_total_beras;
    public JTextField tf_total_telur;
    public JTextField tf_total_susu;
    public JComboBox cbx_minyakgoreng;
    public JComboBox cbx_gula;
    public JComboBox cbx_beras;
    public JComboBox cbx_telur;
    public JComboBox cbx_susu;

    public  JLabel lb_subtotal_sembako;
    public JTextField tf_subtotal_sembako;
    public JButton button_reset_sembako;

    public boolean is_buy_minyakgoreng = false;
    public boolean is_buy_gula = false;
    public boolean is_buy_beras = false;
    public boolean is_buy_telur = false;
    public boolean is_buy_susu = false;

    public boolean is_logined = false;

    Border br = BorderFactory.createLineBorder(Color.black);

    public static void main(String[] args) {
        Main main = new Main();
        main.transaksi_page();
    }

    public void transaksi_page(){
        if(is_logined == true){
            Main main = new Main();
            main.splash_screen_open();
            main.frame_open();
            main.title();
            main.panel_sembako();
            main.panel_pulsa();
            main.frame_close();
        }
        else{
            Login login = new Login();
        }
    }

    public void splash_screen_open(){
        super.splash_screen_open();
    }

    public String developer(){
        return super.developer();
    }

    public String nama_toko(){
        return super.nama_toko();
    }

    public void frame_open()
    {
        jframe = new JFrame();
        jframe.setTitle("TOKO "+nama_toko());
        jframe.setBounds(0, 0, 1920, 1000);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);

        content = jframe.getContentPane();
        content.setLayout(null);
    }

    public void frame_close()
    {
        JLabel footer = new JLabel();
        footer.setText(developer());
        footer.setBounds(15, 810, 1000, 100);
        footer.setFont(new Font("Arial",Font.BOLD,12));

        content.add(footer);

        jframe.setVisible(true);
    }

    public void title(){
        title = new JLabel("TOKO "+nama_toko());
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setSize(300,30);
        title.setLocation(700,30);
        content.add(title);
    }

    public void panel_sembako(){
        Sembako sembako = new Sembako();

        JLabel jdl = new JLabel(sembako.keterangan);
        jdl.setFont(new Font("Arial",Font.BOLD,16));
        jdl.setBounds(16,2,500,20);

        panel_sembako = new JPanel();
        panel_sembako.setLayout(null);

        panel_sembako.add(jdl);

        showing_minyakgoreng();
        showing_gula();
        showing_beras();
        showing_telur();
        showing_susu();
        showing_tf_subtotal_sembako();
        showing_button_reset_sembako();

        panel_sembako.setBackground(Color.lightGray);
        panel_sembako.setBounds(100,90,600,350);

        content.add(panel_sembako);

    }

    public void panel_pulsa(){
        JLabel jdl = new JLabel("#Daftar Pulsa");
        jdl.setFont(new Font("Arial",Font.BOLD,16));
        jdl.setBounds(16,2,500,20);

        panel_pulsa = new JPanel();
        panel_pulsa.setLayout(null);

        panel_pulsa.setBackground(Color.lightGray);
        panel_pulsa.setBounds(850,90,600,350);

        panel_pulsa.add(jdl);

        content.add(panel_pulsa);

    }

    public void showing_minyakgoreng(){

        cb_minyakgoreng = new JCheckBox();
        cb_minyakgoreng.setText("Minyak Goreng");
        cb_minyakgoreng.setBounds(15,15,150,50);
        cb_minyakgoreng.setOpaque(false);
        cb_minyakgoreng.addActionListener(this::actionPerformed);

        Sembako ls_mg = new Sembako();

        cbx_minyakgoreng = new JComboBox<>();
        for(int i = 0;i<ls_mg.ls_mg.length;i++){
            cbx_minyakgoreng.addItem(ls_mg.ls_mg[i][0]);
        }
        cbx_minyakgoreng.setBounds(165,25,100,30);
        cbx_minyakgoreng.addActionListener(this::actionPerformed);

        tf_harga_minyakgoreng = new JTextField();
        tf_harga_minyakgoreng.setText(ls_mg.ls_mg[0][1]);
        tf_harga_minyakgoreng.setBounds(270,25,100,30);
        tf_harga_minyakgoreng.setEnabled(false);
        tf_harga_minyakgoreng.setDisabledTextColor(Color.black);

        tf_pcs_minyakgoreng = new JTextField();
        tf_pcs_minyakgoreng.setText("0");
        tf_pcs_minyakgoreng.setBounds(380,25,50,30);
        tf_pcs_minyakgoreng.addActionListener(this::actionPerformed);

        lb_pcs_minyakgoreng = new JLabel();
        lb_pcs_minyakgoreng.setText("pcs");
        lb_pcs_minyakgoreng.setBounds(440,15,50,50);

        tf_total_minyakgoreng = new JTextField();
        tf_total_minyakgoreng.setText("0");
        tf_total_minyakgoreng.setBounds(470,25,100,30);
        tf_total_minyakgoreng.setEnabled(false);
        tf_total_minyakgoreng.setDisabledTextColor(Color.black);

        panel_sembako.add(cb_minyakgoreng);
        panel_sembako.add(tf_harga_minyakgoreng);
        panel_sembako.add(tf_pcs_minyakgoreng);
        panel_sembako.add(lb_pcs_minyakgoreng);
        panel_sembako.add(tf_total_minyakgoreng);
        panel_sembako.add(cbx_minyakgoreng);
    }

    public void showing_gula(){

        cb_gula = new JCheckBox();
        cb_gula.setText("Gula");
        cb_gula.setBounds(15,55,150,50);
        cb_gula.setOpaque(false);
        cb_gula.addActionListener(this::actionPerformed);

        Sembako ls_gula = new Sembako();

        cbx_gula = new JComboBox<>();
        for(int i = 0;i<ls_gula.ls_gula.length;i++){
            cbx_gula.addItem(ls_gula.ls_gula[i][0]);
        }
        cbx_gula.setBounds(165,65,100,30);
        cbx_gula.addActionListener(this::actionPerformed);

        tf_harga_gula = new JTextField();
        tf_harga_gula.setText(ls_gula.ls_gula[0][1]);
        tf_harga_gula.setBounds(270,65,100,30);
        tf_harga_gula.setEnabled(false);
        tf_harga_gula.setDisabledTextColor(Color.black);

        tf_pcs_gula = new JTextField();
        tf_pcs_gula.setText("0");
        tf_pcs_gula.setBounds(380,65,50,30);
        tf_pcs_gula.addActionListener(this::actionPerformed);

        lb_pcs_gula = new JLabel();
        lb_pcs_gula.setText("pcs");
        lb_pcs_gula.setBounds(440,55,50,50);

        tf_total_gula = new JTextField();
        tf_total_gula.setText("0");
        tf_total_gula.setBounds(470,65,100,30);
        tf_total_gula.setEnabled(false);
        tf_total_gula.setDisabledTextColor(Color.black);

        panel_sembako.add(cb_gula);
        panel_sembako.add(tf_harga_gula);
        panel_sembako.add(tf_pcs_gula);
        panel_sembako.add(lb_pcs_gula);
        panel_sembako.add(tf_total_gula);
        panel_sembako.add(cbx_gula);
    }

    public void showing_beras(){

        cb_beras = new JCheckBox();
        cb_beras.setText("Beras");
        cb_beras.setBounds(15,95,150,50);
        cb_beras.setOpaque(false);
        cb_beras.addActionListener(this::actionPerformed);

        Sembako ls_beras = new Sembako();

        cbx_beras = new JComboBox<>();
        for(int i = 0;i<ls_beras.ls_beras.length;i++){
            cbx_beras.addItem(ls_beras.ls_beras[i][0]);
        }
        cbx_beras.setBounds(165,105,100,30);
        cbx_beras.addActionListener(this::actionPerformed);

        tf_harga_beras = new JTextField();
        tf_harga_beras.setText(ls_beras.ls_beras[0][1]);
        tf_harga_beras.setBounds(270,105,100,30);
        tf_harga_beras.setEnabled(false);
        tf_harga_beras.setDisabledTextColor(Color.black);

        tf_pcs_beras = new JTextField();
        tf_pcs_beras.setText("0");
        tf_pcs_beras.setBounds(380,105,50,30);
        tf_pcs_beras.addActionListener(this::actionPerformed);

        lb_pcs_beras = new JLabel();
        lb_pcs_beras.setText("pcs");
        lb_pcs_beras.setBounds(440,95,50,50);

        tf_total_beras = new JTextField();
        tf_total_beras.setText("0");
        tf_total_beras.setBounds(470,105,100,30);
        tf_total_beras.setEnabled(false);
        tf_total_beras.setDisabledTextColor(Color.black);

        panel_sembako.add(cb_beras);
        panel_sembako.add(tf_harga_beras);
        panel_sembako.add(tf_pcs_beras);
        panel_sembako.add(lb_pcs_beras);
        panel_sembako.add(tf_total_beras);
        panel_sembako.add(cbx_beras);
    }

    public void showing_telur(){

        cb_telur = new JCheckBox();
        cb_telur.setText("Telur");
        cb_telur.setBounds(15,135,150,50);
        cb_telur.setOpaque(false);
        cb_telur.addActionListener(this::actionPerformed);

        Sembako ls_telur = new Sembako();

        cbx_telur = new JComboBox<>();
        for(int i = 0;i<ls_telur.ls_telur.length;i++){
            cbx_telur.addItem(ls_telur.ls_telur[i][0]);
        }
        cbx_telur.setBounds(165,145,100,30);
        cbx_telur.addActionListener(this::actionPerformed);

        tf_harga_telur = new JTextField();
        tf_harga_telur.setText(ls_telur.ls_telur[0][1]);
        tf_harga_telur.setBounds(270,145,100,30);
        tf_harga_telur.setEnabled(false);
        tf_harga_telur.setDisabledTextColor(Color.black);

        tf_pcs_telur = new JTextField();
        tf_pcs_telur.setText("0");
        tf_pcs_telur.setBounds(380,145,50,30);
        tf_pcs_telur.addActionListener(this::actionPerformed);

        lb_pcs_telur = new JLabel();
        lb_pcs_telur.setText("pcs");
        lb_pcs_telur.setBounds(440,135,50,50);

        tf_total_telur = new JTextField();
        tf_total_telur.setText("0");
        tf_total_telur.setBounds(470,145,100,30);
        tf_total_telur.setEnabled(false);
        tf_total_telur.setDisabledTextColor(Color.black);

        panel_sembako.add(cb_telur);
        panel_sembako.add(tf_harga_telur);
        panel_sembako.add(tf_pcs_telur);
        panel_sembako.add(lb_pcs_telur);
        panel_sembako.add(tf_total_telur);
        panel_sembako.add(cbx_telur);
    }

    public void showing_susu(){

        cb_susu = new JCheckBox();
        cb_susu.setText("Susu Indomilk");
        cb_susu.setBounds(15,175,150,50);
        cb_susu.setOpaque(false);
        cb_susu.addActionListener(this::actionPerformed);

        Sembako ls_susu = new Sembako();

        cbx_susu = new JComboBox<>();
        for(int i = 0;i<ls_susu.ls_susu.length;i++){
            cbx_susu.addItem(ls_susu.ls_susu[i][0]);
        }
        cbx_susu.setBounds(165,185,100,30);
        cbx_susu.addActionListener(this::actionPerformed);

        tf_harga_susu = new JTextField();
        tf_harga_susu.setText(ls_susu.ls_susu[0][1]);
        tf_harga_susu.setBounds(270,185,100,30);
        tf_harga_susu.setEnabled(false);
        tf_harga_susu.setDisabledTextColor(Color.black);

        tf_pcs_susu = new JTextField();
        tf_pcs_susu.setText("0");
        tf_pcs_susu.setBounds(380,185,50,30);
        tf_pcs_susu.addActionListener(this::actionPerformed);

        lb_pcs_susu = new JLabel();
        lb_pcs_susu.setText("pcs");
        lb_pcs_susu.setBounds(440,175,50,50);

        tf_total_susu = new JTextField();
        tf_total_susu.setText("0");
        tf_total_susu.setBounds(470,185,100,30);
        tf_total_susu.setEnabled(false);
        tf_total_susu.setDisabledTextColor(Color.black);

        panel_sembako.add(cb_susu);
        panel_sembako.add(tf_harga_susu);
        panel_sembako.add(tf_pcs_susu);
        panel_sembako.add(lb_pcs_susu);
        panel_sembako.add(tf_total_susu);
        panel_sembako.add(cbx_susu);
    }

    public void showing_tf_subtotal_sembako(){
        lb_subtotal_sembako = new JLabel();
        lb_subtotal_sembako.setText("Sub Total");
        lb_subtotal_sembako.setBounds(395,230,100,50);

        tf_subtotal_sembako = new JTextField();
        tf_subtotal_sembako.setText("0");
        tf_subtotal_sembako.setBounds(470,240,100,30);
        tf_subtotal_sembako.setEnabled(false);
        tf_subtotal_sembako.setDisabledTextColor(Color.black);

        panel_sembako.add(lb_subtotal_sembako);
        panel_sembako.add(tf_subtotal_sembako);
    }

    public void showing_button_reset_sembako(){
        button_reset_sembako = new JButton("RESET");
        button_reset_sembako.setBounds(15,290,100,30);
        button_reset_sembako.addActionListener(this::actionPerformed);

        panel_sembako.add(button_reset_sembako);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cb_minyakgoreng){
            action_cb_minyakgoreng();
        }
        else if(e.getSource() == cb_gula){
            action_cb_gula();
        }
        else if(e.getSource() == cb_beras){
            action_cb_beras();
        }
        else if(e.getSource() == cb_telur){
            action_cb_telur();
        }
        else if(e.getSource() == cb_susu){
            action_cb_susu();
        }
        else if(e.getSource() == cbx_minyakgoreng){
            action_cbx_minyakgoreng();
        }
        else if(e.getSource() == cbx_gula){
            action_cbx_gula();
        }
        else if(e.getSource() == cbx_beras){
            action_cbx_beras();
        }
        else if(e.getSource() == cbx_telur){
            action_cbx_telur();
        }
        else if(e.getSource() == cbx_susu){
            action_cbx_susu();
        }
        else if(e.getSource() == tf_pcs_minyakgoreng){
            action_tf_pcs_minyakgoreng();
        }
        else if(e.getSource() == tf_pcs_gula){
            action_tf_pcs_gula();
        }
        else if(e.getSource() == tf_pcs_beras){
            action_tf_pcs_beras();
        }
        else if(e.getSource() == tf_pcs_telur){
            action_tf_pcs_telur();
        }
        else if(e.getSource() == tf_pcs_susu){
            action_tf_pcs_susu();
        }
        else if(e.getSource() == button_reset_sembako){
            action_button_reset_sembako();
        }
    }


    public void action_cb_minyakgoreng(){
        if(cb_minyakgoreng.isSelected()){
            is_buy_minyakgoreng = true;
            JOptionPane.showMessageDialog(null,"Minyak goreng berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_minyakgoreng = false;
            JOptionPane.showMessageDialog(null,"Minyak goreng gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_cb_gula(){
        if(cb_gula.isSelected()){
            is_buy_gula = true;
            JOptionPane.showMessageDialog(null,"Gula berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_gula = false;
            JOptionPane.showMessageDialog(null,"Gula gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_cb_beras(){
        if(cb_beras.isSelected()){
            is_buy_beras = true;
            JOptionPane.showMessageDialog(null,"Beras berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_beras = false;
            JOptionPane.showMessageDialog(null,"Beras gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_cb_telur(){
        if(cb_telur.isSelected()){
            is_buy_telur = true;
            JOptionPane.showMessageDialog(null,"Telur berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_telur = false;
            JOptionPane.showMessageDialog(null,"Telur gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_cb_susu(){
        if(cb_susu.isSelected()){
            is_buy_susu = true;
            JOptionPane.showMessageDialog(null,"Susu berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_susu = false;
            JOptionPane.showMessageDialog(null,"Susu gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_cbx_minyakgoreng(){
        Sembako ls_mg = new Sembako();

        for(int i = 0;i<ls_mg.ls_mg.length;i++){
            if(cbx_minyakgoreng.getSelectedItem().equals(ls_mg.ls_mg[i][0])){
                tf_harga_minyakgoreng.setText(ls_mg.ls_mg[i][1]);
            }
        }

        tf_pcs_minyakgoreng.setText("0");
        tf_total_minyakgoreng.setText("0");
    }

    public void action_cbx_gula(){
        Sembako ls_gula = new Sembako();

        for(int i = 0;i<ls_gula.ls_gula.length;i++){
            if(cbx_gula.getSelectedItem().equals(ls_gula.ls_gula[i][0])){
                tf_harga_gula.setText(ls_gula.ls_gula[i][1]);
            }
        }

        tf_pcs_gula.setText("0");
        tf_total_gula.setText("0");
    }

    public void action_cbx_beras(){
        Sembako ls_beras = new Sembako();

        for(int i = 0;i<ls_beras.ls_beras.length;i++){
            if(cbx_beras.getSelectedItem().equals(ls_beras.ls_beras[i][0])){
                tf_harga_beras.setText(ls_beras.ls_beras[i][1]);
            }
        }

        tf_pcs_beras.setText("0");
        tf_total_beras.setText("0");
    }

    public void action_cbx_telur(){
        Sembako ls_telur = new Sembako();

        for(int i = 0;i<ls_telur.ls_telur.length;i++){
            if(cbx_telur.getSelectedItem().equals(ls_telur.ls_telur[i][0])){
                tf_harga_telur.setText(ls_telur.ls_telur[i][1]);
            }
        }

        tf_pcs_telur.setText("0");
        tf_total_telur.setText("0");
    }

    public void action_cbx_susu(){
        Sembako ls_susu = new Sembako();

        for(int i = 0;i<ls_susu.ls_susu.length;i++){
            if(cbx_telur.getSelectedItem().equals(ls_susu.ls_susu[i][0])){
                tf_harga_telur.setText(ls_susu.ls_susu[i][1]);
            }
        }

        tf_pcs_susu.setText("0");
        tf_total_susu.setText("0");
    }

    public void action_tf_pcs_minyakgoreng(){
        try{
            int harga = Integer.parseInt(tf_harga_minyakgoreng.getText());
            int qty = Integer.parseInt(tf_pcs_minyakgoreng.getText());

            int total = harga * qty;
            tf_total_minyakgoreng.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_minyakgoreng.setText("0");
            tf_total_minyakgoreng.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_tf_pcs_gula(){
        try{
            int harga = Integer.parseInt(tf_harga_gula.getText());
            int qty = Integer.parseInt(tf_pcs_gula.getText());

            int total = harga * qty;
            tf_total_gula.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_gula.setText("0");
            tf_total_gula.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_tf_pcs_beras(){
        try{
            int harga = Integer.parseInt(tf_harga_beras.getText());
            int qty = Integer.parseInt(tf_pcs_beras.getText());

            int total = harga * qty;
            tf_total_beras.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_beras.setText("0");
            tf_total_beras.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_tf_pcs_telur(){
        try{
            int harga = Integer.parseInt(tf_harga_telur.getText());
            int qty = Integer.parseInt(tf_pcs_telur.getText());

            int total = harga * qty;
            tf_total_telur.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_telur.setText("0");
            tf_total_telur.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_tf_pcs_susu(){
        try{
            int harga = Integer.parseInt(tf_harga_susu.getText());
            int qty = Integer.parseInt(tf_pcs_susu.getText());

            int total = harga * qty;
            tf_total_susu.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_susu.setText("0");
            tf_total_susu.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_sembako();
    }

    public void action_button_reset_sembako(){
        cb_minyakgoreng.setSelected(false);
        cb_gula.setSelected(false);
        cb_beras.setSelected(false);
        cb_telur.setSelected(false);
        cb_susu.setSelected(false);

        is_buy_minyakgoreng = false;
        is_buy_gula = false;
        is_buy_beras = false;
        is_buy_telur = false;
        is_buy_susu = false;

        cbx_minyakgoreng.setSelectedIndex(0);
        cbx_gula.setSelectedIndex(0);
        cbx_beras.setSelectedIndex(0);
        cbx_telur.setSelectedIndex(0);
        cbx_susu.setSelectedIndex(0);

        Sembako ls = new Sembako();

        for(int i = 0;i<ls.ls_mg.length;i++){
            if(cbx_minyakgoreng.getSelectedItem().equals(ls.ls_mg[i][0])){
                tf_harga_minyakgoreng.setText(ls.ls_mg[i][1]);
            }
        }

        for(int i = 0;i<ls.ls_gula.length;i++){
            if(cbx_gula.getSelectedItem().equals(ls.ls_gula[i][0])){
                tf_harga_gula.setText(ls.ls_gula[i][1]);
            }
        }

        for(int i = 0;i<ls.ls_beras.length;i++){
            if(cbx_beras.getSelectedItem().equals(ls.ls_beras[i][0])){
                tf_harga_beras.setText(ls.ls_beras[i][1]);
            }
        }

        for(int i = 0;i<ls.ls_telur.length;i++){
            if(cbx_telur.getSelectedItem().equals(ls.ls_telur[i][0])){
                tf_harga_telur.setText(ls.ls_telur[i][1]);
            }
        }

        for(int i = 0;i<ls.ls_susu.length;i++){
            if(cbx_susu.getSelectedItem().equals(ls.ls_susu[i][0])){
                tf_harga_susu.setText(ls.ls_susu[i][1]);
            }
        }

        tf_pcs_minyakgoreng.setText("0");
        tf_pcs_gula.setText("0");
        tf_pcs_beras.setText("0");
        tf_pcs_telur.setText("0");
        tf_pcs_susu.setText("0");
        tf_total_minyakgoreng.setText("0");
        tf_total_gula.setText("0");
        tf_total_beras.setText("0");
        tf_total_telur.setText("0");
        tf_total_susu.setText("0");
        tf_subtotal_sembako.setText("0");
    }

    public void hitung_subtotal_sembako(){
        int subtotal_mg = 0;
        int subtotal_gula = 0;
        int subtotal_beras = 0;
        int subtotal_telur = 0;
        int subtotal_susu = 0;

        if(is_buy_minyakgoreng == true){
            subtotal_mg = Integer.parseInt(tf_total_minyakgoreng.getText());
        }
        else{
            subtotal_mg = 0;
        }

        if(is_buy_gula == true){
            subtotal_gula = Integer.parseInt(tf_total_gula.getText());
        }
        else{
            subtotal_gula = 0;
        }

        if(is_buy_beras == true){
            subtotal_beras = Integer.parseInt(tf_total_beras.getText());
        }
        else{
            subtotal_beras = 0;
        }

        if(is_buy_telur == true){
            subtotal_telur = Integer.parseInt(tf_total_telur.getText());
        }
        else{
            subtotal_telur = 0;
        }

        if(is_buy_susu == true){
            subtotal_susu = Integer.parseInt(tf_total_susu.getText());
        }
        else{
            subtotal_susu = 0;
        }

        int subtotal = subtotal_mg + subtotal_gula + subtotal_beras + subtotal_telur + subtotal_susu;

        tf_subtotal_sembako.setText(Integer.toString(subtotal));
    }

}
