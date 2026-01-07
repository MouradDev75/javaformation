package fr.dawan.couchesapplication.ihm;

import fr.dawan.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.couchesapplication.repositories.UtilisateurRepositoryImpl;
import fr.dawan.couchesapplication.services.IUtilisateurService;
import fr.dawan.couchesapplication.services.UtilisateurServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class app {

    private static IUtilisateurService utilisateurService = new UtilisateurServiceImpl(new UtilisateurRepositoryImpl());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Menu:
                    - Afficher la liste des utilisateur: tapez 1
                    - Ajouter un utilisateur: tapez 2
                    - Supprimer un utilisateur: tapez 3
                    - Quitter: tapez 4
                    """);
            int choix = sc.nextInt();

            if(choix == 4){
                System.out.println("Fin du programme....");
                break;
            }

            switch (choix){
                case 1:
                    try {
                        List<UtilisateurDto> dtos = utilisateurService.getAll();
                        if(dtos.size() == 0)
                            System.out.println("Aucun utilisateur trouvés");
                        else{
                            System.out.println(dtos.size()+" utilisateurs trouvés");
                            dtos.forEach(u -> System.out.println(u));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 2:
                    System.out.println("ID: ");
                    int id = sc.nextInt();

                    System.out.println("Nom: ");
                    String nom = sc.next();

                    System.out.println("Email: ");
                    String email = sc.next();

                    System.out.println("Password: ");
                    String pwd = sc.next();

                    UtilisateurDto dto = new UtilisateurDto(id,nom,email,pwd);

                    try {
                        utilisateurService.save(dto);
                        System.out.println("Utiisateur ajouté......");
                    } catch (Exception e) {
                        e.getMessage();
                    }

                    break;

                case 3:
                    System.out.println("ID: ");
                    int id2 = sc.nextInt();
                    try {
                        Set<UtilisateurDto> dtos = utilisateurService.getAll().stream()
                                .filter(u -> u.getId() == id2)
                                .collect(Collectors.toSet());
                        UtilisateurDto d = (UtilisateurDto) dtos.toArray()[0];
                        utilisateurService.delete(d);
                        System.out.println("Utilisateur supprimé.............");

                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;

                default:
                    System.out.println("Choix invalide.....");
                    break;
            }



        }




    }
}
