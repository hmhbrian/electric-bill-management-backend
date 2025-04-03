package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "FEED_BACK", schema = "SYS")
public class feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int STAR;
    private String FEEDBACK_TEXT;
    private LocalDate FEEDBACK_DATE;
    private long CUSTOMER_ID;

    public feedback() {
    }

    public feedback(int ID, int STAR, String FEEDBACK_TEXT, LocalDate FEEDBACK_DATE, long CUSTOMER_ID) {
        this.ID = ID;
        this.STAR = STAR;
        this.FEEDBACK_TEXT = FEEDBACK_TEXT;
        this.FEEDBACK_DATE = FEEDBACK_DATE;
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSTAR() {
        return STAR;
    }

    public void setSTAR(int STAR) {
        this.STAR = STAR;
    }

    public String getFEEDBACK_TEXT() {
        return FEEDBACK_TEXT;
    }

    public void setFEEDBACK_TEXT(String FEEDBACK_TEXT) {
        this.FEEDBACK_TEXT = FEEDBACK_TEXT;
    }

    public LocalDate getFEEDBACK_DATE() {
        return FEEDBACK_DATE;
    }

    public void setFEEDBACK_DATE(LocalDate FEEDBACK_DATE) {
        this.FEEDBACK_DATE = FEEDBACK_DATE;
    }

    public long getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(long CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }
}
