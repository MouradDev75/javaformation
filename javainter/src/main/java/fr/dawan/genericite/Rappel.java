package fr.dawan.genericite;

public class Rappel {

    public static void divide(int x) throws Exception {
        //option1: la méthode gère sa propre exception
        /*
        try {
            System.out.println(10 / x);
        } catch (Exception e) {
            e.printStackTrace();
            //garder une trace dans les logs
        }

         */

        //option2: faire une remontée d'exception
        if(x != 0){
            System.out.println(10 / x);
        }else{
            //thorw: mot clé permattant de declancher une exception
            throw new Exception("Attention, division par 0");
        }
    }
}
