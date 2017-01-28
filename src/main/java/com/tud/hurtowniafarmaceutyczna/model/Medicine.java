package com.tud.hurtowniafarmaceutyczna.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by karol on 28.01.2017.
 */
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String nazwa;
    public double cena;
    public int ilosc;
    //public int producentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
