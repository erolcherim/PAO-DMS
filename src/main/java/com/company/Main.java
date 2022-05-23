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
        InfoRepository infoRepo = InfoRepository.getInstance();
        ClientRepository clientRepo = ClientRepository.getInstance();
        AgentVanzariRepository agentRepo = AgentVanzariRepository.getInstance();
        MasinaRepository masinaRepo = MasinaRepository.getInstance();
        MasinaNouaRepository masinaNouaRepo = MasinaNouaRepository.getInstance();
        MasinaRulataRepository masinaRulataRepo = MasinaRulataRepository.getInstance();
        ClientMasinaAgentVanzariRepository clientMasinaAgentVanzariRepo = ClientMasinaAgentVanzariRepository.getInstance();

        infoRepo.createTable();
        clientRepo.createTable();
        agentRepo.createTable();
        masinaRepo.createTable();
        masinaNouaRepo.createTable();
        masinaRulataRepo.createTable();
        clientMasinaAgentVanzariRepo.createTable();


    }
}
