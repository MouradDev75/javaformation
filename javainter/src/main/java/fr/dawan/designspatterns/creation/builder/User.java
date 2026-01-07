package fr.dawan.designspatterns.creation.builder;


public class User {

    private String lastName; //required
    private String firstName; //required
    private String phone; //optional
    private String adresse; //optional
    private int age; //optional

    /*
    Option1: la classe gère sa propre instanciation
    User(lastName,firstName)
    User(lastName,firstName,phone)
    User(lastName,firstName,phone,adresse)
    User(lastName,firstName,phone,adresse,age)
     */
    /*
    Option2: dééguer la tâche d'instanciation de la classe à une autre classe: pattern builder
    1- vérrouiller au constructeur par défaut
    2- définir une classe interne static qui va initialiser tous les attributs de l'instance à construire
    3- Dans la classe à instancier, définir une méthode qui renvoie le builder
     */

    private User(){

    }

    public static UserBuilder builder(String lastName, String firstName){

        return new UserBuilder(lastName,firstName);
    }

    public static class  UserBuilder{
        private User user;

        //gestion des attributs recquis
        public UserBuilder(String lastName,String firstName){
            user = new User();
            user.lastName = lastName;
            user.firstName = firstName;
        }

        /*
        définir une méthode pour chaque attribut optionnel
         */
        public UserBuilder withPhone(String phone){
            user.phone = phone;
            return this;
        }

        public UserBuilder withAdresse(String adresse){
            user.adresse = adresse;
            return this;
        }

        public UserBuilder withAge(int age){
            user.age = age;
            return this;
        }

        //méthode qui renvoie l'objet construit
        public User build(){
            return this.user;
        }

    }


}
