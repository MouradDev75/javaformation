package fr.dawan.apistream;

import fr.dawan.comparators.PeopleComparatorAgeAscendant;
import fr.dawan.comparators.PeopleComparatorAgeDescendant;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class app {
    public static void main(String[] args) throws Exception{
        /*
        Api Stream: permet d'effectuer des opérations sur une source de données (filtrer, transformer...),
        de récupérer le résultat final sans modifier la source de départ
        2 types de stream:
        - séquentiel
        - parallel
         */

        //Etape1: charger les données dans l'api stream

        // Stream à partir d'une liste de valeurs constantes
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

        // Stream à partir d'un tableau
        String[] array = {"a1", "a2", "a3"};
        Stream<String>  streamFromArray = Arrays.stream(array);

        // Stream à partir d'un fichier
        File file = new File("1.tmp");
        Stream<String> streamFromFile = Files.lines(Paths.get(file.getAbsolutePath()));

        //Stream à partir d'une collection: list, set, map.....
        Collection<String> collection = Arrays.asList("a1", "a2","a3");
        Stream<String> streamFromcollection = collection.stream();

        testFilterAndCount();
        testMap();
        testSkipAndLimit();
        testDistinct();
        testSorted();
    }

    private static void testSorted() {
        System.out.println(">>>>> Test Sorted:");
        Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a2");

        collection.stream()
                .sorted()
                .forEach(e -> System.out.println(e));

        collection.stream()
                .distinct()
                .sorted()
                .forEach(e -> System.out.println(e));

        System.out.println(">>> Inverser Sorted:");
        collection.stream()
                .sorted((s1,s2) -> -s1.compareTo(s2)).forEach(e -> System.out.println(e));

        List<People> peoples = new ArrayList<>();
        peoples.add(new People("William", 16, Sexe.MAN));
        peoples.add(new People("John", 26, Sexe.MAN));
        peoples.add(new People("Helene", 42, Sexe.WOMEN));
        peoples.add(new People("Peter", 69, Sexe.MAN));

        System.out.println(">>>> Age ascendant:");
        peoples.stream()
                .sorted(new PeopleComparatorAgeAscendant())
                .forEach(e -> System.out.println(e));

        System.out.println(">>>> Age descendant:");
        peoples.stream()
                .sorted(new PeopleComparatorAgeDescendant())
                .forEach(p -> System.out.println(p));

    }

    private static void testDistinct() {
        System.out.println(">>>>> Test Distinct:");
        Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a2");
        collection.stream()
                .distinct()
                .forEach(e -> System.out.println(e));
    }

    private static void testSkipAndLimit() {
        System.out.println(">>>>> Test Skip and Limit:");
        Collection<String> collection = Arrays.asList("a1","a2","a3","a4","a5");

        collection.stream()
                .limit(2)
                .forEach(s -> System.out.println(s));

        //pagination: affichez 2 éléments par page
        System.out.println(">> 2 premières chaines");
        collection.stream()
                .skip(0)
                .limit(2)
                .forEach(e -> System.out.println(e));

        System.out.println(">> 2 chaines suivantes:");
        collection.stream()
                .skip(2)
                .limit(2)
                .forEach(e -> System.out.println(e));



    }

    private static void testMap() {

        System.out.println(">>>>>>> Test Map:");
        List<People> peoples = new ArrayList<>();
        peoples.add(new People("William", 16, Sexe.MAN));
        peoples.add(new People("John", 26, Sexe.MAN));
        peoples.add(new People("Helene", 42, Sexe.WOMEN));
        peoples.add(new People("Peter", 69, Sexe.MAN));

        List<PeopleDto> dtos = peoples.stream()
                .map(p -> new PeopleDto(p.getName(), p.getAge()))
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
    }

    private static void testFilterAndCount() {
        System.out.println(">>>>>>>>>> Test filter and count:");
        Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a3");

        //compter le nombre de a1
        long nb = collection.stream()
                .filter(s -> s.equals("a1"))
                //.filter("a1"::equals)
                .count();
        System.out.println("nombre de a1 = "+nb);

        List<People> peoples = new ArrayList<>();
        peoples.add(new People("William", 16, Sexe.MAN));
        peoples.add(new People("John", 26, Sexe.MAN));
        peoples.add(new People("Helene", 42, Sexe.WOMEN));
        peoples.add(new People("Peter", 69, Sexe.MAN));

        //La liste et le nombre de people aptent pour le service militaire: âge entre 18 et 27 ans et de sexe masculin

        List<People> result = peoples.stream()
                .filter( p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getSexe().equals(Sexe.MAN))
                .collect(Collectors.toList());

        result.forEach(p -> System.out.println(p));
        System.out.println("nb service militaire: "+result.size());

        //Le nombre de people pouvant travailler: âge min 18 ans et max 60 pour les hommes et 55 pour les femmes
        long nbPeoplePouvantTravailler = peoples.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getSexe().equals(Sexe.WOMEN) && p.getAge() <= 55 || p.getSexe().equals(Sexe.MAN ) && p.getAge() <= 60)
                .count();
        System.out.println("nb people pouvant travailler: "+nbPeoplePouvantTravailler);
    }
}

