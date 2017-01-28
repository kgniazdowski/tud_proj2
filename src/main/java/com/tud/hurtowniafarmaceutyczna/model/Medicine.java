package com.tud.hurtowniafarmaceutyczna.model;

import javax.persistence.*;

/**
 * Created by karol on 28.01.2017.
 */
@Entity
@Table
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;
    @Column
    public String nazwa;
    @Column
    public double cena;
    @Column
    public int ilosc;

    //public int producentId;

    public Medicine()
    {

    }

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
