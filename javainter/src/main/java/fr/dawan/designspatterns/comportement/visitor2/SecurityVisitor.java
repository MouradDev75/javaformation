package fr.dawan.designspatterns.comportement.visitor2;

public class SecurityVisitor implements Visitor<Compagny, SecurityReport>{
    @Override
    public SecurityReport visit(Compagny obj) {
        //contrôler les mesures de sécurité
        return new SecurityReport();
    }
}
