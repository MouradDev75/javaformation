package fr.dawan.telldontask.bad;

public class CompteService {

    private CompteRepository compteRepository;

    public void retrait(int id, double montant) throws Exception {
        Compte cpt = compteRepository.getById(id);

        if(cpt.getSolde() < montant){
            throw new Exception("Solde insuffisant...");
        }

        cpt.setSolde(cpt.getSolde() - montant);
        compteRepository.save(cpt);
    }
}
/*
Tell dont ask: dites, ne posez pas de questions. Dites à vos objets ce qu'ils doivent faire, ne leur
posez pas de questions sur leur état
 */
