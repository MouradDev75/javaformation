package fr.dawan.designspatterns.comportement.chainofrepsonsability;

public class Teacher extends Staff{

    public Teacher(String name, Staff successor) {
        super(name, successor);
    }

    @Override
    public void handleComplaint(ComplaintRequest request) {

        //ne peut traiter que les demandes de niveau 1
        if(request.getComplaintType()==1){
            System.out.println(request.getMessage()+" Req. traitée par le Teacher");
            request.setState(ComplaintState.CLOSE);
        }else{
            System.out.println("Req. transmise au succésseur (Responsable Pédago.)");
            getSuccessor().handleComplaint(request);
        }
    }
}
