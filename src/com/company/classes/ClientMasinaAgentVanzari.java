package com.company.classes;

public class ClientMasinaAgentVanzari {
    private static int counter = 0;
    private int clientMasinaId;
    private Client client;
    private Masina masina;
    private AgentVanzari agentVanzari;
    private int pret;
    public ClientMasinaAgentVanzari() {
    }

    public ClientMasinaAgentVanzari(Client client, Masina masina, AgentVanzari agentVanzari) {
        this.client = client;
        this.masina = masina;
        this.agentVanzari = agentVanzari;
        this.pret = calculeazaPret();
        this.setClientMasinaId(++counter);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ClientMasinaAgentVanzari.counter = counter;
    }

    @Override
    public String toString() {
        return "ClientMasinaAgentVanzari{" +
                "clientMasinaId=" + clientMasinaId +
                ", client=" + client +
                ", masina=" + masina +
                ", agentVanzari=" + agentVanzari +
                ", pret=" + pret +
                '}';
    }

    public AgentVanzari getAgentVanzari() {
        return agentVanzari;
    }

    public void setAgentVanzari(AgentVanzari agentVanzari) {
        this.agentVanzari = agentVanzari;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    private int calculeazaPret(){
        int pret;
        if (this.masina instanceof MasinaNoua){
            pret = this.masina.getPret() - ((MasinaNoua)this.masina).getReducereRabla();
        }
        else
            pret = this.masina.getPret();

        return pret;
    }

    public int getClientMasinaId() {
        return this.clientMasinaId;
    }

    public void setClientMasinaId(int clientMasinaId) {
        this.clientMasinaId = clientMasinaId;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Masina getMasina() {
        return this.masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }


}