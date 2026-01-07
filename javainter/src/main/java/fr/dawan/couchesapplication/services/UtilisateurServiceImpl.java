package fr.dawan.couchesapplication.services;

import fr.dawan.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.couchesapplication.entities.Utilisateur;
import fr.dawan.couchesapplication.repositories.IUtilisateurRepository;
import fr.dawan.couchesapplication.tools.MapperTool;

import java.util.ArrayList;
import java.util.List;
/*
Règle métier: email est unique
 */

public class UtilisateurServiceImpl implements IUtilisateurService{

    private IUtilisateurRepository repository;

    public UtilisateurServiceImpl(IUtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UtilisateurDto> getAll() throws Exception{
        List<UtilisateurDto> dtos = new ArrayList<>();
        List<Utilisateur> entities = repository.getAll();
        /*
        Convertir entities en dto
         */
        for(Utilisateur u : entities){

            //Option1: définir ses propres méthodes de conversion
            //UtilisateurDto dto = new UtilisateurDto(u.getId(), u.getNom(), u.getEmail(), u.getPassword()); -- Tell dont ask
            //UtilisateurDto dto = u.getDto(); Single Responsability -> déleguer cette tâche à une autre classe
            //UtilisateurDto dto = ConverterTool.getDto(u);

            /*
            Option2: utiliser des bibliothèques externes: mapstruct - modelmapper
            doc ModelMapper: https://modelmapper.org/getting-started/
             */

            UtilisateurDto dto = MapperTool.convertGeneric(u, UtilisateurDto.class);

            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public void save(UtilisateurDto dto) throws Exception{
        Utilisateur u = MapperTool.convertGeneric(dto, Utilisateur.class);
        if(repository.getAll().stream()
                        .filter(user -> user.getEmail().equals(u.getEmail()))
                                .count() != 0){
            throw new Exception("Email déjà utilisé.....");
        }
        repository.save(u);
    }

    @Override
    public void delete(UtilisateurDto dto) throws Exception{
        Utilisateur u = MapperTool.convertGeneric(dto, Utilisateur.class);
        repository.delete(u);
    }
}
