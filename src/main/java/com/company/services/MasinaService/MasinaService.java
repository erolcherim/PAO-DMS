package com.company.services.MasinaService;

import com.company.classes.Masina;
import com.company.classes.MasinaNoua;
import com.company.classes.MasinaRulata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasinaService {
    public static List<Masina> masini = new ArrayList<Masina>();

    public static void addMasinaNoua(){
        System.out.println("Introduceti datele pentru o masina noua");
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
        masini.add(masinaCurenta);


    }

    public static void addMasinaRulata(){
        System.out.println("Introduceti datele pentru o masina rulata");
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
        masini.add(masinaCurenta);
    }

    public static Masina addMasina(){
        System.out.println("Introduceti datele pentru o masina noua");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti producatorul");
        String producator = scanner.nextLine();
        System.out.println("Introduceti modelul");
        String model = scanner.nextLine();
        System.out.println("Introduceti capacitatea cilindrica (cm3)");
        int capacitateCilindrica = scanner.nextInt();
        System.out.println("Introduceti anul de fabricatie");
        int anFabricatie = scanner.nextInt();
        System.out.println("Introduceti pretul(eur)");
        int pret = scanner.nextInt();

        Masina masinaCurenta = new Masina(producator, model, capacitateCilindrica, pret, anFabricatie);
        return masinaCurenta;
    }

    public static void stergeMasina(){
        System.out.println("Introduceti id-ul masinii ce trebuie sterse (id masina)");
        Scanner scanner = new Scanner(System.in);
        int idMasinaDeSters = scanner.nextInt();
        for (int i=0; i<masini.size(); i++){
            if (masini.get(i).getMasinaId()==idMasinaDeSters)
                System.out.println(String.format("Masina cu id-ul %s a fost stearsa",i+1));
            masini.remove(i);
        }
    }

    public static void afisareMasini(){
        System.out.println("Afisare masini");
        System.out.println(masini);
    }

    public static void afisareMasiniRulate(){
        System.out.println("Afisare masini In Parcul Auto Rulate");
        for (int n = 0; n < masini.size(); n++) {
            if (masini.get(n) instanceof MasinaRulata)
            {System.out.println(" " + masini.get(n));}
        }
    }
}
