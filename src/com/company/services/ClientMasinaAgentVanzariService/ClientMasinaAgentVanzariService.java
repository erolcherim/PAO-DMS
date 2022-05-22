package com.company.services.ClientMasinaAgentVanzariService;

import com.company.classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.services.AgentVanzariService.AgentVanzariService.agentiVanzari;
import static com.company.services.ClientService.ClientService.clienti;
import static com.company.services.MasinaService.MasinaService.masini;

public class ClientMasinaAgentVanzariService {
    public static List<ClientMasinaAgentVanzari> vanzari = new ArrayList<ClientMasinaAgentVanzari>();

    public static void addVanzare(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti cumparatorul (id-ul clientului)");
        int idClient = scanner.nextInt();
        System.out.println("Introduceti masina cumparata (id-ul masinii)");
        int idMasina = scanner.nextInt();
        System.out.print("Introduceti agentul de vanzari (id-ul agentului)");
        int idAgentVanzari = scanner.nextInt();

        Masina masinaCurenta = new Masina();
        Client clientCurent = new Client();
        AgentVanzari agentVanzariCurrent = new AgentVanzari();

        for (int i=0; i<masini.size(); i++){
            if(masini.get(i).getMasinaId()==idMasina)
                masinaCurenta = masini.get(i);
        }
        for (int i=0; i<clienti.size(); i++){
            if(clienti.get(i).getId()==idClient)
                clientCurent = clienti.get(i);
        }

        for (int i=0; i<agentiVanzari.size(); i++){
            if(agentiVanzari.get(i).getId()==idAgentVanzari)
                agentVanzariCurrent = agentiVanzari.get(i);
        }
        /*daca se vinde o masina rulata aceasta este scoasa din oferta parcului */
        for (int i=0; i<masini.size(); i++){
            if(masini.get(i) instanceof MasinaRulata && masini.get(i).getMasinaId()==idMasina)
                masini.remove(i);
        }
        ClientMasinaAgentVanzari vanzare = new ClientMasinaAgentVanzari(clientCurent, masinaCurenta, agentVanzariCurrent);
        vanzari.add(vanzare);
    }





    public static void stergeVanzare(){
        System.out.println("Introduceti id-ul vanzarii ce trebuie sterse (id vanzare)");
        Scanner scanner = new Scanner(System.in);
        int idVanzareDeSters = scanner.nextInt();
        for (int i=0; i<vanzari.size(); i++){
            if (vanzari.get(i).getClientMasinaId()==idVanzareDeSters)
                System.out.println(String.format("Vanzarea cu id-ul %s a fost stearsa",i+1));
            vanzari.remove(i);
        }
    }


    public static void afisareVanzari(){
        System.out.println("Afisare istoric vanzari");
        System.out.println(vanzari);
    }
}
