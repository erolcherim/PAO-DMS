package com.company.classes;

public class MasinaNoua extends Masina {
    private int reducereRabla;

    public MasinaNoua(String producator, String model, int capacitateCilindrica, int pret, int anFabricatie, int reducereRabla) {
        super(producator, model, capacitateCilindrica, pret, anFabricatie);
        this.reducereRabla = reducereRabla;
    }

    public MasinaNoua(int reducereRabla) {
        this.reducereRabla = reducereRabla;
    }

    public int getReducereRabla() {
        return this.reducereRabla;
    }

    public void setReducereRabla(int reducereRabla) {
        this.reducereRabla = reducereRabla;
    }

    public String toString() {
        return "MasinaNoua{reducereRabla=" + this.reducereRabla + ", masinaId=" + this.masinaId + ", producator='" + this.producator + "', model='" + this.model + "', capacitateCilindrica=" + this.capacitateCilindrica + ", pret=" + this.pret + ", anFabricatie=" + this.anFabricatie + "}";
    }
}
