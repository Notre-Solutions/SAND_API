package com.example.sand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class JobConfiguration {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String base;
    private String quote;
    private String klineInterval;
    private String cronExp;
    private boolean active;

    public JobConfiguration(){}

    public JobConfiguration(String name, String base, String quote, String klineInterval, String cronExp, boolean active) {
        this.name = name;
        this.base = base;
        this.quote = quote;
        this.klineInterval = klineInterval;
        this.cronExp = cronExp;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getKlineInterval() {
        return klineInterval;
    }

    public void setKlineInterval(String klineInterval) {
        this.klineInterval = klineInterval;
    }

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public boolean active() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
