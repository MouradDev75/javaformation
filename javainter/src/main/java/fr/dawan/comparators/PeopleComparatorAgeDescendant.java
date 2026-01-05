package fr.dawan.comparators;

import fr.dawan.apistream.People;

import java.util.Comparator;

public class PeopleComparatorAgeDescendant implements Comparator<People> {
    @Override
    public int compare(People p1, People p2) {
        if(p1.getAge() > p2.getAge()){
            return -1;
        }else if (p1.getAge() < p1.getAge()){
            return 01;
        }else {
            return 0;
        }
    }
}
