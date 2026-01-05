package fr.dawan.javafunctional;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

    }

    static void afficherContact(Contact c){
        System.out.println(c);
    }

    static Consumer<Contact> afficherContactConsumer = c -> System.out.println(c);
}




class Contact{
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }
}