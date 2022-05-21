package com.company.classes;

import java.util.Set;

public class Client {
    private static int counter = 0;
    private int clientId;
    private Info info;
    private Set<ClientMasina> clientMasinaSet;

    public Client(Info info) {
        this.info = info;
        this.setId(++counter);
    }

    public Client() {
    }

    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public int getId() {
        return this.clientId;
    }

    public void setId(int id) {
        this.clientId = id;
    }

    public String toString() {
        return "Client{Id=" + this.clientId + ", info=" + this.info + "}";
    }
}
