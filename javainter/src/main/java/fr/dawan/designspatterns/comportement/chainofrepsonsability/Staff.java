package fr.dawan.designspatterns.comportement.chainofrepsonsability;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Classe qui représente les objets de la chaine.
 * Chaque dans cette chaine possède un objet supérieur et peut soit traiter la demande
 * soit la transmettre à l'objet supérieur
 */

@AllArgsConstructor
@Data
public abstract class Staff {
    private String name;
    private Staff successor;

    public abstract void handleComplaint(ComplaintRequest request);

}
