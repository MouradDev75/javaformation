package fr.dawan.genericite;

import java.util.List;

public interface IRepository<T> {
    List<T> getAl();
    void insert(T obj);
}
