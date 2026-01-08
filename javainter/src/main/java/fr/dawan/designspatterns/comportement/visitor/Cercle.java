package fr.dawan.designspatterns.comportement.visitor;

public class Cercle implements Forme{
    @Override
    public void accept(Visitor v) {
        v.Visit(this);
    }

    /*
    public void exportXml(){
        //logic
    }*/


    /*
    public void exportJson(){
        //logic
    }*/
}
