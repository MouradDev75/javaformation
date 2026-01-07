package fr.dawan.couchesapplication.repositories;

import fr.dawan.couchesapplication.entities.Utilisateur;

import java.util.List;

public interface IUtilisateurRepository {
    List<Utilisateur> getAll();

    void save(Utilisateur u);

    void delete(Utilisateur u);
}