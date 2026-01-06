package fr.dawan.telldontask.good;


public class CompteService {

    private ICompteRepository repository;

    public CompteService(ICompteRepository repository) {
        this.repository = repository;
    }

    public void retrait(int id, double montant) throws Exception {
        Compte cpt = repository.getById(id);

       cpt.retrait(montant);
       repository.save(cpt);
    }
}
