package fr.dawan.couchesapplication.tools;

import fr.dawan.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.couchesapplication.entities.Utilisateur;
import org.modelmapper.ModelMapper;

public class MapperTool {

    /*
    Ajout dans le pom.xml de la dependance modelmapper
    <!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>3.2.6</version>
        </dependency>
     */

    private static ModelMapper mapper ;

    //bloc d'initialisation static: permet d'initialiser les variables statiques d'une classe
    static{
       mapper = new ModelMapper();
    }



    public static UtilisateurDto utilisateurDtoFromEntity(Utilisateur entity) {
        /*
        possibilité d'ajouter des règles de mapping
        mapper.typeMap(Utilisateur.class, UtilisateurDto.class).addMappings
                (m -> {
                    m.map(src -> src.getNom(), ContactDto::setLastName);
                    m.map(src -> src.getPrenom(), ContactDto::setFirstName);
                });
         */
        return mapper.map(entity, UtilisateurDto.class);
    }

    public static Utilisateur utilisateurFromDto(UtilisateurDto dto) {
        return mapper.map(dto, Utilisateur.class);
    }

    //méthode de conversion générique

    public static <TSource, TDestination> TDestination convertGeneric(TSource obj, Class<TDestination> clazz){
        return mapper.map(obj, clazz);
    }

}

