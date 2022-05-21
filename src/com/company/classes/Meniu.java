package com.company.classes;

import java.util.Scanner;

import static com.company.services.MenuService.*;

public class Meniu{
    static Meniu meniu = new Meniu();
    private Meniu(){
    }

    public static Meniu getInstance(){
        return meniu;
    }

    public static void showMeniu() {
        Scanner scan = new Scanner(System.in);
        int initial = 0;
        while (initial!=50) {
            System.out.println("Meniu Interactiv");
            System.out.println("1. Adauga Client");
            System.out.println("2. Adauga Masina");
            System.out.println("3. Adauga Vanzare");
            System.out.println("4. Afisare Clienti");
            System.out.println("5. Afisare Masini");
            System.out.println("6. Afisare Istoric Vanzari");
            System.out.println("7. Sterge o vanzare din registru");
            System.out.println("8. Sterge un client din registru");
            System.out.println("9. Sterge o masina din registru");
            System.out.println("10. Afisare doar masini rulate");
            System.out.println("10. Terminare Program");
            initial = scan.nextInt();
            switch (initial) {
                case 1:
                    addClient();
                    break;
                case 2:
                    int tipMasina = 0;
                    while (tipMasina!=10) {
                        System.out.println("Meniu Adaugare Masini");
                        System.out.println("1. Adauga Masina Noua");
                        System.out.println("2. Adauga Masina Rulata");
                        System.out.println("10. Inapoi La Meniul Principal");
                        tipMasina = scan.nextInt();
                        switch (tipMasina) {
                            case 1:
                                System.out.println("Introduceti datele pentru o masina noua");
                                addMasinaNoua();
                                break;
                            case 2:
                                System.out.println("Introduceti datele pentru o masina rulata");
                                addMasinaRulata();
                                break;
                            case 10:
                                break;
                        }
                    }
                    break;
                case 3:
                    addVanzare();
                    break;
                case 4:
                    afisareClienti();
                    break;
                case 5:
                    afisareMasini();
                    break;
                case 6:
                    afisareVanzari();
                    break;
                case 7:
                    stergeVanzare();
                    break;
                case 8:
                    stergeClient();
                    break;
                case 9:
                    stergeMasina();
                    break;
                case 10:
                    afisareMasiniRulate();;
                    break;
                case 50:
                    System.out.println("Exitting...");
                    break;
            }
        }
    }
}
