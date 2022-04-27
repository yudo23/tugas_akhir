package com.company;

public class Sembako implements Item{
    public String keterangan = "#Daftar Sembako";

    public Sembako(){
        load_sembako_mg();
        load_sembako_gula();
        load_sembako_beras();
        load_sembako_telur();
        load_sembako_susu();
    }

    public void load_sembako_mg(){
        ls_mg[0][0] = "1 liter";
        ls_mg[0][1] = "14000";

        ls_mg[1][0] = "2 liter";
        ls_mg[1][1] = "27000";

        ls_mg[2][0] = "3 liter";
        ls_mg[2][1] = "40000";
    }
    public void load_sembako_gula(){
        ls_gula[0][0] = "1 kg";
        ls_gula[0][1] = "10000";

        ls_gula[1][0] = "2 kg";
        ls_gula[1][1] = "19000";

        ls_gula[2][0] = "3 kg";
        ls_gula[2][1] = "29000";
    }
    public void load_sembako_beras(){
        ls_beras[0][0] = "1 kg";
        ls_beras[0][1] = "15000";

        ls_beras[1][0] = "2 kg";
        ls_beras[1][1] = "29000";

        ls_beras[2][0] = "3 kg";
        ls_beras[2][1] = "44000";
    }
    public void load_sembako_telur(){
        ls_telur[0][0] = "1/2 kg";
        ls_telur[0][1] = "8000";

        ls_telur[1][0] = "1 kg";
        ls_telur[1][1] = "15000";
    }

    public void load_sembako_susu(){
        ls_susu[0][0] = "1 lusin";
        ls_susu[0][1] = "13000";
    }
}
