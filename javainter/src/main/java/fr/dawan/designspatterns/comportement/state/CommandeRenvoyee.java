package fr.dawan.designspatterns.comportement.state;

public class CommandeRenvoyee implements CommandeState{
    @Override
    public void next(Commande cmd) {
        System.out.println("Commande renvoyée...");
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandeRecue());
    }

    @Override
    public void printState() {
        System.out.println("Le client n'est pas satisfait de la commande reçue......");
    }
}
