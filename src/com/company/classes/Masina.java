package com.company.classes;

import java.util.Set;

public class Masina {
    public static int counter = 0;
    public int masinaId;
    public String producator;
    public String model;
    public int capacitateCilindrica;
    public int pret;
    public int anFabricatie;
    private Set<ClientMasina> clientMasinaSet;

    public Masina(String producator, String model, int capacitateCilindrica, int pret, int anFabricatie) {
        this.producator = producator;
        this.model = model;
        this.capacitateCilindrica = capacitateCilindrica;
        this.pret = pret;
        this.anFabricatie = anFabricatie;
        this.setMasinaId(++counter);
    }

    public Masina() {
    }

    public int getMasinaId() {
        return this.masinaId;
    }

    public void setMasinaId(int masinaId) {
        this.masinaId = masinaId;
    }

    public String getProducator() {
        return this.producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacitateCilindrica() {
        return this.capacitateCilindrica;
    }

    public void setCapacitateCilindrica(int capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public int getPret() {
        return this.pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getAnFabricatie() {
        return this.anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String toString() {
        return "Masina{masinaId=" + this.masinaId + ", producator='" + this.producator + "', model='" + this.model + "', capacitateCilindrica=" + this.capacitateCilindrica + ", pret=" + this.pret + ", anFabricatie=" + this.anFabricatie + ", clientMasinaSet=" + this.clientMasinaSet + "}";
    }
}