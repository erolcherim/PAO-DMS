package com.company.classes;

import com.company.repository.*;
import com.company.services.LoggerService.LoggerService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.company.services.ClientMasinaAgentVanzariService.ClientMasinaAgentVanzariService.*;
import static com.company.services.ClientService.ClientService.*;
import static com.company.services.MasinaService.MasinaService.*;
import static com.company.services.AgentVanzariService.AgentVanzariService.*;


public class Menu {
    InfoRepository infoRepo = InfoRepository.getInstance();
    ClientRepository clientRepo = ClientRepository.getInstance();
    AgentVanzariRepository agentRepo = AgentVanzariRepository.getInstance();
    MasinaRepository masinaRepo = MasinaRepository.getInstance();
    MasinaNouaRepository masinaNouaRepo = MasinaNouaRepository.getInstance();
    MasinaRulataRepository masinaRulataRepo = MasinaRulataRepository.getInstance();
    ClientMasinaAgentVanzariRepository clientMasinaAgentVanzariRepo = ClientMasinaAgentVanzariRepository.getInstance();


    static Menu meniu = new Menu();
    private Menu(){
    }
    public static Menu getInstance(){
        return meniu;
    }
    LoggerService loggerService = new LoggerService();

    public void showMeniuDB() {
        //TBD
        Scanner scan = new Scanner(System.in);
        int tip = 0;
        while (tip!=100) {
            System.out.println("Meniu Interactiv");
            System.out.println("1. Operatiuni Clienti");
            System.out.println("2. Operatiuni Masini");
            System.out.println("3. Operatiuni AgentiVanzari");
            System.out.println("4. Operatiuni Vanzari");
            System.out.println("5. Creare Tabele + Populare (demo)");
            System.out.println("6. Drop all tables");
            System.out.println("100. Terminare Program");
            tip = scan.nextInt();
            try {
                switch (tip) {
                    case 1:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Clienti");
                            System.out.println("1. Adauga Un Nou Client");
                            System.out.println("2. Sterge Un Client");
                            System.out.println("3. Afisare Clienti");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addClient();
                                    loggerService.log("addClient()");
                                    break;
                                case 2:
                                    stergeClient();
                                    loggerService.log("stergeClient");
                                    break;
                                case 3:
                                    afisareClienti();
                                    loggerService.log("afisareClienti()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 2:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Masini");
                            System.out.println("1. Adauga Masina Noua");
                            System.out.println("2. Adauga Masina Rulata");
                            System.out.println("3. Sterge Masina");
                            System.out.println("4. Afisare masini (toate)");
                            System.out.println("5. Afisare masini (rulate)");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    //TBD
                                    break;
                                case 2:
                                    addMasinaRulata();
                                    loggerService.log("addMasinaRulata()");
                                    break;
                                case 3:
                                    stergeMasina();
                                    loggerService.log("stergeMasina()");
                                    break;
                                case 4:
                                    afisareMasini();
                                    loggerService.log("afisareMasini()");
                                    break;
                                case 5:
                                    afisareMasiniRulate();
                                    loggerService.log("afisareMasiniRulate()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Agenti Vanzari");
                            System.out.println("1. Adauga Un Nou Agent de Vanzari");
                            System.out.println("2. Sterge Un Agent de Vanzari");
                            System.out.println("3. Afisare Agenti Vanzari");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addAgentVanzari();
                                    loggerService.log("addAgentVanzari()");
                                    break;
                                case 2:
                                    stergeAgentVanzari();
                                    loggerService.log("stergeAgentVanzari()");
                                    break;
                                case 3:
                                    afisareAgentiVanzari();
                                    loggerService.log("afisareAgentiVanzari()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 4:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Vanzari");
                            System.out.println("1. Adauga O noua Vanzare");
                            System.out.println("2. Sterge O Vanzare");
                            System.out.println("3. Afisare Vanzari");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addVanzare();
                                    loggerService.log("addVanzare()");
                                    break;
                                case 2:
                                    stergeVanzare();
                                    loggerService.log("stergeVanzare()");
                                    break;
                                case 3:
                                    afisareVanzari();
                                    loggerService.log("afisareVanzari()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Creating Tables...");
                        infoRepo.createTable();
                        clientRepo.createTable();
                        agentRepo.createTable();
                        masinaRepo.createTable();
                        masinaNouaRepo.createTable();
                        masinaRulataRepo.createTable();
                        clientMasinaAgentVanzariRepo.createTable();

                        System.out.println("Inserting values...");
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
                        break;
                    case 6:
                        System.out.println("Dropping tables...");
                        clientMasinaAgentVanzariRepo.dropTable();
                        clientRepo.dropTable();
                        agentRepo.dropTable();
                        infoRepo.dropTable();
                        masinaNouaRepo.dropTable();
                        masinaRulataRepo.dropTable();
                        masinaRepo.dropTable();
                        break;
                    case 100:
                        System.out.println("Exitting...");
                        loggerService.log("Program terminated successfully");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public void showMeniu() {
        Scanner scan = new Scanner(System.in);
        int tip = 0;
        while (tip!=100) {
            System.out.println("Meniu Interactiv");
            System.out.println("1. Operatiuni Clienti");
            System.out.println("2. Operatiuni Masini");
            System.out.println("3. Operatiuni AgentiVanzari");
            System.out.println("4. Operatiuni Vanzari");
            System.out.println("100. Terminare Program");
            tip = scan.nextInt();
            try {
                switch (tip) {
                    case 1:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Clienti");
                            System.out.println("1. Adauga Un Nou Client");
                            System.out.println("2. Sterge Un Client");
                            System.out.println("3. Afisare Clienti");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addClient();
                                    loggerService.log("addClient()");
                                    break;
                                case 2:
                                    stergeClient();
                                    loggerService.log("stergeClient");
                                    break;
                                case 3:
                                    afisareClienti();
                                    loggerService.log("afisareClienti()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 2:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Masini");
                            System.out.println("1. Adauga Masina Noua");
                            System.out.println("2. Adauga Masina Rulata");
                            System.out.println("3. Sterge Masina");
                            System.out.println("4. Afisare masini (toate)");
                            System.out.println("5. Afisare masini (rulate)");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addMasinaNoua();
                                    loggerService.log("addMasinaNoua()");
                                    break;
                                case 2:
                                    addMasinaRulata();
                                    loggerService.log("addMasinaRulata()");
                                    break;
                                case 3:
                                    stergeMasina();
                                    loggerService.log("stergeMasina()");
                                    break;
                                case 4:
                                    afisareMasini();
                                    loggerService.log("afisareMasini()");
                                    break;
                                case 5:
                                    afisareMasiniRulate();
                                    loggerService.log("afisareMasiniRulate()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Agenti Vanzari");
                            System.out.println("1. Adauga Un Nou Agent de Vanzari");
                            System.out.println("2. Sterge Un Agent de Vanzari");
                            System.out.println("3. Afisare Agenti Vanzari");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addAgentVanzari();
                                    loggerService.log("addAgentVanzari()");
                                    break;
                                case 2:
                                    stergeAgentVanzari();
                                    loggerService.log("stergeAgentVanzari()");
                                    break;
                                case 3:
                                    afisareAgentiVanzari();
                                    loggerService.log("afisareAgentiVanzari()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 4:
                        tip = 0;
                        while (tip != 10) {
                            System.out.println("Meniu Operatiuni Vanzari");
                            System.out.println("1. Adauga O noua Vanzare");
                            System.out.println("2. Sterge O Vanzare");
                            System.out.println("3. Afisare Vanzari");
                            System.out.println("10. Inapoi La Meniul Principal");
                            tip = scan.nextInt();
                            switch (tip) {
                                case 1:
                                    addVanzare();
                                    loggerService.log("addVanzare()");
                                    break;
                                case 2:
                                    stergeVanzare();
                                    loggerService.log("stergeVanzare()");
                                    break;
                                case 3:
                                    afisareVanzari();
                                    loggerService.log("afisareVanzari()");
                                    break;
                                case 10:
                                    break;
                            }
                        }
                        break;
                    case 100:
                        System.out.println("Exitting...");
                        loggerService.log("Program terminated successfully");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

