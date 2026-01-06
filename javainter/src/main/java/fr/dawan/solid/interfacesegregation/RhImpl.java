package fr.dawan.solid.interfacesegregation;

import java.time.LocalDate;

public class RhImpl implements RhMetier{
    @Override
    public LocalDate getDateEmbauche() {
        return null;
    }

    @Override
    public String getContratType() {
        return "";
    }
}
