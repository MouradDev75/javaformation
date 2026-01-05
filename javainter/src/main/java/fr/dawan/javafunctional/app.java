package fr.dawan.javafunctional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Genre{
    MASCULIN,
    FEMININ
}

class Personne{
    private String nom;
    private Genre genre;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Personne(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;
    }

    public Personne() {
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", genre=" + genre +
                '}';
    }
}

public class app {
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Marc", Genre.MASCULIN));
        personnes.add(new Personne("Julie", Genre.FEMININ));
        personnes.add(new Personne("David", Genre.MASCULIN));
        personnes.add(new Personne("Marie", Genre.FEMININ));

        System.out.println(">>>>> Approche impérative:");
        //Approche impérative: on doit au compilateur ce qu'il doit faire et comment le faire
        List<Personne> feminins = new ArrayList<>();

        for(Personne p : personnes){
            if(p.getGenre().equals(Genre.FEMININ)){
                feminins.add(p);
            }
        }

        for(Personne p : feminins){
            System.out.println(p);
        }

        System.out.println(">>>>> Approche déclarative (fonctionnelle):");
        //Approche déclarative: on déclare au compilateur ce qu'on veut sans lui dire comment le faire
        personnes
                .stream()
                .filter(p -> p.getGenre().equals(Genre.FEMININ))
                .collect(Collectors.toList())
                .forEach(p -> System.out.println(p));
        /*
        Approche fonctionnelle repose sur l'utilisation d'interfaces fonctionnelles
        Concept introduit depuis la version 8 de java (java.util.function)
        Interface fonctionnellene possède qu'une seule méthode à implémenter
        Pour pratiquer l'approche fonctionnele en Java, on utilise l'api Stream
         */

        //instancier une interface:

        //option1: utiliser une classe qui l'implémente

        ICalcul cal1 = new Calcul();

        //option2: utilise une classe anonyme -> syntaxe utiliser dans Android et dans les Threads


        ICalcul cal2 = new ICalcul() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };

        //option3: utiliser une expression lambda (méthode anonyme) : syntaxe utilisée dans les threads
        // (params) -> instructions;

        ICalcul cal3 = (a,b) -> a+b;

        //option4: utiliser le mécanisme de method reference -> syntaxe utilisée dans les threads

        //réferencer une méthode d'instance
        MyClasse instance = new MyClasse();
        ICalcul cal4 = instance::instanceMethode;

        //réferencer une méthode de classe (static)
        ICalcul cal5 = MyClasse::staticMethode;

/*
API: Application Programing Interfaces
 */

    }
}
