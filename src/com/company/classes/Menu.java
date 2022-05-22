package com.company.classes;

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

    public static void showMeniu() {
        Scanner scan = new Scanner(System.in);
        int initial = 0;
        while (initial!=10) {
            System.out.println("Meniu Interactiv");
            System.out.println("1. Operatiuni Clienti");
            System.out.println("2. Operatiuni Masini");
            System.out.println("3. Operatiuni AgentiVanzari");
            System.out.println("4. Operatiuni Vanzari");
            System.out.println("10. Terminare Program");
            initial = scan.nextInt();
            switch (initial) {
                case 1:
                    int tipOperatiuneClient = 0;
                    while (tipOperatiuneClient!=10) {
                        System.out.println("Meniu Operatiuni Clienti");
                        System.out.println("1. Adauga Un Nou Client");
                        System.out.println("2. Sterge Un Client");
                        System.out.println("3. Afisare Clienti");
                        System.out.println("10. Inapoi La Meniul Principal");
                        tipOperatiuneClient = scan.nextInt();
                        switch (tipOperatiuneClient) {
                            case 1:
                                addClient();
                                break;
                            case 2:
                                stergeClient();
                                break;
                            case 3:
                                afisareClienti();
                                break;
                            case 10:
                                break;
                        }
                    }
                    break;
                case 2:
                    int tipOperatiuneMasina = 0;
                    while (tipOperatiuneMasina!=10) {
                        System.out.println("Meniu Operatiuni Masini");
                        System.out.println("1. Adauga Masina Noua");
                        System.out.println("2. Adauga Masina Rulata");
                        System.out.println("3. Sterge Masina");
                        System.out.println("4. Afisare masini (toate)");
                        System.out.println("5. Afisare masini (rulate)");
                        System.out.println("10. Inapoi La Meniul Principal");
                        tipOperatiuneMasina = scan.nextInt();
                        switch (tipOperatiuneMasina) {
                            case 1:
                                addMasinaNoua();
                                break;
                            case 2:
                                addMasinaRulata();
                                break;
                            case 3:
                                stergeMasina();
                                break;
                            case 4:
                                afisareMasini();
                                break;
                            case 5:
                                afisareMasiniRulate();
                                break;
                            case 10:
                                break;
                        }
                    }
                    break;
                case 3:
                    int tipOperatiuneAgentVanzari = 0;
                    while (tipOperatiuneAgentVanzari!=10) {
                        System.out.println("Meniu Operatiuni Agenti Vanzari");
                        System.out.println("1. Adauga Un Nou Agent de Vanzari");
                        System.out.println("2. Sterge Un Agent de Vanzari");
                        System.out.println("3. Afisare Agenti Vanzari");
                        System.out.println("10. Inapoi La Meniul Principal");
                        tipOperatiuneAgentVanzari = scan.nextInt();
                        switch (tipOperatiuneAgentVanzari) {
                            case 1:
                                addAgentVanzari();
                                break;
                            case 2:
                                stergeAgentVanzari();
                                break;
                            case 3:
                                afisareAgentiVanzari();
                                break;
                            case 10:
                                break;
                        }
                    }
                    break;
                case 4:
                    int tipOperatiuneVanzari = 0;
                    while (tipOperatiuneVanzari!=10) {
                        System.out.println("Meniu Operatiuni Vanzari");
                        System.out.println("1. Adauga O noua Vanzare");
                        System.out.println("2. Sterge O Vanzare");
                        System.out.println("3. Afisare Vanzari");
                        System.out.println("10. Inapoi La Meniul Principal");
                        tipOperatiuneVanzari = scan.nextInt();
                        switch (tipOperatiuneVanzari) {
                            case 1:
                                addVanzare();
                                break;
                            case 2:
                                stergeVanzare();
                                break;
                            case 3:
                                afisareVanzari();
                                break;
                            case 10:
                                break;
                        }
                    }
                    break;
                case 50:
                    System.out.println("Exitting...");
                    break;
            }
        }
    }
}
