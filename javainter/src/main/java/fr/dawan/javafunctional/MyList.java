package fr.dawan.javafunctional;

import fr.dawan.genericite.Produit;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList implements List<Produit> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Produit> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Produit produit) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Produit> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Produit> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Produit get(int index) {
        return null;
    }

    @Override
    public Produit set(int index, Produit element) {
        return null;
    }

    @Override
    public void add(int index, Produit element) {

    }

    @Override
    public Produit remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Produit> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Produit> listIterator(int index) {
        return null;
    }

    @Override
    public List<Produit> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
