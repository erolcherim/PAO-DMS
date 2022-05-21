package com.company.classes;

public class MasinaRulata extends Masina {
    private int rulaj;

    public MasinaRulata(String producator, String model, int capacitateCilindrica, int pret, int anFabricatie, int rulaj) {
        super(producator, model, capacitateCilindrica, pret, anFabricatie);
        this.rulaj = rulaj;
    }

    public MasinaRulata(int rulaj) {
        this.rulaj = rulaj;
    }

    public int getRulaj() {
        return this.rulaj;
    }

    public void setRulaj(int rulaj) {
        this.rulaj = rulaj;
    }

    public String toString() {
        return "MasinaRulata{rulaj=" + this.rulaj + ", masinaId=" + this.masinaId + ", producator='" + this.producator + "', model='" + this.model + "', capacitateCilindrica=" + this.capacitateCilindrica + ", pret=" + this.pret + ", anFabricatie=" + this.anFabricatie + "}";
    }
}
