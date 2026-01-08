package fr.dawan.designspatterns.comportement.visitor;

public class Elipse implements Forme{
    @Override
    public void accept(Visitor v) {
        v.Visit(this);
    }
}
