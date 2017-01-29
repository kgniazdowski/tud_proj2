package com.tud.hurtowniafarmaceutyczna.model;

import javax.persistence.*;

/**
 * Created by karol on 28.01.2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Producer.getAllProducers", query = "Select p from Producer p")
})
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;
    @Column(unique = true)
    public String nazwa;
    @Column
    public String miasto;
    @Column
    public String ulica;
    @Column
    public String kodPocztowy;
    @Column
    public int nr;

    public Producer()
    {

    }

    public Producer(String nazwa, String miasto, String ulica, String kodPocztowy, int nr) {
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.nr = nr;
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

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}
