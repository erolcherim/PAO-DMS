package com.company.classes;

public class AgentVanzari {
    private static int counter=0;
    private Info info;
    private int salariu;
    private int aniExperienta;
    private float comision;
    private int id;
    public AgentVanzari(Info info, int salariu, int aniExperienta, float comision) {
        this.info = info;
        this.salariu = salariu;
        this.aniExperienta = aniExperienta;
        this.comision = comision;
        this.setId(++counter);
    }

    public AgentVanzari() {
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        AgentVanzari.counter = counter;
    }

    @Override
    public String toString() {
        return "AgentVanzari{" +
                "info=" + info +
                ", salariu=" + salariu +
                ", aniExperienta=" + aniExperienta +
                ", comision=" + comision +
                ", id=" + id +
                '}';
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
