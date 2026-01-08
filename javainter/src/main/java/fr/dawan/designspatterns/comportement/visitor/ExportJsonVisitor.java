package fr.dawan.designspatterns.comportement.visitor;

public class ExportJsonVisitor implements Visitor{
//    @Override
//    public void Visit(Rectangle rec) {
//        //export json
//    }
//
//    @Override
//    public void Visit(Cercle cercle) {
//        //export json
//    }
//
//    @Override
//    public void Visit(Triangle t) {
//
//    }

    @Override
    public void Visit(Forme t) {
        t.accept(this);
    }
}
