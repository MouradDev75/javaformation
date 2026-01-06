package fr.dawan.encapsulation;

/*
2 types de classes: objet et service + 2 classes particulières (abstraite et interface)
 */
public class Test {
    //y est une variable de classe (globale): pas besoin de l'initialiser car elle possède une valeur par défaut
    /*
    types numériques: 0
    type boolean: false
    types complèxes (objets): null
     */
    int y;

    public void mIntance(){
        //x est une variable locale qui doit être initialisée
        int x = 0;
        System.out.println(y);
    }

    public static void mClasse(){

    }
}
