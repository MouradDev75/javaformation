package fr.dawan.designspatterns.creation;

public class LoggingSingleton {

    /*
    Eager: immédiatement
    l'instance est chargée en mémoire dès la première utilisation de la classe
     */

    private static LoggingSingleton instance;
    static{
        instance = new LoggingSingleton();
    }

    private LoggingSingleton(){

    }

    public static synchronized LoggingSingleton getInstance(){
        return instance;
    }

    public void info(String msg){

    }

    public void error(String msg){

    }
    public void warning(String msg){

    }
}
