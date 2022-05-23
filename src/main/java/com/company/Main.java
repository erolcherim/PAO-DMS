package com.company;

import com.company.classes.*;
import com.company.repository.AgentVanzariRepository;
import com.company.repository.ClientRepository;
import com.company.repository.InfoRepository;
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

        infoRepo.createTable();
        clientRepo.createTable();
        agentRepo.createTable();

        Info info = new Info("Erol", "Cherim", "1999-10-01", "2", "3");
        infoRepo.createInfo(info);



    }
}
