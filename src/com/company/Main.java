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
    public JPanel panel_transaksi;
    public JPanel panel_nota;
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
    public JCheckBox cb_tsel;
    public JCheckBox cb_isat;
    public JCheckBox cb_smart;
    public JCheckBox cb_axis;
    public JCheckBox cb_tri;
    public JTextField tf_harga_tsel;
    public JTextField tf_harga_isat;
    public JTextField tf_harga_smart;
    public JTextField tf_harga_axis;
    public JTextField tf_harga_tri;
    public JTextField tf_pcs_tsel;
    public JTextField tf_pcs_isat;
    public JTextField tf_pcs_smart;
    public JTextField tf_pcs_axis;
    public JTextField tf_pcs_tri;
    public JLabel lb_pcs_tsel;
    public JLabel lb_pcs_isat;
    public JLabel lb_pcs_smart;
    public JLabel lb_pcs_axis;
    public JLabel lb_pcs_tri;
    public JTextField tf_total_tsel;
    public JTextField tf_total_isat;
    public JTextField tf_total_smart;
    public JTextField tf_total_axis;
    public JTextField tf_total_tri;
    public JComboBox cbx_tsel;
    public JComboBox cbx_isat;
    public JComboBox cbx_smart;
    public JComboBox cbx_axis;
    public JComboBox cbx_tri;

    public JLabel lb_transaksi_sembako;
    public JLabel lb_transaksi_pulsa;
    public JLabel lb_transaksi_total;
    public JTextField tf_transaksi_sembako;
    public JTextField tf_transaksi_pulsa;
    public JTextField tf_transaksi_total;

    public JLabel lb_subtotal_sembako;
    public JTextField tf_subtotal_sembako;
    public JButton button_reset_sembako;
    public JLabel lb_subtotal_pulsa;
    public JTextField tf_subtotal_pulsa;
    public JButton button_reset_pulsa;

    public JTextArea ta_nota;

    public boolean is_buy_minyakgoreng = false;
    public boolean is_buy_gula = false;
    public boolean is_buy_beras = false;
    public boolean is_buy_telur = false;
    public boolean is_buy_susu = false;
    public boolean is_buy_tsel = false;
    public boolean is_buy_isat = false;
    public boolean is_buy_smart = false;
    public boolean is_buy_axis = false;
    public boolean is_buy_tri = false;

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
            main.panel_transaksi();
            main.panel_nota();
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
        jframe.setBounds(0, 0, 1280, 720);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);

        content = jframe.getContentPane();
        content.setLayout(null);
    }

    public void frame_close()
    {
        JLabel footer = new JLabel();
        footer.setText(developer());
        footer.setBounds(20, 620, 1000, 100);
        footer.setFont(new Font("Arial",Font.BOLD,10));

        content.add(footer);

        jframe.setVisible(true);
    }

    public void title(){
        title = new JLabel("TOKO "+nama_toko());
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setSize(300,30);
        title.setLocation(550,20);
        content.add(title);
    }

    public void panel_sembako(){
        Sembako sembako = new Sembako();

        JLabel jdl = new JLabel(sembako.keterangan);
        jdl.setFont(new Font("Arial",Font.BOLD,16));
        jdl.setBounds(15,2,500,20);

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
        panel_sembako.setBounds(20,70,600,330);

        content.add(panel_sembako);

    }

    public void panel_pulsa(){
        JLabel jdl = new JLabel("#Daftar Pulsa");
        jdl.setFont(new Font("Arial",Font.BOLD,16));
        jdl.setBounds(15,2,500,20);

        panel_pulsa = new JPanel();
        panel_pulsa.setLayout(null);

        panel_pulsa.setBackground(Color.lightGray);
        panel_pulsa.setBounds(650,70,600,330);

        panel_pulsa.add(jdl);

        showing_tsel();
        showing_isat();
        showing_smart();
        showing_axis();
        showing_tri();
        showing_tf_subtotal_pulsa();
        showing_button_reset_pulsa();

        content.add(panel_pulsa);

    }

    public void panel_transaksi(){

        JLabel jdl = new JLabel("#Total Transaksi");
        jdl.setFont(new Font("Arial",Font.BOLD,16));
        jdl.setBounds(15,2,500,20);

        panel_transaksi = new JPanel();
        panel_transaksi.setLayout(null);

        panel_transaksi.add(jdl);

        showing_transaksi_sembako();
        showing_transaksi_pulsa();
        showing_transaksi_total();

        panel_transaksi.setBackground(Color.lightGray);
        panel_transaksi.setBounds(20,410,600,250);

        content.add(panel_transaksi);

    }

    public void panel_nota(){

        JLabel jdl = new JLabel("#Nota Pembelian");
        jdl.setFont(new Font("Arial",Font.BOLD,16));
        jdl.setBounds(15,2,500,20);

        panel_nota = new JPanel();
        panel_nota.setLayout(null);

        panel_nota.add(jdl);

        ta_nota = new JTextArea();
        ta_nota.setBounds(15,30,550,210);
        ta_nota.setEnabled(false);
        ta_nota.setDisabledTextColor(Color.black);
        ta_nota.setFont(new Font("Arial",Font.BOLD,11));

        panel_nota.add(ta_nota);

        panel_nota.setBackground(Color.lightGray);
        panel_nota.setBounds(650,410,600,250);

        content.add(panel_nota);

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

    public void showing_tsel(){

        cb_tsel = new JCheckBox();
        cb_tsel.setText("Telkomsel");
        cb_tsel.setBounds(15,15,150,50);
        cb_tsel.setOpaque(false);
        cb_tsel.addActionListener(this::actionPerformed);

        Pulsa lp_tsel = new Pulsa();

        cbx_tsel = new JComboBox<>();
        for(int i = 0;i<lp_tsel.lp_tsel.length;i++){
            cbx_tsel.addItem(lp_tsel.lp_tsel[i][0]);
        }
        cbx_tsel.setBounds(165,25,100,30);
        cbx_tsel.addActionListener(this::actionPerformed);

        tf_harga_tsel = new JTextField();
        tf_harga_tsel.setText(lp_tsel.lp_tsel[0][1]);
        tf_harga_tsel.setBounds(270,25,100,30);
        tf_harga_tsel.setEnabled(false);
        tf_harga_tsel.setDisabledTextColor(Color.black);

        tf_pcs_tsel = new JTextField();
        tf_pcs_tsel.setText("0");
        tf_pcs_tsel.setBounds(380,25,50,30);
        tf_pcs_tsel.addActionListener(this::actionPerformed);

        lb_pcs_tsel = new JLabel();
        lb_pcs_tsel.setText("pcs");
        lb_pcs_tsel.setBounds(440,15,50,50);

        tf_total_tsel = new JTextField();
        tf_total_tsel.setText("0");
        tf_total_tsel.setBounds(470,25,100,30);
        tf_total_tsel.setEnabled(false);
        tf_total_tsel.setDisabledTextColor(Color.black);

        panel_pulsa.add(cb_tsel);
        panel_pulsa.add(tf_harga_tsel);
        panel_pulsa.add(tf_pcs_tsel);
        panel_pulsa.add(lb_pcs_tsel);
        panel_pulsa.add(tf_total_tsel);
        panel_pulsa.add(cbx_tsel);
    }

    public void showing_isat(){

        cb_isat = new JCheckBox();
        cb_isat.setText("Indosat");
        cb_isat.setBounds(15,55,150,50);
        cb_isat.setOpaque(false);
        cb_isat.addActionListener(this::actionPerformed);

        Pulsa lp_isat = new Pulsa();

        cbx_isat = new JComboBox<>();
        for(int i = 0;i<lp_isat.lp_isat.length;i++){
            cbx_isat.addItem(lp_isat.lp_isat[i][0]);
        }
        cbx_isat.setBounds(165,65,100,30);
        cbx_isat.addActionListener(this::actionPerformed);

        tf_harga_isat = new JTextField();
        tf_harga_isat.setText(lp_isat.lp_isat[0][1]);
        tf_harga_isat.setBounds(270,65,100,30);
        tf_harga_isat.setEnabled(false);
        tf_harga_isat.setDisabledTextColor(Color.black);

        tf_pcs_isat = new JTextField();
        tf_pcs_isat.setText("0");
        tf_pcs_isat.setBounds(380,65,50,30);
        tf_pcs_isat.addActionListener(this::actionPerformed);

        lb_pcs_isat = new JLabel();
        lb_pcs_isat.setText("pcs");
        lb_pcs_isat.setBounds(440,55,50,50);

        tf_total_isat = new JTextField();
        tf_total_isat.setText("0");
        tf_total_isat.setBounds(470,65,100,30);
        tf_total_isat.setEnabled(false);
        tf_total_isat.setDisabledTextColor(Color.black);

        panel_pulsa.add(cb_isat);
        panel_pulsa.add(tf_harga_isat);
        panel_pulsa.add(tf_pcs_isat);
        panel_pulsa.add(lb_pcs_isat);
        panel_pulsa.add(tf_total_isat);
        panel_pulsa.add(cbx_isat);
    }

    public void showing_smart(){

        cb_smart = new JCheckBox();
        cb_smart.setText("Smartfren");
        cb_smart.setBounds(15,95,150,50);
        cb_smart.setOpaque(false);
        cb_smart.addActionListener(this::actionPerformed);

        Pulsa lp_smart = new Pulsa();

        cbx_smart = new JComboBox<>();
        for(int i = 0;i<lp_smart.lp_smart.length;i++){
            cbx_smart.addItem(lp_smart.lp_smart[i][0]);
        }
        cbx_smart.setBounds(165,105,100,30);
        cbx_smart.addActionListener(this::actionPerformed);

        tf_harga_smart = new JTextField();
        tf_harga_smart.setText(lp_smart.lp_smart[0][1]);
        tf_harga_smart.setBounds(270,105,100,30);
        tf_harga_smart.setEnabled(false);
        tf_harga_smart.setDisabledTextColor(Color.black);

        tf_pcs_smart = new JTextField();
        tf_pcs_smart.setText("0");
        tf_pcs_smart.setBounds(380,105,50,30);
        tf_pcs_smart.addActionListener(this::actionPerformed);

        lb_pcs_smart = new JLabel();
        lb_pcs_smart.setText("pcs");
        lb_pcs_smart.setBounds(440,95,50,50);

        tf_total_smart = new JTextField();
        tf_total_smart.setText("0");
        tf_total_smart.setBounds(470,105,100,30);
        tf_total_smart.setEnabled(false);
        tf_total_smart.setDisabledTextColor(Color.black);

        panel_pulsa.add(cb_smart);
        panel_pulsa.add(tf_harga_smart);
        panel_pulsa.add(tf_pcs_smart);
        panel_pulsa.add(lb_pcs_smart);
        panel_pulsa.add(tf_total_smart);
        panel_pulsa.add(cbx_smart);
    }

    public void showing_axis(){

        cb_axis = new JCheckBox();
        cb_axis.setText("Axis");
        cb_axis.setBounds(15,135,150,50);
        cb_axis.setOpaque(false);
        cb_axis.addActionListener(this::actionPerformed);

        Pulsa lp_axis = new Pulsa();

        cbx_axis = new JComboBox<>();
        for(int i = 0;i<lp_axis.lp_axis.length;i++){
            cbx_axis.addItem(lp_axis.lp_axis[i][0]);
        }
        cbx_axis.setBounds(165,145,100,30);
        cbx_axis.addActionListener(this::actionPerformed);

        tf_harga_axis = new JTextField();
        tf_harga_axis.setText(lp_axis.lp_axis[0][1]);
        tf_harga_axis.setBounds(270,145,100,30);
        tf_harga_axis.setEnabled(false);
        tf_harga_axis.setDisabledTextColor(Color.black);

        tf_pcs_axis = new JTextField();
        tf_pcs_axis.setText("0");
        tf_pcs_axis.setBounds(380,145,50,30);
        tf_pcs_axis.addActionListener(this::actionPerformed);

        lb_pcs_axis = new JLabel();
        lb_pcs_axis.setText("pcs");
        lb_pcs_axis.setBounds(440,135,50,50);

        tf_total_axis = new JTextField();
        tf_total_axis.setText("0");
        tf_total_axis.setBounds(470,145,100,30);
        tf_total_axis.setEnabled(false);
        tf_total_axis.setDisabledTextColor(Color.black);

        panel_pulsa.add(cb_axis);
        panel_pulsa.add(tf_harga_axis);
        panel_pulsa.add(tf_pcs_axis);
        panel_pulsa.add(lb_pcs_axis);
        panel_pulsa.add(tf_total_axis);
        panel_pulsa.add(cbx_axis);
    }

    public void showing_tri(){

        cb_tri = new JCheckBox();
        cb_tri.setText("Tri");
        cb_tri.setBounds(15,175,150,50);
        cb_tri.setOpaque(false);
        cb_tri.addActionListener(this::actionPerformed);

        Pulsa lp_tri = new Pulsa();

        cbx_tri = new JComboBox<>();
        for(int i = 0;i<lp_tri.lp_tri.length;i++){
            cbx_tri.addItem(lp_tri.lp_tri[i][0]);
        }
        cbx_tri.setBounds(165,185,100,30);
        cbx_tri.addActionListener(this::actionPerformed);

        tf_harga_tri = new JTextField();
        tf_harga_tri.setText(lp_tri.lp_tri[0][1]);
        tf_harga_tri.setBounds(270,185,100,30);
        tf_harga_tri.setEnabled(false);
        tf_harga_tri.setDisabledTextColor(Color.black);

        tf_pcs_tri = new JTextField();
        tf_pcs_tri.setText("0");
        tf_pcs_tri.setBounds(380,185,50,30);
        tf_pcs_tri.addActionListener(this::actionPerformed);

        lb_pcs_tri = new JLabel();
        lb_pcs_tri.setText("pcs");
        lb_pcs_tri.setBounds(440,175,50,50);

        tf_total_tri = new JTextField();
        tf_total_tri.setText("0");
        tf_total_tri.setBounds(470,185,100,30);
        tf_total_tri.setEnabled(false);
        tf_total_tri.setDisabledTextColor(Color.black);

        panel_pulsa.add(cb_tri);
        panel_pulsa.add(tf_harga_tri);
        panel_pulsa.add(tf_pcs_tri);
        panel_pulsa.add(lb_pcs_tri);
        panel_pulsa.add(tf_total_tri);
        panel_pulsa.add(cbx_tri);
    }

    public void showing_tf_subtotal_pulsa(){
        lb_subtotal_pulsa = new JLabel();
        lb_subtotal_pulsa.setText("Sub Total");
        lb_subtotal_pulsa.setBounds(395,230,100,50);

        tf_subtotal_pulsa = new JTextField();
        tf_subtotal_pulsa.setText("0");
        tf_subtotal_pulsa.setBounds(470,240,100,30);
        tf_subtotal_pulsa.setEnabled(false);
        tf_subtotal_pulsa.setDisabledTextColor(Color.black);

        panel_pulsa.add(lb_subtotal_pulsa);
        panel_pulsa.add(tf_subtotal_pulsa);
    }

    public void showing_button_reset_pulsa(){
        button_reset_pulsa = new JButton("RESET");
        button_reset_pulsa.setBounds(15,290,100,30);
        button_reset_pulsa.addActionListener(this::actionPerformed);

        panel_pulsa.add(button_reset_pulsa);
    }

    public void showing_transaksi_sembako(){

        lb_transaksi_sembako = new JLabel();
        lb_transaksi_sembako.setText("Total Pembelian Sembako");
        lb_transaksi_sembako.setBounds(15,15,200,50);

        tf_transaksi_sembako = new JTextField();
        tf_transaksi_sembako.setText("0");
        tf_transaksi_sembako.setBounds(350,25,200,30);
        tf_transaksi_sembako.setEnabled(false);
        tf_transaksi_sembako.setDisabledTextColor(Color.black);

        panel_transaksi.add(lb_transaksi_sembako);
        panel_transaksi.add(tf_transaksi_sembako);

    }

    public void showing_transaksi_pulsa(){
        lb_transaksi_pulsa = new JLabel();
        lb_transaksi_pulsa.setText("Total Pembelian Pulsa");
        lb_transaksi_pulsa.setBounds(15,55,200,50);

        tf_transaksi_pulsa = new JTextField();
        tf_transaksi_pulsa.setText("0");
        tf_transaksi_pulsa.setBounds(350,65,200,30);
        tf_transaksi_pulsa.setEnabled(false);
        tf_transaksi_pulsa.setDisabledTextColor(Color.black);

        panel_transaksi.add(lb_transaksi_pulsa);
        panel_transaksi.add(tf_transaksi_pulsa);
    }

    public void showing_transaksi_total(){
        lb_transaksi_total = new JLabel();
        lb_transaksi_total.setText("Total Pembelian Keseluruhan");
        lb_transaksi_total.setBounds(15,95,200,50);

        tf_transaksi_total = new JTextField();
        tf_transaksi_total.setText("0");
        tf_transaksi_total.setBounds(350,105,200,30);
        tf_transaksi_total.setEnabled(false);
        tf_transaksi_total.setDisabledTextColor(Color.black);

        panel_transaksi.add(lb_transaksi_total);
        panel_transaksi.add(tf_transaksi_total);

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
        else if(e.getSource() == cb_tsel){
            action_cb_tsel();
        }
        else if(e.getSource() == cb_isat){
            action_cb_isat();
        }
        else if(e.getSource() == cb_smart){
            action_cb_smart();
        }
        else if(e.getSource() == cb_axis){
            action_cb_axis();
        }
        else if(e.getSource() == cb_tri){
            action_cb_tri();
        }
        else if(e.getSource() == cbx_tsel){
            action_cbx_tsel();
        }
        else if(e.getSource() == cbx_isat){
            action_cbx_isat();
        }
        else if(e.getSource() == cbx_smart){
            action_cbx_smart();
        }
        else if(e.getSource() == cbx_axis){
            action_cbx_axis();
        }
        else if(e.getSource() == cbx_tri){
            action_cbx_tri();
        }
        else if(e.getSource() == tf_pcs_tsel){
            action_tf_pcs_tsel();
        }
        else if(e.getSource() == tf_pcs_isat){
            action_tf_pcs_isat();
        }
        else if(e.getSource() == tf_pcs_smart){
            action_tf_pcs_smart();
        }
        else if(e.getSource() == tf_pcs_axis){
            action_tf_pcs_axis();
        }
        else if(e.getSource() == tf_pcs_tri){
            action_tf_pcs_tri();
        }
        else if(e.getSource() == button_reset_pulsa){
            action_button_reset_pulsa();
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

    public void action_cb_tsel(){
        if(cb_tsel.isSelected()){
            is_buy_tsel = true;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_tsel = false;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_cb_isat(){
        if(cb_isat.isSelected()){
            is_buy_isat = true;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_isat = false;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_cb_smart(){
        if(cb_smart.isSelected()){
            is_buy_smart = true;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_smart = false;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_cb_axis(){
        if(cb_axis.isSelected()){
            is_buy_axis = true;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_axis = false;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_cb_tri(){
        if(cb_tri.isSelected()){
            is_buy_tri = true;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel berhasil dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            is_buy_tri = false;
            JOptionPane.showMessageDialog(null,"Pulsa Telkomsel gagal dipilih","Informasi Pembelian", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
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

        action_tf_pcs_minyakgoreng();
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

        action_tf_pcs_gula();
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

        action_tf_pcs_beras();
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

        action_tf_pcs_telur();
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

        action_tf_pcs_susu();
    }

    public void action_cbx_tsel(){
        Pulsa lp_tsel = new Pulsa();

        for(int i = 0;i<lp_tsel.lp_tsel.length;i++){
            if(cbx_tsel.getSelectedItem().equals(lp_tsel.lp_tsel[i][0])){
                tf_harga_tsel.setText(lp_tsel.lp_tsel[i][1]);
            }
        }

        tf_pcs_tsel.setText("0");
        tf_total_tsel.setText("0");

        action_tf_pcs_tsel();
    }

    public void action_cbx_isat(){
        Pulsa lp_isat = new Pulsa();

        for(int i = 0;i<lp_isat.lp_isat.length;i++){
            if(cbx_isat.getSelectedItem().equals(lp_isat.lp_isat[i][0])){
                tf_harga_isat.setText(lp_isat.lp_isat[i][1]);
            }
        }

        tf_pcs_isat.setText("0");
        tf_total_isat.setText("0");

        action_tf_pcs_isat();
    }

    public void action_cbx_smart(){
        Pulsa lp_smart = new Pulsa();

        for(int i = 0;i<lp_smart.lp_smart.length;i++){
            if(cbx_smart.getSelectedItem().equals(lp_smart.lp_smart[i][0])){
                tf_harga_smart.setText(lp_smart.lp_smart[i][1]);
            }
        }

        tf_pcs_smart.setText("0");
        tf_total_smart.setText("0");

        action_tf_pcs_smart();
    }

    public void action_cbx_axis(){
        Pulsa lp_axis = new Pulsa();

        for(int i = 0;i<lp_axis.lp_axis.length;i++){
            if(cbx_axis.getSelectedItem().equals(lp_axis.lp_axis[i][0])){
                tf_harga_axis.setText(lp_axis.lp_axis[i][1]);
            }
        }

        tf_pcs_axis.setText("0");
        tf_total_axis.setText("0");

        action_tf_pcs_axis();
    }

    public void action_cbx_tri(){
        Pulsa lp_tri = new Pulsa();

        for(int i = 0;i<lp_tri.lp_tri.length;i++){
            if(cbx_tri.getSelectedItem().equals(lp_tri.lp_tri[i][0])){
                tf_harga_tri.setText(lp_tri.lp_tri[i][1]);
            }
        }

        tf_pcs_tri.setText("0");
        tf_total_tri.setText("0");

        action_tf_pcs_tri();
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

    public void action_tf_pcs_tsel(){
        try{
            int harga = Integer.parseInt(tf_harga_tsel.getText());
            int qty = Integer.parseInt(tf_pcs_tsel.getText());

            int total = harga * qty;
            tf_total_tsel.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_tsel.setText("0");
            tf_total_tsel.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_tf_pcs_isat(){
        try{
            int harga = Integer.parseInt(tf_harga_isat.getText());
            int qty = Integer.parseInt(tf_pcs_isat.getText());

            int total = harga * qty;
            tf_total_isat.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_isat.setText("0");
            tf_total_isat.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_tf_pcs_smart(){
        try{
            int harga = Integer.parseInt(tf_harga_smart.getText());
            int qty = Integer.parseInt(tf_pcs_smart.getText());

            int total = harga * qty;
            tf_total_smart.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_smart.setText("0");
            tf_total_smart.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_tf_pcs_axis(){
        try{
            int harga = Integer.parseInt(tf_harga_axis.getText());
            int qty = Integer.parseInt(tf_pcs_axis.getText());

            int total = harga * qty;
            tf_total_axis.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_axis.setText("0");
            tf_total_axis.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
    }

    public void action_tf_pcs_tri(){
        try{
            int harga = Integer.parseInt(tf_harga_tri.getText());
            int qty = Integer.parseInt(tf_pcs_tri.getText());

            int total = harga * qty;
            tf_total_tri.setText(Integer.toString(total));

        }catch (Exception exc){
            tf_pcs_tri.setText("0");
            tf_total_tri.setText("0");
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        hitung_subtotal_pulsa();
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

    public void action_button_reset_pulsa(){
        cb_tsel.setSelected(false);
        cb_isat.setSelected(false);
        cb_smart.setSelected(false);
        cb_axis.setSelected(false);
        cb_tri.setSelected(false);

        is_buy_tsel = false;
        is_buy_isat = false;
        is_buy_smart = false;
        is_buy_axis = false;
        is_buy_tri = false;

        cbx_tsel.setSelectedIndex(0);
        cbx_isat.setSelectedIndex(0);
        cbx_smart.setSelectedIndex(0);
        cbx_axis.setSelectedIndex(0);
        cbx_tri.setSelectedIndex(0);

        Pulsa lp = new Pulsa();

        for(int i = 0;i<lp.lp_tsel.length;i++){
            if(cbx_tsel.getSelectedItem().equals(lp.lp_tsel[i][0])){
                tf_harga_tsel.setText(lp.lp_tsel[i][1]);
            }
        }
        for(int i = 0;i<lp.lp_isat.length;i++){
            if(cbx_isat.getSelectedItem().equals(lp.lp_isat[i][0])){
                tf_harga_isat.setText(lp.lp_isat[i][1]);
            }
        }
        for(int i = 0;i<lp.lp_smart.length;i++){
            if(cbx_smart.getSelectedItem().equals(lp.lp_smart[i][0])){
                tf_harga_smart.setText(lp.lp_smart[i][1]);
            }
        }
        for(int i = 0;i<lp.lp_axis.length;i++){
            if(cbx_axis.getSelectedItem().equals(lp.lp_axis[i][0])){
                tf_harga_axis.setText(lp.lp_axis[i][1]);
            }
        }
        for(int i = 0;i<lp.lp_tri.length;i++){
            if(cbx_tri.getSelectedItem().equals(lp.lp_tri[i][0])){
                tf_harga_tri.setText(lp.lp_tri[i][1]);
            }
        }
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

        hitung_total_transaksi();
    }

    public void hitung_subtotal_pulsa(){
        int subtotal_tsel = 0;
        int subtotal_isat = 0;
        int subtotal_smart = 0;
        int subtotal_axis = 0;
        int subtotal_tri = 0;

        if(is_buy_tsel == true){
            subtotal_tsel = Integer.parseInt(tf_total_tsel.getText());
        }
        else{
            subtotal_tsel = 0;
        }

        if(is_buy_isat == true){
            subtotal_isat = Integer.parseInt(tf_total_isat.getText());
        }
        else{
            subtotal_isat = 0;
        }

        if(is_buy_smart == true){
            subtotal_smart = Integer.parseInt(tf_total_smart.getText());
        }
        else{
            subtotal_smart = 0;
        }

        if(is_buy_axis == true){
            subtotal_axis = Integer.parseInt(tf_total_axis.getText());
        }
        else{
            subtotal_axis = 0;
        }

        if(is_buy_tri == true){
            subtotal_tri = Integer.parseInt(tf_total_tri.getText());
        }
        else{
            subtotal_tri = 0;
        }

        int subtotal = subtotal_tsel + subtotal_isat + subtotal_smart + subtotal_axis + subtotal_tri;

        tf_subtotal_pulsa.setText(Integer.toString(subtotal));

        hitung_total_transaksi();
    }

    public void hitung_total_transaksi(){
        int total_sembako = Integer.parseInt(tf_subtotal_sembako.getText());
        int total_pulsa = Integer.parseInt(tf_subtotal_pulsa.getText());

        int total = total_sembako + total_pulsa;

        tf_transaksi_sembako.setText(Integer.toString(total_sembako));
        tf_transaksi_pulsa.setText(Integer.toString(total_pulsa));
        tf_transaksi_total.setText(Integer.toString(total));

        generate_nota();
    }

    public void generate_nota(){
        String sembako = "";
        String pulsa = "";
        String total = "";

        if(is_buy_minyakgoreng == true && (Integer.parseInt(tf_total_minyakgoreng.getText()) >= 1)){
            sembako += " (SMB) Minyak Goreng"+"\t"+ cbx_minyakgoreng.getSelectedItem().toString()+'\t'+tf_pcs_minyakgoreng.getText().toString()+'x'+'\t'+'@'+tf_harga_minyakgoreng.getText().toString()+'\t'+tf_total_minyakgoreng.getText().toString();
            sembako += "\n";
        }
        if(is_buy_beras == true && (Integer.parseInt(tf_total_beras.getText()) >= 1)){
            sembako += " (SMB) Beras"+"\t\t"+ cbx_beras.getSelectedItem().toString()+'\t'+tf_pcs_beras.getText().toString()+'x'+'\t'+'@'+tf_harga_beras.getText().toString()+'\t'+tf_total_beras.getText().toString();
            sembako += "\n";
        }
        if(is_buy_gula == true && (Integer.parseInt(tf_total_gula.getText()) >= 1)){
            sembako += " (SMB) Gula"+"\t\t"+ cbx_gula.getSelectedItem().toString()+'\t'+tf_pcs_gula.getText().toString()+'x'+'\t'+'@'+tf_harga_gula.getText().toString()+'\t'+tf_total_gula.getText().toString();
            sembako += "\n";
        }
        if(is_buy_telur == true && (Integer.parseInt(tf_total_telur.getText()) >= 1)){
            sembako += " (SMB) Telur"+"\t\t"+ cbx_telur.getSelectedItem().toString()+'\t'+tf_pcs_telur.getText().toString()+'x'+'\t'+'@'+tf_harga_telur.getText().toString()+'\t'+tf_total_telur.getText().toString();
            sembako += "\n";
        }
        if(is_buy_susu == true && (Integer.parseInt(tf_total_susu.getText()) >= 1)){
            sembako += " (SMB) Susu"+"\t\t"+ cbx_susu.getSelectedItem().toString()+'\t'+tf_pcs_susu.getText().toString()+'x'+'\t'+'@'+tf_harga_susu.getText().toString()+'\t'+tf_total_susu.getText().toString();
            sembako += "\n";
        }

        if(is_buy_tsel == true && (Integer.parseInt(tf_total_tsel.getText()) >= 1)){
            pulsa += " (PLS) Telkomsel"+"\t"+ cbx_tsel.getSelectedItem().toString()+'\t'+tf_pcs_tsel.getText().toString()+'x'+'\t'+'@'+tf_harga_tsel.getText().toString()+'\t'+tf_total_tsel.getText().toString();
            pulsa += "\n";
        }
        if(is_buy_isat == true && (Integer.parseInt(tf_total_isat.getText()) >= 1)){
            pulsa += " (PLS) Indosat"+"\t\t"+ cbx_isat.getSelectedItem().toString()+'\t'+tf_pcs_isat.getText().toString()+'x'+'\t'+'@'+tf_harga_isat.getText().toString()+'\t'+tf_total_isat.getText().toString();
            pulsa += "\n";
        }
        if(is_buy_axis == true && (Integer.parseInt(tf_total_axis.getText()) >= 1)){
            pulsa += " (PLS) Axis"+"\t\t"+ cbx_axis.getSelectedItem().toString()+'\t'+tf_pcs_axis.getText().toString()+'x'+'\t'+'@'+tf_harga_axis.getText().toString()+'\t'+tf_total_axis.getText().toString();
            pulsa += "\n";
        }
        if(is_buy_tri == true && (Integer.parseInt(tf_total_tri.getText()) >= 1)){
            pulsa += " (PLS) Tri"+"\t\t"+ cbx_tri.getSelectedItem().toString()+'\t'+tf_pcs_tri.getText().toString()+'x'+'\t'+'@'+tf_harga_tri.getText().toString()+'\t'+tf_total_tri.getText().toString();
            pulsa += "\n";
        }
        if(is_buy_smart == true && (Integer.parseInt(tf_total_smart.getText()) >= 1)){
            pulsa += " (PLS) Smartfren"+"\t"+ cbx_smart.getSelectedItem().toString()+'\t'+tf_pcs_smart.getText().toString()+'x'+'\t'+'@'+tf_harga_smart.getText().toString()+'\t'+tf_total_smart.getText().toString();
            pulsa += "\n";
        }

        if(pulsa != "" || sembako != ""){
            total = "----------------------------------------------------------------------------------------------------------------------- +\n";
            total += "\n"+"\t\t\t\t\t"+ tf_transaksi_total.getText().toString();

            sembako = "====================================DETAIL SEMBAKO DAN PULSA======================================\n\n" + sembako;
        }

        ta_nota.setText(sembako+pulsa+'\n'+total);

    }

}
