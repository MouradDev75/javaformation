package fr.dawan.couchesapplication.tools;

import org.modelmapper.ModelMapper;

public class ModelMapperDemo {

    public static void main(String[] args) {

        /*
        Lien doc: https://modelmapper.org/getting-started/
         */

        ModelMapper mapper = new ModelMapper();

        /*
        Ajout de règles de mapping
         */

        mapper.typeMap(Contact.class, ContactDto.class).addMappings
                (m -> {
                    m.map(src -> src.getNom(), ContactDto::setLastName);
                    m.map(src -> src.getPrenom(), ContactDto::setFirstName);
                });

        Contact contact = new Contact("DUPONT", "Jean");

        ContactDto dto = mapper.map(contact, ContactDto.class);

        System.out.println(dto);

    }
}

class Contact{
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Contact(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

class ContactDto{
    private String lastName;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ContactDto(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public ContactDto() {
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
