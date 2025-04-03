package com.example.demo.DTO;

public class AccountDTO {
    private int ID_USER;
    private String USERNAME;
    private String PASS;
    private int ROLE_ACC;
    private long customer_id;

    public AccountDTO() {
    }

    public AccountDTO(int ID_USER, String USERNAME, String PASS, int ROLE_ACC, long customer_id) {
        this.ID_USER = ID_USER;
        this.USERNAME = USERNAME;
        this.PASS = PASS;
        this.ROLE_ACC = ROLE_ACC;
        this.customer_id = customer_id;
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

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}
