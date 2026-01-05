package fr.dawan.annotations;

import fr.dawan.genericite.Produit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {

    int times() default 1; //sans valeur par défaut le param est obligatoire


    /*
    les attributs d'une annotation sont limités aux types suivants:
    - types primitifs: int, boolean, char....
    - string
    - enum
    - un tableau des types mentionnés
     */
}
