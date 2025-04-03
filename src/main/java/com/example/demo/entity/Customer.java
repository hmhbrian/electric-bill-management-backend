package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER",schema = "SYS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String NAME;
    private String YYYYMM;
    private String ADDRESS;
    private int USED_NUM_ELECTRIC;
    private int ID_USER;
    private int ELEC_USER_TYPE_ID;
    private String AVATAR;


    public Customer(long ID, String NAME, String YYYYMM, String ADDRESS, int USED_NUM_ELECTRIC, int ELEC_USER_TYPE_ID, int ID_USER) {
        this.ID = ID;
        this.NAME = NAME;
        this.YYYYMM = YYYYMM;
        this.ADDRESS = ADDRESS;
        this.USED_NUM_ELECTRIC = USED_NUM_ELECTRIC;
        this.ID_USER = ID_USER;
        this.ELEC_USER_TYPE_ID = ELEC_USER_TYPE_ID;
    }


    public Customer() {
    }

    public String getAVATAR() {
        return AVATAR;
    }

    public void setAVATAR(String AVATAR) {
        this.AVATAR = AVATAR;
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

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public int getELEC_USER_TYPE_ID() {
        return ELEC_USER_TYPE_ID;
    }

    public void setELEC_USER_TYPE_ID(int ELEC_USER_TYPE_ID) {
        this.ELEC_USER_TYPE_ID = ELEC_USER_TYPE_ID;
    }
}
