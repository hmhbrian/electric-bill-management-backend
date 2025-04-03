package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNT_ELEC", schema = "SYS")
public class AccountElec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_USER;
    private String USERNAME;
    private String PASS;
    private int ROLE_ACC;


    public AccountElec(int ID_USER,String USERNAME, String PASS, int ROLE_ACC) {
        this.ID_USER = ID_USER;
        this.USERNAME = USERNAME;
        this.PASS = PASS;
        this.ROLE_ACC = ROLE_ACC;
    }

    public AccountElec() {
    }

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public int getROLE_ACC() {
        return ROLE_ACC;
    }

    public void setROLE_ACC(int ROLE_ACC) {
        this.ROLE_ACC = ROLE_ACC;
    }
}
