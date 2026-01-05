package fr.dawan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
RUNTIME: annotation conservée dans le fichier .class et utilisée lors de l'exécution
CLASS: annotation conservée dans le fichier .class et ignorée lors de l'exécution -> prise en compte uniquement lors de la compilation
SOURCE: annotation ignorée par le compilateur et ignorée dans le fichier .class
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VeryImportant {
}
