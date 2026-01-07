package fr.dawan.designspatterns.creation.factory;

public class ComputerFactory {
    /*
    Classe qui gère le processus de création d'objets enfants
     */

    /*
    Méthode qui ne respecte le open/close
     */
    public Computer getcomputer(String computer){

        if(computer.equalsIgnoreCase("laptop")){
            return new Laptop();
        }else if(computer.equalsIgnoreCase("phone")){
            return new Phone();
        }else if(computer.equalsIgnoreCase("smarttv")){
            return new SmartTv();
        }

        return  null;
    }

    //solution:
    public Computer getComputer(Class<? extends Computer> clazz) throws Exception {
        /*
        Si une des classes filles ne possède pas de constructeur par défaut,
        cette méthode génère une exception
        Possibilité d'utiliser la reflection pour initialiser les attributs des classes filles
         */

        return clazz.getDeclaredConstructor().newInstance();
    }
}
