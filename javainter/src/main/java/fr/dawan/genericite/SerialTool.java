package fr.dawan.genericite;

/*
Sérialisation: mécanisme permettant de sauvegarder l'état d'un objet dans un support physique de persistance
3 types de sérialisation:
binaire
xml
json
Java propose 2 types de flux pour manipuler les fichiers:
flux binaires: lecture/écriture char/char: FileInputStream - FileOutputStream
flux caractères: lecture/écritue ligne/ligne: FileReader - FileWriter

Obligation: une ressource doit être libérée à la fin de son utilisation (fermeture du flux)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialTool {

    public static void copy(String src, String cible){
        try{

            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(cible);

            int tmp = fis.read();
            while (tmp != -1){
                fos.write(tmp);
                tmp = fis.read();
            }

            fis.close();
            fos.close();

        }catch (Exception e){

        }
    }

    public static void copy2(String src, String cible){
        try{

            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(cible);

            //bonne pratique: prévoir un buffer pour les léctire/écriture
            BufferedReader br = new BufferedReader(fr, 16384);
            BufferedWriter bw = new BufferedWriter(fw, 16384);

            String ligne = br.readLine();
            while(ligne != null){
                bw.write(ligne);
                ligne = br.readLine();
            }

            br.close();
            bw.close();

        }catch (Exception e){

        }
    }

    public static void exportBin(List<Produit> lst, String chemin){
        try{
            FileOutputStream fos = new FileOutputStream(chemin);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lst);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Produit> importBin(String chemin){
        List<Produit> lst = new ArrayList<>();
        try {

            FileInputStream fis = new FileInputStream(chemin);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lst = (List<Produit>) ois.readObject();

            ois.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        return lst;
    }
}
