package fr.dawan.recflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class app {
    public static void main(String[] args) throws Exception {
        /*
        Reflection (introspection): mécanisme permettant de découvrir des types (classes) et d'invoquer leur
        membre à l'exécution
         */

        Class<Employe> employeClass = Employe.class;

        System.out.println(">>> Méthodes de la classe Employe:");
        Method[] methodes = employeClass.getMethods();
        for(Method m : methodes){
            System.out.println(m.getName());
        }

        System.out.println(">>> Attributs de la classe Employe:");
        Field[] fields = employeClass.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f.getName());
        }

        System.out.println(">>> Appelle de la méthode identite de la classe Employe:");
        Method methodIdentite = employeClass.getMethod("identite", null);

        //Appelle de la méthode d'instance identite:
        Employe emp = employeClass.getDeclaredConstructor().newInstance(); //appelle du constructeur sans params
        methodIdentite.invoke(emp, null);

        //Autre instance de employe
        Constructor<Employe> constructor = employeClass.getConstructor(String.class, String.class);
        Employe emp2 = constructor.newInstance("DUPONT", "Jean");
        methodIdentite.invoke(emp2, null);
    }
}
