package com.company.classes;

public class Info {
    private static int counter = 0;
    private int infoId;
    private String nume;
    private String prenume;
    private String dataNasterii;
    private String numarTelefon;
    private String adresa;

    public Info() {
    }

    public Info(String nume, String prenume, String dataNasterii, String numarTelefon, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.numarTelefon = numarTelefon;
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

    public String getdataNasterii() {
        return this.dataNasterii;
    }

    public void setdataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getnumarTelefon() {
        return this.numarTelefon;
    }

    public void setnumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String toString() {
        return "Info{nume='" + this.nume + "', prenume='" + this.prenume + "', dataNasterii='" + this.dataNasterii + "', numarTelefon='" + this.numarTelefon + "', adresa='" + this.adresa + "'}";
    }
}