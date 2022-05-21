package com.company.classes;

public class Info {
    private static int counter = 0;
    private int infoId;
    private String nume;
    private String prenume;
    private String data_nasterii;
    private String numar_telefon;
    private String adresa;

    public Info() {
    }

    public Info(String nume, String prenume, String data_nasterii, String numar_telefon, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
        this.numar_telefon = numar_telefon;
        this.adresa = adresa;
        this.setInfoId(++counter);
    }

    public int getInfoId() {
        return this.infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getData_nasterii() {
        return this.data_nasterii;
    }

    public void setData_nasterii(String data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getNumar_telefon() {
        return this.numar_telefon;
    }

    public void setNumar_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String toString() {
        return "Info{nume='" + this.nume + "', prenume='" + this.prenume + "', data_nasterii='" + this.data_nasterii + "', numar_telefon='" + this.numar_telefon + "', adresa='" + this.adresa + "'}";
    }
}