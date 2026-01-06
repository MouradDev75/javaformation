package fr.dawan.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class app {

    static int total = 0;

    public static void main(String[] args) throws Exception{
        /*
        Processus: est un programme en cours d'exécution contenant au moins une tâche
        Thread: est une unité physique d'exécution d'une tâche
         */



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("tâche1..........."+Thread.currentThread().getName());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("tâche2............."+Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();

        t1.join(); //join: met en attente le main thread
        t2.join();


        System.out.println("tâche principale................."+Thread.currentThread().getName());

        /*
        Le multi threading permet d'obtenir des applications responsives (non bloquantes)
         */
        System.out.println("Gestion des accès concurrentiels à des ressources partagées:");

        Thread th1 = new Thread(app::addMillion);
        Thread th2 = new Thread(app::addMillion);
        Thread th3 = new Thread(app::addMillion);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println("Total = "+total);

        /*
        Lancer 100 copies de fichiers en parallel
         */
        String src1 = "a.txt";
        String src2 = "b.txt";
        String src3 = "c.txt";
        String src4 = "d.txt";

        String dest1 = "e.txt";
        String dest2 = "f.txt";
        String dest3 = "g.txt";
        String dest4 = "h.txt";

        /*
        Java propose la possibilité de définir un réservoir de thread (ThreadPool)
        pour gérer des tâches asynchrones
        Si aucun threan n'est disponible, la tâche est mise en attene dans une file d'attente
         */
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Thread copy1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileTool.copy(src1,dest1);
                    System.out.println("copy1......."+Thread.currentThread().getName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread copy2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileTool.copy(src2,dest2);
                    System.out.println("copy2......."+Thread.currentThread().getName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread copy3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileTool.copy(src3,dest3);
                    System.out.println("copy3......."+Thread.currentThread().getName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread copy4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileTool.copy(src4,dest4);
                    System.out.println("copy4......."+Thread.currentThread().getName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        pool.execute(copy1);
        pool.execute(copy2);
        pool.execute(copy3);
        pool.execute(copy4);

        /*
        Exécuter une tâche asynchrone et récupérer un résultat à la fin de cette tâche
         */

        int x = 10;
        int y = 20;
        int resultat = 0;

        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return x+y;
            }
        });

        resultat = future.get();

        System.out.println("Résultat = "+resultat);


        pool.shutdown(); //libérer les threads monopolisés par le réservoir de threads
        /*
        Thread ne gère que des tâche void
        ThreadPool: gère les 2 types de tâches (void et non void)
         */
    }

    //synchronized: demande à la JVM d'exécuter cette méthode en mode synchrone
    static synchronized void addMillion(){
        for (int i = 0; i < 100000; i++) {
            total++;
        }
    }
}
