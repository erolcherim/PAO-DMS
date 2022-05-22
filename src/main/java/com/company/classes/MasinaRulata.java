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

    @Override
    public String toString() {
        return "MasinaRulata{" +
                ", masinaId=" + masinaId +
                ", producator='" + producator + '\'' +
                ", model='" + model + '\'' +
                ", capacitateCilindrica=" + capacitateCilindrica +
                ", anFabricatie=" + anFabricatie +
                ", rulaj=" + rulaj +
                ", pret=" + pret;
    }

    public int getRulaj() {
        return this.rulaj;
    }

    public void setRulaj(int rulaj) {
        this.rulaj = rulaj;
    }


}
