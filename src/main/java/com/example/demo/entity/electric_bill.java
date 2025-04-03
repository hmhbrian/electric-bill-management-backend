package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ELECTRIC_BILL",schema = "SYS")
public class electric_bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private LocalDate BILL_DATE;
    private LocalDate DUE_DATE;
    private LocalDate PAID_DATE;
    private Double TOTAL_ELEC;
    private Double TOTAL_AMOUNT;
    private int IS_PAID;
    private Double LATE_FEE;
    private long CUSTOMER_ID;

    public electric_bill() {
    }

    public electric_bill(int ID, LocalDate BILL_DATE, LocalDate DUE_DATE, LocalDate PAID_DATE, Double TOTAL_ELEC, Double TOTAL_AMOUNT, int IS_PAID, Double LATE_FEE, long CUSTOMER_ID) {
        this.ID = ID;
        this.BILL_DATE = BILL_DATE;
        this.DUE_DATE = DUE_DATE;
        this.PAID_DATE = PAID_DATE;
        this.TOTAL_ELEC = TOTAL_ELEC;
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
        this.IS_PAID = IS_PAID;
        this.LATE_FEE = LATE_FEE;
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getBILL_DATE() {
        return BILL_DATE;
    }

    public void setBILL_DATE(LocalDate BILL_DATE) {
        this.BILL_DATE = BILL_DATE;
    }

    public LocalDate getDUE_DATE() {
        return DUE_DATE;
    }

    public void setDUE_DATE(LocalDate DUE_DATE) {
        this.DUE_DATE = DUE_DATE;
    }

    public LocalDate getPAID_DATE() {
        return PAID_DATE;
    }

    public void setPAID_DATE(LocalDate PAID_DATE) {
        this.PAID_DATE = PAID_DATE;
    }

    public Double getTOTAL_ELEC() {
        return TOTAL_ELEC;
    }

    public void setTOTAL_ELEC(Double TOTAL_ELEC) {
        this.TOTAL_ELEC = TOTAL_ELEC;
    }

    public Double getTOTAL_AMOUNT() {
        return TOTAL_AMOUNT;
    }

    public void setTOTAL_AMOUNT(Double TOTAL_AMOUNT) {
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
    }

    public int getIS_PAID() {
        return IS_PAID;
    }

    public void setIS_PAID(int IS_PAID) {
        this.IS_PAID = IS_PAID;
    }

    public Double getLATE_FEE() {
        return LATE_FEE;
    }

    public void setLATE_FEE(Double LATE_FEE) {
        this.LATE_FEE = LATE_FEE;
    }

    public long getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(long CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }
}
