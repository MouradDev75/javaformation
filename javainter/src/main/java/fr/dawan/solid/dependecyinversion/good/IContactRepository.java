package fr.dawan.solid.dependecyinversion.good;

public interface IContactRepository {
    /*
    interface contenant les besoins du service
     */
    Contact getById(int id);
}
