package com.company.classes;

public class MasinaNoua extends Masina {
    private int reducereRabla;
    private int timpAsteptare;

    public MasinaNoua(String producator, String model, int capacitateCilindrica, int pret, int anFabricatie, int reducereRabla, int timpAsteptare) {
        super(producator, model, capacitateCilindrica, pret, anFabricatie);
        this.reducereRabla = reducereRabla;
        this.timpAsteptare = timpAsteptare;
    }

    public MasinaNoua(int reducereRabla, int timpAsteptare) {
        this.reducereRabla = reducereRabla;
        this.timpAsteptare = timpAsteptare;
    }

    public int getTimpAsteptare() {
        return timpAsteptare;
    }

    public void setTimpAsteptare(int timpAsteptare) {
        this.timpAsteptare = timpAsteptare;
    }

    @Override
    public String toString() {
        return "MasinaNoua{" +
                ", masinaId=" + masinaId +
                ", producator='" + producator + '\'' +
                ", model='" + model + '\'' +
                ", capacitateCilindrica=" + capacitateCilindrica +
                ", anFabricatie=" + anFabricatie +
                "reducereRabla=" + reducereRabla +
                ", timpAsteptare=" + timpAsteptare +
                ", pret=" + pret +
                '}';
    }

    public int getReducereRabla() {
        return this.reducereRabla;
    }

    public void setReducereRabla(int reducereRabla) {
        this.reducereRabla = reducereRabla;
    }


}
