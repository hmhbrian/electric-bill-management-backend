package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ELECTRIC_USER_TYPE",schema = "SYS")
public class electric_user_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_TYPE;
    private String ELEC_USER_TYPE_NAME;
    private Double UNIT_PRICE;

    public electric_user_type(Integer ID_TYPE, String ELEC_USER_TYPE_NAME, Double UNIT_PRICE) {
        this.ID_TYPE = ID_TYPE;
        this.ELEC_USER_TYPE_NAME = ELEC_USER_TYPE_NAME;
        this.UNIT_PRICE = UNIT_PRICE;
    }

    public electric_user_type(String ELEC_USER_TYPE_NAME, Double UNIT_PRICE) {
        this.ELEC_USER_TYPE_NAME = ELEC_USER_TYPE_NAME;
        this.UNIT_PRICE = UNIT_PRICE;
    }

    public electric_user_type() {
    }

    public electric_user_type(Integer ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
    }

    public Integer getID_TYPE() {
        return ID_TYPE;
    }

    public void setID_TYPE(Integer ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
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
