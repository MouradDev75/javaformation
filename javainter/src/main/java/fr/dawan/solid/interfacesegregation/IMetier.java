package fr.dawan.solid.interfacesegregation;

import java.time.LocalDate;
import java.util.List;

public interface IMetier {
    List<User> getAll();
    void insert(User u);
    LocalDate getDateEmbauche();
    String getContratType();
}
