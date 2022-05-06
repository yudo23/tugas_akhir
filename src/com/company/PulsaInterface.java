package com.company;

public interface PulsaInterface {
    public String[][] lp_tsel  = new String[5][2];
    public String[][] lp_isat  = new String[5][2];
    public String[][] lp_smart = new String[5][2];
    public String[][] lp_axis  = new String[5][2];
    public String[][] lp_tri   = new String[5][2];

    void load_pulsa_tsel();
    void load_pulsa_isat();
    void load_pulsa_smart();
    void load_pulsa_axis();
    void load_pulsa_tri();
}
