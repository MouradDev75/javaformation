package fr.dawan.designspatterns.structure.bridge;

import java.util.List;

/**
 * Interface qui décrit le rôle du pattern Bridge
 */
public interface Bridge {
    List<ProduitEntity> getProduitEntities(Object sysExtern);
}
