package fr.dawan.couchesapplication.repositories;

import fr.dawan.couchesapplication.entities.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurRepositoryImpl implements IUtilisateurRepository{

    private List<Utilisateur> users = new ArrayList<>();

    @Override
    public List<Utilisateur> getAll() {
        return users;
    }

    @Override
    public void save(Utilisateur u) {
        users.add(u);
    };

    @Override
    public void delete(Utilisateur u) {
        users.remove(u);
    }
}
