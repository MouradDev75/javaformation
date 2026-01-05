package fr.dawan.genericite;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SerialToolGeneric {

    public static <T extends Serializable> void exportBinGeneric(List<T> lst, String chemin){
        try{
            FileOutputStream fos = new FileOutputStream(chemin);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lst);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> List<T> importBinGeneric(String chemin){
        List<T> lst = new ArrayList<>();
        try {

            FileInputStream fis = new FileInputStream(chemin);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lst = (List<T>) ois.readObject();

            ois.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        return lst;
    }

    public static <T extends Serializable> void exportCsv(List<T> lst, String chemin, String separateur){

        /*
        1,PC DELL
        2,Ecran HP
         */
        try{

            FileWriter fw = new FileWriter(chemin);
            BufferedWriter bw = new BufferedWriter(fw);

            //convertir chaque prouit en ligne -> insérer la ligne dans le fichier
            for(T obj : lst){
                Class<?> clazz = obj.getClass();
                Field[] fields = clazz.getDeclaredFields();

                StringBuilder sb = new StringBuilder();
                for(Field f : fields){
                    //construire la ligne à insérer dans le fichier csv
                    f.setAccessible(true); //les attributs sont private dans une classe
                    sb.append(f.get(obj).toString()).append(separateur);
                    //1,PC Dell,
                }
                //suppression du dernier séparateur
                String ligne = sb.substring(0, sb.length() - 1)+"\n";
                bw.write(ligne);

            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //désérialisation CSV
    public static List<Produit> importCsv(String chemin, String separateur){
        /*
        Lecture igne par ligne
        Convertir chaque ligne en produit
        insérer le produit dans la liste
         */

        List<Produit> lst = new ArrayList<>();
        try{

            FileReader fr = new FileReader(chemin);
            BufferedReader br = new BufferedReader(fr);
            String ligne = br.readLine();
            while(ligne != null){
                //1,PC Dell
                String[] tab = ligne.split(separateur);
                Produit p = new Produit(Integer.parseInt(tab[0]), tab[1]);
                lst.add(p);
                ligne = br.readLine();
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
}
