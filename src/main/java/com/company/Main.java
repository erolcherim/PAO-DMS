package com.company;

import com.company.classes.*;
import com.company.repository.*;
import com.company.services.LoggerService.LoggerService;
import com.sun.tools.attach.AgentInitializationException;

import java.util.*;

public class Main{
    public static void main(String[] args) {
// //pentru etapele 1 si 2
//        Menu meniu = Menu.getInstance();
//        meniu.showMeniu();

//pentru etapa 3

        /*doar niste exemple pentru ca mi-am gandit serviciile de la etapa 1 gresit si trebuie sa le refac
         *nu se pot folosi la meniu pentru ca nu returneaza obiecte
         *Spre ex in DB la relatiile de tip IS-A trebuie intai definite obiectele din tabelele exterioare, apoi se creeaza
         *un entry pentru tabelul din interior dar functia se apeleaza CREATE(OBIECT, atribut1, atribut2)
         * */

        InfoRepository infoRepo = InfoRepository.getInstance();
        ClientRepository clientRepo = ClientRepository.getInstance();
        AgentVanzariRepository agentRepo = AgentVanzariRepository.getInstance();
        MasinaRepository masinaRepo = MasinaRepository.getInstance();
        MasinaNouaRepository masinaNouaRepo = MasinaNouaRepository.getInstance();
        MasinaRulataRepository masinaRulataRepo = MasinaRulataRepository.getInstance();
        ClientMasinaAgentVanzariRepository clientMasinaAgentVanzariRepo = ClientMasinaAgentVanzariRepository.getInstance();

        System.out.println("Dropping tables...");
        clientMasinaAgentVanzariRepo.dropTable();
        clientRepo.dropTable();
        agentRepo.dropTable();
        infoRepo.dropTable();
        masinaNouaRepo.dropTable();
        masinaRulataRepo.dropTable();
        masinaRepo.dropTable();

        System.out.println("Creating Tables...");
        infoRepo.createTable();
        clientRepo.createTable();
        agentRepo.createTable();
        masinaRepo.createTable();
        masinaNouaRepo.createTable();
        masinaRulataRepo.createTable();
        clientMasinaAgentVanzariRepo.createTable();

        System.out.println("Inserting values...");
        //Create-uri
        Info info1 = new Info("Cherim", "Erol", "1999-01-10", "0748851760", "str. Aleea Bujoreni nr.2");
        infoRepo.createInfo(info1);

        Info info2 = new Info("Popescu", "Ion", "1987-03-11", "0745869123", "str. Luncilor nr. 16");
        infoRepo.createInfo(info2);

        Info info3 = new Info("Tomescu", "Andrei", "1994-05-03", "0758214322", "str. 1848, nr. 21");
        infoRepo.createInfo(info3);

        Info info4 = new Info("Roman", "Robert", "2001-09-27", "0351945632", "str. Cordun, nr.14");
        infoRepo.createInfo(info4); //creare din obiect

        clientRepo.createClient(1);
        agentRepo.createAgentVanzari(4500, 2, 0.2,2); //create cu atribute
        clientRepo.createClient(3);
        agentRepo.createAgentVanzari(6000, 5, 0.23, 4);

        Masina masina1 = new Masina("Dacia", "Logan", 1300, 3500, 2005);
        masinaRepo.createMasina(masina1);
        masinaRulataRepo.createMasinaRulata(1,240000);

        Masina masina2 = new Masina("Mazda", "3", 1997, 18700, 2021);
        masinaRepo.createMasina(masina2);
        masinaNouaRepo.createMasinaNoua(2, 1650,8);

        Masina masina3 = new Masina("Toyota", "C-HR Hybrid", 1798, 25500, 2020);
        masinaRepo.createMasina(masina3);
        masinaNouaRepo.createMasinaNoua(3,2800,6);

        Masina masina4 = new Masina("Hyundai", "i30", 1376, 13100, 2019);
        masinaRepo.createMasina(masina4);
        masinaRulataRepo.createMasinaRulata(4, 64000);

        clientMasinaAgentVanzariRepo.createVanzare(1,3,2);
        clientMasinaAgentVanzariRepo.createVanzare(1,2,1);
        clientMasinaAgentVanzariRepo.createVanzare(2,1,2);
        clientMasinaAgentVanzariRepo.createVanzare(2,4,1);

        //Read dupa id
        System.out.println("-------------------");
        System.out.println("Select dupa id");
        clientRepo.selectClientById(2);
        System.out.println("-------------------");


        //Read toate
        System.out.println("-------------------");
        System.out.println("Select *");
        masinaNouaRepo.selectAllMasinaNoua();
        System.out.println("-------------------");

        //Update
        System.out.println("EXEMPLU UPDATE");
        System.out.println("Inainte de update pret = 3500");
        masinaRulataRepo.selectMasinaRulataById(1);
        System.out.println("-------------------");
        masinaRepo.updatePretMasina(3200, 1);
        System.out.println("Dupa update pret = 3200");
        masinaRulataRepo.selectMasinaRulataById(1);
        System.out.println("-------------------");


        //Delete
        clientMasinaAgentVanzariRepo.deleteVanzareById(3);


    }
}
