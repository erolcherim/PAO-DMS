package com.company.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.company.classes.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;


public class MenuService {

    public static List<Client> Clienti = new ArrayList<Client>();
    public static List<Masina> Masini = new ArrayList<Masina>();
    public static List<ClientMasina> Vanzari = new ArrayList<ClientMasina>();

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

        Clienti.add(clientCurent);
    }

    public static void addMasinaNoua(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti producatorul");
        String producator = scanner.nextLine();
        System.out.println("Introduceti modelul");
        String model = scanner.nextLine();
        System.out.println("Introduceti reducerea obtinuta prin programul rabla (eur)");
        int reducereRabla = scanner.nextInt();
        System.out.println("Introduceti timpul de asteptare pentru livrarea automobilului (luni)");
        int timpAsteptare = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti capacitatea cilindrica (cm3)");
        int capacitateCilindrica = scanner.nextInt();
        System.out.println("Introduceti anul de fabricatie");
        int anFabricatie = scanner.nextInt();
        System.out.println("Introduceti pretul(eur)");
        int pret = scanner.nextInt();

        Masina masinaCurenta = (Masina) new MasinaNoua(producator, model, capacitateCilindrica, pret, anFabricatie, reducereRabla, timpAsteptare);
        Masini.add(masinaCurenta);

    }

    public static void addMasinaRulata(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti producatorul");
        String producator = scanner.nextLine();
        System.out.println("Introduceti modelul");
        String model = scanner.nextLine();
        System.out.println("Introduceti capacitatea cilindrica (cm3)");
        int capacitateCilindrica = scanner.nextInt();
        System.out.println("Introduceti anul de fabricatie");
        int anFabricatie = scanner.nextInt();
        System.out.println("Introduceti rulajul (km)");
        int rulaj = scanner.nextInt();
        System.out.println("Introduceti pretul(eur)");
        int pret = scanner.nextInt();

        Masina masinaCurenta = (Masina) new MasinaRulata(producator, model, capacitateCilindrica, pret, anFabricatie, rulaj);
        Masini.add(masinaCurenta);
    }

    public static void addVanzare(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti cumparatorul (id-ul clientului)");
        int idClient = scanner.nextInt();
        System.out.println("Introduceti masina cumparata (id-ul masinii)");
        int idMasina = scanner.nextInt();

        Masina masinaCurenta = new Masina();
        Client clientCurent = new Client();
        for (int i=0; i<Masini.size(); i++){
            if(Masini.get(i).getMasinaId()==idMasina)
                masinaCurenta = Masini.get(i);
        }
        for (int i=0; i<Clienti.size(); i++){
            if(Clienti.get(i).getId()==idClient)
                clientCurent = Clienti.get(i);
        }
        /*daca se vinde o masina rulata aceasta este scoasa din oferta parcului */
        for (int i=0; i<Masini.size(); i++){
            if(Masini.get(i) instanceof MasinaRulata && Masini.get(i).getMasinaId()==idMasina)
                Masini.remove(i);
        }
        ClientMasina vanzare = new ClientMasina(clientCurent, masinaCurenta);
        Vanzari.add(vanzare);
    }

    public static void stergeClient() {
        System.out.println("Introduceti id-ul clientului ce trebuie sters (id client)");
        Scanner scanner = new Scanner(System.in);
        int idClientDeSters = scanner.nextInt();
        for (int i = 0; i < Clienti.size(); i++) {
            if (Clienti.get(i).getId() == idClientDeSters)
                System.out.println(String.format("Client-ul cu id-ul %s a fost sters", i + 1));
            Clienti.remove(i);
        }
    }

    public static void stergeMasina(){
        System.out.println("Introduceti id-ul masinii ce trebuie sterse (id masina)");
        Scanner scanner = new Scanner(System.in);
        int idMasinaDeSters = scanner.nextInt();
        for (int i=0; i<Masini.size(); i++){
            if (Masini.get(i).getMasinaId()==idMasinaDeSters)
                System.out.println(String.format("Masina cu id-ul %s a fost stearsa",i+1));
            Masini.remove(i);
        }
    }

    public static void stergeVanzare(){
        System.out.println("Introduceti id-ul vanzarii ce trebuie sterse (id vanzare)");
        Scanner scanner = new Scanner(System.in);
        int idVanzareDeSters = scanner.nextInt();
        for (int i=0; i<Vanzari.size(); i++){
            if (Vanzari.get(i).getClientMasinaId()==idVanzareDeSters)
                System.out.println(String.format("Vanzarea cu id-ul %s a fost stearsa",i+1));
            Vanzari.remove(i);
        }
    }

    public static void afisareClienti(){
        System.out.println("Afisare Clienti");
        System.out.println(Clienti);
    }

    public static void afisareMasini(){
        System.out.println("Afisare Masini");
        System.out.println(Masini);
    }

    public static void afisareMasiniRulate(){
        System.out.println("Afisare Masini In Parcul Auto Rulate");
        for (int n = 0; n < Masini.size(); n++) {
            if (Masini.get(n) instanceof MasinaRulata)
            {System.out.println(" " + Masini.get(n));}
        }
    }
    public static void afisareVanzari(){
        System.out.println("Afisare istoric vanzari");
        System.out.println(Vanzari);
    }
}
