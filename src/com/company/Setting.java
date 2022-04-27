package com.company;
import javax.swing.JOptionPane;

public class Setting extends SettingAbstact {
    private String nama_toko = "MYW";
    private String developer = "DEVELOPED BY MUJAHIDDIN A.A (210533616011),YUDO DENDY(210533616046) ,WINDI WAHYU(210533616037) - S1 PENDIDIKAN TEKNIK INFORMATIKA B";

    public void splash_screen_open(){
        JOptionPane.showMessageDialog(null,"Selamat datang di Toko "+nama_toko,"Informasi",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Selamat berbelanja","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }

    public String developer(){
        return developer;
    }

    public String nama_toko(){
        return nama_toko;
    }
}
