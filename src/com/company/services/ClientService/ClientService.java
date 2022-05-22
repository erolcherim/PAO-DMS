package com.company.services.ClientService;

import com.company.classes.Client;
import com.company.classes.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService{
    public static List<Client> clienti = new ArrayList<Client>();

    public static void addClient(){
        System.out.println("Introduceti datele pentru un nou client");
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

        Info infoClientCurent = new Info(nume, prenume, dataNasterii, numarTelefon, adresa);
        Client clientCurent = new Client(infoClientCurent);

        clienti.add(clientCurent);
    }

    public static void stergeClient() {
        System.out.println("Introduceti id-ul clientului ce trebuie sters (id client)");
        Scanner scanner = new Scanner(System.in);
        int idClientDeSters = scanner.nextInt();
        for (int i = 0; i < clienti.size(); i++) {
            if (clienti.get(i).getId() == idClientDeSters)
                System.out.println(String.format("Client-ul cu id-ul %s a fost sters", i + 1));
            clienti.remove(i);
        }
    }

    public static void afisareClienti(){
        System.out.println("Afisare clienti");
        System.out.println(clienti);
    }
}