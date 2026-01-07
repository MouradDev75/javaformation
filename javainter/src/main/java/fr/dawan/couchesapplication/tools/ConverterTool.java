package fr.dawan.couchesapplication.tools;

import fr.dawan.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.couchesapplication.entities.Utilisateur;

public class ConverterTool {

    public static UtilisateurDto getDto(Utilisateur u) {
        UtilisateurDto dto = new UtilisateurDto();
       /* dto.setId(u.getId());
        dto.setNom(u.getNom());
        dto.setEmail(u.getEmail());
        dto.setPassword(u.getPassword());*/
        dto = u.getUtilisateurDto();

        return dto;
    }
}
