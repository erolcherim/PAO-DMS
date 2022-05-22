package com.company.services.AgentVanzariService;

import com.company.classes.AgentVanzari;
import com.company.classes.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgentVanzariService {
    public static List<AgentVanzari> agentiVanzari = new ArrayList<AgentVanzari>();

    public static void addAgentVanzari(){
        System.out.println("Introduceti datele pentru un nou agent de vanzari");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti Numele");
        String nume = scanner.nextLine();
        System.out.println("Introduceti Prenumele");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti Data Nasterii");
        String dataNasterii = scanner.nextLine();
        System.out.println("Introduceti Numarul de Telefon");
        String numarTelefon = scanner.nextLine();
        System.out.println("Introduceti Adresa");
        String adresa = scanner.nextLine();
        System.out.println("Introduceti Anii de experienta");
        int aniExperienta = scanner.nextInt();
        System.out.println("Introduceti Comisionul");
        int comision = scanner.nextInt();
        System.out.println("Introduceti Salariul");
        int salariu = scanner.nextInt();

        Info infoAgentVanzariCurent = new Info(nume, prenume, dataNasterii, numarTelefon, adresa);
        AgentVanzari agentVanzariCurrent = new AgentVanzari(infoAgentVanzariCurent, salariu, aniExperienta, comision);

        agentiVanzari.add(agentVanzariCurrent);
    }

    public static void stergeAgentVanzari(){
        System.out.println("Introduceti id-ul agentului de vanzari ce trebuie sters (id agent)");
        Scanner scanner = new Scanner(System.in);
        int idAgentVanzariDeSters = scanner.nextInt();
        for (int i=0; i<agentiVanzari.size(); i++){
            if (agentiVanzari.get(i).getId()==idAgentVanzariDeSters)
                System.out.println(String.format("Agentul de vanzari cu id-ul %s a fost stears",i+1));
            agentiVanzari.remove(i);
        }
    }

    public static void afisareAgentiVanzari(){
        System.out.println("Afisare agenti vanzari");
        System.out.println(agentiVanzari);
    }

}
