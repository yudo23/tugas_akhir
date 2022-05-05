package com.company;

public class Pulsa implements PulsaInterface{
    public String keterangan = "#Daftar Pulsa";
    public Pulsa(){
        load_pulsa_tsel();
        load_pulsa_isat();
        load_pulsa_smart();
        load_pulsa_axis();
        load_pulsa_tri();
    }
    public void load_pulsa_tsel(){
        lp_tsel[0][0] = "5 rb";
        lp_tsel[0][1] = "7000";

        lp_tsel[1][0] = "10 rb";
        lp_tsel[1][1] = "12000";

        lp_tsel[2][0] = "20 rb";
        lp_tsel[2][1] = "22000";

        lp_tsel[3][0] = "50 rb";
        lp_tsel[3][1] = "52000";

        lp_tsel[4][0] = "100 rb";
        lp_tsel[4][1] = "102000";
    }
    public void load_pulsa_isat(){
        lp_isat[0][0] = "5 rb";
        lp_isat[0][1] = "7000";

        lp_isat[1][0] = "12 rb";
        lp_isat[1][1] = "14000";

        lp_isat[2][0] = "20 rb";
        lp_isat[2][1] = "22000";

        lp_isat[3][0] = "50 rb";
        lp_isat[3][1] = "52000";

        lp_isat[4][0] = "100 rb";
        lp_isat[4][1] = "102000";
    }
    public void load_pulsa_smart(){
        lp_smart[0][0] = "5 rb";
        lp_smart[0][1] = "7000";

        lp_smart[1][0] = "10 rb";
        lp_smart[1][1] = "12000";

        lp_smart[2][0] = "20 rb";
        lp_smart[2][1] = "22000";

        lp_smart[3][0] = "50 rb";
        lp_smart[3][1] = "52000";

        lp_smart[4][0] = "100 rb";
        lp_smart[4][1] = "102000";
    }
    public void load_pulsa_axis(){
        lp_axis[0][0] = "5 rb";
        lp_axis[0][1] = "7000";

        lp_axis[1][0] = "10 rb";
        lp_axis[1][1] = "12000";

        lp_axis[2][0] = "20 rb";
        lp_axis[2][1] = "22000";

        lp_axis[3][0] = "50 rb";
        lp_axis[3][1] = "52000";

        lp_axis[4][0] = "100 rb";
        lp_axis[4][1] = "102000";
    }
    public void load_pulsa_tri(){
        lp_tri[0][0] = "5 rb";
        lp_tri[0][1] = "7000";

        lp_tri[1][0] = "10 rb";
        lp_tri[1][1] = "12000";

        lp_tri[2][0] = "20 rb";
        lp_tri[2][1] = "22000";

        lp_tri[3][0] = "50 rb";
        lp_tri[3][1] = "52000";

        lp_tri[4][0] = "100 rb";
        lp_tri[4][1] = "102000";
    }
}
