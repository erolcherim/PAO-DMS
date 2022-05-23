package com.company;

import com.company.classes.*;
import com.company.repository.*;
import com.company.services.LoggerService.LoggerService;
import com.sun.tools.attach.AgentInitializationException;

import java.util.*;

public class Main{
    public static void main(String[] args) {
// pentru etapele 1 si 2
//        Menu meniu = Menu.getInstance();
//        meniu.showMeniu();

//pentru etapa 3
        InfoRepository infoRepo = new InfoRepository();
        ClientRepository clientRepo = new ClientRepository();
        AgentVanzariRepository agentRepo = new AgentVanzariRepository();
        MasinaRepository masinaRepo = new MasinaRepository();
        MasinaNouaRepository masinaNouaRepo = new MasinaNouaRepository();
        MasinaRulataRepository masinaRulataRepo = new MasinaRulataRepository();

        infoRepo.createTable();
        clientRepo.createTable();
        agentRepo.createTable();
        masinaRepo.createTable();
        masinaNouaRepo.createTable();
        masinaRulataRepo.createTable();

    }
}
