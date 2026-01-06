package fr.dawan.solid.interfacesegregation;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
    void insert(User u);
    void delete(User u);
}
