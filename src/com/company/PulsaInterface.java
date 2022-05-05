package com.company;

public interface PulsaInterface {
    public String[][] lp_tsel = new String[3][2];
    public String[][] lp_isat = new String[3][2];
    public String[][] lp_smart = new String[3][2];
    public String[][] lp_axis = new String[2][2];
    public String[][] lp_ = new String[1][2];

    void load_sembako_mg();
    void load_sembako_gula();
    void load_sembako_beras();
    void load_sembako_telur();
    void load_sembako_susu();
}
