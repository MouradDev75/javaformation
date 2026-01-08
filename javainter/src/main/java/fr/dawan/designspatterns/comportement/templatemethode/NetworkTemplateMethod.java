package fr.dawan.designspatterns.comportement.templatemethode;

/**
 * classe qui décrit le rôle du pattern template Method
 */
public abstract class NetworkTemplateMethod {

    String userName;
    String password;

    public NetworkTemplateMethod(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //Etapes de l'algorithe pour envoyer un msg
    //Découpage de en plusieurs étapes -> chaque étape devient une méthode
    abstract boolean login(String userName, String password);
    abstract boolean sendMessage(byte[] msg);
    abstract void logout();

    //Template Method pour déclencher l'appel des 3 méthodes
    //La seule méthode appelée dans le code
    public boolean post(String msg){
        //login
        if(login(userName, password)){

            //sendMessage
            boolean result = sendMessage(msg.getBytes());

            //logout
            logout();

            return result;
        }

        return false;
    }
}
