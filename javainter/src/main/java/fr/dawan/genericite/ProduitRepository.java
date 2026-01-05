package fr.dawan.genericite;

import java.util.List;

public class ProduitRepository implements IRepository<Produit>{
    @Override
    public List<Produit> getAl() {
        return List.of();
    }

    @Override
    public void insert(Produit obj) {

    }
}
