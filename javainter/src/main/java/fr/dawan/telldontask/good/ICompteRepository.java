package fr.dawan.telldontask.good;

public interface ICompteRepository {
    Compte getById(int id);
    void save(Compte cpt);
}
