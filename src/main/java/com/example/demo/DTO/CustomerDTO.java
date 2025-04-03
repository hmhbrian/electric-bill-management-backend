package com.example.demo.DTO;

public class CustomerDTO {
    private long ID;
    private String NAME;
    private String YYYYMM;
    private String ADDRESS;
    private int USED_NUM_ELECTRIC;
    private String ELEC_USER_TYPE_NAME;
    private Double UNIT_PRICE;

    public CustomerDTO(long ID, String NAME, String YYYYMM, String ADDRESS, int USED_NUM_ELECTRIC, String ELEC_USER_TYPE_NAME, Double UNIT_PRICE) {
        this.ID = ID;
        this.NAME = NAME;
        this.YYYYMM = YYYYMM;
        this.ADDRESS = ADDRESS;
        this.USED_NUM_ELECTRIC = USED_NUM_ELECTRIC;
        this.ELEC_USER_TYPE_NAME = ELEC_USER_TYPE_NAME;
        this.UNIT_PRICE = UNIT_PRICE;
    }


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getYYYYMM() {
        return YYYYMM;
    }

    public void setYYYYMM(String YYYYMM) {
        this.YYYYMM = YYYYMM;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public int getUSED_NUM_ELECTRIC() {
        return USED_NUM_ELECTRIC;
    }

    public void setUSED_NUM_ELECTRIC(int USED_NUM_ELECTRIC) {
        this.USED_NUM_ELECTRIC = USED_NUM_ELECTRIC;
    }

    public String getELEC_USER_TYPE_NAME() {
        return ELEC_USER_TYPE_NAME;
    }

    public void setELEC_USER_TYPE_NAME(String ELEC_USER_TYPE_NAME) {
        this.ELEC_USER_TYPE_NAME = ELEC_USER_TYPE_NAME;
    }

    public Double getUNIT_PRICE() {
        return UNIT_PRICE;
    }

    public void setUNIT_PRICE(Double UNIT_PRICE) {
        this.UNIT_PRICE = UNIT_PRICE;
    }
}
