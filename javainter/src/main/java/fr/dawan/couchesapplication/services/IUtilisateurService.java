package fr.dawan.couchesapplication.services;

/*
Couche métier:
- règles métier (logique métier)
- répondre aux besoins des utilisateurs finaux (contient les fonctionnalités de l'application)
 */

import fr.dawan.couchesapplication.dtos.UtilisateurDto;

import java.util.List;

public interface IUtilisateurService {
    List<UtilisateurDto> getAll() throws Exception;
    void save(UtilisateurDto dto) throws Exception;
    void delete(UtilisateurDto dto) throws Exception;
}
