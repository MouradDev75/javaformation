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

    public static void main(String[] args) {
        /*
        Le type String par définition est immuable
         */
        String s = "test";
        s.toUpperCase();
        s.toLowerCase();

        System.out.println(s);

        //StringBuilder est muable
        StringBuilder sb = new StringBuilder();
        sb.append("t");
        sb.append("es");
        sb.append("t");

        System.out.println(sb.toString());
    }
}
