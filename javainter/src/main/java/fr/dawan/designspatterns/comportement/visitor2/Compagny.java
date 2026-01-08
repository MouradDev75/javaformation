package fr.dawan.designspatterns.comportement.visitor2;

import lombok.Data;

@Data
public class Compagny implements Element{

    private String name;
    private String mesureSecutiry;
    private double profitability;


    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
