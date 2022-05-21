package com.company.classes;

public class ClientMasina {
    private static int counter = 0;
    private int clientMasinaId;
    private Client client;
    private Masina masina;

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
        this.setClientMasinaId(++counter);
    }

    public String toString() {
        return "ClientMasina{clientMasinaId=" + this.clientMasinaId + ", client=" + this.client + ", masina=" + this.masina + "}";
    }
}