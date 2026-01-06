package fr.dawan.demeter;

import java.util.ArrayList;
import java.util.List;

/*
Loi Demeter:
Une classe ne doit interagir qu'avec les classes amies
Une méthode d'une classe ne peut utiliser:
- que les attributs de classe
- que ses propres paramètres
- que ses variables locales
 */

public class School {
    private List<Grade> grades = new ArrayList<>();

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    //méthode qui renvoie le nbre total de students dans l'école

    public int coutStudents(){
        int count  = 0;

        for(Grade grade : grades){
            for(StudentClass classe : grade.getClasses()){
                for(Student s : classe.getStudents()){
                    count++;
                }
            }
        }

        return count;
    }

    //version respectant Loi Demeter
    public int studentsCount(){
        int count = 0;
        for(Grade grade : grades){
            count = grade.studentsCount();
        }

        return count;
    }
}
