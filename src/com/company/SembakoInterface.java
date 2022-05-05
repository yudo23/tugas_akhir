package com.company;

public interface SembakoInterface {
    public String[][] ls_mg = new String[3][2];
    public String[][] ls_gula = new String[3][2];
    public String[][] ls_beras = new String[3][2];
    public String[][] ls_telur = new String[2][2];
    public String[][] ls_susu = new String[1][2];

    void load_sembako_mg();
    void load_sembako_gula();
    void load_sembako_beras();
    void load_sembako_telur();
    void load_sembako_susu();
}
