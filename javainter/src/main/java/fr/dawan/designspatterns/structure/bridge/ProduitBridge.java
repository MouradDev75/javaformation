package fr.dawan.designspatterns.structure.bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProduitBridge implements Bridge{
    @Override
    public List<ProduitEntity> getProduitEntities(Object sysExtern) {

        List<ProduitEntity> entities = new ArrayList<>();

        if(sysExtern instanceof SystemExtern1){

            SystemExtern1 sys = (SystemExtern1) sysExtern;

            entities = sys.getProducts()
                    .stream()
                    .map(p -> new ProduitEntity(p.getId(), p.getDescription()))
                    .collect(Collectors.toList());
        }else if(sysExtern instanceof SystemExtern2){
            SystemExtern2 sys = (SystemExtern2) sysExtern;

            entities = sys.getProduits()
                    .stream()
                    .map(p -> new ProduitEntity(p.getProdId(), p.getName()))
                    .collect(Collectors.toList());
        }


        return entities;
    }
}
