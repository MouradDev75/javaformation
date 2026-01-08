package fr.dawan.designspatterns.comportement.chainofrepsonsability;

public class ResponsablePedago extends Staff{

    public ResponsablePedago(String name, Staff successor) {
        super(name, successor);
    }

    @Override
    public void handleComplaint(ComplaintRequest request) {
        //ne pet traiter que les demandes de niveau 2
        if(request.getComplaintType() == 2){
            System.out.println(request.getMessage()+" Req. traitée par le Responsable pédago.");
            request.setState(ComplaintState.CLOSE);
        }else{
            System.out.println("Req. transmise au Directeur");
            getSuccessor().handleComplaint(request);
        }
    }
}
