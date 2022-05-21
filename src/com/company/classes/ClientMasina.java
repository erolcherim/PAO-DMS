package com.company.classes;

public class ClientMasina {
    private static int counter = 0;
    private int clientMasinaId;
    private Client client;
    private Masina masina;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ClientMasina.counter = counter;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    private int calculeazaPret(){
        int pret = 0;
        if (this.masina instanceof MasinaNoua){
            pret = this.masina.getPret() - ((MasinaNoua)this.masina).getReducereRabla();
        }
        else
            pret = this.masina.getPret();

        return pret;
    }
    private int pret;


    public int getClientMasinaId() {
        return this.clientMasinaId;
    }

    public Client getClient() {
        return this.client;
    }

    public Masina getMasina() {
        return this.masina;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    public void setClientMasinaId(int clientMasinaId) {
        this.clientMasinaId = clientMasinaId;
    }

    public ClientMasina() {
    }

    public ClientMasina(Client client, Masina masina) {
        this.client = client;
        this.masina = masina;
        this.pret = calculeazaPret();
        this.setClientMasinaId(++counter);
    }

    public String toString() {
        return "ClientMasina{clientMasinaId=" + this.clientMasinaId + ", client=" + this.client + ", masina=" + this.masina + ", pret=" + this.pret + "}";
    }
}