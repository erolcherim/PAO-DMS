package com.company.classes;

import com.company.services.LoggerService.LoggerService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.company.services.ClientMasinaAgentVanzariService.ClientMasinaAgentVanzariService.*;
import static com.company.services.ClientService.ClientService.*;
import static com.company.services.MasinaService.MasinaService.*;
import static com.company.services.AgentVanzariService.AgentVanzariService.*;

public class Menu {
    static Menu meniu = new Menu();
    private Menu(){
    }
    public static Menu getInstance(){
        return meniu;
    }
    LoggerService loggerService = new LoggerService();

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

