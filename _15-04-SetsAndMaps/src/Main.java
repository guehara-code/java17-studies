import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);
    }

    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println("-----------------------------------");
        System.out.println(header);
        System.out.println("-----------------------------------");
        contacts.forEach(System.out::println);
    }
}
