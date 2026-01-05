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

    public static <T extends Serializable> void exportCsvGeneric(List<T> lst, String chemin, String separateur){

        try{

            FileWriter fw = new FileWriter(chemin);
            BufferedWriter bw = new BufferedWriter(fw);

            //convertir chaque produit en ligne -> insérer la ligne dans le fichier
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
    public static <T extends Serializable> List<T> importCsvGeneric(String chemin, String separateur, Class<T> clazz){
        /*
        Lecture ligne par ligne
        Convertir chaque ligne en objet de type T
        insérer l'objet T dans la liste
         */

        List<T> lst = new ArrayList<>();
        try{

            FileReader fr = new FileReader(chemin);
            BufferedReader br = new BufferedReader(fr);
            String ligne = br.readLine();
            while(ligne != null){

                String[] tab = ligne.split(separateur); // tab: contient les valeurs des attributs de l'objet

                //["1", "PC Dell"]

                //récupérer les attributs de l'objet T
                T obj = clazz.getDeclaredConstructor().newInstance();
                Field[] fields = clazz.getDeclaredFields();

                int i = 0;

                for(Field f : fields){
                    f.setAccessible(true); //activer les get/set

                    Class<?> type = f.getType();
                    if(type.equals(Integer.class)){
                       f.set(obj, Integer.parseInt(tab[i]));
                    }else if(type.equals(int.class)){
                        f.set(obj, Integer.parseInt(tab[i]));
                    }else if(type.equals(String.class)){
                        f.set(obj, tab[i]);
                    }else if(type.equals(Double.class)){
                        f.set(obj, Double.parseDouble(tab[i]));
                    }else if(type.equals(double.class)){
                        f.set(obj, Double.parseDouble(tab[i]));
                    }else if(type.equals(Boolean.class)){
                        f.set(obj, Boolean.parseBoolean(tab[i]));
                    }

                    i++;
                }

                lst.add(obj);
                ligne = br.readLine();
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
}
