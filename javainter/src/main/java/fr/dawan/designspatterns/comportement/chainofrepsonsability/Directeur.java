package fr.dawan.designspatterns.comportement.chainofrepsonsability;

public class Directeur extends Staff{


    public Directeur(String name, Staff successor) {
        super(name, successor);
    }

    @Override
    public void handleComplaint(ComplaintRequest request) {
        //peut traiter les demandes de niveau 3 et plus
        System.out.println(request.getMessage()+" traitée par le Directeur");
        request.setState(ComplaintState.CLOSE);
    }
}
