package fr.dawan.designspatterns.comportement.visitor;

public class Rectangle implements Forme{
    @Override
    public void accept(Visitor v) {
        v.Visit(this);
    }

   /* public void exportXml(){
        //logic
    }*/

     /*
    public void exportJson(){
        //logic
    }*/
}
