package fr.dawan.solid.interfacesegregation;

import java.util.List;

public class UserRepoImpl implements UserRepository{
    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void insert(User u) {

    }

    @Override
    public void delete(User u) {

    }
}
